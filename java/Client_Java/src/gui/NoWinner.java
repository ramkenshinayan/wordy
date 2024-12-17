package src.gui;

public class NoWinner extends javax.swing.JFrame {

    int time;
    String reason;

    public NoWinner(String reason) {
        this.reason = reason;
        initComponents();
        timerDisplay();
    }

    private void timerDisplay() {
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                time = 5;
                while (time > 0) {
                    countDown.setText(String.valueOf(time));
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

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        countDown = new javax.swing.JLabel();
        reasonLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(null);

        countDown.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        countDown.setForeground(new java.awt.Color(235, 234, 101));
        countDown.setText("5");
        jPanel1.add(countDown);
        countDown.setBounds(1010, 660, 40, 60);

        reasonLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        reasonLabel.setForeground(new java.awt.Color(235, 234, 101));
        reasonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reasonLabel.setText("<longest word>");
        jPanel1.add(reasonLabel);
        reasonLabel.setBounds(30, 360, 1030, 60);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\noWinner.jpg"));
        jPanel1.add(background);
        background.setBounds(0, 0, 1080, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();

        reason = reason.substring(10);
        reasonLabel.setText(reason);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {

    }

    private javax.swing.JLabel background;
    private javax.swing.JLabel countDown;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel reasonLabel;

}
