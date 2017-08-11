package mytetris01;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MyTetrisMain extends JFrame{

    TetrisText tetrisArea = new TetrisText();

    public MyTetrisMain() {
        // タイトルを設定
        setTitle("テトリス");

//        setBounds(100, 100, 600, 650);

//        // サイズ変更禁止
//        setResizable(false)
        ;
        MainPanel panel = new MainPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        // パネルサイズに合わせてフレームサイズを自動設定
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new MyTetrisMain();
    }
}
