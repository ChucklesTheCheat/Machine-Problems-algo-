import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

	int[][] First;
	int[][] Second;
	int[][] Value;
	String Title = "Strassen Matrix Multiplication";
	JFrame mainWindow;
	JTextField FirstLength; 
	JTextField FirstWidth;
	JTextField SecondLength;
	JTextField SecondWidth;
	JTextArea Errors;
	JButton NextButton;
	Container container;

	public static void main(String[] args) {
		GUI gui = new GUI();

		gui.InitGUI();
	}

	public void InitGUI() {
                
		mainWindow = new JFrame(Title);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FirstLength = new JTextField();
		FirstLength.setEditable(true);
                FirstLength.setForeground(Color.RED);
		FirstLength.setBorder(BorderFactory.createTitledBorder("FIRST MATRIX LENGTH : "));  
                FirstLength.setBackground(Color.LIGHT_GRAY);

		FirstWidth = new JTextField();
		FirstWidth.setEditable(true);
                FirstWidth.setForeground(Color.RED);
		FirstWidth.setBorder(BorderFactory.createTitledBorder("FIRST MATRIX WIDTH :"));
                FirstWidth.setBackground(Color.LIGHT_GRAY);
                
		SecondLength = new JTextField();
		SecondLength.setEditable(true);
                SecondLength.setForeground(Color.RED);
		SecondLength.setBorder(BorderFactory.createTitledBorder("SECOND MATRIX LENGTH :"));
                SecondLength.setBackground(Color.LIGHT_GRAY);
                
		SecondWidth = new JTextField();
		SecondWidth.setEditable(true);
                SecondWidth.setForeground(Color.RED);
		SecondWidth.setBorder(BorderFactory.createTitledBorder("SECOND MATRIX WIDTH :"));
                SecondWidth.setBackground(Color.LIGHT_GRAY);
                
		Errors = new JTextArea();
		Errors.setEditable(false);
		Errors.setText("NOTE: THE VALUE OF THE FIRST MATRIX WIDTH MUST BE \nEQUAL TO THE LENGTH OF THE SECOND MATRIX.");
                Errors.setFont(new Font("Bahnschrift", Font.BOLD, 11));
                Errors.setBackground(Color.WHITE);

		NextButton = new JButton("Next");
                NextButton.setBackground(Color.black);
                NextButton.setBounds(220,180,100,30);//(x,y,width, height) 
                NextButton.setForeground(Color.white);
		NextButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    if (FirstWidth.getText() != null && SecondWidth.getText() != null && FirstLength.getText() != null && SecondLength.getText() != null) //it must contain a value it cannot be left blank during insert
                    { 
			if (!FirstWidth.getText().equals("") && !SecondWidth.getText().equals("") && !FirstLength.getText().equals("") && !SecondLength.getText().equals("")) //IF MAY INIMPUT BA SI USER O WALA
                        {
				if (!FirstWidth.getText().equals(SecondLength.getText())) { //IF THE FIST WIDTH IS NOT EQUAL TO THE VALUE OF SECOND LENGTH ERROR MUST OCCUR
							Errors.setText("NOTE: THE VALUE OF THE FIRST MATRIX WIDTH MUST BE \nEQUAL TO THE LENGTH OF THE SECOND MATRIX.");
						} else {
							try {   //SHOW SECOND FRAME
								First = new int[Integer.parseInt(FirstLength.getText())][Integer.parseInt(FirstWidth.getText())];
								Second = new int[Integer.parseInt(SecondLength.getText())][Integer.parseInt(SecondWidth.getText())];
								Value = new int[First.length][Second[0].length];
								ShowMatrices();
							} catch (Exception ex) {
								Errors.setText("NOTE: IN MATRIX CELLS, PLEASE ONLY \nPOSITIVE NUMBER ARE ACCEPTED."); //IF YOU INPUT 0 AND NEGATIVE NUMBERS
								return;
							}
						}
					} else {
						Errors.setText("NOTE: FILL EACH TEXT BOX WITH POSITIVE INTEGERS."); //IF WALA INUMPUT SI USER TAPOS NAG NEXT BUTTON
					}
				} 
			}
		});

		container = mainWindow.getContentPane();
		container.setLayout(new BorderLayout(6,6));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		panel.add(FirstLength);
		panel.add(FirstWidth);
		panel.add(SecondLength);
		panel.add(SecondWidth);

		container.add(panel, BorderLayout.CENTER);
		container.add(NextButton, BorderLayout.SOUTH);
		container.add(Errors, BorderLayout.NORTH);
                
                
		mainWindow.pack();
		mainWindow.setSize(350, 300);
		mainWindow.setVisible(true);
                mainWindow.setLocationRelativeTo(null); 
	}//first frame

	public void ShowMatrices() { //second frame
		JLabel AMatrixLabel = new JLabel("FIRST MATRIX CELLS :");
                AMatrixLabel.setFont(new Font("", Font.BOLD, 14));
                AMatrixLabel.setForeground(Color.RED);
                
		JTextField[][] AFields = new JTextField[First.length][First[0].length];
		JPanel Grid = new JPanel();
		Grid.setLayout(new GridLayout(First.length, First[0].length));
                Grid.setBackground(Color.BLACK);
		
                for (int i = 0; i < AFields.length; i++) {
			for (int j = 0; j < AFields[0].length; j++) {
				AFields[i][j] = new JTextField();
				AFields[i][j].setEditable(true);
				Grid.add(AFields[i][j]);
			}
		}

		JPanel APanel = new JPanel();
		APanel.setLayout(new BorderLayout(0, 0));
		APanel.add(AMatrixLabel, BorderLayout.NORTH);
		APanel.add(Grid, BorderLayout.CENTER);

		JLabel BMatrixLabel = new JLabel("SECOND MATRIX CELLS :");
                BMatrixLabel.setFont(new Font("", Font.BOLD, 14));
                BMatrixLabel.setForeground(Color.RED);
		JTextField[][] BFields = new JTextField[Second.length][Second[0].length];
                
		JPanel BGrid = new JPanel();
		BGrid.setLayout(new GridLayout(Second.length, Second[0].length));
                BGrid.setBackground(Color.BLACK);
		
                for (int i = 0; i < BFields.length; i++) {
			for (int j = 0; j < BFields[0].length; j++) {
				BFields[i][j] = new JTextField();
				BFields[i][j].setEditable(true);
				BGrid.add(BFields[i][j]);
			}
		}

		JPanel BPanel = new JPanel();
		BPanel.setLayout(new BorderLayout(0, 0));
		BPanel.add(BMatrixLabel, BorderLayout.NORTH);
		BPanel.add(BGrid, BorderLayout.CENTER);

		JTextArea ErrorSpot = new JTextArea();
		ErrorSpot.setEditable(false);
		ErrorSpot.setText("NOTE: FILL ALL THE BLANK TABLE WITH INTEGERS. ");
                ErrorSpot.setFont(new Font("Bahnschrift", Font.BOLD, 14));

		JButton calculateButton = new JButton("CALCULATE");
                calculateButton.setBackground(Color.black);
                calculateButton.setBounds(10,40,50,20);
                calculateButton.setForeground(Color.white);
                
                
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < AFields.length; i++) { //FIRST MATRIX CELLS SHOWILNG TABLE BASE ON THE NUMBER OF THE FIRST MATRIX WIDTH IN A COLUMN AND ROW
				for (int j = 0; j < AFields[0].length; j++) {
					if (AFields[i][j].getText() != null) { ////the first matrix table must contain a value it cannot be left blank
						if (!AFields[i][j].getText().equals("")) {
							try {
                                                            First[i][j] = Integer.parseInt(AFields[i][j].getText());
								} catch (Exception ex) {
									ErrorSpot.setText("NOTE: ALL INPUT MUST BE A INTEGERS.");
									return;
								}
                                                }
                                             }
					}
				}

				for (int i = 0; i < BFields.length; i++) { //SECOND MATRIX CELLS
					for (int j = 0; j < BFields[0].length; j++) {
						if (BFields[i][j].getText() != null) { //the Second matrix table must contain a value it cannot be left blank
							if (!BFields[i][j].getText().equals("")) {
								try {
									Second[i][j] = Integer.parseInt(BFields[i][j].getText());
								} catch (Exception ex) {
									ErrorSpot.setText("NOTE: ALL INPUT MUST BE A INTEGERS.");
									return;
								}							
					}
					}
				}
                                }
				calculate();
				showResult();
			}
		});

		JFrame matrixWindow = new JFrame(Title);

		Container matrixContainer = matrixWindow.getContentPane();
		matrixContainer.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
                
		panel.add(APanel);
		panel.add(BPanel);

		matrixContainer.add(panel, BorderLayout.CENTER);
		matrixContainer.add(calculateButton, BorderLayout.SOUTH);
		matrixContainer.add(ErrorSpot, BorderLayout.NORTH);
                

		matrixWindow.pack();
		matrixWindow.setSize(First.length * 200, Second.length * 200);
		matrixWindow.setVisible(true);
                matrixWindow.setLocationRelativeTo(null); 
	}

	private void demo() {
                //Declares a 2-D array
		First = new int[3][3]; //The code int [ 3 ] [ 3 ] indicates that there will be 3 arrays of ints in the array First, with 3 ints in each array of ints.  
		Second = new int[3][3]; //The code int [ 3 ] [ 3 ] indicates that there will be 3 arrays of ints in the array Second, with 3 ints in each array of ints.
                //Frist and Second holds a reference to an array of 3 elements where each element is a reference to an array of 3 integers.
                

                //This declaration creates a matrix with the following subscripted elements
		First[0][0] = 3;
		First[0][1] = 1;
		First[0][2] = 4;
		First[1][0] = 5;
		First[1][1] = 2;
		First[1][2] = 0;
		First[2][0] = 2;
		First[2][1] = 3;
		First[2][2] = 6;

		Second[0][0] = 0;
		Second[0][1] = 1;
		Second[0][2] = 1;
		Second[1][0] = 4;
		Second[1][1] = 5;
		Second[1][2] = 3;
		Second[2][0] = 2;
		Second[2][1] = 2;
		Second[2][2] = 7;
	}

	private void calculate() { //
		CalculateMatrix runner = new CalculateMatrix(First, Second, Value);
		runner.run();
	}
        //method for the final result
	private void showResult() {
		JFrame finishFrame = new JFrame("Strassen Matrix Multiplication Result");
                
		Container finishContent = finishFrame.getContentPane();
		finishContent.setLayout(new GridLayout(Value.length, Value[0].length));
                
		for (int i = 0; i < Value.length; i++) {
			for (int j = 0; j < Value[0].length; j++) {
				finishContent.add(new JLabel("                  " + Value[i][j]));
                                
			}
		}
                
                finishContent.setBackground(Color.LIGHT_GRAY);
		finishFrame.pack();
		finishFrame.setSize(400,300);
		finishFrame.setVisible(true);
                finishFrame.setLocationRelativeTo(null); 
	}
}