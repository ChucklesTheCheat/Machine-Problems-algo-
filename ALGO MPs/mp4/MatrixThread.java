public class MatrixThread implements Runnable{
	
	private int row;
	private int col;
	private int[][] A1;
	private int[][] B1;
	private int[][] C1;
	
	public MatrixThread(int row, int col, int[][] A1, int [][] B1, int[][] C1) {
                
		this.row = row;
		this.col = col;
		this.A1 = A1;
		this.B1 = B1;
		this.C1 = C1;
	}

	@Override
	public void run() {
		C1[row][col] = 0;
		
		for(int i = 0; i < A1[0].length ; i++) {
			C1[row][col] += A1[row][i] * B1[i][col];
		}
	}
}