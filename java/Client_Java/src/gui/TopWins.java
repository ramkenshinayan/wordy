package src.gui;

import clientInt.WordyModule.TopPlayer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import static src.WordyClientMain.wordyImpl;

public class TopWins extends JFrame {

    public TopWins() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        leaderboardsTable = new javax.swing.JTable();
        backButton = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Top 5 Winners");
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));

        jPanel1.setLayout(null);

        leaderboardsTable.setBackground(new java.awt.Color(0, 0, 0));
        leaderboardsTable.setFont(new java.awt.Font("Eras Bold ITC", 0, 34)); // NOI18N
        leaderboardsTable.setForeground(new java.awt.Color(255, 255, 255));
        leaderboardsTable.setRowHeight(53);
        leaderboardsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[]{
                        "", "", ""
                }
        ));
        leaderboardsTable.setEnabled(false);
        leaderboardsTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(leaderboardsTable);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        leaderboardsTable.setTableHeader(null);

        int availableEntries = wordyImpl.getTopPlayersSize();
        for (int rowIndex = 0; rowIndex < 5; rowIndex++) {
            if (rowIndex < availableEntries) {
                TopPlayer topPlayer = wordyImpl.getTopPlayers(rowIndex);
                String username = topPlayer.username;
                Integer roundsWon = topPlayer.roundWins;
                Integer gamesWon = topPlayer.gameWins;
                leaderboardsTable.getModel().setValueAt(username, rowIndex, 0);
                leaderboardsTable.getModel().setValueAt(roundsWon, rowIndex, 1);
                leaderboardsTable.getModel().setValueAt(gamesWon, rowIndex, 2);
            } else {
                leaderboardsTable.getModel().setValueAt(null, rowIndex, 0);
                leaderboardsTable.getModel().setValueAt(null, rowIndex, 1);
                leaderboardsTable.getModel().setValueAt(null, rowIndex, 2);
            }
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < leaderboardsTable.getColumnCount(); i++) {
            leaderboardsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(62, 280, 720, 265);

        backButton.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\Buttons\\leaderboards\\backButton.png")); // NOI18N
        backButton.setText("jLabel2");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        jPanel1.add(backButton);
        backButton.setBounds(80, 660, 90, 50);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\winsBoard.jpg")); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 1080, 730);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
    }

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {
        Menu rgf = new Menu();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(this);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private javax.swing.JLabel backButton;
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable leaderboardsTable;

}
