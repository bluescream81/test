package mytetris01;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Created on 2006/02/24
 */

public class MainPanel extends JPanel implements KeyListener {
    private static final int WIDTH = 480;
    private static final int HEIGHT = 480;

    // テトリス画面エリア
    private JTextArea dialogueArea;
    // テトリス画面エリアに表示されるテキスト
    private TetrisText tetrisText = new TetrisText();

	private String tetris;

    public MainPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initGUI();
    }

    /**
     * GUIを初期化する
     */
    private void initGUI() {
        setLayout(new BorderLayout());

        // メッセージ履歴表示エリア
        dialogueArea = new JTextArea();
        dialogueArea.setEditable(false);
        dialogueArea.setLineWrap(true);

        // パネルに追加
        JScrollPane scrollPane = new JScrollPane(dialogueArea);
        scrollPane.setAutoscrolls(true);
        add(scrollPane, BorderLayout.CENTER);


    	tetris = tetrisText.getText();
    	dialogueArea.setText("");
        dialogueArea.append(tetris + "\n");

        dialogueArea.addKeyListener(this);
    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getKeyCode()==37){
			tetrisText.moveLeft();
		}else if(e.getKeyCode()==38){
			tetrisText.moveUp();
		}else if(e.getKeyCode()==39){
			tetrisText.moveRight();
		}else if(e.getKeyCode()==40){
			tetrisText.moveDown();
		}

    	tetris = tetrisText.getText();
    	dialogueArea.setText("");
        dialogueArea.append(tetris + "\n");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
