import java.util.Scanner;
// this class is meant to implement an extension of the machine which allows users to choose their own setting for the machine
public class User {
	
	 
	private int numberOfPlugs;
	private EnigmaMachine userEnigmaMachine = new EnigmaMachine();
	private Scanner reader = new Scanner(System.in);  // Reading from System.in
	private String type;// stores the type of the rotors as set by the user
	private int position; // stores the position of the rotors as set by the user
	private Scanner scan = new Scanner(System.in);
	
	public void getUserSpecs() {
		
		
		System.out.println("To encode your letter we need to set up Enigma Machine.");
		System.out.println("First you need to choose how many plugs you want the machine to use. Remember you can have from 1 to 13 plugs");
		
		System.out.println("Enter a number: ");
		numberOfPlugs = reader.nextInt();
		Boolean userInput = true;// this variable  is true by default, and it becomes false if the user inputs a right value 
		
		while(userInput == true) {
			if(numberOfPlugs >0 && numberOfPlugs < 14) {
				System.out.println("Now you can choose the plugs!");
				addPlugs();
				userInput = false;
			}
		
			else {
				System.out.println("You can't have this many plugs. Choose a number from 1 to 13!");
				numberOfPlugs = reader.nextInt();
			
			}
		
		}
		
		System.out.println("Now we need to get the details for the three rotors our machine is using");
		System.out.println("Each rotor has a type and an initial position. You can choose type to be I, II, III, IV or V and the position can be any number from 0 to 25");
		System.out.println("Let's get the details for the first rotor!");
		System.out.println("Now enter the type of the first rotor: ");
		
		type = scan.nextLine();
		System.out.println("Now enter the position of the first rotor: ");
		position = reader.nextInt();
		BasicRotor rotor1 = new BasicRotor (type, position);
		userEnigmaMachine.addRotor(rotor1, 0);
		
		System.out.println("Now enter the type of the second rotor: ");
		type = scan.nextLine();
		System.out.println("Now enter the position of the second rotor: ");
		position = reader.nextInt();
		BasicRotor rotor2 = new BasicRotor (type, position);
		userEnigmaMachine.addRotor(rotor2, 1);
		
		System.out.println("Now enter the type of the third rotor: ");
		type = scan.nextLine();
		System.out.println("Now enter the position of the third rotor: ");
		position = reader.nextInt();
		BasicRotor rotor3 = new BasicRotor (type, position);
		userEnigmaMachine.addRotor(rotor3, 2);
		
		System.out.println("We now have 3 rotors, but still need a reflector for our machine to work. A reflector can be of 2 types: <<ReflectorI>> and <<ReflectorII>>");
		System.out.println("Now enter the type of the reflector: ");
		type = scan.nextLine();
		
		Reflector myReflector = new Reflector ();
    	myReflector.initialise(type);
    	userEnigmaMachine.addReflector(myReflector);
    	
    	System.out.println("Now we are ready to encode your messages. Enter the letters you want to encode or press 0 to exit");
    	userInput = true;
    	// as long as the userInput is true, the user is allowed to input characters. When the '0' is pressed, the program stops.
    	while(userInput == true) {
    		
    		char letter = reader.next().charAt(0);
    		if(letter != '0')
    			userEnigmaMachine.encodeLetter(letter);
    		else
    			System.exit(0);
    	}
    	
    	
	}
	// the addPlugs method gets user input for the 2 ends of the plug and adds them to the plugboard if they don't already exist
	public void addPlugs() {
		
		int count = 1;
		while(numberOfPlugs > 0) {
			
			
			System.out.println("The first letter for plug number " +count+ " is:");
			char end1 = reader.next().charAt(0);
			System.out.println("The second letter for plug number " +count+ " is:");
			char end2 = reader.next().charAt(0);
			userEnigmaMachine.addPlug(end1, end2);
			count++;
			numberOfPlugs--;
		}
	}

}
