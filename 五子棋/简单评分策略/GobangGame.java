package five_in_row;

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
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
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
			//******************************************************************************************************************************************
			//从四个方向去设置user_mark平分表的分数
			//方向依次是：0度的方向,45度方向，90度方向，135度方向
			for(int i=0;i<4;i++){
				int count=getWIN_COUNT(posX,posY,chessman,i);
				System.out.println(i+"94hang:"+count);
				setUser_mark(posX, posY, chessman, count + 1, i);
			}
			chessboard.setUser_mark(posX,posY,0);
			chessboard.setComputer_mark(posX,posY,0);
			//******************************************************************************************************************************************
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;
			}
			else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				//******************************************************************************************************************************************
				//设置computer_mark分数数组
				//从四个方向去设置computer_mark评分表的分数
				//方向依次是：0度的方向,45度方向，90度方向，135度方向
				for(int i=0;i<4;i++){
					int count=getWIN_COUNT(computerPosArr[0],computerPosArr[1],chessman,0);
					setComputer_mark(computerPosArr[0], computerPosArr[1], chessman, count + 1, 0);
				}
				chessboard.setComputer_mark(computerPosArr[0],computerPosArr[1],0);
				chessboard.setUser_mark(computerPosArr[0],computerPosArr[1],0);
				//******************************************************************************************************************************************
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
			//System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
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
	 * 计算机随机下棋
	 */
	public int[] computerDo() {

		int[] user_pos=search_user_maxmark();
		int[] computer_pos=search_computer_maxmark();
		int user_posX = user_pos[0];
		int user_posY = user_pos[1];
		int user_mark = user_pos[2];
		int computer_posX=computer_pos[0];
		int computer_posY=computer_pos[1];
		int computer_mark=computer_pos[2];
		int posX=user_posX;
		int posY=user_posY;
		System.out.println("横坐标"+posX+",纵坐标"+posY);
		if(user_mark<4 && computer_mark>=4){
			posX = computer_posX;
			posY = computer_posY;
		}
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			chessboard.setUser_mark(posX,posY,0);
			chessboard.setComputer_mark(posX, posY, 0);
			user_pos=search_user_maxmark();
			computer_pos=search_computer_maxmark();
			user_posX = user_pos[0];
			user_posY = user_pos[1];
			user_mark = user_pos[2];
			computer_posX=computer_pos[0];
			computer_posY=computer_pos[1];
			computer_mark=computer_pos[2];
			posX=user_posX;
			posY=user_posY;
			if(user_mark<4 && computer_mark>=4){
				posX = computer_posX;
				posY = computer_posY;
			}
		}
		int[] result = { posX, posY};
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
	public boolean isWon(int posX, int posY, String ico) {
		boolean result=false;
		int count=0;
		//从四个方向开始双向寻找,先从0度方向开始找起，然后依次检测45度方向、90度方向、135度方向，只要检测出一个方向有5个棋子，就返回结果为真
		for (int i=0;i<4;i++)
		{
			count=getWIN_COUNT(posX,posY,ico,i);
			if(count>=5){
				result=true;
				break;
			}
		}
		return result;
	}

	int getWIN_COUNT(int posX,int posY,String ico,int direction){
		String[][] board = chessboard.getBoard();
		int[] upright={posX,posY};
		int[] leftdown={posX,posY};
		int count=1;//因为上面程序显示，只搜索那些有棋子的位置
		//从四个方向开始双向寻找
		//1、0度方向双向寻找
		//第一个函数
		switch (direction){
			case 0://水平方向
				while (upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]][upright[1]+1]==ico)
					upright[1]+=1;//水平向右方向
				while (leftdown[1]-1>=0 && board[leftdown[0]][leftdown[1]-1]==ico)
					leftdown[1]-=1;//水平向左方向
				count= upright[1]-leftdown[1]+1;
				break;
			case 1://45度方向
				while (upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]-1][upright[1]+1]==ico){
					upright[0]-=1;
					upright[1]+=1;
				}//右上方
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0 &&board[leftdown[0]+1][leftdown[1]-1]==ico){
					leftdown[0]+=1;
					leftdown[1]-=1;
				}//左下方
				count=upright[1]-leftdown[1]+1;
				break;
			case 2://90度方向
				while (upright[0]-1>=0 && board[upright[0]-1][upright[1]]==ico){
					upright[0]-=1;
				}//上方
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]]==ico){
					leftdown[0]+=1;
				}//下方
				count=leftdown[0]-upright[0]+1;
				break;

			case 3://135度方向
				while (upright[0]-1>=0 && upright[1]-1>=0 && board[upright[0]-1][upright[1]-1]==ico){
					upright[0]-=1;
					upright[1]-=1;
				}//左上方
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]+1]==ico){
					leftdown[0]+=1;
					leftdown[1]+=1;
				}//右上方
				count=leftdown[0]-upright[0]+1;
				break;
			default:
				break;
		}
		return count;
	}
	//****************************************************************************************************************************************************
	//设置评分表函数
	void setUser_mark(int posX,int posY,String ico,int mark,int direction){
		String[][] board = chessboard.getBoard();
		int[] upright={posX,posY};
		boolean upright_right=false;
		int[] leftdown={posX,posY};
		boolean leftdown_left=false;
		switch (direction){
			case 0://水平方向
				while (upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]][upright[1]+1]==ico)
					upright[1]+=1;//水平向右方向
				if ((upright[1]+1)< Chessboard.BOARD_SIZE) {//连子右端的右边位置不越界并且没有子，才会平分
					if(board[upright[0]][upright[1]+1]=="十") {
						upright_right = true;
					}
				}
				while (leftdown[1]-1>=0 && board[leftdown[0]][leftdown[1]-1]==ico)
					leftdown[1]-=1;//水平向左方向
				if((leftdown[1]-1)>=0){
					if(board[leftdown[0]][leftdown[1]-1]=="十")
						leftdown_left=true;
				}
				if (upright_right==true)
					chessboard.setUser_mark(posX,upright[1]+1,mark);
				if(leftdown_left==true)
					chessboard.setUser_mark(posX,leftdown[1]-1,mark);
				break;
			case 1://45度方向
				while (upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]-1][upright[1]+1]==ico){
					upright[0]-=1;
					upright[1]+=1;
				}//右上方
				if(upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE){
					if(board[upright[0]-1][upright[1]+1]=="十"){
						upright_right=true;
					}
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0 &&board[leftdown[0]+1][leftdown[1]-1]==ico){
					leftdown[0]+=1;
					leftdown[1]-=1;
				}//左下方
				if(leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0){
					if(board[leftdown[0]+1][leftdown[1]-1]=="十")
						leftdown_left=true;
				}
				if(upright_right==true)
					chessboard.setUser_mark(upright[0]-1,upright[1]+1,mark);
				if(leftdown_left==true)
					chessboard.setUser_mark(leftdown[0]+1,leftdown[1]-1,mark);
				break;
			case 2://90度方向
				while (upright[0]-1>=0 && board[upright[0]-1][upright[1]]==ico){
					upright[0]-=1;
				}//上方
				if(upright[0]-1>=0){
					if(board[upright[0]-1][upright[1]]=="十")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]]==ico){
					leftdown[0]+=1;
				}//下方
				if(leftdown[0]+1< Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]]=="十")
						leftdown_left=true;
				}
				if(upright_right==true)
					chessboard.setUser_mark(upright[0]-1,upright[1],mark);
				if(leftdown_left==true)
					chessboard.setUser_mark(leftdown[0]+1,leftdown[1],mark);
				break;

			case 3://135度方向
				while (upright[0]-1>=0 && upright[1]-1>=0 && board[upright[0]-1][upright[1]-1]==ico){
					upright[0]-=1;
					upright[1]-=1;
				}//左上方
				if(upright[0]-1>=0 && upright[1]-1>=0){
					if(board[upright[0]-1][upright[1]-1]=="十")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]+1]==ico){
					leftdown[0]+=1;
					leftdown[1]+=1;
				}//右上方
				if(leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]+1]=="十")
						leftdown_left=true;
				}
				if(upright_right==true)
					chessboard.setUser_mark(upright[0]-1,upright[1]-1,mark);
				if(leftdown_left==true)
					chessboard.setUser_mark(leftdown[0]+1,leftdown[1]+1,mark);
				System.out.println("set_user_mark"+mark);
				break;
			default:
				break;
		}
	}
	void setComputer_mark(int posX,int posY,String ico,int mark,int direction){
		String[][] board = chessboard.getBoard();
		int[] upright={posX,posY};
		boolean upright_right=false;
		int[] leftdown={posX,posY};
		boolean leftdown_left=false;
		switch (direction){
			case 0://水平方向
				while (upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]][upright[1]+1]==ico)
					upright[1]+=1;//水平向右方向
				if ((upright[1]+1)< Chessboard.BOARD_SIZE) {//连子右端的右边位置不越界并且没有子，才会平分
					if(board[upright[0]][upright[1]+1]=="十") {
						upright_right = true;
					}
				}
				while (leftdown[1]-1>=0 && board[leftdown[0]][leftdown[1]-1]==ico)
					leftdown[1] -= 1;//水平向左方向
				if((leftdown[1]-1)>=0){
					if(board[leftdown[0]][leftdown[1] - 1] == "十")
						leftdown_left=true;
				}
				if (upright_right==true)
					chessboard.setComputer_mark(posX, upright[1] + 1, mark);
				if(leftdown_left==true)
					chessboard.setComputer_mark(posX, leftdown[1] - 1, mark);
				break;
			case 1://45度方向
				while (upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]-1][upright[1]+1]==ico){
					upright[0]-=1;
					upright[1]+=1;
				}//右上方
				if(upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE){
					if(board[upright[0]-1][upright[1]+1]=="十"){
						upright_right=true;
					}
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0 &&board[leftdown[0]+1][leftdown[1]-1]==ico){
					leftdown[0]+=1;
					leftdown[1]-=1;
				}//左下方
				if(leftdown[0] + 1 < Chessboard.BOARD_SIZE && leftdown[1]-1>=0){
					if(board[leftdown[0]+1][leftdown[1]-1]=="十")
						leftdown_left = true;
				}
				if(upright_right==true)
					chessboard.setComputer_mark(upright[0] - 1, upright[1] + 1, mark);
				if(leftdown_left==true)
					chessboard.setComputer_mark(leftdown[0] + 1, leftdown[1] - 1, mark);
				break;
			case 2://90度方向
				while (upright[0]-1>=0 && board[upright[0]-1][upright[1]]==ico){
					upright[0]-=1;
				}//上方
				if(upright[0]-1>=0){
					if(board[upright[0]-1][upright[1]]=="十")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]]==ico){
					leftdown[0]+=1;
				}//下方
				if (leftdown[0] + 1 < Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]]== "十")
						leftdown_left = true;
				}
				if(upright_right==true)
					chessboard.setComputer_mark(upright[0] - 1, upright[1], mark);
				if(leftdown_left==true)
					chessboard.setComputer_mark(leftdown[0] + 1, leftdown[1], mark);
				break;

			case 3://135度方向
				while (upright[0]-1>=0 && upright[1]-1>=0 && board[upright[0]-1][upright[1]-1]==ico){
					upright[0]-=1;
					upright[1]-=1;
				}//左上方
				if(upright[0]-1>=0 && upright[1]-1>=0){
					if(board[upright[0]-1][upright[1]-1]=="十")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]+1]==ico){
					leftdown[0]+=1;
					leftdown[1]+=1;
				}//右上方
				if(leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1] + 1 < Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]+1]=="十")
						leftdown_left = true;
				}
				if(upright_right==true)
					chessboard.setComputer_mark(upright[0] - 1, upright[1] - 1, mark);
				if(leftdown_left==true)
					chessboard.setComputer_mark(leftdown[0] + 1, leftdown[1] + 1, mark);
				break;
			default:
				break;
		}
	}
	int[] search_user_maxmark(){
		int[][] user_mark=chessboard.getUser_mark();
		int max=user_mark[0][0];
		int[] result={0,0,0};
		for (int i=0;i< Chessboard.BOARD_SIZE;i++){
			for (int j=0;j< Chessboard.BOARD_SIZE;j++)
				if(user_mark[i][j]>max){
					max=user_mark[i][j];
					result[0]=i;//mark数组横坐标
					result[1]=j;//mark数组纵坐标
					result[2]=max;//mark数组对应位置值
				}
		}
		return result;
	}
	int[] search_computer_maxmark(){
		int[][] computer_mark=chessboard.getComputer_mark();
		int max=computer_mark[0][0];
		int[] result={0,0,0};
		for (int i=0;i< Chessboard.BOARD_SIZE;i++){
			for (int j=0;j< Chessboard.BOARD_SIZE;j++)
				if(computer_mark[i][j]>max){
					max=computer_mark[i][j];
					result[0]=i;//mark数组横坐标
					result[1]=j;//mark数组纵坐标
					result[2]=max;//mark数组对应位置值
				}
		}
		return result;
	}
	//****************************************************************************************************************************************************

	public static void main(String[] args) throws Exception {
		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
