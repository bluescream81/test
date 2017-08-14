package mytetris01;

import javax.swing.JTextArea;

public class TetrisText extends JTextArea{

	private static final String SPACE = "�Q";
	private static final String CELL = "�T";
	private static final String ACTIVE = "��";

	int[][] field = new int[23][12];

	int[] x = new int[4];
	int[] y = new int[4];
	int t=0;


	/**
	 * 
	 */
	public TetrisText(){
		super();
		this.append(CELL);
		for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				field[i][j] = 1;
			}
		}
		for(int i=0;i<22;i++){
			for(int j=1;j<11;j++){
				field[i][j] = 0;
			}
		}
		//ToDo �ŏ��̃u���b�N�𐶐��B�b��I��L�^�u���b�N�̂�
		field[3][6] = 2;
		field[2][6] = 2;
		field[2][7] = 2;
		field[2][8] = 2;
		this.setText(makeField());
	}

	private void initCounter() {
		t=0;
    	for(int i=0;i<4;i++){
    		x[i]=0;
    		y[i]=0;
    	}
	}
	private void clearActiveBlock() {
		for(int i=0;i<4;i++){
    		field[x[i]][y[i]] = 0;
		}
	}

	private void fixActiveBlock() {
    	for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				if(field[i][j] == 2){
					field[i][j] = 1;
				}
			}
		}
	}
	
	private void deleteLine(){
		for(int i=0;i<22;i++){
			int cnt=0;
			for(int j=0;j<12;j++){
				if(field[i][j] == 1){
					cnt++;
				}
			}
			if(cnt==12){
				for(int j=1;j<11;j++){
					field[i][j] = 0;
				}
	    		this.setText(makeField());
	    		//ToDo ��b�~�߂�
	    		//�l�߂�
				for(int k=i;k>0;k--){
					for(int j=0;j<12;j++){
						field[k][j] = field[k-1][j];
					}
				}
			}
		}
	}

	private void addCounter(int i, int j) {
		x[t]=i;
		y[t]=j;
		t++;
	}
    
    // ���Ȃ�leftRight=-1, ���Ȃ�upDown=1
    public void moveActiveBlock(int leftRight, int upDown){
    	initCounter();
    	for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				if(i+upDown>=0 && j+leftRight>=0 && field[i][j] == 2 && field[i+upDown][j+leftRight] !=1){
					addCounter(i,j);
				}
			}
		}
    	if(t==4){
    		clearActiveBlock();
    		for(int i=0;i<4;i++){
        		field[x[i] + upDown][y[i]+leftRight] = 2;
    		}
    		this.setText(makeField());
    	}else if(upDown == 1){
    		//���ɉ�����Ȃ��ꍇ�̓u���b�N�Œ�
    		fixActiveBlock();
    		//ToDo �u���b�N���������s�͏�̍s���l�߂�
    		deleteLine();
    		//ToDo ���̃u���b�N�𐶐��B�b��I��L�^�u���b�N�̂�
    		field[3][6] = 2;
    		field[2][6] = 2;
    		field[2][7] = 2;
    		field[2][8] = 2;
    		this.setText(makeField());
    	}
    }

    private String makeField(){

    	String result = "";

		for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				if(field[i][j] == 2){
					result = result + ACTIVE;
				}else if(field[i][j] == 1){
					result = result + CELL;
				}else{
					result = result + SPACE;
				}
			}
			result = result + "\n";
		}
    	return result;
    }
}
