package five_in_row;

public class Chessboard {
	// 定义一个二维数组来充当棋盘
	private String[][] board;
	//{***************************************************************************************************************************
	/* 定义棋盘平分表,分别为用户分值表和电脑分值表，下棋的时候因为是用户先下，所以电脑在下棋的时候先看看对手的分值表，
	如果没有危险则下在自己胜算高的位置，如果有危险，则先堵对手的棋路。首次下棋的时候，电脑要下在对手的任一棋子紧邻位置，
	如果出现两个位置分数值相同，则要下在离棋盘中心比较近的那个位置。棋盘初始化的时候要对评分表也进行初始化，棋子落在那
	些高分值的位置时，同时要对相应的评分表进行初始化。*/
	private int[][] user_mark;
	private int[][] computer_mark;
	//***************************************************************************************************************************}
	// 定义棋盘的大小
	public static final int BOARD_SIZE = 22;
	private int lastX = -1, lastY = -1;//记录棋局中当前最后一步下棋的位置
	/**
	 * 初始化棋盘
	 * 
	 * @return void
	 */
	public void initBoard() {
		// 初始化棋盘数组
		board = new String[BOARD_SIZE][BOARD_SIZE];
		//{*************************************************************************************************************************
		//初始化用户和电脑的平分数组
		user_mark=new int[BOARD_SIZE][BOARD_SIZE];
		computer_mark=new int[BOARD_SIZE][BOARD_SIZE];
		//*************************************************************************************************************************}
		// 把每个元素赋值为“十”，用于控制台输出棋盘
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = "十";
				//对用户和电脑的评分数组进行初始化
				user_mark[i][j]=0;
				computer_mark[i][j]=0;
			}
		}
	}
	
	public void test() {
		Object[][] array = new Object[10][10];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = new Object();
			}
		}
	}

	/**
	 * 在控制台输出棋盘的方法
	 */
	public void printBoard() {
		// 打印每个数组元素
			for (int i=0; i < BOARD_SIZE; i+=2)
		{
			System.out.printf("  %02d",i+1);	// 第一行显示列号序列
		}
		System.out.println();
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.printf("%02d", i+1);		// 首列显示行号
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (i == lastX && j == lastY)
				{
					System.out.print("◎");		// 突出显示最后下棋位置的棋子
				}else
				{
				// 打印后不换行
				System.out.print(board[i][j]);
				}
			}
			// 每打印完一行数组元素就换行一次
			System.out.print("\n");
		}
		System.out.println("请输入您下棋的坐标，应以x,y的格式输入：*,*");
	}

	/**
	 * 给棋盘位置赋值
	 * 
	 * @param posX
	 *            X坐标
	 * @param posY
	 *            Y坐标
	 * @param chessman
	 *            棋子
	 */
	public void setBoard(int posX, int posY, String chessman) {
		lastX = posX;
		lastY = posY;
		this.board[posX][posY] = chessman;
	}

	/**
	 * 返回棋盘
	 * 
	 * @return 返回棋盘
	 */
	public String[][] getBoard() {
		return this.board;
	}

	//****************************************************************************************************************************
	//设置评分表,自己每落一子，计算自己的评分表，对方相应位置评分表置0,自己相应落子位置置0
	public void setUser_mark(int posX,int posY,int mark){
		if(posX>=0 && posX<BOARD_SIZE && posY>=0 && posY<BOARD_SIZE)
			user_mark[posX][posY]=mark;
		else
			return;
	}
	public void setComputer_mark(int posX,int posY,int mark){
		if(posX>=0 && posX<BOARD_SIZE && posY>=0 && posY<BOARD_SIZE)
			computer_mark[posX][posY]=mark;
		else
			return;
	}
	//返回评分表
	public int[][] getUser_mark(){
		return this.user_mark;
	}
	public int[][] getComputer_mark(){
		return this.computer_mark;
	}

	public void printMark() {
		// 打印每个数组元素
		for (int i=0; i < BOARD_SIZE; i+=2)
		{
			System.out.printf("  %02d",i+1);	// 第一行显示列号序列
		}
		System.out.println();
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.printf("%02d", i+1);		// 首列显示行号
			for (int j = 0; j < BOARD_SIZE; j++) {
					// 打印后不换行
					System.out.print(user_mark[i][j]+" ");

			}
			// 每打印完一行数组元素就换行一次
			System.out.print("\n");
		}

	}
	//****************************************************************************************************************************
}