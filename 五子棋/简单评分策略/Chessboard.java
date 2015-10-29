package five_in_row;

public class Chessboard {
	// ����һ����ά�������䵱����
	private String[][] board;
	//{***************************************************************************************************************************
	/* ��������ƽ�ֱ�,�ֱ�Ϊ�û���ֵ��͵��Է�ֵ�������ʱ����Ϊ���û����£����Ե����������ʱ���ȿ������ֵķ�ֵ��
	���û��Σ���������Լ�ʤ��ߵ�λ�ã������Σ�գ����ȶ¶��ֵ���·���״������ʱ�򣬵���Ҫ���ڶ��ֵ���һ���ӽ���λ�ã�
	�����������λ�÷���ֵ��ͬ����Ҫ�������������ıȽϽ����Ǹ�λ�á����̳�ʼ����ʱ��Ҫ�����ֱ�Ҳ���г�ʼ��������������
	Щ�߷�ֵ��λ��ʱ��ͬʱҪ����Ӧ�����ֱ���г�ʼ����*/
	private int[][] user_mark;
	private int[][] computer_mark;
	//***************************************************************************************************************************}
	// �������̵Ĵ�С
	public static final int BOARD_SIZE = 22;
	private int lastX = -1, lastY = -1;//��¼����е�ǰ���һ�������λ��
	/**
	 * ��ʼ������
	 * 
	 * @return void
	 */
	public void initBoard() {
		// ��ʼ����������
		board = new String[BOARD_SIZE][BOARD_SIZE];
		//{*************************************************************************************************************************
		//��ʼ���û��͵��Ե�ƽ������
		user_mark=new int[BOARD_SIZE][BOARD_SIZE];
		computer_mark=new int[BOARD_SIZE][BOARD_SIZE];
		//*************************************************************************************************************************}
		// ��ÿ��Ԫ�ظ�ֵΪ��ʮ�������ڿ���̨�������
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = "ʮ";
				//���û��͵��Ե�����������г�ʼ��
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
	 * �ڿ���̨������̵ķ���
	 */
	public void printBoard() {
		// ��ӡÿ������Ԫ��
			for (int i=0; i < BOARD_SIZE; i+=2)
		{
			System.out.printf("  %02d",i+1);	// ��һ����ʾ�к�����
		}
		System.out.println();
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.printf("%02d", i+1);		// ������ʾ�к�
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (i == lastX && j == lastY)
				{
					System.out.print("��");		// ͻ����ʾ�������λ�õ�����
				}else
				{
				// ��ӡ�󲻻���
				System.out.print(board[i][j]);
				}
			}
			// ÿ��ӡ��һ������Ԫ�ؾͻ���һ��
			System.out.print("\n");
		}
		System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺*,*");
	}

	/**
	 * ������λ�ø�ֵ
	 * 
	 * @param posX
	 *            X����
	 * @param posY
	 *            Y����
	 * @param chessman
	 *            ����
	 */
	public void setBoard(int posX, int posY, String chessman) {
		lastX = posX;
		lastY = posY;
		this.board[posX][posY] = chessman;
	}

	/**
	 * ��������
	 * 
	 * @return ��������
	 */
	public String[][] getBoard() {
		return this.board;
	}

	//****************************************************************************************************************************
	//�������ֱ�,�Լ�ÿ��һ�ӣ������Լ������ֱ��Է���Ӧλ�����ֱ���0,�Լ���Ӧ����λ����0
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
	//�������ֱ�
	public int[][] getUser_mark(){
		return this.user_mark;
	}
	public int[][] getComputer_mark(){
		return this.computer_mark;
	}

	public void printMark() {
		// ��ӡÿ������Ԫ��
		for (int i=0; i < BOARD_SIZE; i+=2)
		{
			System.out.printf("  %02d",i+1);	// ��һ����ʾ�к�����
		}
		System.out.println();
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.printf("%02d", i+1);		// ������ʾ�к�
			for (int j = 0; j < BOARD_SIZE; j++) {
					// ��ӡ�󲻻���
					System.out.print(user_mark[i][j]+" ");

			}
			// ÿ��ӡ��һ������Ԫ�ؾͻ���һ��
			System.out.print("\n");
		}

	}
	//****************************************************************************************************************************
}