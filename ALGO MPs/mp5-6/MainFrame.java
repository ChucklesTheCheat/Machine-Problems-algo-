
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mahmoud Abas
 */
public class MainFrame extends javax.swing.JFrame {

   
    private MainFramePresenter presenter;
    private final DefaultTableModel matrixTable;
    private final DefaultTableModel solutionTable;

    public MainFrame() {
        initComponents();
        matrixTable = (DefaultTableModel) jTable1.getModel(); //for user input
        solutionTable = (DefaultTableModel) jTable2.getModel(); //for solution
        createMatrix();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        equationsCountSpinner = new javax.swing.JSpinner();
        varsCountSpinner = new javax.swing.JSpinner();
        randomNumbers = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        gausianRadio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gaussian elimination calculator");

        jPanel1.setBackground(new java.awt.Color(202, 168, 230));

        jPanel3.setBackground(new java.awt.Color(169, 111, 186));

        equationsCountSpinner.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        equationsCountSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        equationsCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                refreshMatrix(evt);
            }
        });

        varsCountSpinner.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        varsCountSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        varsCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                refreshMatrix(evt);
            }
        });

        randomNumbers.setBackground(new java.awt.Color(153, 204, 0));
        randomNumbers.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        randomNumbers.setForeground(new java.awt.Color(255, 255, 255));
        randomNumbers.setSelected(true);
        randomNumbers.setText("Random Numbers");
        randomNumbers.setBorder(null);
        randomNumbers.setOpaque(false);
        randomNumbers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomNumbersActionPerformed(evt);
            }
        });

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        gausianRadio.setBackground(new java.awt.Color(89, 173, 208));
        buttonGroup1.add(gausianRadio);
        gausianRadio.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        gausianRadio.setForeground(new java.awt.Color(89, 173, 208));
        gausianRadio.setSelected(true);
        gausianRadio.setText("Gaussian Elimination");

        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel3.setText("Solve By : ");

        jLabel4.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Number of Equations : ");

        jLabel5.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Number of Variables :");

        jLabel1.setFont(new java.awt.Font("Edwardian Script ITC", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gaussian Elimination");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(equationsCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(405, 405, 405)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varsCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(randomNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(gausianRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(gausianRadio)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(randomNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varsCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(equationsCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(210, 89, 194));

        jPanel4.setBackground(new java.awt.Color(159, 195, 230));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrix", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Candara Light", 1, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(245, 215, 122));
        jButton2.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jButton2.setText("Solve");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(139, 230, 180));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solution", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Candara Light", 1, 18))); // NOI18N

        jTable2.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Variable", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Candara Light", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.getAccessibleContext().setAccessibleName("SOLUTION"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            getEqationsFromTable();
            solveSystemWithPrint();
        }
        catch(java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
        "Error: Please fill all cells with only numbers",
        "Error",
        JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String solutions =  "\tCheck All Iteams in Leading Column Equal to Zero\n\n" +
                            "     for (int i = leadingRowToStart + 1; i < equationsToCheck.size(); i++) {\n" +
                            "            Equation equation = equationsToCheck.get(i);\n" +
                            "            if (equation.getColValInIndex(leadingColToCheck) != 0) {\n" +
                            "                return false;}\n\n" +
                            "\tCheck All zero equation\n\n" +
                            "     for (int i = 0; i < equationsToCheck.size(); i++) {\n" +
                            "            Equation equation = equationsToCheck.get(i);\n" +
                            "            if (equation.isZeroRow()) {\n" +
                            "                lastZeroEquation = i;\n" +
                            "            } else {\n" +
                            "                if (i > lastZeroEquation) {\n" +
                            "                    return false;\n" +
                            "                }}}  return true;\n\n" +
                            "\tMake all items in column equal to zero except the first value\n\n" +
                            "     for (int i = 1; i < equations.size(); i++) {\n" +
                            "            Equation equation = equations.get(i);\n" +
                            "            double numToMul = -equation.getColValInIndex(indexOfColToChange);\n" +
                            "            equation.addEquation(currentRow.mulWithNumberGetEquationCopy(numToMul)); }\n\n" +
                            "\tGet first value non zero column and row index\n\n" +
                            "     for (int i = 0; i < equations.size(); i++) {\n" +
                            "            Equation equation = equations.get(i);\n" +
                            "            int tempeFirstNonZeroCol = equation.getFirstNonZeroIndex();\n" +
                            "            if (tempeFirstNonZeroCol != -1 && tempeFirstNonZeroCol < firstNonZeroCol) {\n" +
                            "                firstNonZeroCol = tempeFirstNonZeroCol;\n" +
                            "                row_index = i;\n" +
                            "            }\n" +
                            "        }\n" +
                            "        return row_index;\n\n" +
                            "\tCollect results from  the system\n\n" +
                            "     for (int i = vars.length - 1; i >= 0; i--) {\n" +
                            "            Equation equation;\n\n" + 
                            "\tGet Equations from table\n\n" +
                            "     for (int row = 0; row < rowsCount; row++) {\n" +
                            "            double[] equationVars = new double[colsCount];\n" +
                            "     for (int col = 0; col < colsCount; col++) {\n" +
                            "                String val = matrixTable.getValueAt(row, col).toString();\n" +
                            "                equationVars[col] = Double.valueOf(\n" +
                            "                        val.isEmpty() ? \"0\" : val\n" +
                            "                );\n" +
                            "            } presenter.addEquationToSystem(new Equation(equationVars)); }";
        jTextArea1.setText(solutions);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void refreshMatrix(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_refreshMatrix
        createMatrix();
    }//GEN-LAST:event_refreshMatrix

    private void randomNumbersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomNumbersActionPerformed
       
        if (randomNumbers.isSelected()) {
            testData();
        } else {
            emptyData();
        }
    }//GEN-LAST:event_randomNumbersActionPerformed

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            MainFramePresenter mainFramePresenter = MainFramePresenter.getInstance();
            mainFramePresenter.setFrame(frame);
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner equationsCountSpinner;
    private javax.swing.JRadioButton gausianRadio;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JCheckBox randomNumbers;
    private javax.swing.JSpinner varsCountSpinner;
    // End of variables declaration//GEN-END:variables

    private void solveSystemWithPrint() throws Exception {
        presenter.printSystem();
        if (gausianRadio.isSelected()) {
            presenter.solveByGausian();
        } 
        
    }

    private void createMatrix() {
        int eqationsCount = (int) equationsCountSpinner.getValue();
        int varsCount = (int) varsCountSpinner.getValue();
        String[] varsNames = new String[varsCount];
        matrixTable.setColumnCount(0);
        for (int i = 0; i < varsCount; i++) {
            varsNames[i] = "x" + (i + 1);
            matrixTable.addColumn(varsNames[i]);
        }
        matrixTable.addColumn("=");
        matrixTable.setRowCount(eqationsCount);
        if (randomNumbers.isSelected()) {
            testData();
        } else {
            emptyData();
        }
    }

    private void getEqationsFromTable() {
        presenter.clearSystem();
        int colsCount = matrixTable.getColumnCount();
        int rowsCount = matrixTable.getRowCount();
        for (int row = 0; row < rowsCount; row++) {
            double[] equationVars = new double[colsCount];
            for (int col = 0; col < colsCount; col++) {
                String val = matrixTable.getValueAt(row, col).toString();
                equationVars[col] = Double.valueOf(
                        val.isEmpty() ? "0" : val
                );
            }
            presenter.addEquationToSystem(new Equation(equationVars));
        }
    }

    public void addResultsToTable(double[] finalResultFromSystem) {
        solutionTable.setRowCount(0);
        for (int i = 0; i < finalResultFromSystem.length; i++) {
            solutionTable.addRow(
                    new String[]{
                        "x" + (i + 1),
                        String.valueOf(finalResultFromSystem[i])
                    }
            );
        }
    }

    private void testData() {
        for (int i = 0; i < matrixTable.getColumnCount(); i++) {
            for (int j = 0; j < matrixTable.getRowCount(); j++) {
                matrixTable.setValueAt(
                        1 + (int) (Math.random() * ((10 - 1) + 1)),
                        j, i);
            }
        }
    }

    public void setPresenter(MainFramePresenter presenter) {
        this.presenter = presenter;
    }

    private void emptyData() {
        for (int i = 0; i < matrixTable.getColumnCount(); i++) {
            for (int j = 0; j < matrixTable.getRowCount(); j++) {
                matrixTable.setValueAt(
                        "",
                        j, i);
            }
        }
    }
}