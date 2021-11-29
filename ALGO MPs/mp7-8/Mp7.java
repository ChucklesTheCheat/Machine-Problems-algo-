import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Mp7 {
    //constants
    GridBagConstraints cPanel;
    GridBagConstraints cOption;

    //declaration of gui components
    JFrame frame;
    JPanel mainPanel;
    JPanel headerPanel;
    JPanel outputPanel;
    JLabel lblImage;
    JLabel lblTitle;
    JPanel inputPanel;
    JLabel lblAT;
    JTextField fieldAT;
    JLabel lblBT;
    JTextField fieldBT;
    JLabel lblQuantum;
    JTextField fieldQuantum;
    JPanel buttonPanel;
    JButton btnRun;
    JButton btnRandomize;
    JLabel lblOutput;
    Mp7(){
        cPanel = new GridBagConstraints();
        cOption = new GridBagConstraints();
        //initialization of gui components
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for proper close
        frame.setLayout(new BorderLayout()); //for border layout in adding components ex. add(component,BorderLayout.NORTH); try making null later
        frame.setPreferredSize(new Dimension(800, 800)); //for responsive design
        frame.pack(); //for responsive design, packs contents based on setPreferredSize of mainFrame
        frame.setLocationRelativeTo(null); //for frame to appear in center of screen

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        mainPanel.setBackground(Color.WHITE);

        //panels
        cPanel.gridx = 0;
        cPanel.gridy = 0;
        headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setOpaque(true);
        headerPanel.setBackground(new Color(50,100,50));
        cPanel.fill = GridBagConstraints.BOTH; // for responsive line and label
        cPanel.weightx = 1; // for responsive line and label
        mainPanel.add(headerPanel, cPanel);
        cPanel = new GridBagConstraints();

        cPanel.gridx = 0;
        cPanel.gridy= 1;
        inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        inputPanel.setOpaque(false);
        mainPanel.add(inputPanel, cPanel);

        cPanel.gridx = 0;
        cPanel.gridy= 2;
        buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        buttonPanel.setOpaque(false);
        mainPanel.add(buttonPanel, cPanel);

        cPanel.gridx = 0;
        cPanel.gridy = 3;
        outputPanel = new JPanel(new GridBagLayout());
        outputPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        outputPanel.setOpaque(false);
        mainPanel.add(outputPanel, cPanel);

        //headerPanel
        lblImage = new JLabel(); //Background image of header
        lblTitle = new JLabel("PROCESS SCHEDULING ALGORITHM", SwingConstants.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setPreferredSize(new Dimension(350,200));
        lblTitle.setMinimumSize(new Dimension(350,200));
        lblTitle.setSize(new Dimension(350,200));
        lblTitle.setFont(new Font("Arial", Font.PLAIN, 15));
        cOption.gridx = 0;
        cOption.gridy = 0;
        cOption.weighty = 1;
        headerPanel.add(lblTitle, cOption);

        //inputPanel
        lblAT = new JLabel("Arrival Time");
        fieldAT = new JTextField();
        fieldAT.setPreferredSize(new Dimension(300,25));
        fieldAT.setMinimumSize(new Dimension(300,25));
        fieldAT.setSize(new Dimension(300,25));
        lblBT = new JLabel("Burst Time");
        lblBT.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        fieldBT = new JTextField();
        fieldBT.setPreferredSize(new Dimension(300,25));
        fieldBT.setMinimumSize(new Dimension(300,25));
        fieldBT.setSize(new Dimension(300,25));
        lblQuantum = new JLabel("Time Quantum");
        lblQuantum.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        fieldQuantum = new JTextField();
        fieldQuantum.setPreferredSize(new Dimension(300,25));
        fieldQuantum.setMinimumSize(new Dimension(300,25));
        fieldQuantum.setSize(new Dimension(300,25));
        cOption.gridx = 0;
        cOption.gridy = 0;
        inputPanel.add(lblAT, cOption);
        cOption.gridy = 1;
        inputPanel.add(fieldAT, cOption);
        cOption.gridy = 2;
        inputPanel.add(lblBT, cOption);
        cOption.gridy = 3;
        inputPanel.add(fieldBT, cOption);
        cOption.gridy = 4;
        inputPanel.add(lblQuantum, cOption);
        cOption.gridy = 5;
        inputPanel.add(fieldQuantum, cOption);

        //buttonPanel
        btnRun = new JButton("RUNNING");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                runActionPerformed(evt);
            }
        });
        btnRandomize = new JButton("RANDOMIZE");
        btnRandomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                randomizeActionPerformed(evt);
            }
        });
        cOption.gridx = 0;
        cOption.gridy = 0;
        cOption.gridx = 1;
        buttonPanel.add(btnRun, cOption);
        cOption.gridx = 2;
        buttonPanel.add(btnRandomize, cOption);

        //outputPanel
        lblOutput = new JLabel("Output: ");
        cOption.gridx = 0;
        cOption.gridy = 0;
        outputPanel.add(lblOutput, cOption);

        //to put content upper left filler panel
        cPanel.gridy = 4;
        cPanel.weightx = 1;
        cPanel.weighty = 1;
        JPanel filler = new JPanel();
        filler.setOpaque(false);
        mainPanel.add(filler, cPanel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    void simulateActionPerformed(ActionEvent evt) {

    }

    void runActionPerformed(ActionEvent evt) {
        int readyQueue[];
        int quantum = Integer.parseInt(fieldQuantum.getText());
        String temp = "";
        int tempN;
        int arrivalTimes[];
        int burstTimes[];
        int tempBurst[];
        int turnTime[];
        int waitTime[];
        boolean complete[];
        int noItems = 1;
        int indexToPut = 0;
        int timer = 0;
        int maxProcessIndex = 0;
        float averageWait = 0;
        float averageTurn = 0;
        for(int i = 0; i < fieldAT.getText().length(); i++) {
            if(fieldAT.getText().charAt(i) == ' ') {
                noItems++;
            }
        }
        readyQueue = new int[noItems];
        complete = new boolean[noItems];
        arrivalTimes = new int[noItems];
        burstTimes = new int[noItems];
        tempBurst = new int[noItems];
        turnTime = new int[noItems];
        waitTime = new int[noItems];
        System.out.println(noItems);
        for(int i = 0; i < fieldAT.getText().length(); i++) {
            if(fieldAT.getText().charAt(i) == ' ') {
                arrivalTimes[indexToPut] = Integer.parseInt(temp);
                indexToPut++;
                temp = "";
            }
            else {
                temp += fieldAT.getText().charAt(i);
            }
        }
        arrivalTimes[indexToPut] = Integer.parseInt(temp);

        indexToPut = 0;
        temp = "";
        for(int i = 0; i < fieldBT.getText().length(); i++) {
            if(fieldBT.getText().charAt(i) == ' ') {
                burstTimes[indexToPut] = Integer.parseInt(temp);
                tempBurst[indexToPut] = Integer.parseInt(temp);
                indexToPut++;
                temp = "";
            }
            else {
                temp += fieldBT.getText().charAt(i);
            }
        }
        burstTimes[indexToPut] = Integer.parseInt(temp);
        tempBurst[indexToPut] = Integer.parseInt(temp);

        System.out.println(quantum);
        System.out.println(Arrays.toString(arrivalTimes));//test if input properly
        System.out.println(Arrays.toString(burstTimes));//test if input properly

        //process
        for(int i = 0; i < noItems; i++){    //Initializing the queue and complete array
            complete[i] = false;
            readyQueue[i] = 0;
        }
        while(timer < arrivalTimes[0])    //Incrementing Timer until the first process arrives
            timer++;
        readyQueue[0] = 1;

        while(true){
            boolean flag = true;
            for(int i = 0; i < noItems; i++){
                if(tempBurst[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                break;

            for(int i = 0; (i < noItems) && (readyQueue[i] != 0); i++){
                int ctr = 0;
                while((ctr < quantum) && (tempBurst[readyQueue[0]-1] > 0)){
                    tempBurst[readyQueue[0]-1] -= 1;
                    timer += 1;
                    ctr++;

                    checkNewArrival(timer, arrivalTimes, noItems, maxProcessIndex, readyQueue);
                }
                if((tempBurst[readyQueue[0]-1] == 0) && (complete[readyQueue[0]-1] == false)){
                    turnTime[readyQueue[0]-1] = timer;
                    complete[readyQueue[0]-1] = true;
                }

                //checks whether or not CPU is idle
                boolean idle = true;
                if(readyQueue[noItems-1] == 0){
                    for(int k = 0; k < noItems && readyQueue[k] != 0; k++){
                        if(complete[readyQueue[k]-1] == false){
                            idle = false;
                        }
                    }
                }
                else
                    idle = false;

                if(idle){
                    timer++;
                    checkNewArrival(timer, arrivalTimes, noItems, maxProcessIndex, readyQueue);
                }

                //Maintaining the entires of processes after each premption in the ready Queue
                queueMaintainence(readyQueue,noItems);
            }
        }

        for(int i = 0; i < noItems; i++){
            turnTime[i] = turnTime[i] - arrivalTimes[i];
            waitTime[i] = turnTime[i] - burstTimes[i];
        }

        for(int i =0; i< noItems; i++){
            averageWait += waitTime[i];
            averageTurn += turnTime[i];
        }
        averageWait = averageWait/noItems;
        averageTurn = averageTurn/noItems;

        System.out.println(Arrays.toString(waitTime)); //for test
        System.out.println(Arrays.toString(turnTime)); //for test

        //output
        String s = "Output: ";
        lblOutput.setText("<html><br>PR   AT   BT   WT   TA");
        for(int i = 0; i < noItems; i++) {
            s = lblOutput.getText();
            s += "<br>P" + i + "   <t>" + String.valueOf(arrivalTimes[i]) + "   <t>" +  String.valueOf(burstTimes[i]) + "   <t>" +  String.valueOf(waitTime[i]) + "   <t>" + String.valueOf(turnTime[i]);
            lblOutput.setText(s);
        }
        s += "<br>Average WT: " + averageWait + "<br>Average TA: " + averageTurn;
        s += "<br>TA = Completion Time - AT OR BT + WT";
        s += "<br>WT = TA – BT";
        lblOutput.setText(s + "</html>");
    }

    void queueUpdation(int queue[],int timer,int arrival[],int n, int maxProcessIndex){
        int zeroIndex = -1;
        for(int i = 0; i < n; i++){
            if(queue[i] == 0){
                zeroIndex = i;
                break;
            }
        }
        if(zeroIndex == -1)
            return;
        queue[zeroIndex] = maxProcessIndex + 1;
    }

    void checkNewArrival(int timer, int arrival[], int n, int maxProcessIndex,int queue[]){
        if(timer <= arrival[n-1]){
            boolean newArrival = false;
            for(int j = (maxProcessIndex+1); j < n; j++){
                if(arrival[j] <= timer){
                    if(maxProcessIndex < j){
                        maxProcessIndex = j;
                        newArrival = true;
                    }
                }
            }
            if(newArrival)    //adds the index of the arriving process(if any)
                queueUpdation(queue,timer,arrival,n, maxProcessIndex);
        }
    }

    void queueMaintainence(int queue[], int n){

        for(int i = 0; (i < n-1) && (queue[i+1] != 0) ; i++){
            int temp = queue[i];
            queue[i] = queue[i+1];
            queue[i+1] = temp;
        }
    }

    void randomizeActionPerformed(ActionEvent evt) {
        int randomSize = 1 + (int)(Math.random() * ((10 - 1) + 1));
        int quantum = 1 + (int)(Math.random() * ((3 - 1) + 1));
        int rand = 0;
        int temp;
        int AT[] = new int[randomSize];
        int BT[] = new int[randomSize];
        boolean found = true;
        String a = "";
        String b = "";
        for(int i = 0; i < randomSize; i++) {
            while(found) {
                found = false;
                rand = 0 + (int) (Math.random() * ((10 - 1) + 1));
                for (int j = 0; j < AT.length; j++) {
                    if (rand == AT[j]) {
                        found = true;
                    }
                }

            }
            AT[i] = rand;
            found = true;
        }

        for(int i = 0; i < randomSize; i++) {
            while(found) {
                found = false;
                rand = 0 + (int) (Math.random() * ((10 - 1) + 1));
                for (int j = 0; j < BT.length; j++) {
                    if (rand == BT[j]) {
                        found = true;
                    }
                }
            }
            BT[i] = rand;
            found = true;
        }

        for (int i = 0; i < AT.length; i++) {
            for (int j = i; j < AT.length; j++) {
                if (AT[i] > AT[j]) {
                    temp = AT[i];
                    AT[i] = AT[j];
                    AT[j] = temp;
                }
            }
        }

        for (int i = 0; i < BT.length; i++) {
            for (int j = i; j < BT.length; j++) {
                if (BT[i] < BT[j]) {
                    temp = BT[i];
                    BT[i] = BT[j];
                    BT[j] = temp;
                }
            }
        }

        fieldQuantum.setText(String.valueOf(quantum));
        a = String.valueOf(AT[0]);
        for(int i = 1; i < randomSize; i++) {
            a += " " + String.valueOf(AT[i]);
        }
        fieldAT.setText(a);
        b = String.valueOf(BT[0]);
        for(int i = 1; i < randomSize; i++) {
            b += " " + String.valueOf(BT[i]);
        }
        fieldBT.setText(b);
    }

    public static void main(String args[]) {
        new Mp7();
    }
}