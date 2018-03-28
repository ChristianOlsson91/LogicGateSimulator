package can.gates;

public class NOR extends Gate {
  
	public NOR(int a, int b) {
		super(a, b);
	}

	public void calcNOR() {
		if(a == 0 && b == 0) {
			output = 1;
	    	}
		else{
			output = 0;
		}
}
	}
