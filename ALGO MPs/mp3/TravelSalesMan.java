import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class TravelSalesMan {
    GridBagConstraints c = new GridBagConstraints();
    JFrame mainFrame;
    JPanel panel;
    JPanel tablePanel;
    JTextField lblnMatrix;
    JButton btnMatrix;
    DefaultTableModel matrixGUI;
    JTable table;
    int dimension = 0;
    int step = 0;
    String originalMatrixArray[][];
    String matrixArray[][];
    String reducedMatrixArray[][];
    String paths[][];
    String totalPaths[][];
    int pathNo;
    int totalCost;
    int ASCII;
    int gridYPos = 0;
    int gridXPos = 0;

    TravelSalesMan() {
        mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for proper close
        mainFrame.setSize(new Dimension(500,1000));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Travel Sales Man Problem");
        mainFrame.setVisible(true);
        panel = new JPanel(new GridBagLayout());

        lblnMatrix = new JTextField();
        lblnMatrix.setPreferredSize(new Dimension(150, 25));

        btnMatrix = new JButton("Submit");
        btnMatrix.setSize(100, 25);



        btnMatrix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mainFrame.getContentPane().remove(1);
                SwingUtilities.updateComponentTreeUI(mainFrame);
                gridYPos = 0;
                gridXPos = 0;
                tablePanel = new JPanel(new GridBagLayout());
                ASCII = 65;
                totalCost = 0;
                step = 0;
                //Input Table
                step++;
                String input = lblnMatrix.getText();
                String passToTable = "";
                int spaces = 1;
                int counter = 0;
                int colCounter = 1;
                int rowCounter = 1;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == ' ') {
                        spaces++;
                    }
                }
                dimension = (int)Math.ceil(Math.sqrt(spaces))+1; //gets sqrt of number of spaces in field + 1
                paths = new String[dimension-1][2];
                pathNo = 0;
                originalMatrixArray = new String[dimension][dimension]; //original copy for path counting
                matrixArray = new String[dimension][dimension]; //array for the matrix
                matrixGUI = new DefaultTableModel(dimension, dimension); //gui for the matrix

                originalMatrixArray[0][0] = "";
                matrixArray[0][0] = "";

                for(int i = 0; i < dimension; i++) { //sets all array items to -1
                    for(int j = 1; j < dimension; j++) {
                        if(i == 0) {
                            originalMatrixArray[i][j] = Character.toString((char)ASCII);
                            originalMatrixArray[j][i] = Character.toString((char)ASCII);
                            matrixArray[i][j] = Character.toString((char)ASCII);
                            matrixArray[j][i] = Character.toString((char)ASCII);
                            ASCII++;
                        }
                        else {
                            originalMatrixArray[i][j] = "-";
                            matrixArray[i][j] = "-";
                        }
                    }
                }

                while(counter < input.length()) { //gets text from field
                    if(input.charAt(counter) == ' ') {
                        if(colCounter != rowCounter) {
                            originalMatrixArray[rowCounter][colCounter] = passToTable;
                            matrixArray[rowCounter][colCounter] = passToTable;
                        }
                        if(colCounter >= dimension-1) {
                            rowCounter++;
                            colCounter = 1;
                        }
                        else {
                            colCounter++;
                        }
                        passToTable = "";
                    }
                    else {
                        passToTable = passToTable + input.charAt(counter);
                    }
                    if(counter == input.length()-1 && colCounter != rowCounter) {
                        originalMatrixArray[rowCounter][colCounter] = passToTable;
                        matrixArray[rowCounter][colCounter] = passToTable;
                    }
                    counter++;
                }

                for(int i = 0; i < dimension; i++) { //code to put array to table
                    for(int j = 0; j < dimension; j++) {
                        matrixGUI.setValueAt(matrixArray[i][j], i, j);
                    }
                }
                reducedMatrixArray = matrixArray.clone();

                c.gridx = gridXPos;
                c.gridy = gridYPos++;
                tablePanel.add(new JLabel("Step " + step), c);
                table = new JTable(matrixGUI);
                c.gridx = gridXPos;
                c.gridy = gridYPos++;
                //c.gridwidth = 2;
                c.insets = new Insets(10,10,10,10);
                tablePanel.add(table, c);

                if(paths.length > 0) {
                    if(paths.length == 2) {
                        totalCost = Integer.parseInt(originalMatrixArray[1][2]);
                        paths[0][0] = originalMatrixArray[0][1];
                        paths[0][1] = originalMatrixArray[0][2];
                        mainFrame.add(tablePanel);
                        mainFrame.setVisible(true);
                    }
                    else if(paths.length == 1) {
                        paths[0][0] = originalMatrixArray[0][1];
                        paths[0][1] = originalMatrixArray[0][1];
                        mainFrame.add(tablePanel);
                        mainFrame.setVisible(true);
                    }
                    else {
                        totalPaths = new String[paths.length][2];
                        recurse();
                        /*
                        for(int i = 0; i < paths.length; i++) {
                            for(int j = 0; j < paths.length; j++) {
                                System.out.println(paths[i][1] + " == " + paths[j][0]);
                                if(paths[i][1].equals(paths[j][0])) {
                                    totalPaths[i][0] = paths[i][0];
                                    totalPaths[i][1] = paths[j][0];
                                }
                            }
                        }
                        */

                        System.out.println(Arrays.deepToString(paths));
                        //System.out.println(Arrays.deepToString(totalPaths));
                        for(int j = 0; j < paths.length; j++) {
                            totalCost += Integer.parseInt(originalMatrixArray[(int)paths[j][0].charAt(0)-64][(int)paths[j][1].charAt(0)-64]);
                        }

                    }
                }

                c.gridx = 0;
                c.gridy = gridYPos++;
                tablePanel.add(new JLabel(Arrays.deepToString(paths)), c);
                c.gridx = 0;
                c.gridy = gridYPos++;
                tablePanel.add(new JLabel(String.valueOf(totalCost)), c);
                JScrollPane scroll = new JScrollPane(tablePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                mainFrame.add(scroll, BorderLayout.CENTER);
                System.out.println(totalCost);
            }
        });

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,10,10);
        c.gridwidth = 4;
        panel.add(lblnMatrix, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(btnMatrix, c);
        mainFrame.add(panel, BorderLayout.NORTH);
        mainFrame.add(new JLabel());
        mainFrame.setVisible(true);
        c.gridwidth = 1;
    }

    void recurse() {
        boolean found = false;
        if(reducedMatrixArray.length > 3 && reducedMatrixArray.length > originalMatrixArray.length - 2) {
            rowMinimization();
            columnMinimization();
            penaltyReduction();
            recurse();
        }
        else if (reducedMatrixArray.length > 3) {
            penaltyReduction();
            recurse();
        }
        else if (reducedMatrixArray.length <= 3) {
            for(int i = 1; i < reducedMatrixArray.length; i++) {
                for(int j = 0; j < paths.length; j++) {
                    if (!(reducedMatrixArray[i][0] + reducedMatrixArray[0][i]).equals(paths[j][1] + paths[j][0])) {
                        System.out.println(reducedMatrixArray[i][0] + reducedMatrixArray[0][i] + " != " + paths[j][1] + paths[j][0]);
                    }
                    else {
                        System.out.println(reducedMatrixArray[i][0] + reducedMatrixArray[0][i] + " == " + paths[j][1] + paths[j][0]);
                        found = true;
                    }
                }
                if(!found) {
                    paths[pathNo][0] = reducedMatrixArray[i][0];
                    paths[pathNo][1] = reducedMatrixArray[0][i];
                    pathNo++;
                }
            }
        }
        gridXPos++;
        System.out.println(Arrays.deepToString(paths));
    }

    void rowMinimization() {
        //rowmin
        step++;
        matrixGUI = new DefaultTableModel(dimension, dimension);
        int rowMin = Integer.MAX_VALUE;
        for(int i = 1; i < dimension; i++) {
            for(int j = 1; j < dimension; j++) {
                if(matrixArray[i][j] != "-") {
                    if (Integer.valueOf(matrixArray[i][j]) < rowMin) {
                        rowMin = Integer.valueOf(matrixArray[i][j]);
                    }
                }
            }
            for(int j = 1; j < dimension; j++) {
                if(matrixArray[i][j] != "-") {
                    matrixArray[i][j] = String.valueOf(Integer.valueOf(matrixArray[i][j]) - rowMin);
                }
            }
            rowMin = Integer.MAX_VALUE;
        }

        for(int i = 0; i < dimension; i++) { //code to put array to table
            for(int j = 0; j < dimension; j++) {
                matrixGUI.setValueAt(matrixArray[i][j], i, j);
            }
        }


        c.gridx = gridXPos;
        c.gridy = gridYPos++;
        tablePanel.add(new JLabel("Step " + step + " Row Minimization"), c);
        table = new JTable(matrixGUI);
        c.gridx = gridXPos;
        c.gridy = gridYPos++;
        //c.gridwidth = 2;
        c.insets = new Insets(10,10,10,10);
        tablePanel.add(table, c);
    }

    void columnMinimization() {
        //colmin
        step++;
        matrixGUI = new DefaultTableModel(dimension, dimension);
        int colMin = Integer.MAX_VALUE;
        for(int i = 1; i < dimension; i++) {
            for(int j = 1; j < dimension; j++) {
                if(matrixArray[i][j] != "-" && matrixArray[j][i] != "-") {
                    if (Integer.valueOf(matrixArray[j][i]) < colMin) {
                        colMin = Integer.valueOf(matrixArray[j][i]);
                    }
                }
            }
            for(int j = 1; j < dimension; j++) {
                if(matrixArray[i][j] != "-" && matrixArray[j][i] != "-") {
                    matrixArray[j][i] = String.valueOf(Integer.valueOf(matrixArray[j][i]) - colMin);
                }
            }
            colMin = Integer.MAX_VALUE;
        }

        for(int i = 0; i < dimension; i++) { //code to put array to table
            for(int j = 0; j < dimension; j++) {
                matrixGUI.setValueAt(matrixArray[i][j], i, j);
            }
        }


        c.gridx = gridXPos;
        c.gridy = gridYPos++;
        tablePanel.add(new JLabel("Step " + step + " Column Minimization"), c);
        table = new JTable(matrixGUI);
        c.gridx = gridXPos;
        c.gridy = gridYPos++;
        //c.gridwidth = 2;
        c.insets = new Insets(10,10,10,10);
        tablePanel.add(table, c);
    }

    void penaltyReduction() {
        //Penalty
        step++;
        int rMin = Integer.MAX_VALUE;
        int cMin = Integer.MAX_VALUE;
        int penalty = Integer.MIN_VALUE;
        int cPos = -1;
        int rPos = -1;
        for(int i = 1; i < dimension; i++) {
            for (int j = 1; j < dimension; j++) {
                if(matrixArray[i][j] != "-") {
                    if (Integer.valueOf(matrixArray[i][j]) == 0) {
                        for (int k = 1; k < dimension; k++) {
                            if (matrixArray[k][j] != "-" && matrixArray[k][i] != "-" && rMin > Integer.valueOf(matrixArray[k][j])) {
                                rMin = Integer.valueOf(matrixArray[k][j]);
                            }
                        }
                        for (int k = 1; k < dimension; k++) {
                            if (matrixArray[k][j] != "-" && matrixArray[k][i] != "-" && cMin > Integer.valueOf(matrixArray[k][j])) {
                                cMin = Integer.valueOf(matrixArray[k][j]);
                            }
                        }
                        if (penalty < Math.abs(rMin + cMin)) {
                            penalty = Math.abs(rMin + cMin);
                            rPos = i-1;
                            cPos = j-1;
                        }
                        rMin = Integer.MAX_VALUE;
                        cMin = Integer.MAX_VALUE;
                    }
                }
            }
        }

        //Reduction
        matrixArray[cPos+1][rPos+1] = "-";
        --dimension; //reduces rows/columns also in array
        matrixGUI = new DefaultTableModel(dimension, dimension);
        reducedMatrixArray = new String[dimension][dimension];
        int p = 0;
        int q = 0;

        for(int i = 0; i < dimension+1; i++) { //reduce array remove row and column
            if(i == rPos+1) {
                continue;
            }
            q = 0;
            for(int j = 0; j < dimension+1; j++) {
                if(j == cPos+1) {
                    continue;
                }
                reducedMatrixArray[p][q] = matrixArray[i][j];
                q++;
            }
            p++;
        }

        for(int i = 0; i < dimension; i++) { //code to put array to table
            for(int j = 0; j < dimension; j++) {
                matrixGUI.setValueAt(reducedMatrixArray[i][j], i, j);
            }
        }

        c.gridx = gridXPos;
        c.gridy = gridYPos++;
        tablePanel.add(new JLabel("Step " + step + " Penalty and Reduction"), c);
        table = new JTable(matrixGUI);
        c.gridx = gridXPos;
        c.gridy = gridYPos++;
        //c.gridwidth = 2;
        c.insets = new Insets(10,10,10,10);
        tablePanel.add(table, c);
        mainFrame.add(tablePanel, BorderLayout.CENTER);

        //note path
        mainFrame.setVisible(true);
        paths[pathNo][0] = matrixArray[rPos+1][0];
        paths[pathNo][1] = matrixArray[0][cPos+1];
        pathNo++;

        matrixArray = reducedMatrixArray.clone();

        //note path and then minimize again and then penalty again and then reduce again until 2x2 array left
    }

    public static void main(String args[]) {
        //TSP JavaFX
        new TravelSalesMan();
    }
}