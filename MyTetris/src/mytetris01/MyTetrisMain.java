package mytetris01;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MyTetrisMain extends JFrame{

    TetrisText tetrisArea = new TetrisText();

    public MyTetrisMain() {
        // �^�C�g����ݒ�
        setTitle("�e�g���X");

//        setBounds(100, 100, 600, 650);

//        // �T�C�Y�ύX�֎~
//        setResizable(false)
        ;
        MainPanel panel = new MainPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        // �p�l���T�C�Y�ɍ��킹�ăt���[���T�C�Y�������ݒ�
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new MyTetrisMain();
    }
}
