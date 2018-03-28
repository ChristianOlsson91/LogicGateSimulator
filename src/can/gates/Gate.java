package can.gates;

import javax.swing.JComboBox;

import can.interfaces.Input;

/**
 * Class that handles logic gates. It provides its subclasses with two inputs and an output and methods to set the inputs and returning
 * the output.
 *
 * @author Alexander Mogren, Christian Olsson, Nicolas Suau Carvajal
 * @version 2016-10-29
 */
 public abstract class Gate implements Input {
	protected int a;
	protected int b;
	protected int output;
	
	 /**
	 * @param a
	 * 			- input of the gate
	 * @param b
	 * 			- input of the gate
	 */
	public Gate(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	 /**
	 * Sets the inputs of the gate to the values that is chosen by the user.
	 * 
	 * @param a
	 * 			- input of the gate
	 * @param b
	 * 			- input of the gate
	 */
	public void input(int a, int b) {
	   this.a = a;
	   this.b = b;
	}

	public void setInputA(int a){
		this.a = a;
	}
	
	public void setInputB(int b){
		this.b = b;
	}
	
	 /**
	 * Returns the output of the gate.
	 * 
	 * @return output
	 * 					- the value to be returned
	 */
	public int getOutput(){
	    return output;
	}
	
	public int getInputA(){
		return a;
	}
	
	public int getInputB(){
		return b;
	}
	
	/**
	 * Sets if a JComboBox should be disabled.
	 * 
	 * @param jcombo
	 * 					- the JComboBox to be disabled
	 */
	public void setCombo(JComboBox jcombo){
		jcombo.setEnabled(false);
	}
}
