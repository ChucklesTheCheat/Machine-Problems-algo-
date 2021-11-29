//semi-optimized in layouting
//not optimized in adding/removing components yet
//not optimized in simulation algorithm yet (no backward algorithm yet, just forward)
//no animation yet

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;

public class InterpolationSearch {
    Font arrayFont = new Font("Arial", Font.PLAIN, 24);
    Font titleFont = new Font("Arial", Font.PLAIN, 16);
    Font buttonFont = new Font("Arial", Font.BOLD, 16);
    Font subTitleFont = new Font("Arial", Font.PLAIN, 14);
    Color mainBackground = new Color(0, 57, 197);
    Color semiWhite = new Color(163, 175, 227);
    Color transparentBlack = new Color(0,28,98);
    GridBagConstraints cPanel;
    GridBagConstraints cOption;

    JFrame mainFrame;
    JPanel mainPanel;
    //mainComponents
    JPanel headerPanel;
    JPanel optionsPanel;
    JPanel searchPanel;
    JPanel submitPanel;
    JLabel lblTitle;
    JLabel lblTitleVer;
    JToggleButton btnOption1;
    JToggleButton btnOption2;
    JLabel lblFieldItems;
    JTextField fieldItems;
    JLabel lblFieldItemSearch;
    JTextField fieldItemSearch;
    JLabel lblSortedArray;
    JLabel lblOutput;
    JButton btnSimulate;
    JButton btnSubmit;
    //simulateComponents
    JPanel arrayPanel;
    JPanel dataPanel;
    JPanel codePanel;
    JPanel buttonsPanel;
    JButton btnBack;
    JButton btnBackward;
    JButton btnForward;
    int arr[];
    Vector<Integer> positions;
    Vector<Integer> highs;
    Vector<Integer> lows;
    int arraySize;
    int pos;
    int temp;
    int high;
    int low;
    int find;
    int dex;
    int positionIndex;
    int highIndex;
    int lowIndex;
    int simulationIndex;

    InterpolationSearch() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for proper lcose
        mainFrame.setLayout(new BorderLayout()); //for border layout in adding components ex. add(component,BorderLayout.NORTH); try making null later
        mainFrame.setPreferredSize(new Dimension(800, 800)); //for responsive design
        mainFrame.pack(); //for responsive design, packs contents based on setPreferredSize of mainFrame
        mainFrame.setLocationRelativeTo(null); //for frame to appear in center of screen

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(75, 150, 75, 150));
        mainPanel.setBackground(mainBackground);

        //panels
        headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setOpaque(false);

        optionsPanel = new JPanel(new GridBagLayout());
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        optionsPanel.setOpaque(false);

        searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        searchPanel.setOpaque(false);

        submitPanel = new JPanel(new GridBagLayout());
        submitPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        submitPanel.setOpaque(false);

        arrayPanel = new JPanel(new GridBagLayout());
        arrayPanel.setOpaque(false);

        dataPanel = new JPanel(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 50, 0));
        dataPanel.setOpaque(false);

        codePanel = new JPanel(new GridBagLayout());
        codePanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        codePanel.setBackground(transparentBlack);

        buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        buttonsPanel.setOpaque(false);

        //titlePanel
        lblTitle = new JLabel("OneTwoThree");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setOpaque(false);
        lblTitle.setBackground(Color.BLACK);
        lblTitle.setFont(titleFont);
        lblTitle.isOpaque();

        lblTitleVer = new JLabel("v1.0");
        lblTitleVer.setBorder(BorderFactory.createEmptyBorder(2, 5, 0, 0));
        lblTitleVer.setForeground(semiWhite);
        lblTitleVer.setOpaque(false);
        lblTitleVer.setBackground(Color.BLACK);
        lblTitleVer.setFont(subTitleFont);
        lblTitleVer.isOpaque();

        //optionsPanel
        JLabel tempLabel = new JLabel("INTERPOLATION");
        tempLabel.setForeground(mainBackground);
        tempLabel.setFont(buttonFont);
        btnOption1 = new JToggleButton("", false);
        btnOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });
        btnOption1.setLayout(new BorderLayout());
        btnOption1.add(BorderLayout.CENTER, tempLabel);
        tempLabel = new JLabel("       SEARCH");
        tempLabel.setForeground(mainBackground);
        tempLabel.setFont(buttonFont);
        btnOption1.add(BorderLayout.AFTER_LAST_LINE, tempLabel);
        btnOption1.isSelected();
        btnOption1.setUI(new StyledButtonUI());
        btnOption1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 40));
        btnOption1.setOpaque(false);
        btnOption1.setFocusPainted(false);
        btnOption1.setBorderPainted(false);
        btnOption1.setContentAreaFilled(false);
        btnOption1.setBackground(Color.WHITE);
        btnOption1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        tempLabel = new JLabel("  GAUSSIAN");
        tempLabel.setForeground(semiWhite);
        tempLabel.setFont(buttonFont);
        btnOption2 = new JToggleButton("", false);
        btnOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });
        btnOption2.setLayout(new BorderLayout());
        btnOption2.add(BorderLayout.CENTER, tempLabel);
        tempLabel = new JLabel("ELIMINATION");
        tempLabel.setForeground(semiWhite);
        tempLabel.setFont(buttonFont);
        btnOption2.add(BorderLayout.AFTER_LAST_LINE, tempLabel);
        btnOption2.setBorderPainted(false);
        btnOption2.setOpaque(false);
        btnOption2.setFocusPainted(false);
        btnOption2.setContentAreaFilled(false);
        btnOption2.setForeground(semiWhite);
        btnOption2.setFont(buttonFont);
        btnOption2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 40));

        //searchPanel
        lblFieldItems = new JLabel("Input");
        lblFieldItems.setFont(titleFont);
        lblFieldItems.setForeground(Color.WHITE);
        lblFieldItems.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        fieldItems = new JTextField();
        fieldItems.setBorder(null);
        fieldItems.setBackground(mainBackground);
        fieldItems.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        fieldItems.setBorder(BorderFactory.createCompoundBorder(fieldItems.getBorder(), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
        fieldItems.setFont(new Font("Arial", Font.BOLD, 14));
        fieldItems.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldItems.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldItemsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldItemsFocusLost(evt);
            }
        });
        fieldItems.setText("1 2 3 4 5 6");
        fieldItems.setForeground(semiWhite);

        lblFieldItemSearch = new JLabel("No. to be searched");
        lblFieldItemSearch.setFont(titleFont);
        lblFieldItemSearch.setForeground(Color.WHITE);
        lblFieldItemSearch.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        fieldItemSearch = new JTextField();
        fieldItemSearch.setBorder(null);
        fieldItemSearch.setForeground(Color.WHITE);
        fieldItemSearch.setBackground(mainBackground);
        fieldItemSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        fieldItemSearch.setBorder(BorderFactory.createCompoundBorder(fieldItemSearch.getBorder(), BorderFactory.createEmptyBorder(0, 5, 5, 5)));
        fieldItemSearch.setFont(new Font("Arial", Font.BOLD, 14));
        fieldItemSearch.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldItemSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldItemSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldItemSearchFocusLost(evt);
            }
        });
        fieldItemSearch.setText("4");
        fieldItemSearch.setForeground(semiWhite);

        //submitPanel
        lblSortedArray = new JLabel("Sorted Array: ");
        lblSortedArray.setFont(titleFont);
        lblSortedArray.setForeground(Color.WHITE);
        lblSortedArray.setBorder(BorderFactory.createEmptyBorder(25, 0, 5, 0));
        lblSortedArray.setHorizontalAlignment(SwingConstants.CENTER);

        lblOutput = new JLabel("Output: ");
        lblOutput.setFont(titleFont);
        lblOutput.setForeground(Color.WHITE);
        lblOutput.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);

        btnSimulate = new JButton("Simulate ⚙");
        btnSimulate.setBorderPainted(false);
        btnSimulate.setOpaque(false);
        btnSimulate.setFocusPainted(false);
        btnSimulate.setContentAreaFilled(false);
        btnSimulate.setForeground(semiWhite);
        btnSimulate.setFont(new Font("", Font.PLAIN, 24));
        btnSimulate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSimulate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSimulateMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSimulateMouseExited(evt);
            }
        });
        btnSimulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                simulateActionPerformed(evt);
            }
        });

        btnSubmit = new JButton("Output ⬇");
        btnSubmit.setBorderPainted(false);
        btnSubmit.setOpaque(false);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setContentAreaFilled(false);
        btnSubmit.setForeground(semiWhite);
        btnSubmit.setFont(new Font("", Font.PLAIN, 24));
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitMouseExited(evt);
            }
        });
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        //codePanel
        btnBackward = new JButton("<<");
        btnBackward.setBorderPainted(false);
        btnBackward.setOpaque(false);
        btnBackward.setFocusPainted(false);
        btnBackward.setContentAreaFilled(false);
        btnBackward.setForeground(semiWhite);
        btnBackward.setFont(subTitleFont);
        btnBackward.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBackward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackwardMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {

                btnBackwardMouseExited(evt);
            }
        });
        btnBackward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //btnBackwardActionPerformed(evt);
            }
        });

        btnForward = new JButton(">>");
        btnForward.setBorderPainted(false);
        btnForward.setOpaque(false);
        btnForward.setFocusPainted(false);
        btnForward.setContentAreaFilled(false);
        btnForward.setForeground(semiWhite);
        btnForward.setFont(subTitleFont);
        btnForward.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnForward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnForwardMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {

                btnForwardMouseExited(evt);
            }
        });
        btnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnForwardActionPerformed(evt);
            }
        });

        //buttonsPanel
        btnBack = new JButton("Back");
        btnBack.setBorderPainted(false);
        btnBack.setOpaque(false);
        btnBack.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setForeground(semiWhite);
        btnBack.setFont(new Font("", Font.PLAIN, 24));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {

                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        //Add Components
        mainFrame.add(mainPanel);
        addMainComponents();

        mainFrame.setVisible(true);
    }

    private void option2ActionPerformed(ActionEvent evt) {
        if (btnOption2.isSelected() == true) {
            btnOption1.setUI(new StyledButtonUI());
            btnOption1.getComponent(0).setForeground(mainBackground);
            btnOption1.getComponent(1).setForeground(mainBackground);
            btnOption1.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnOption2.setUI(new BasicButtonUI());
            btnOption2.getComponent(0).setForeground(semiWhite);
            btnOption2.getComponent(1).setForeground(semiWhite);
            btnOption2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            btnOption2.setSelected(false);
        }
    }

    private void addMainComponents() {
        //Constraints
        cPanel = new GridBagConstraints();
        cOption = new GridBagConstraints();


        //Header Panel
        cPanel.gridx = 0;
        cPanel.gridy = 0;
        //cPanel.weightx = 1;
        //cPanel.weighty = 1;
        cPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        mainPanel.add(headerPanel, cPanel); //title not getting positioned/ getting centered without NorthWest(FIRST_LINE_START) and weightx weighty

        cOption.gridx = 0;
        cOption.gridy = 0;
        headerPanel.add(lblTitle, cOption);

        cOption.gridx = 1;
        cOption.gridy = 0;
        headerPanel.add(lblTitleVer, cOption);

        //Options Panel
        cPanel.anchor = GridBagConstraints.CENTER;
        cPanel.gridx = 0;
        cPanel.gridy = 1;
        mainPanel.add(optionsPanel, cPanel);

        cOption.gridx = 0;
        cOption.gridy = 0;
        optionsPanel.add(btnOption1, cOption);

        cOption.gridx = 1;
        cOption.gridy = 0;
        optionsPanel.add(btnOption2, cOption);

        //Search Panel
        cPanel.anchor = GridBagConstraints.CENTER;
        cPanel.gridx = 0;
        cPanel.gridy = 2;
        cPanel.fill = GridBagConstraints.HORIZONTAL; // for responsive line and label
        cPanel.weightx = 1; // for responsive line and label
        mainPanel.add(searchPanel, cPanel);

        cPanel.weightx = 0;
        cOption.fill = GridBagConstraints.HORIZONTAL; // for responsive line and label
        cOption.weightx = 1; // for responsive line and label
        cOption.anchor = GridBagConstraints.WEST;
        cOption.gridx = 0;
        cOption.gridy = 0;
        searchPanel.add(lblFieldItems, cOption);

        cOption.weightx = 0;
        cOption.anchor = GridBagConstraints.CENTER;
        cOption.gridx = 0;
        cOption.gridy = 1;
        searchPanel.add(fieldItems, cOption);

        cOption.gridx = 0;
        cOption.gridy = 2;
        cOption.anchor = GridBagConstraints.WEST;
        searchPanel.add(lblFieldItemSearch, cOption);

        cOption.anchor = GridBagConstraints.CENTER;
        cOption.gridx = 0;
        cOption.gridy = 3;
        searchPanel.add(fieldItemSearch, cOption);

        cOption.weightx = 0;

        //submit Panel
        cPanel.anchor = GridBagConstraints.CENTER;
        cPanel.gridx = 0;
        cPanel.gridy = 3;
        mainPanel.add(submitPanel, cPanel);

        cOption.gridx = 0;
        cOption.gridy = 0;
        cOption.gridwidth = 2;
        submitPanel.add(lblSortedArray, cOption);

        cOption.gridx = 0;
        cOption.gridy = 1;
        cOption.gridwidth = 2;
        submitPanel.add(lblOutput, cOption);

        cOption.gridwidth = 1;
        cOption.gridx = 0;
        cOption.gridy = 2;
        submitPanel.add(btnSimulate, cOption);

        cOption.gridx = 1;
        cOption.gridy = 2;
        submitPanel.add(btnSubmit, cOption);

        //to put content upper left filler panel
        cPanel.gridy = 4;
        cPanel.weightx = 1;
        cPanel.weighty = 1;
        JPanel filler = new JPanel();
        filler.setOpaque(false);
        mainPanel.add(filler, cPanel);
    }

    private void addSimulateComponents() {
        positionIndex = 0;
        highIndex = 0;
        lowIndex = 0;
        simulationIndex = 0;
        //Constraints
        cPanel = new GridBagConstraints();
        cOption = new GridBagConstraints();

        //arrayPanel
        cPanel.anchor = GridBagConstraints.CENTER;
        cPanel.gridx = 0;
        cPanel.gridy = 0;
        mainPanel.add(arrayPanel, cPanel);

        JLabel tempLabel;
        cOption.gridx = 0;
        cOption.gridy = 0;
        for(int i = 0; i < arr.length; i++) {
            tempLabel = new JLabel(String.valueOf(arr[i]));
            tempLabel.setFont(arrayFont);
            tempLabel.setForeground(semiWhite);
            tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
            tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
            arrayPanel.add(tempLabel, cOption);
            cOption.gridx++;
        }

        //dataPanel
        cPanel.gridx = 0;
        cPanel.gridy = 1;
        mainPanel.add(dataPanel,cPanel);

        cOption.gridx = 0;
        cOption.gridy = 0;
        tempLabel = new JLabel("Pos = low + ((x – A[low]) * (high – low) / (A[high] – A[low]))");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(Color.WHITE);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dataPanel.add(tempLabel, cOption);
        cOption.gridy++;

        tempLabel = new JLabel("High = " + String.valueOf(arr.length-1));
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(Color.WHITE);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dataPanel.add(tempLabel, cOption);
        cOption.gridy++;

        tempLabel = new JLabel("Low = " + 0);
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(Color.WHITE);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dataPanel.add(tempLabel, cOption);
        cOption.gridy++;

        tempLabel = new JLabel("Pos = " + (low + ((Integer.parseInt(fieldItemSearch.getText()) - arr[0]) * (arr.length-1 - 0)/(arr[arr.length-1] - arr[0]))));
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(Color.WHITE);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dataPanel.add(tempLabel, cOption);
        cOption.gridy++;

        //codePanel
        cPanel.gridx = 0;
        cPanel.gridy = 2;
        cPanel.fill = GridBagConstraints.HORIZONTAL; // for responsive line and label
        cPanel.weightx = 1; // for responsive line and label
        mainPanel.add(codePanel,cPanel);
        cPanel = new GridBagConstraints();

        cOption.gridx = 0;
        cOption.gridy = 0;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("int recurse(int find, int high, int low, int arr[]) {");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 1;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("   if (low <= high && find >= arr[low] && find <= arr[high]) {");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 2;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("      int pos = low + (((high - low) / (arr[high] - arr[low])) * (find - arr[low]));");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 3;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("      if(arr[pos] == find)");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 4;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("         return pos;");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 5;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("      if(arr[pos] < find)");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 6;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("         return recurse(find, high, pos+1, arr);");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 7;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("      if(arr[pos] > find)");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 8;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("         return recurse(find, pos-1, low, arr);");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 9;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("   }");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 10;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("   return -1;");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 0;
        cOption.gridy = 11;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        tempLabel = new JLabel("}");
        tempLabel.setFont(subTitleFont);
        tempLabel.setForeground(semiWhite);
        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        codePanel.add(tempLabel, cOption);
        cOption.weightx = 0;

        cOption.gridx = 1;
        cOption.gridy = 12;
        cOption.anchor = GridBagConstraints.EAST;
        cOption.weightx = 1;
        codePanel.add(btnForward, cOption);
        cOption.weightx = 0;

        //buttonsPanel
        cPanel.gridx = 0;
        cPanel.gridy = 3;
        cPanel.fill = GridBagConstraints.HORIZONTAL; // for responsive line and label
        cPanel.weightx = 1; // for responsive line and label
        mainPanel.add(buttonsPanel,cPanel);
        cPanel = new GridBagConstraints();

        cOption.gridx = 0;
        cOption.gridy = 0;
        cOption.anchor = GridBagConstraints.WEST;
        cOption.weightx = 1;
        buttonsPanel.add(btnBack, cOption);
        cOption.weightx = 0;

        //to put content upper left filler panel
        cPanel.gridy = 4;
        cPanel.weightx = 1;
        cPanel.weighty = 1;
        JPanel filler = new JPanel();
        filler.setOpaque(false);
        mainPanel.add(filler, cPanel);

        //set initial highlight
        arrayPanel.getComponent(positions.get(0)).setForeground(Color.WHITE);
    }

    private void option1ActionPerformed(ActionEvent evt) {
        if (btnOption1.isSelected() == true) {
            btnOption2.setUI(new StyledButtonUI());
            btnOption2.getComponent(0).setForeground(mainBackground);
            btnOption2.getComponent(1).setForeground(mainBackground);
            btnOption2.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnOption1.setUI(new BasicButtonUI());
            btnOption1.getComponent(0).setForeground(semiWhite);
            btnOption1.getComponent(1).setForeground(semiWhite);
            btnOption1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            btnOption1.setSelected(false);
            //mainPanel.remove(mainPanel.getComponent(2)); //removes searchPanel
            //mainPanel.remove(mainPanel.getComponent(2)); //removes submitPanel
            //mainPanel.remove(mainPanel.getComponent(2)); //removes empty panel for moving up need check and set of true and false

            mainFrame.revalidate();
            mainFrame.repaint();
        }
    }

    private void fieldItemsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usNameFocusGained
        if(fieldItems.getText().equals("1 2 3 4 5 6")) {
            fieldItems.setText("");
            fieldItems.setForeground(Color.white);
        }
    }

    private void fieldItemsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usNameFocusGained
        if(fieldItems.getText().equals("")) {
            fieldItems.setText("1 2 3 4 5 6");
            fieldItems.setForeground(semiWhite);
        }
    }

    private void fieldItemSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usNameFocusGained
        if(fieldItemSearch.getText().equals("4")) {
            fieldItemSearch.setText("");
            fieldItemSearch.setForeground(Color.white);
        }
    }

    private void fieldItemSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usNameFocusGained
        if(fieldItemSearch.getText().equals("")) {
            fieldItemSearch.setText("4");
            fieldItemSearch.setForeground(semiWhite);
        }
    }

    private void btnSimulateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnSimulate.setForeground(Color.WHITE);
    }

    private void btnSimulateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnSimulate.setForeground(semiWhite);
    }

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnSubmit.setForeground(Color.WHITE);
    }

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnSubmit.setForeground(semiWhite);
    }

    private void simulateActionPerformed(ActionEvent evt) {
        try {
            submitActionPerformed(evt);
            if(lblOutput.getText() != "Output: invalid inputs.") {
                mainPanel.remove(mainPanel.getComponent(0)); //removes headerPanel
                mainPanel.remove(mainPanel.getComponent(0)); //removes optionPanel
                mainPanel.remove(mainPanel.getComponent(0)); //removes searchPanel
                mainPanel.remove(mainPanel.getComponent(0)); //removes submitPanel
                mainPanel.remove(mainPanel.getComponent(0)); //removes fillterPanel
                addSimulateComponents();
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
            lblOutput.setText("Output: " + "invalid inputs.");
        }
    }

    private void submitActionPerformed(ActionEvent evt) {
        try {
            positions = new Vector<Integer>();
            highs = new Vector<Integer>();
            lows = new Vector<Integer>();

            String input = fieldItems.getText();
            arraySize = 1;
            pos = 0;
            temp = 0;
            high = arraySize;
            low = 0;
            find = Integer.parseInt(fieldItemSearch.getText());
            dex = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    arraySize++;
                }
            }
            arr = new int[arraySize];
            String getElement = "";
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != ' ') {
                    getElement = getElement + input.charAt(i);
                    System.out.print(getElement);
                } else {
                    arr[dex] = Integer.parseInt(getElement);
                    dex++;
                    getElement = "";
                }
                if (i == input.length() - 1) {
                    arr[dex] = Integer.parseInt(getElement);
                }
            }
            System.out.println("Unsorted array: " + Arrays.toString(arr));
            System.out.println(arraySize + " " + dex);
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            pos = recurse(find, arraySize - 1, 0, arr);
            if (pos != -1) {
                lblOutput.setText("Output: " + "found at index " + pos);
                lblSortedArray.setText("Sorted Array: " + Arrays.toString(arr));
            }
            else {
                lblOutput.setText("Output: " + "not found");
            }
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
            lblOutput.setText("Output: " + "invalid inputs.");
        }
    }

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnBack.setForeground(Color.WHITE);
    }

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnBack.setForeground(semiWhite);
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        mainPanel.remove(mainPanel.getComponent(0)); //removes arrayPanel
        mainPanel.remove(mainPanel.getComponent(0)); //removes dataPanel
        mainPanel.remove(mainPanel.getComponent(0)); //removes codePanel
        mainPanel.remove(mainPanel.getComponent(0)); //removes buttonsPanel
        mainPanel.remove(mainPanel.getComponent(0)); //removes fillterPanel

        arrayPanel.removeAll();
        dataPanel.removeAll();
        codePanel.removeAll();
        addMainComponents();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void btnBackwardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnBackward.setForeground(Color.WHITE);
    }

    private void btnBackwardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnBackward.setForeground(semiWhite);
    }

    private void btnForwardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnForward.setForeground(Color.WHITE);
    }

    private void btnForwardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        btnForward.setForeground(semiWhite);
    }

    private void btnForwardActionPerformed(ActionEvent evt) {//GEN-FIRST:event_usLoginMouseEntered
        System.out.println(positions);
        System.out.println(highs);
        System.out.println(lows);
        if(positionIndex == 1) {
            System.out.println("test");
            cOption.gridx = 0;
            cOption.gridy = 12;
            cOption.anchor = GridBagConstraints.EAST;
            codePanel.add(btnBackward,cOption);
            mainFrame.revalidate();
            mainFrame.repaint();
        }
        if(simulationIndex >= 1 && positionIndex < positions.size()) {
            System.out.println(positionIndex + " " + positions.size());
            System.out.println(simulationIndex);
            if(lows.get(lowIndex) <= highs.get(highIndex) && Integer.parseInt(fieldItemSearch.getText()) >= arr[lows.get(lowIndex)] && Integer.parseInt(fieldItemSearch.getText()) <= arr[highs.get(highIndex)]) {
                if (simulationIndex == 4) {
                    if (arr[positions.get(positionIndex)] == Integer.valueOf(fieldItemSearch.getText())) {
                        arrayPanel.getComponent(positions.get(positionIndex)).setForeground(semiWhite);
                        codePanel.getComponent(simulationIndex).setForeground(semiWhite);
                        simulationIndex = 10;
                        arrayPanel.getComponent(positions.get(positionIndex)).setForeground(Color.WHITE);
                        codePanel.getComponent(simulationIndex).setForeground(Color.WHITE);
                        codePanel.remove(btnForward);
                        positionIndex++;
                        highIndex++;
                        lowIndex++;

                        //need to optimize, removes all labels from datapanel then adds new data
                        dataPanel.removeAll();

                        JLabel tempLabel;
                        cOption.gridx = 0;
                        cOption.gridy = 0;
                        cOption.anchor = GridBagConstraints.CENTER;
                        tempLabel = new JLabel("Pos = low + ((x – A[low]) * (high – low) / (A[high] – A[low]))");
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("High = " + highs.get(highIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("Low = " + lows.get(lowIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("Pos = " + positions.get(positionIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        mainFrame.revalidate();
                        mainFrame.repaint();
                    }
                }
                if (simulationIndex == 6 && positionIndex < positions.size() - 1) {
                    if (arr[positions.get(positionIndex)] < Integer.valueOf(fieldItemSearch.getText())) {
                        arrayPanel.getComponent(positions.get(positionIndex)).setForeground(semiWhite);
                        codePanel.getComponent(simulationIndex).setForeground(semiWhite);
                        positionIndex++;
                        arrayPanel.getComponent(positions.get(positionIndex)).setForeground(Color.WHITE);
                        highIndex++;
                        lowIndex++;
                        simulationIndex = 0;

                        //need to optimize, removes all labels from datapanel then adds new data
                        dataPanel.removeAll();

                        JLabel tempLabel;
                        cOption.gridx = 0;
                        cOption.gridy = 0;
                        cOption.anchor = GridBagConstraints.CENTER;
                        tempLabel = new JLabel("Pos = low + ((x – A[low]) * (high – low) / (A[high] – A[low]))");
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("High = " + highs.get(highIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("Low = " + lows.get(lowIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("Pos = " + positions.get(positionIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        mainFrame.revalidate();
                        mainFrame.repaint();
                    }
                }
                if (simulationIndex == 8 && positionIndex < positions.size() - 1) {
                    if (arr[positions.get(positionIndex)] > Integer.valueOf(fieldItemSearch.getText())) {
                        arrayPanel.getComponent(positions.get(positionIndex)).setForeground(semiWhite);
                        positionIndex++;
                        arrayPanel.getComponent(positions.get(positionIndex)).setForeground(Color.WHITE);
                        highIndex++;
                        lowIndex++;
                        simulationIndex = 0;

                        //need to optimize, removes all labels from datapanel then adds new data
                        dataPanel.removeAll();

                        JLabel tempLabel;
                        cOption.gridx = 0;
                        cOption.gridy = 0;
                        cOption.anchor = GridBagConstraints.CENTER;
                        tempLabel = new JLabel("Pos = low + ((x – A[low]) * (high – low) / (A[high] – A[low]))");
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("High = " + highs.get(highIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("Low = " + lows.get(lowIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        tempLabel = new JLabel("Pos = " + positions.get(positionIndex));
                        tempLabel.setFont(subTitleFont);
                        tempLabel.setForeground(Color.WHITE);
                        tempLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                        tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        dataPanel.add(tempLabel, cOption);
                        cOption.gridy++;

                        mainFrame.revalidate();
                        mainFrame.repaint();
                    }
                }
            }
            else {
                arrayPanel.getComponent(positions.get(positionIndex)).setForeground(semiWhite);
                codePanel.getComponent(simulationIndex).setForeground(semiWhite);
                simulationIndex = 10;
                arrayPanel.getComponent(positions.get(positionIndex)).setForeground(Color.WHITE);
                codePanel.getComponent(simulationIndex).setForeground(Color.WHITE);
                codePanel.remove(btnForward);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        }
        codePanel.getComponent(simulationIndex).setForeground(semiWhite);
        simulationIndex++;
        codePanel.getComponent(simulationIndex).setForeground(Color.WHITE);
        if(simulationIndex == 11 && positionIndex != positions.size()) {
            arrayPanel.getComponent(positions.get(positionIndex)).setForeground(semiWhite);
            codePanel.remove(btnForward);
            mainFrame.revalidate();
            mainFrame.repaint();
        }
        /*System.out.println(positions.get(positionIndex) + "=?" + Integer.parseInt(fieldItemSearch.getText()));
        if(positions.get(positionIndex) == Integer.parseInt(fieldItemSearch.getText())) {
            cOption.gridx = 0;
            cOption.gridy = 12;
            cOption.anchor = GridBagConstraints.EAST;
            cOption.weightx = 1;
            codePanel.add(btnBackward, cOption);
            cOption.weightx = 0;
        }
        if(positionIndex < positions.size()) {
            positionIndex++;
            //sets highlights
            arrayPanel.getComponent(positions.get(positionIndex)).setForeground(Color.WHITE);
            codePanel.getComponent(0).setForeground(Color.WHITE);
        }*/
    }


    int recurse(int find, int high, int low, int arr[]) {
        if (low <= high && find >= arr[low] && find <= arr[high]) {
            int pos = low + (((high - low) / (arr[high] - arr[low])) * (find - arr[low]));
            System.out.println("Position traversed: " + pos);
            highs.add(high);
            lows.add(low);
            positions.add(pos);
            if(arr[pos] == find)
                return pos;
            if(arr[pos] < find)
                return recurse(find, high, pos+1, arr);
            if(arr[pos] > find)
                return recurse(find, pos-1, low, arr);
        }
        return -1;
    }

    public static void main (String args[]) {
        new InterpolationSearch();
    }
}

class StyledButtonUI extends BasicButtonUI {
    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, 2);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D graphics2d = (Graphics2D) g;
        Color color1 = c.getBackground();
        Color color2 = new Color(255,255,255);
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0,0,color1,180,size.height,color2);
        graphics2d.setPaint(gp);
        graphics2d.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 20, 20);
    }
}

class RoundedBorder extends AbstractBorder {

    public RoundedBorder(Color c, int g) {
        color = c;
        gap = g;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d;
        if (g instanceof Graphics2D) {
            g2d = (Graphics2D) g;
            g2d.setColor(color);
            System.out.println(x + y);
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, gap, gap));
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return (getBorderInsets(c, new Insets(gap, gap, gap, gap)));
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = gap;
        return insets;
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    // Variable declarations
    private final Color color;
    private final int gap;
}