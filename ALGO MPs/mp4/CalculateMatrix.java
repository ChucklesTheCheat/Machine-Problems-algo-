import java.util.ArrayList;

public class CalculateMatrix {

	private int[][] A1;
	private int[][] B1;
	private int[][] C1;
	
	public CalculateMatrix(int[][] A1, int [][] B1, int[][] C1) {
                //initialize
		this.A1 = A1;
		this.B1 = B1;
		this.C1 = C1;
	}
	
	public void run(){
             //CALCULATING THE VALUE OF FIRST AND SECOND MATRIX CELLS
		ArrayList<Thread> threads = new ArrayList<>();
		for(int i = 0; i < C1.length ; i ++) {
			for(int j = 0 ; j < C1[0].length; j++) {
				Thread th = new Thread(new MatrixThread(i,j,A1,B1,C1));
				threads.add(th);
				th.run();
			}
		}
		
		for(Thread x : threads) {
			try {
				x.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}