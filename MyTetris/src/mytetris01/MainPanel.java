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
    private static final int WIDTH = 240;
    private static final int HEIGHT = 480;

    // テトリス画面エリアになるテキストエリア
    private JTextArea tetrisTextArea = new JTextArea();
    
    // テトリス画面エリアに表示されるテキスト(TetrisTextはJTextAreaの拡張クラス)
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
        tetrisTextArea.setEditable(false);
        tetrisTextArea.setLineWrap(true);

        // パネルに追加
        JScrollPane scrollPane = new JScrollPane(tetrisTextArea);
        scrollPane.setAutoscrolls(true);
        add(scrollPane, BorderLayout.CENTER);

        //パネルを更新
    	tetris = tetrisText.getText();
    	tetrisTextArea.setText("");
        tetrisTextArea.append(tetris + "\n");

        tetrisTextArea.addKeyListener(this);
    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	private final int KEY_LEFT = 37;
	private final int KEY_UP = 38;
	private final int KEY_RIGHT = 39;
	private final int KEY_DOWN = 40;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getKeyCode()==KEY_LEFT){
			tetrisText.moveActiveBlock(-1, 0);
		}else if(e.getKeyCode()==KEY_UP){
			tetrisText.moveActiveBlock(0, -1);
		}else if(e.getKeyCode()==KEY_RIGHT){
			tetrisText.moveActiveBlock(1,0);
		}else if(e.getKeyCode()==KEY_DOWN){
			tetrisText.moveActiveBlock(0,1);
		}

        //パネルを更新
    	tetris = tetrisText.getText();
    	tetrisTextArea.setText("");
        tetrisTextArea.append(tetris + "\n");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
