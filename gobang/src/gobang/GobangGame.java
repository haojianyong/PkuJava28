package gobang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	// 定义权重
	private Chessweight chessweight;
	private Chesscount chesscount;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 * @param chessweight 
	 *
	 *@param chesscount 
	 */
	public GobangGame(Chessboard chessboard,Chessweight chessweight,Chesscount chesscount) {
		this.chessboard = chessboard;
		this.chessweight = chessweight;
		this.chesscount = chesscount;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessweight.initWeight();
		chesscount.initcount();
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机选择位置坐标computerDo()
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机向weight[][]最高的下子
	 */
	public int[] computerDo() {
		int i;
		int j;
		int posX = 0;
        int posY = 0;
		int max = 0;
		String[][] board = chessboard.getBoard();
		int[][] weight = chessweight.getWeight();
		calchessman();
		calweight();
//		for ( i = 0; i < 15; i++ ){  
//	        for ( j = 0; j < 15; j++ ) {
//	        	System.out.println("weight["+i+"]["+j+"]"+weight[i][j]);
//	        }
//		}
		for ( i = 0; i < 15; i++ ){  
	        for ( j = 0; j < 15; j++ ) {//找到最高的weight[i][j]
	        	
	        	if (board[i][j] == "十"){
	        		if (weight[i][j]>max){
	        			max = weight[i][j];
	        			posY = j;
	        			posX = i;
	        	        
					}
	        		
	        	}
	        }
		}
		int[] result = { posX, posY };
		return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	//判断输赢方法：分别判断垂直方向，水平方向，斜方向是否连接至五子。
	public boolean isWon(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int x = posX;
		int y = posY;
		int count = 0;
		//检查纵向up
		while (x>0 && board[x][posY]==ico) {
			x--;
			count++;
		}
		//检查纵向down
		x = posX + 1;
		while (x<15 && board[x][posY]==ico) {
			x++;
			count++;
		}
		if(count>=5){
			return true; //获胜
		}
		
		
		count = 0;
		//检查横向right
		while (y>0 && board[posX][y]==ico) {
			y--;
			count++;
		}
		y = posY+1;
		//检查横向left
		while (y>0 && board[posX][y]==ico) {
			y++;
			count++;
		}
		if(count>=5){
			return true; //获胜
		}
		count = 0;
		//检查斜左上
		x = posX;
		y = posY;
		while (x>0 && y>0 && board[x][y]==ico) {
				x--;
				y--;
				count++;
		}
		//检查斜左下
		x = posX+1;
		y = posY+1;
		while (x<15 && y<15 && board[x][y]==ico) {
			
				x++;
				y++;
				count++;
		}
		if(count>=5){
			return true; //获胜
		}
		count = 0;
		//检查斜右上
		x = posX-1;
		y = posY+1;
		while (x>0 && y<15 && board[x][y]==ico) {
				x--;
				y++;
				count++;
		}
		//检查斜右下
		x = posX+1;
		y = posY-1;
		while (x<15 && y>0 && board[x][y]==ico) {
				x++;
				y--;
				count++;
		}
		if(count>=5){
			return true; //获胜
		}
		return false;
		
	}
	//主程序
	public static void main(String[] args) throws Exception {
			
		GobangGame gb = new GobangGame(new Chessboard(),new Chessweight(),new Chesscount());
		gb.start();
	}
	
	//对每一个空格评分的方法，计算机要下在分数最高的位置
	public void calweight() {
		String[][] board = chessboard.getBoard();
		//int [][] weight = chessweight.getWeight();
		int[][][] count = chesscount.getCount();
		int i, j, k;  
	    int win ;  
	    for ( i = 0; i < 15; i++ )  
	        for ( j = 0; j < 15; j++ )   
	        {  
	            if ( board[i][j] == "十" ){  
	            	win=0;
	                for ( k = 0; k < 4; k++ )  // direction 0,1,2,3  
	                {  
	                    if ( count[i][j][k] + count[i][j][k+4] >= 4 )  
	                        win += 10000;  
	                    else if ( count[i][j][k] + count[i][j][k+4] == 3 )  
	                        win += 1000;   
	                    else if ( count[i][j][k] + count[i][j][k+4] == 2 )  
	                        win += 100;  
	                    else if ( count[i][j][k] + count[i][j][k+4] == 1 )  
	                        win += 10;  //
	                }  
	                //weight[i][j] = win;
	                chessweight.setWeight(i, j, win);
//	                int[][] weight = chessweight.getWeight();
//                    System.out.println("weight["+i+"]["+j+"]"+weight[i][j]);
	            }
	        }
	}
	//统计每个空位在某一方向●连成一线的棋子数目
	public void calchessman() {
		int i, j, k, t, cnt; 
		int i1, j1; 
		int dx[];
		int dy[];
		//这两个数组为了生成八个方向的board[][]
		dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};  
		dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1}; 
		String[][] board = chessboard.getBoard();
		
		for ( i = 0; i < 15; i++ ){  
		        for ( j = 0; j < 15; j++ ) {  
		            if ( board[i][j] == "十" ){  //空位  
		                for ( k = 0; k < 8; k++ ){  // 8个方向
		                    cnt = 0;  //空位某个方向的旗子数目
		                    i1 = i;  
		                    j1 = j;  
		                    for ( t = 0; t < 5; t++ )  //最多看某个方向开外五个子的
		                    {  
		                    	i1 =i1 + dx[k];  
		                        j1 =j1 + dy[k];  
		                        if ( i1 > 15 || i1 < 0 || j1 > 15 || j1 < 0 ) //超出棋盘不用统计了 
		                            break;  
		                        if( board[i1][j1] == "●" )  
		                            cnt++;  
		                        else //遇到"十"或者"○"阻断，都不用再统计了 
		                            break;  
		                    }  
		                    //count[i][j][k] = cnt;
		                    chesscount.setCount(i, j, k, cnt);
//		                    int[][][] count = chesscount.getCount();
//		                    System.out.println("count["+i+"]["+j+"]["+k+"]"+count[i][j][k]);
		                    
		                }
		            }
		        }
		}
	}
	
}
