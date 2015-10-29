package five_in_row;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			//******************************************************************************************************************************************
			//���ĸ�����ȥ����user_markƽ�ֱ�ķ���
			//���������ǣ�0�ȵķ���,45�ȷ���90�ȷ���135�ȷ���
			for(int i=0;i<4;i++){
				int count=getWIN_COUNT(posX,posY,chessman,i);
				System.out.println(i+"94hang:"+count);
				setUser_mark(posX, posY, chessman, count + 1, i);
			}
			chessboard.setUser_mark(posX,posY,0);
			chessboard.setComputer_mark(posX,posY,0);
			//******************************************************************************************************************************************
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;
			}
			else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				//******************************************************************************************************************************************
				//����computer_mark��������
				//���ĸ�����ȥ����computer_mark���ֱ�ķ���
				//���������ǣ�0�ȵķ���,45�ȷ���90�ȷ���135�ȷ���
				for(int i=0;i<4;i++){
					int count=getWIN_COUNT(computerPosArr[0],computerPosArr[1],chessman,0);
					setComputer_mark(computerPosArr[0], computerPosArr[1], chessman, count + 1, 0);
				}
				chessboard.setComputer_mark(computerPosArr[0],computerPosArr[1],0);
				chessboard.setUser_mark(computerPosArr[0],computerPosArr[1],0);
				//******************************************************************************************************************************************
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			//System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
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
		System.out.println("������"+posX+",������"+posY);
		if(user_mark<4 && computer_mark>=4){
			posX = computer_posX;
			posY = computer_posY;
		}
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
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
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		boolean result=false;
		int count=0;
		//���ĸ�����ʼ˫��Ѱ��,�ȴ�0�ȷ���ʼ����Ȼ�����μ��45�ȷ���90�ȷ���135�ȷ���ֻҪ����һ��������5�����ӣ��ͷ��ؽ��Ϊ��
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
		int count=1;//��Ϊ���������ʾ��ֻ������Щ�����ӵ�λ��
		//���ĸ�����ʼ˫��Ѱ��
		//1��0�ȷ���˫��Ѱ��
		//��һ������
		switch (direction){
			case 0://ˮƽ����
				while (upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]][upright[1]+1]==ico)
					upright[1]+=1;//ˮƽ���ҷ���
				while (leftdown[1]-1>=0 && board[leftdown[0]][leftdown[1]-1]==ico)
					leftdown[1]-=1;//ˮƽ������
				count= upright[1]-leftdown[1]+1;
				break;
			case 1://45�ȷ���
				while (upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]-1][upright[1]+1]==ico){
					upright[0]-=1;
					upright[1]+=1;
				}//���Ϸ�
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0 &&board[leftdown[0]+1][leftdown[1]-1]==ico){
					leftdown[0]+=1;
					leftdown[1]-=1;
				}//���·�
				count=upright[1]-leftdown[1]+1;
				break;
			case 2://90�ȷ���
				while (upright[0]-1>=0 && board[upright[0]-1][upright[1]]==ico){
					upright[0]-=1;
				}//�Ϸ�
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]]==ico){
					leftdown[0]+=1;
				}//�·�
				count=leftdown[0]-upright[0]+1;
				break;

			case 3://135�ȷ���
				while (upright[0]-1>=0 && upright[1]-1>=0 && board[upright[0]-1][upright[1]-1]==ico){
					upright[0]-=1;
					upright[1]-=1;
				}//���Ϸ�
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]+1]==ico){
					leftdown[0]+=1;
					leftdown[1]+=1;
				}//���Ϸ�
				count=leftdown[0]-upright[0]+1;
				break;
			default:
				break;
		}
		return count;
	}
	//****************************************************************************************************************************************************
	//�������ֱ���
	void setUser_mark(int posX,int posY,String ico,int mark,int direction){
		String[][] board = chessboard.getBoard();
		int[] upright={posX,posY};
		boolean upright_right=false;
		int[] leftdown={posX,posY};
		boolean leftdown_left=false;
		switch (direction){
			case 0://ˮƽ����
				while (upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]][upright[1]+1]==ico)
					upright[1]+=1;//ˮƽ���ҷ���
				if ((upright[1]+1)< Chessboard.BOARD_SIZE) {//�����Ҷ˵��ұ�λ�ò�Խ�粢��û���ӣ��Ż�ƽ��
					if(board[upright[0]][upright[1]+1]=="ʮ") {
						upright_right = true;
					}
				}
				while (leftdown[1]-1>=0 && board[leftdown[0]][leftdown[1]-1]==ico)
					leftdown[1]-=1;//ˮƽ������
				if((leftdown[1]-1)>=0){
					if(board[leftdown[0]][leftdown[1]-1]=="ʮ")
						leftdown_left=true;
				}
				if (upright_right==true)
					chessboard.setUser_mark(posX,upright[1]+1,mark);
				if(leftdown_left==true)
					chessboard.setUser_mark(posX,leftdown[1]-1,mark);
				break;
			case 1://45�ȷ���
				while (upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]-1][upright[1]+1]==ico){
					upright[0]-=1;
					upright[1]+=1;
				}//���Ϸ�
				if(upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE){
					if(board[upright[0]-1][upright[1]+1]=="ʮ"){
						upright_right=true;
					}
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0 &&board[leftdown[0]+1][leftdown[1]-1]==ico){
					leftdown[0]+=1;
					leftdown[1]-=1;
				}//���·�
				if(leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0){
					if(board[leftdown[0]+1][leftdown[1]-1]=="ʮ")
						leftdown_left=true;
				}
				if(upright_right==true)
					chessboard.setUser_mark(upright[0]-1,upright[1]+1,mark);
				if(leftdown_left==true)
					chessboard.setUser_mark(leftdown[0]+1,leftdown[1]-1,mark);
				break;
			case 2://90�ȷ���
				while (upright[0]-1>=0 && board[upright[0]-1][upright[1]]==ico){
					upright[0]-=1;
				}//�Ϸ�
				if(upright[0]-1>=0){
					if(board[upright[0]-1][upright[1]]=="ʮ")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]]==ico){
					leftdown[0]+=1;
				}//�·�
				if(leftdown[0]+1< Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]]=="ʮ")
						leftdown_left=true;
				}
				if(upright_right==true)
					chessboard.setUser_mark(upright[0]-1,upright[1],mark);
				if(leftdown_left==true)
					chessboard.setUser_mark(leftdown[0]+1,leftdown[1],mark);
				break;

			case 3://135�ȷ���
				while (upright[0]-1>=0 && upright[1]-1>=0 && board[upright[0]-1][upright[1]-1]==ico){
					upright[0]-=1;
					upright[1]-=1;
				}//���Ϸ�
				if(upright[0]-1>=0 && upright[1]-1>=0){
					if(board[upright[0]-1][upright[1]-1]=="ʮ")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]+1]==ico){
					leftdown[0]+=1;
					leftdown[1]+=1;
				}//���Ϸ�
				if(leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]+1]=="ʮ")
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
			case 0://ˮƽ����
				while (upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]][upright[1]+1]==ico)
					upright[1]+=1;//ˮƽ���ҷ���
				if ((upright[1]+1)< Chessboard.BOARD_SIZE) {//�����Ҷ˵��ұ�λ�ò�Խ�粢��û���ӣ��Ż�ƽ��
					if(board[upright[0]][upright[1]+1]=="ʮ") {
						upright_right = true;
					}
				}
				while (leftdown[1]-1>=0 && board[leftdown[0]][leftdown[1]-1]==ico)
					leftdown[1] -= 1;//ˮƽ������
				if((leftdown[1]-1)>=0){
					if(board[leftdown[0]][leftdown[1] - 1] == "ʮ")
						leftdown_left=true;
				}
				if (upright_right==true)
					chessboard.setComputer_mark(posX, upright[1] + 1, mark);
				if(leftdown_left==true)
					chessboard.setComputer_mark(posX, leftdown[1] - 1, mark);
				break;
			case 1://45�ȷ���
				while (upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE && board[upright[0]-1][upright[1]+1]==ico){
					upright[0]-=1;
					upright[1]+=1;
				}//���Ϸ�
				if(upright[0]-1>=0 && upright[1]+1< Chessboard.BOARD_SIZE){
					if(board[upright[0]-1][upright[1]+1]=="ʮ"){
						upright_right=true;
					}
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]-1>=0 &&board[leftdown[0]+1][leftdown[1]-1]==ico){
					leftdown[0]+=1;
					leftdown[1]-=1;
				}//���·�
				if(leftdown[0] + 1 < Chessboard.BOARD_SIZE && leftdown[1]-1>=0){
					if(board[leftdown[0]+1][leftdown[1]-1]=="ʮ")
						leftdown_left = true;
				}
				if(upright_right==true)
					chessboard.setComputer_mark(upright[0] - 1, upright[1] + 1, mark);
				if(leftdown_left==true)
					chessboard.setComputer_mark(leftdown[0] + 1, leftdown[1] - 1, mark);
				break;
			case 2://90�ȷ���
				while (upright[0]-1>=0 && board[upright[0]-1][upright[1]]==ico){
					upright[0]-=1;
				}//�Ϸ�
				if(upright[0]-1>=0){
					if(board[upright[0]-1][upright[1]]=="ʮ")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]]==ico){
					leftdown[0]+=1;
				}//�·�
				if (leftdown[0] + 1 < Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]]== "ʮ")
						leftdown_left = true;
				}
				if(upright_right==true)
					chessboard.setComputer_mark(upright[0] - 1, upright[1], mark);
				if(leftdown_left==true)
					chessboard.setComputer_mark(leftdown[0] + 1, leftdown[1], mark);
				break;

			case 3://135�ȷ���
				while (upright[0]-1>=0 && upright[1]-1>=0 && board[upright[0]-1][upright[1]-1]==ico){
					upright[0]-=1;
					upright[1]-=1;
				}//���Ϸ�
				if(upright[0]-1>=0 && upright[1]-1>=0){
					if(board[upright[0]-1][upright[1]-1]=="ʮ")
						upright_right=true;
				}
				while (leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1]+1< Chessboard.BOARD_SIZE && board[leftdown[0]+1][leftdown[1]+1]==ico){
					leftdown[0]+=1;
					leftdown[1]+=1;
				}//���Ϸ�
				if(leftdown[0]+1< Chessboard.BOARD_SIZE && leftdown[1] + 1 < Chessboard.BOARD_SIZE){
					if(board[leftdown[0]+1][leftdown[1]+1]=="ʮ")
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
					result[0]=i;//mark���������
					result[1]=j;//mark����������
					result[2]=max;//mark�����Ӧλ��ֵ
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
					result[0]=i;//mark���������
					result[1]=j;//mark����������
					result[2]=max;//mark�����Ӧλ��ֵ
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
