package can.gates;

/**
 * Class that models an OR-gate. It extends the Gate class.
 * 
 * @author Alexander Mogren, Christian Olsson, Nicolas Suau Carvajal
 * @version 2016-10-21
 *
 */
public class OR extends Gate{
	
	public OR(int a, int b) {
		super(a, b);
	}

	public void calcOR() {
		if(a == 1 || b == 1) {
			output = 1;
		}
		else{
			output = 0;
	}
}
	}
