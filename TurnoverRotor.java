
public class TurnoverRotor extends BasicRotor {
	
	private int turnoverPosition;
	private BasicRotor nextRotor;
	private EnigmaMachine someEnigmaMachine;
	
	// this constructor will set the type, position and "conexion" to a machine when an object is created
	public TurnoverRotor(String type, int position, EnigmaMachine someEnigmaMachine ) {
		super(type, position);
		this.someEnigmaMachine = someEnigmaMachine;
	}

	//next method initialises and returns the turnover position, depending on the type of the rotor
	public int getTurnoverPosition() {
		
		if(type.equals("I"))
			turnoverPosition = 24;
		if(type.equals("II"))
			turnoverPosition = 12;
		if(type.equals("III"))
			turnoverPosition = 3;
		if(type.equals("IV"))
			turnoverPosition = 17;
		if(type.equals("V"))
			turnoverPosition = 7;
		
		return turnoverPosition;
	}
	
	public void setNextRotor(TurnoverRotor someRotor) {// sets the rotor on the right of the current rotor
		
			if(someRotor == someEnigmaMachine.getRotor(0))
				nextRotor = someEnigmaMachine.getRotor(1);
			if(someRotor == someEnigmaMachine.getRotor(1))
				nextRotor = someEnigmaMachine.getRotor(2);
			
	}
	
	public BasicRotor getNextRotor() {
		return nextRotor; //returns the rotor on the right of the current rotor
	}
	
	

}
