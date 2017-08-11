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

    // �e�g���X��ʃG���A
    private JTextArea dialogueArea;
    // �e�g���X��ʃG���A�ɕ\�������e�L�X�g
    private TetrisText tetrisText = new TetrisText();

	private String tetris;

    public MainPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initGUI();
    }

    /**
     * GUI������������
     */
    private void initGUI() {
        setLayout(new BorderLayout());

        // ���b�Z�[�W����\���G���A
        dialogueArea = new JTextArea();
        dialogueArea.setEditable(false);
        dialogueArea.setLineWrap(true);

        // �p�l���ɒǉ�
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}
}
