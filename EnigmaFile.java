import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// this class is meant to read a message from a file, encoded this message and then write it in a different file 
public class EnigmaFile {
	
	 private EnigmaMachine myEnigmaMachine1 = new EnigmaMachine(); //creates a new EnigmaMachine 
	 private char[] arrayOfLetters = new char[1000]; //creates a char array with the maximum size 1000
	 private int size = 0; // sets the initial index of the array to 0
	
	 
     
     public void readFile() throws IOException {
    	 
    	 FileReader reader = null; // the file reader will be initially 0

    	 try {
    		 reader = new FileReader("readHere.txt"); // reads file "readHere.txt"
    		 int character;
    		 
    		 // while there are letters in the file, the file is read character by character and each character is stored in the arrayOfLetters
    		 while ((character = reader.read()) != -1) {
    			 arrayOfLetters[size] = (char)character; 
    			 size++;
    		 }
    	 } finally {
    		 if (reader != null) {
             reader.close();
    		 }
    	 }
     
     }
     
     public void encodeFile() throws IOException {
    	
    	// adds three plugs to myEnigmaMachine1:
    	myEnigmaMachine1.addPlug('A', 'M');
     	myEnigmaMachine1.addPlug('G', 'L');
     	myEnigmaMachine1.addPlug('E', 'T');
     	
     	// creates 3 rotors:
     	BasicRotor rotor1 = new BasicRotor("I", 6);
     	BasicRotor rotor2 = new BasicRotor("II", 12);
     	BasicRotor rotor3 = new BasicRotor("III", 5);
     	
     	//adds the three created rotors to myEnigmaMachine1
        myEnigmaMachine1.addRotor(rotor1, 0);
     	myEnigmaMachine1.addRotor(rotor2, 1);
     	myEnigmaMachine1.addRotor(rotor3, 2);
     	
     	//creates a reflector of type I:
     	Reflector myReflector = new Reflector ();
     	myReflector.initialise("ReflectorI");
     	myEnigmaMachine1.addReflector(myReflector);
    	 
    	 FileWriter writer = null;
    	 int i;
    
    		 try {
    			 writer = new FileWriter("writeHere.txt"); // declares a file writer for file "writeHere.txt"
    			 //iterates over the arrayOfletters, encodes each letter and then writes it in the file "writeHere.txt"
    			 for(i=0; i< size; i++) {
    				 int character = (int)myEnigmaMachine1.encodeLetter(arrayOfLetters[i]);
    				 writer.write(character);
    			 }
    			 
    		 } finally {
    			 if (writer != null) {
    	             writer.close();
    	         }
    		 }
     }
     
	

 }
