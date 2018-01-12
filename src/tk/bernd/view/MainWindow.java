package tk.bernd.view;

import tk.bernd.logic.BL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    BL bl = new BL(new Frame());
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
    private int circleWins = 0;
    private int crossWins = 0;
    private int draws = 0;

    MainWindow(Frame frame) {
        this.bl = new BL(frame);
    }
    public MainWindow() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(0, 2, button1);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(1, 2, button2);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(2, 2, button3);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(0, 1, button4);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(1, 1, button5);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(2, 1, button6);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(0, 0, button7);
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(1, 0, button8);
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleClick(2, 0, button9);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TicTacToe by Bernd-L");
        new MainWindow(frame);
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

    private void handleClick(int x, int y, JButton btn) {
        switch (bl.handlePress(x, y, btn)) {
            case BL.CIRCLE_WIN:
                circleWins++;
                JOptionPane.showMessageDialog(null, "Circle won!\n\nCircle:  " + circleWins + "\nCross:  " + crossWins + "\nDraws: " + draws);
                restart();
                break;
            case BL.CROSS_WIN:
                crossWins++;
                JOptionPane.showMessageDialog(null, "Cross won!\n\nCircle:  " + circleWins + "\nCross:  " + crossWins + "\nDraws: " + draws);
                restart();
                break;
            case BL.DRAW:
                draws++;
                JOptionPane.showMessageDialog(null, "It's a draw!\n\nCircle:  " + circleWins + "\nCross:  " + crossWins + "\nDraws: " + draws);
                restart();
        }
    }

    private void restart() {
        restart(BL.DEFAULT);
    }

    private void restart(int beginer) {
        bl.restart(beginer);
        button1.setBackground(null);
        button2.setBackground(null);
        button3.setBackground(null);
        button4.setBackground(null);
        button5.setBackground(null);
        button6.setBackground(null);
        button7.setBackground(null);
        button8.setBackground(null);
        button9.setBackground(null);

        button1.setText(" ");
        button2.setText(" ");
        button3.setText(" ");
        button4.setText(" ");
        button5.setText(" ");
        button6.setText(" ");
        button7.setText(" ");
        button8.setText(" ");
        button9.setText(" ");
    }
}
