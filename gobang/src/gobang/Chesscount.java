package gobang;

public class Chesscount {
	
		private int[][][] count;
		public int[][][] getCount() {
			return this.count;
		}
		public void initcount() {
			// 初始化棋盘数组
			count = new int[15][15][8];
			
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					for (int k = 0; k < 8; k++) {
						count[i][j][k] = 0;
					}
				}
			}
		}
		public void setCount(int posX, int posY,int k,int cnt) {
			
			this.count[posX][posY][k] = cnt;
		}

}
