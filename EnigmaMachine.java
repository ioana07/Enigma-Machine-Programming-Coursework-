

public class EnigmaMachine {
	
	private Plugboard plugboard; // declares a plugboard
	private BasicRotor[] myBasicRotors = new BasicRotor[3]; // creates an array of type BasicRotor and sets its size to 3
	private Reflector reflector; // declares a reflector
	
	public EnigmaMachine() {
		
		plugboard = new Plugboard();// creates a new plugboard
	}
	/* the addPlug method takes two chars as parameters and then calls method addPlug from EnigmaMachine
	 * if this method returns true, it means the plugs were added, otherwise the plugs are not added
	 */
	public void addPlug (char end1, char end2) {
		
		if(plugboard.addPlug(end1, end2)) {
			
			System.out.println("You added the plug "+ end1+ " and "+ end2);
		}
		else
			System.out.println("You cannot add this plug");
			
	}
	
	public void clearPlugboard() {
		
		plugboard.clear(); // clears all plugs from the plugboard
	}
	
	public void setNumberOfPlugs() {
		
		plugboard.setNumberOfPlugs();// sets the number of plugs from the plugboard to 0
	}
	
	public void addRotor(BasicRotor someRotor, int someSlot) {
		
		myBasicRotors[someSlot] = someRotor; // adds a rotor received as a parameter into the array in the given slot
	}
	
	public BasicRotor getRotor (int slot) {
		
		return myBasicRotors[slot];// returns the rotor from the given slot in the array
		
	}
	
	
	public void addReflector (Reflector reflector) {
		
		this.reflector = reflector;// adds the given reflector to the machine
	}
	
	public Reflector getReflector() {
		
		return reflector; //returns the reflector
	}
	
	public void setPosition (int slot, int position) {
		
		myBasicRotors[slot].setPosition(position);// sets the position of the rotor in the given slot to the one received as parameter
	}
	
	public char encodeLetter (char letter) {
		
		letter = plugboard.substitute(letter);//the letter is sent to the plug board where it is converted into another letter if a plug exists
		int index = convertToInt(letter);// index stores the numeric value of the letter so that we can substitute the letter using the substitute method
		
		index = myBasicRotors[0].substitute(index);// sends the letter to the first rotor that changes it to a different letter
		index = myBasicRotors[1].substitute(index);// the outcome returned by the first rotor is sent to the second rotor
		index = myBasicRotors[2].substitute(index);// the outcome of the second rotor is sent to the third rotor
		
		index = reflector.substitute(index);// the third rotor passes the letter to the reflector
		
		index = myBasicRotors[2].substituteBack(index);// the reflector maps the letter and reflects it back to the third rotor
		index = myBasicRotors[1].substituteBack(index);//the output goes to the second rotor and this changes the letter with its inverse mapping and passes it to the first rotor
		index = myBasicRotors[0].substituteBack(index);// the first rotor uses its inverse mapping to change the letter and passes the resulting letter back to the plugboard
		
		letter =convertToChar(index);// the index is converted back to char - a proper letter
		letter = plugboard.substitute(letter);// the letter is changed again by the plugboard
		
		myBasicRotors[0].rotate();// the first rotor is rotated by one increment
		
		/* If the first Rotor is a TurnoverRotor AND its position corresponds to its turnoverPosition
		 *    Then rotate the second Rotor
		 *    If Rotor two is a TurnoverRotor AND its position corresponds to its turnoverPosition
				Then rotate the third Rotor.
		 */
		if(myBasicRotors[0] instanceof TurnoverRotor) {
			
			TurnoverRotor TurnoverRotor1 = (TurnoverRotor) myBasicRotors[0];
			if(myBasicRotors[0].getPosition() == TurnoverRotor1.getTurnoverPosition()){ 
				
				myBasicRotors[1].rotate();
				if (myBasicRotors[1] instanceof TurnoverRotor) {
					
					TurnoverRotor TurnoverRotor2 = (TurnoverRotor) myBasicRotors[1];
					if(myBasicRotors[1].getPosition() == TurnoverRotor2.getTurnoverPosition())
						
						myBasicRotors[2].rotate();
				}
			}
		}
				
		
		System.out.print(letter);//the resulted encoded letter is displayed
		return letter; // the letter is also returned when the method is called
		
		
		}
	
	// convertToInt takes a letter as a parameter and returns the corresponding integer value
	public int convertToInt (char letter) {
		
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i=0; i< 26; i++) {
			if(letter == alphabet[i])
				return i;
			}
		return -1;
		
	}
	//convertToChar takes an integer as a parameter and returns the corresponding char value
	public char convertToChar (int index) {
		
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i=0; i< 26; i++) {
			if(index == i)
				return alphabet[i];
		}
			
		return '0';
	
	
	}
	
	public void start() {
		
		//Test1:
		
		// adds 3 plugs:
		this.addPlug('A', 'M');
    	this.addPlug('G', 'L');
    	this.addPlug('E', 'T');
    	
    	// creates 3 rotors:
    	BasicRotor rotor1 = new BasicRotor("I", 6);
    	BasicRotor rotor2 = new BasicRotor("II", 12);
    	BasicRotor rotor3 = new BasicRotor("III", 5);
    	
    	// adds rotors to the machine:
    	this.addRotor(rotor1, 0);
    	this.addRotor(rotor2, 1);
    	this.addRotor(rotor3, 2);
    	
    	// creates a reflector of type I:
    	Reflector myReflector = new Reflector ();
    	myReflector.initialise("ReflectorI");
    	this.addReflector(myReflector);
    	
    	//encodes the given letters:
    	this.encodeLetter('G');
    	this.encodeLetter('F');
    	this.encodeLetter('W');
    	this.encodeLetter('I');
    	this.encodeLetter('Q');
    	this.encodeLetter('H');
    	
    	System.out.println();
    	this.clearPlugboard();// clears all plugs from the plugboard
    	this.setNumberOfPlugs(); // sets number of plugs to 0
    	
    	//Test2:
    	
    	// adds 4 plugs to the machine:
    	this.addPlug('B', 'C');
    	this.addPlug('R', 'I');
    	this.addPlug('S', 'M');
    	this.addPlug('A', 'F');
    	
    	// creates 3 rotors:
    	BasicRotor rotor4 = new BasicRotor("IV", 23);
    	BasicRotor rotor5 = new BasicRotor("V", 4);
    	BasicRotor rotor6 = new BasicRotor("II", 9);
    	
    	// adds the rotors to the machine:
    	this.addRotor(rotor4, 0);
    	this.addRotor(rotor5, 1);
    	this.addRotor(rotor6, 2);
    	
    	//creates a reflector of type II:
    	Reflector myReflector1 = new Reflector ();
    	myReflector1.initialise("ReflectorII");
    	this.addReflector(myReflector1);
    	
    	// encodes the given letters:
    	this.encodeLetter('G');
    	this.encodeLetter('A');
    	this.encodeLetter('C');
    	this.encodeLetter('I');
    	this.encodeLetter('G');
    	
    	System.out.println();
    	this.clearPlugboard(); //clears all plugs from the plugboard
    	this.setNumberOfPlugs(); //sets number of plugs to 0
    	
    	
    	//Test3:
    	
    	// adds a plug to the machine:
    	this.addPlug('Q', 'F');
    	
    	//creates 3 Turnover rotors:
    	TurnoverRotor trotor4 = new TurnoverRotor("I", 23,  this);
    	TurnoverRotor trotor5 = new TurnoverRotor("II", 11, this);
    	TurnoverRotor trotor6 = new TurnoverRotor("III", 7, this);
    	
    	//adds the rotors to the machine:
    	this.addRotor(trotor4, 0);
    	this.addRotor(trotor5, 1);
    	this.addRotor(trotor6, 2);
    	
    	//creates a reflector of type I:
    	Reflector myReflector2 = new Reflector ();
    	myReflector2.initialise("ReflectorI");
    	this.addReflector(myReflector2);
    	
    	String encodedMessage = "OJVAYFGUOFIVOTAYRNIWJYQWMXUEJGXYGIFT"; //message to decode
    	for(int index=0; index< encodedMessage.length(); index++) {
	    	   
	    	   char character = encodedMessage.charAt(index);
	    	   this.encodeLetter(character);
 	}
    	
    	System.out.println();
    	this.clearPlugboard(); //clears all plugs from the plugboard
    	this.setNumberOfPlugs(); //sets number of plugs to 0
    	
	}
}
