package can.gates;

public class NAND extends Gate {

	public NAND(int a, int b){
		super(a, b);
	}

	public void calcNAND(){
		if(a != 0 && b != 0){
			output = 0;
		}
		else {
			output = 1;
		}
	}
}