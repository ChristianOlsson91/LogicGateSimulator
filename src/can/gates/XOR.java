package can.gates;

public class XOR extends Gate{
  
	public XOR(int a, int b){
		super(a, b);
	}

	public void calcXOR(){
		if(a == 1 && b == 1 || a == 0 && b == 0){
			output = 0;
		}
	    else {
	    	output = 1;
	    }
  	}
}