package mp8;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MSaqib
 */
public class NewJFrame extends javax.swing.JFrame {
    
public static int graph[][];  
public static int size;
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }
 // algorithm for a graph represented using adjacency matrix
    // representation
    
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < size; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
       
        txtConsole.append("  Vertex     Distance from source");
        //System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < size; i++)
                txtConsole.append("\n" + "       " + i + "\t         "+ dist[i]);

        
    }
    void dijkstra(int graph[][], int src,int dstn)
    {
        NewJPanel.SRC = src;
        NewJPanel.DSTN = dstn;
        int dist[] = new int[size]; // The output array. dist[i] will hold the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean Set[] = new Boolean[size];
        ArrayList<Integer> permanentOrder = new ArrayList<>();
        
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < size; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            Set[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < size-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, Set);
                //System.out.println("u = " + u);
            // Mark the picked vertex as processed
            Set[u] = true;
            if(!Set[dstn])
                permanentOrder.add(u);
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < size; v++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!Set[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
        // print the constructed distance array
        printSolution(dist, size);
        for(int i=0;i<size;i++)  
        if(dist[dstn]!=Integer.MAX_VALUE)
           jTextField1.setText(Integer.toString(dist[dstn]));
        else{
            JFrame frame  = new JFrame();
           frame.setSize(30,20);
           frame.setLocation(50,50); 
         JOptionPane.showMessageDialog(frame,"Source and Destination are not connected","Error",
                 JOptionPane.ERROR_MESSAGE);
         jTextField1.setText("");
         return;
        }
        permanentOrder.add(dstn);
        findLines(permanentOrder,dist);
        for(int i=0;i<permanentOrder.size();i++){ 
        }
        NewJPanel.nodes.get(src).inPath = true;
    }
    void findLines(ArrayList<Integer> po,int distance[]){
         int n1,n2;
            n1 = po.size()-1;
            n2 = n1-1;
            int m = 1;
            boolean found = false;
        for(int i=0;i<po.size()-1;i++){
            for(int j=0;j<NewJPanel.lines.size();j++){
                if(((NewJPanel.lines.get(j).dstn == po.get(n1)+65 && NewJPanel.lines.get(j).src == po.get(n2)+65)
                    || (NewJPanel.lines.get(j).src == po.get(n1)+65 && NewJPanel.lines.get(j).dstn == po.get(n2)+65))
                        &&(distance[po.get(n1)]-distance[po.get(n2)] == NewJPanel.lines.get(j).weight)){
                    NewJPanel.lines.get(j).toHighlight = true;
                    found = true;
                    for(int k=0;k<NewJPanel.nodes.size();k++){
                        if(NewJPanel.nodes.get(k).name == NewJPanel.lines.get(j).src )
                            NewJPanel.nodes.get(k).inPath = true;
                         if(NewJPanel.nodes.get(k).name == NewJPanel.lines.get(j).dstn)
                            NewJPanel.nodes.get(k).inPath = true;
                    }
                    break;
                }
            }
            if(found){
                n1 -= m;
                    n2 -= 1;
                    m = 1;
                    found  =  false;
            }else{
                 m++;
                    n2 -= 1;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        newJPanel1 = new mp8.NewJPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtConsole1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dijkstra Algorithm");
        setBackground(new java.awt.Color(182, 16, 191));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 172, 119));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setText("Source");

        jComboBox1.setBackground(new java.awt.Color(165, 178, 181));
        jComboBox1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jComboBox1.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel2.setText("Destination");

        jComboBox2.setBackground(new java.awt.Color(165, 178, 181));
        jComboBox2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jComboBox2.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(210, 216, 217));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Find Shortest Path");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel3.setText("Total Distance ");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        jButton2.setBackground(new java.awt.Color(195, 203, 208));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        newJPanel1.setBackground(new java.awt.Color(106, 135, 127));
        newJPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtConsole.setBackground(new java.awt.Color(217, 205, 151));
        txtConsole.setColumns(2);
        txtConsole.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        txtConsole.setRows(5);
        jScrollPane3.setViewportView(txtConsole);

        txtConsole1.setBackground(new java.awt.Color(217, 205, 151));
        txtConsole1.setColumns(20);
        txtConsole1.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        txtConsole1.setRows(5);
        jScrollPane4.setViewportView(txtConsole1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(newJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(244, 244, 244))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       for(int i=0;i<NewJPanel.lines.size();i++){
           NewJPanel.lines.get(i).toHighlight = false;
           NewJPanel.lines.get(i).isHighlighted = false;
       }
       for(int i=0;i<NewJPanel.nodes.size();i++){
           NewJPanel.nodes.get(i).inPath = false;
       }
       createGraph();
       NewJPanel.found = true;
       repaint();
       
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        NewJPanel.lines.removeAll(NewJPanel.lines);
        NewJPanel.nodes.removeAll(NewJPanel.nodes);
        NewJPanel.Name = 'A';
        jTextField1.setText("");
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox2.setEnabled(false);
        jComboBox1.setEnabled(false);
        txtConsole.selectAll();
        txtConsole.replaceSelection("");
        txtConsole1.selectAll();
        txtConsole1.replaceSelection("");
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed
void createGraph(){
    
    txtConsole1.append(" v|");
    size = NewJPanel.nodes.size();
    graph = new int[size][size];
    for(int i=0;i<size;i++){
        txtConsole1.append(" "+ i + "               \t    ");
        for(int j=0;j<size;j++){
                graph[i][j] = 0;
        }
    }
    for(int i=0;i<size;i++){ 
        for(int j=0;j<NewJPanel.nodes.get(i).info.size();j++){
          graph[i][NewJPanel.nodes.get(i).info.get(j).toNode] = NewJPanel.nodes.get(i).info.get(j).lineNo;
        }
    }
    txtConsole1.append("\n");
    for(int i=0;i<size;i++){
        for(int j=0;j<size;j++){
            txtConsole1.append("     " + graph[i][j] + "\t");

        }
        txtConsole1.append("\n");
        
        
    }
    dijkstra(graph, jComboBox1.getSelectedItem().toString().charAt(0)-65,jComboBox2.getSelectedItem().toString().charAt(0)-65);
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame myFrame = new NewJFrame();
                        //myFrame.setSize(800,1000);
                        myFrame.setVisible(true);
                        
                        
                //myFrame.setExtendedState(NewJFrame.MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTextField jTextField1;
    private mp8.NewJPanel newJPanel1;
    private javax.swing.JTextArea txtConsole;
    private javax.swing.JTextArea txtConsole1;
    // End of variables declaration//GEN-END:variables
}