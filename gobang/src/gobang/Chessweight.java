package gobang;

public class Chessweight {
	private int[][] weight;
	public int[][] getWeight() {
		return this.weight;
	}
	public void initWeight() {
		// 初始化棋盘数组
		weight = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				weight[i][j] = 0;
			}
		}
	}
	public void setWeight(int posX, int posY,int weight) {
		
		this.weight[posX][posY] = weight;
	}
}
