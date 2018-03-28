package can.gates;

/**
 * Class that models an AND-gate. It extends the Gate class.
 * 
 * @author Alexander Mogren, Christian Olsson, Nicolas Suau Carvajal
 * @version 2016-10-21
 *
 */
public class AND extends Gate {
	
	public AND(int a, int b) {
		super(a, b);
	}

	public void calcAND(){
		 if(a == 1 && b == 1){
		    output = 1;
		 }
		 else{
		    output = 0;
		 }
	 }
}