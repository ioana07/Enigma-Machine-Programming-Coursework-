import java.io.IOException;
// the main class contains the main method which is meant to call all methods that make the Enigma Machine work
public class Main {

	public static void main (String[] args) throws IOException {
		/*  Note: Due to the high dimension of the output, all methods are made comments.
		 *  To call a method, please uncomment the method.
		 */
		EnigmaMachine myEnigmaMachine = new EnigmaMachine();// creates a new Enigma Machine
		//the start method will display the results of the first three tests
		//myEnigmaMachine.start();
    	
    	EnigmaFile myEnigmaFile = new EnigmaFile(); // creates a new EnigmaFile object
    	myEnigmaFile.readFile(); // calls readFile methid which reads characters from file
    	myEnigmaFile.encodeFile(); // calls the encodeFile method which writes the encoded message in a different file
    	
    	System.out.println();
    	
    	Bomb myBomb = new Bomb(); // creates a Bomb object
    	//the calling of the following methods will display the output of the three challenges in part 8:
    	//myBomb.challenge1();
    	//myBomb.challenge2();
    	//myBomb.challenge3();
    	
    	
    	User newUser = new User(); // creates a new user object
    	//the getUserspecs is an extension method which is meant to create a user interface
    	//newUser.getUserSpecs();
    	
    	}
}
