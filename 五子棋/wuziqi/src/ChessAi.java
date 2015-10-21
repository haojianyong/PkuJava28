
public class ChessAi {
	Chessboard chessboard;
	int BOARD_SIZE;
	String chessman;
	public ChessAi(Chessboard b,int bs,String cm) {
		// TODO Auto-generated constructor stub
		chessboard=b;
		BOARD_SIZE=bs;
		chessman=cm;
	}
	public boolean isWon(int posX, int posY, String ico) {
		int i,j;
		i=-1;
		j=+1;
		while(posY+i>=0&&chessboard.getBoard()[posX][posY+i].equals(ico))i--;
		while(posY+j<chessboard.BOARD_SIZE&&chessboard.getBoard()[posX][posY+j].equals(ico))j++;
		if(j-i-1>=5)return true;

		i=-1;
		j=+1;
		while(posX+i>=0&&chessboard.getBoard()[posX+i][posY].equals(ico))i--;
		while(posX+j<chessboard.BOARD_SIZE&&chessboard.getBoard()[posX+j][posY].equals(ico))j++;
		if(j-i-1>=5)return true;

		i=-1;
		j=+1;
		while(posX+i>=0&&posY+i>=0&&chessboard.getBoard()[posX+i][posY+i].equals(ico))i--;
		while(posX+j<chessboard.BOARD_SIZE&&posY+j<chessboard.BOARD_SIZE&&chessboard.getBoard()[posX+j][posY+j].equals(ico))j++;
		if(j-i-1>=5)return true;

		i=-1;
		j=+1;
		while(posX-i<chessboard.BOARD_SIZE&&posY+i>=0&&chessboard.getBoard()[posX-i][posY+i].equals(ico))i--;
		while(posX-j>=0&&posY+j<chessboard.BOARD_SIZE&&chessboard.getBoard()[posX-j][posY+j].equals(ico))j++;
		if(j-i-1>=5)return true;

		return false;
	}
	public int[] decide(){
		int[] res=new int[2];
		int p1x,p1y,p2x,p2y;
		boolean flag=true;
		
		for(int i=0;flag&&i<chessboard.BOARD_SIZE*chessboard.BOARD_SIZE;i++){
			p1x=i/chessboard.BOARD_SIZE;
			p1y=i%chessboard.BOARD_SIZE;
			if(chessboard.getBoard()[p1x][p1y]=="十")chessboard.setBoard(p1x, p1y,Chessman.WHITE.getChessman());
			else continue;
			if(isWon(p1x,p1y,Chessman.WHITE.getChessman())){
				res[0]=p1x;
				res[1]=p1y;
				flag=false;
			}
			chessboard.setBoard(p1x, p1y,"十");
		}
		if(flag==false)return res;

		for(int i=0;flag&&i<chessboard.BOARD_SIZE*chessboard.BOARD_SIZE;i++){
			p1x=i/chessboard.BOARD_SIZE;
			p1y=i%chessboard.BOARD_SIZE;
			if(chessboard.getBoard()[p1x][p1y]=="十")chessboard.setBoard(p1x, p1y,Chessman.BLACK.getChessman());
			else continue;
			if(isWon(p1x,p1y,Chessman.BLACK.getChessman())){
				res[0]=p1x;
				res[1]=p1y;
				flag=false;
			}
			chessboard.setBoard(p1x, p1y,"十");
		}
		if(flag==false)return res;

		for(int i=0;flag&&i<chessboard.BOARD_SIZE*chessboard.BOARD_SIZE;i++){
			p1x=i/chessboard.BOARD_SIZE;
			p1y=i%chessboard.BOARD_SIZE;
			if(chessboard.getBoard()[p1x][p1y]=="十")chessboard.setBoard(p1x, p1y,Chessman.WHITE.getChessman());
			else continue;
			for(int j=0;flag&&j<chessboard.BOARD_SIZE*chessboard.BOARD_SIZE;j++){
				p2x=j/chessboard.BOARD_SIZE;
				p2y=j%chessboard.BOARD_SIZE;
				if(chessboard.getBoard()[p2x][p2y]=="十")chessboard.setBoard(p1x, p1y,Chessman.WHITE.getChessman());
				else continue;
				if(isWon(p2x,p2y,Chessman.WHITE.getChessman())){
					res[0]=p2x;
					res[1]=p2y;
					flag=false;
				}
				chessboard.setBoard(p2x, p2y,"十");
			}
			chessboard.setBoard(p1x, p1y,"十");
		}
		if(flag==false)return res;
		
		for(int i=0;flag&&i<chessboard.BOARD_SIZE*chessboard.BOARD_SIZE;i++){
			p1x=i/chessboard.BOARD_SIZE;
			p1y=i%chessboard.BOARD_SIZE;
			if(chessboard.getBoard()[p1x][p1y]=="十")chessboard.setBoard(p1x, p1y,Chessman.BLACK.getChessman());
			else continue;
			for(int j=0;flag&&j<chessboard.BOARD_SIZE*chessboard.BOARD_SIZE;j++){
				p2x=j/chessboard.BOARD_SIZE;
				p2y=j%chessboard.BOARD_SIZE;
				if(chessboard.getBoard()[p2x][p2y]=="十")chessboard.setBoard(p1x, p1y,Chessman.BLACK.getChessman());
				else continue;
				if(isWon(p2x,p2y,Chessman.BLACK.getChessman())){
					res[0]=p2x;
					res[1]=p2y;
					flag=false;
				}
				chessboard.setBoard(p2x, p2y,"十");
			}
			chessboard.setBoard(p1x, p1y,"十");
		}
		if(flag==false)return res;

		int[][] score=new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE];
		int pb,pw,pl,pr;
		pb=5;
		pw=8;
		pl=6;
		pr=6;
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				score[i][j]=0;
				if(chessboard.getBoard()[i][j]=="十"){
					if(i-1>=0){
						if(chessboard.getBoard()[i-1][j]==Chessman.BLACK.getChessman()){
							score[i][j]+=pb;
						}
						else if(chessboard.getBoard()[i-1][j]==Chessman.WHITE.getChessman()){
							score[i][j]+=pw;
						}
					}
					if(i+1<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[i+1][j]==Chessman.BLACK.getChessman()){
							score[i][j]+=pb;
						}
						else if(chessboard.getBoard()[i+1][j]==Chessman.WHITE.getChessman()){
							score[i][j]+=pw;
						}
					}
					if(j-1>=0){
						if(chessboard.getBoard()[i][j-1]==Chessman.BLACK.getChessman()){
							score[i][j]+=pb;
						}
						else if(chessboard.getBoard()[i][j-1]==Chessman.WHITE.getChessman()){
							score[i][j]+=pw;
						}
					}
					if(j+1<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[i][j+1]==Chessman.BLACK.getChessman()){
							score[i][j]+=pb;
						}
						else if(chessboard.getBoard()[i][j+1]==Chessman.WHITE.getChessman()){
							score[i][j]+=pw;
						}
					}
					if(i-1>=0&&j-1>=0){
						if(chessboard.getBoard()[i-1][j-1]==Chessman.BLACK.getChessman()){
							score[i][j]+=pl;
						}
						else if(chessboard.getBoard()[i-1][j-1]==Chessman.WHITE.getChessman()){
							score[i][j]+=pl;
						}
					}
					if(i-1>=0&&j+1<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[i-1][j+1]==Chessman.BLACK.getChessman()){
							score[i][j]+=pr;
						}
						else if(chessboard.getBoard()[i-1][j+1]==Chessman.WHITE.getChessman()){
							score[i][j]+=pr;
						}
					}
					if(i+1<chessboard.BOARD_SIZE&&j-1>=0){
						if(chessboard.getBoard()[i+1][j-1]==Chessman.BLACK.getChessman()){
							score[i][j]+=pr;
						}
						else if(chessboard.getBoard()[i+1][j-1]==Chessman.WHITE.getChessman()){
							score[i][j]+=pr;
						}
					}
					if(i+1<chessboard.BOARD_SIZE&&j+1<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[i+1][j+1]==Chessman.BLACK.getChessman()){
							score[i][j]+=pl;
						}
						else if(chessboard.getBoard()[i+1][j+1]==Chessman.WHITE.getChessman()){
							score[i][j]+=pl;
						}
					}
				}
			}
		}
		int max=0;
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				if(score[i][j]>max){
					max=score[i][j];
					res[0]=i;
					res[1]=j;
				}
			}
		}

		//		res[0]=(int)Math.random()*chessboard.BOARD_SIZE;
		//		res[1]=(int)Math.random()*chessboard.BOARD_SIZE;
		//		while(chessboard.getBoard()[res[0]][res[1]]!="十"){
		//			res[0]=(int)((Math.random())*chessboard.BOARD_SIZE);
		//			res[1]=(int)((Math.random())*chessboard.BOARD_SIZE);
		//		}
		return res;
	}
}
