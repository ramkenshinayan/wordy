package src.gui;

import javax.swing.JFrame;

public class Welcome extends JFrame {

    public Welcome() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WELCOME TO WORDY!");
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setLayout(null);

        background.setIcon(new javax.swing.ImageIcon("Client_Java\\res\\welcome.jpg")); // NOI18N
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login login = new Login();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
                dispose();
            }
        });
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
}
