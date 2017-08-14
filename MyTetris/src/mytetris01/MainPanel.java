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

    // �e�g���X��ʃG���A�ɂȂ�e�L�X�g�G���A
    private JTextArea tetrisTextArea = new JTextArea();
    
    // �e�g���X��ʃG���A�ɕ\�������e�L�X�g(TetrisText��JTextArea�̊g���N���X)
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
        tetrisTextArea.setEditable(false);
        tetrisTextArea.setLineWrap(true);

        // �p�l���ɒǉ�
        JScrollPane scrollPane = new JScrollPane(tetrisTextArea);
        scrollPane.setAutoscrolls(true);
        add(scrollPane, BorderLayout.CENTER);

        //�p�l�����X�V
    	tetris = tetrisText.getText();
    	tetrisTextArea.setText("");
        tetrisTextArea.append(tetris + "\n");

        tetrisTextArea.addKeyListener(this);
    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}
	
	private final int KEY_LEFT = 37;
	private final int KEY_UP = 38;
	private final int KEY_RIGHT = 39;
	private final int KEY_DOWN = 40;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		if(e.getKeyCode()==KEY_LEFT){
			tetrisText.moveActiveBlock(-1, 0);
		}else if(e.getKeyCode()==KEY_UP){
			tetrisText.moveActiveBlock(0, -1);
		}else if(e.getKeyCode()==KEY_RIGHT){
			tetrisText.moveActiveBlock(1,0);
		}else if(e.getKeyCode()==KEY_DOWN){
			tetrisText.moveActiveBlock(0,1);
		}

        //�p�l�����X�V
    	tetris = tetrisText.getText();
    	tetrisTextArea.setText("");
        tetrisTextArea.append(tetris + "\n");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}
}
