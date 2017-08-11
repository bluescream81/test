package mytetris01;

import javax.swing.JTextArea;

public class TetrisText extends JTextArea{

	private static final String space = "o";
	private static final String cell = "Å°";
	private static final String active = "Å†";

	int[][] field = new int[23][12];

	int[] x = new int[4];
	int[] y = new int[4];
	int t=0;


	/**
	 * 
	 */
	public TetrisText(){
		super();
		this.append(cell);
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
		field[2][6] = 2;
		field[1][6] = 2;
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

	private void addCounter(int i, int j) {
		x[t]=i;
		y[t]=j;
		t++;
	}

    public void moveLeft() {
    	initCounter();
    	for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				if(field[i][j] == 2 && field[i][j-1] !=1){
					addCounter(i,j);
				}
			}
		}
    	if(t==4){
    		clearActiveBlock();
    		for(int i=0;i<4;i++){
        		field[x[i]][y[i]-1] = 2;
    		}
    		this.setText(makeField());
    	}
    }

    public void moveUp() {
    	initCounter();
    	for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				if(field[i][j] == 2 && field[i-1][j] !=1){
					addCounter(i,j);
				}
			}
		}
    	if(t==4){
    		clearActiveBlock();
    		for(int i=0;i<4;i++){
        		field[x[i]-1][y[i]] = 2;
    		}
    		this.setText(makeField());
    	}
    }

    public void moveRight() {
    	initCounter();
    	for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				if(field[i][j] == 2 && field[i][j+1] !=1){
					addCounter(i,j);
				}
			}
		}
    	if(t==4){
    		clearActiveBlock();
    		for(int i=0;i<4;i++){
        		field[x[i]][y[i]+1] = 2;
    		}
    		this.setText(makeField());
    	}
    }

    public void moveDown() {
    	initCounter();
    	for(int i=0;i<23;i++){
			for(int j=0;j<12;j++){
				if(field[i][j] == 2 && field[i+1][j] !=1){
					addCounter(i,j);
				}
			}
		}
    	if(t==4){
    		clearActiveBlock();
    		for(int i=0;i<4;i++){
        		field[x[i]+1][y[i]] = 2;
    		}
    		this.setText(makeField());
    	}else{
    		fixActiveBlock();
    		field[2][6] = 2;
    		field[1][6] = 2;
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
					result = result + active;
				}else if(field[i][j] == 1){
					result = result + cell;
				}else{
					result = result + space;
				}
			}
			result = result + "\n";
		}
    	return result;
    }
}
