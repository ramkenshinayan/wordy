package src.gui;

import clientInt.WordyModule.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static src.WordyClientMain.wordyImpl;
import static src.gui.Login.username;

public class Game extends javax.swing.JFrame {

    char[] letters;
    boolean roundEndFlag;
    boolean gameEndFlag;
    int time = 10;

    public Game() {
        roundEndFlag = false;
        initComponents();
        startGame();
        updateLetters();
        timerDisplay();
        updateScoreTable();
    }

    private void updateScoreTable() {
        Player_[] players = wordyImpl.getAllPlayers(username);
        DefaultTableModel model = (DefaultTableModel) score.getModel();
        for (int i = 0; i < players.length; i++) {
            Player_ player = players[i];
            if (i >= model.getRowCount()) {
                model.addRow(new Object[]{player.username, player.roundWins});
            } else {
                model.setValueAt(player.username, i, 0);
                model.setValueAt(player.roundWins, i, 1);
            }
        }
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        timerText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        score = new javax.swing.JTable();
        typeWordsHere = new javax.swing.JTextField();
        confirmButton = new javax.swing.JLabel();
        letter1 = new javax.swing.JLabel();
        letter2 = new javax.swing.JLabel();
        letter3 = new javax.swing.JLabel();
        letter4 = new javax.swing.JLabel();
        letter5 = new javax.swing.JLabel();
        letter6 = new javax.swing.JLabel();
        letter7 = new javax.swing.JLabel();
        letter8 = new javax.swing.JLabel();
        letter9 = new javax.swing.JLabel();
        letter10 = new javax.swing.JLabel();
        letter11 = new javax.swing.JLabel();
        letter12 = new javax.swing.JLabel();
        letter13 = new javax.swing.JLabel();
        letter14 = new javax.swing.JLabel();
        letter15 = new javax.swing.JLabel();
        letter16 = new javax.swing.JLabel();
        letter17 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WORDY | " + username);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(null);

        timerText.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        timerText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(timerText);
        timerText.setBounds(30, 40, 70, 60);

        score.setBackground(new java.awt.Color(0, 0, 0));
        score.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        score.setForeground(new java.awt.Color(255, 255, 255));
        score.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "", ""
                }
        ));
        score.setEnabled(false);
        score.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(score);
        score.setTableHeader(null);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(130, 460, 270, 90);

        typeWordsHere.setBackground(new java.awt.Color(0, 0, 0));
        typeWordsHere.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        typeWordsHere.setForeground(new java.awt.Color(255, 255, 255));
        typeWordsHere.setBorder(null);
        jPanel1.add(typeWordsHere);
        typeWordsHere.setBounds(70, 220, 660, 50);
        typeWordsHere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmButtonMouseClicked(null);
            }
        });

        confirmButton.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\Buttons\\mainGame\\mainGame.png")); // NOI18N
        confirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmButtonMouseClicked(evt);
            }
        });
        jPanel1.add(confirmButton);
        confirmButton.setBounds(780, 170, 280, 100);

        letter1.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter1.setForeground(new java.awt.Color(255, 255, 255));
        letter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter1);
        letter1.setBounds(640, 430, 40, 60);

        letter2.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter2.setForeground(new java.awt.Color(255, 255, 255));
        letter2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter2);
        letter2.setBounds(690, 430, 40, 60);

        letter3.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter3.setForeground(new java.awt.Color(255, 255, 255));
        letter3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter3);
        letter3.setBounds(740, 430, 40, 60);

        letter4.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter4.setForeground(new java.awt.Color(255, 255, 255));
        letter4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter4);
        letter4.setBounds(840, 430, 40, 60);

        letter5.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter5.setForeground(new java.awt.Color(255, 255, 255));
        letter5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter5);
        letter5.setBounds(890, 430, 40, 60);

        letter6.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter6.setForeground(new java.awt.Color(255, 255, 255));
        letter6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter6);
        letter6.setBounds(940, 430, 40, 60);

        letter7.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter7.setForeground(new java.awt.Color(255, 255, 255));
        letter7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter7);
        letter7.setBounds(640, 480, 40, 60);

        letter8.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter8.setForeground(new java.awt.Color(255, 255, 255));
        letter8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter8);
        letter8.setBounds(690, 480, 40, 60);

        letter9.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter9.setForeground(new java.awt.Color(255, 255, 255));
        letter9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter9);
        letter9.setBounds(740, 480, 40, 60);

        letter10.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter10.setForeground(new java.awt.Color(255, 255, 255));
        letter10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter10);
        letter10.setBounds(840, 530, 40, 60);

        letter11.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter11.setForeground(new java.awt.Color(255, 255, 255));
        letter11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter11);
        letter11.setBounds(840, 480, 40, 60);

        letter12.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter12.setForeground(new java.awt.Color(255, 255, 255));
        letter12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter12);
        letter12.setBounds(890, 480, 40, 60);

        letter13.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter13.setForeground(new java.awt.Color(255, 255, 255));
        letter13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter13);
        letter13.setBounds(940, 480, 40, 60);

        letter14.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter14.setForeground(new java.awt.Color(255, 255, 255));
        letter14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter14);
        letter14.setBounds(640, 530, 40, 60);

        letter15.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter15.setForeground(new java.awt.Color(255, 255, 255));
        letter15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter15);
        letter15.setBounds(690, 530, 40, 60);

        letter16.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter16.setForeground(new java.awt.Color(255, 255, 255));
        letter16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter16);
        letter16.setBounds(740, 530, 40, 60);

        letter17.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        letter17.setForeground(new java.awt.Color(255, 255, 255));
        letter17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(letter17);
        letter17.setBounds(890, 530, 40, 60);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\mainGame.jpg")); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 1080, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void confirmButtonMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            wordyImpl.submitWord(username, typeWordsHere.getText());
            System.out.println(typeWordsHere.getText() + " is valid!");
            JOptionPane.showMessageDialog(this, typeWordsHere.getText() + " is valid!", "Valid Word", JOptionPane.INFORMATION_MESSAGE);
            typeWordsHere.setText("");
        } catch (InvalidWordException e) {
            JOptionPane.showMessageDialog(this, e.reason + ". Try again", "Invalid Word", JOptionPane.ERROR_MESSAGE);
            typeWordsHere.setText("");
        }
    }

    private void startGame() {
        Thread start = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    roundEndFlag = wordyImpl.roundEndFlag(username);
                    gameEndFlag = wordyImpl.gameEndFlag(username);
                    if (roundEndFlag) {
                        try {
                            dispose();
                            RoundWinner_ playerWin = wordyImpl.getRoundWinner(username);
                            RoundWinner roundWinner = new RoundWinner(playerWin);
                            roundWinner.setLocationRelativeTo(null);
                            roundWinner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            roundWinner.setVisible(true);
                            timer();
                            roundWinner.dispose();
                            if (gameEndFlag && playerWin.roundWins >= 3) {
                                roundWinner.dispose();
                                System.out.println("Game over. Winner: " + wordyImpl.getGameWinner(username));
                                GameOver gameOver = new GameOver();
                                gameOver.setLocationRelativeTo(null);
                                gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                gameOver.setVisible(true);
                                break;
                            }
                            resumeGame();
                        } catch (NoWinnerException e) {
                            dispose();
                            System.err.println(e.reason);
                            NoWinner noWinner = new NoWinner(e.reason);
                            noWinner.setLocationRelativeTo(null);
                            noWinner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            noWinner.setVisible(true);
                            timer();
                            noWinner.setVisible(false);
                            resumeGame();
                        }
                    }
                }
            }
        });
        start.start();
    }

    private void updateLetters() {
        letters = wordyImpl.getLetters(username);
        System.out.println("Letters: " + Arrays.toString(letters));
        String ltrs = new String(letters);
        letter1.setText(String.valueOf(ltrs.charAt(0)));
        letter2.setText(String.valueOf(ltrs.charAt(1)));
        letter3.setText(String.valueOf(ltrs.charAt(2)));
        letter4.setText(String.valueOf(ltrs.charAt(3)));
        letter5.setText(String.valueOf(ltrs.charAt(4)));
        letter6.setText(String.valueOf(ltrs.charAt(5)));
        letter7.setText(String.valueOf(ltrs.charAt(6)));
        letter8.setText(String.valueOf(ltrs.charAt(7)));
        letter9.setText(String.valueOf(ltrs.charAt(8)));
        letter10.setText(String.valueOf(ltrs.charAt(9)));
        letter11.setText(String.valueOf(ltrs.charAt(10)));
        letter12.setText(String.valueOf(ltrs.charAt(11)));
        letter13.setText(String.valueOf(ltrs.charAt(12)));
        letter14.setText(String.valueOf(ltrs.charAt(13)));
        letter15.setText(String.valueOf(ltrs.charAt(14)));
        letter16.setText(String.valueOf(ltrs.charAt(15)));
        letter17.setText(String.valueOf(ltrs.charAt(16)));
    }

    private void resumeGame() {
        updateLetters();
        setVisible(true);
        updateScoreTable();
        timerDisplay();
    }
    private void timerDisplay() {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                time = 10;
                while (time > 0) {
                    timerText.setText(String.valueOf(time));
                    time--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        timer.start();
    }

    private void timer() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }

    private javax.swing.JLabel background;
    private javax.swing.JLabel confirmButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel letter1;
    private javax.swing.JLabel letter10;
    private javax.swing.JLabel letter11;
    private javax.swing.JLabel letter12;
    private javax.swing.JLabel letter13;
    private javax.swing.JLabel letter14;
    private javax.swing.JLabel letter15;
    private javax.swing.JLabel letter16;
    private javax.swing.JLabel letter17;
    private javax.swing.JLabel letter2;
    private javax.swing.JLabel letter3;
    private javax.swing.JLabel letter4;
    private javax.swing.JLabel letter5;
    private javax.swing.JLabel letter6;
    private javax.swing.JLabel letter7;
    private javax.swing.JLabel letter8;
    private javax.swing.JLabel letter9;
    private javax.swing.JTable score;
    private javax.swing.JLabel timerText;
    private javax.swing.JTextField typeWordsHere;

}
