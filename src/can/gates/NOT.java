package can.gates;

/**
 * Class that models a NOT-gate. It extends the Gate class.
 
 * @author Alexander Mogren, Christian Olsson, Nicolas Suau Carvajal
 * @version 2016-10-21
 *
 */
public class NOT {
	private int a;
	private int output;
	
	public NOT(int a) {
		this.a = a;
	}
	
	public void input(int a) {
		this.a = a;
	}
	
	public void calcNOT() {
		if(a==0) {
			output = 1;
		}
		else {
			output = 0;
		}
	}
	
	public void setInputA(int a){
		this.a = a;
	}
	
	public int getOutput(){
		return output;
	}
}
