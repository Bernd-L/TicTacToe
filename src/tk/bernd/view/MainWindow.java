package tk.bernd.view;

import javax.swing.*;
import tk.bernd.logic.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    BL bl = new BL();

    public MainWindow() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bl
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().pnGameField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        frame.pack();
        frame.setVisible(true);
    }

    private JPanel pnGameField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
}
