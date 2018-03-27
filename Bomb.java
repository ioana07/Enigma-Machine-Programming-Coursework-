// the Bomb class is designed to decode messages when not all the settings of the EnigmaMachine are known
public class Bomb {
	
	private EnigmaMachine bombEnigmaMachine = new EnigmaMachine(); // creates a new EnigmamMachine
	// the method challenge 1 decodes a message when the details of the plugs are not entirely known
	public void challenge1 () {
		
		String encodedMessage = "JBZAQVEBRPEVPUOBXFLCPJQSYFJI";// the message we need to decode
		char [] result = new char[encodedMessage.length()];// this array will store all encoded letters for a possible combination of rotors at a time
		String[] solution = new String [676];// the solution array will store all possible solutions that we have found - we can have a maximum of 26*26 strings
		int contor = 0; // the contor will count the possible decoded messages that we have found
		
		// the next two for loops will generate all the possibilities for the two plugs
		for (char i='A'; i<='Z'; i++) {
			for (char j='A'; j<='Z'; j++) {
				
				bombEnigmaMachine.addPlug('D', i);
				bombEnigmaMachine.addPlug('S', j);
				
				//next we create our three rotors as specified:
				BasicRotor bombRotor1 = new BasicRotor("IV", 8);
		    	BasicRotor bombRotor2 = new BasicRotor("III", 4);
		    	BasicRotor bombRotor3 = new BasicRotor("II", 21);
		    	
		    	// next we add the rotors to our bombEnigmaMachine:
		    	bombEnigmaMachine.addRotor(bombRotor1, 0);
		    	bombEnigmaMachine.addRotor(bombRotor2, 1);
		    	bombEnigmaMachine.addRotor(bombRotor3, 2);
		    	
				// next we create a reflector of type I and add it to our bombEnigmamMachine
		    	Reflector myReflector = new Reflector ();
		    	myReflector.initialise("ReflectorI");
		    	bombEnigmaMachine.addReflector(myReflector);
		    	
		    	// the for loop below will take every character from our encodedMessage and then will send the letter to the encodeLetter method which will display the encoded letter
		    	for(int index=0; index< encodedMessage.length(); index++) {
			    	   
			    	   char character = encodedMessage.charAt(index);
			    	   result[index] = bombEnigmaMachine.encodeLetter(character);
		    	}
		    	
		    	String someSolution = new String (result); // someSolution will store every generated solution by a combination of rotors at a time
		    	if(someSolution.contains("ANSWER")) // if the generated solution contains the word we are trying to find, then we save that solution in the solution array
		    		{solution[contor] = someSolution + " Your plugs are: " + i + ", "+ j;
		    		contor++;
		    		}
		    	 
		    	 System.out.println();
		    	 
		    	 bombEnigmaMachine.clearPlugboard();// clears all plugs from the plugboard
		    	 bombEnigmaMachine.setNumberOfPlugs();// sets the number of plugs to 0
			}
		}
		
solution[contor] = "";
		
		// next we print out all the solution that we found:
		for(int index =0; index < contor; index++)
			System.out.println(solution[index]);
			
	}
	
	public void challenge2() {
		
		String encodedMessage = "AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD"; //the message we need to decode
		char [] result = new char[encodedMessage.length()];// this array will store all encoded letters for a possible combination of rotors at a time
		int contor = 0; // the contor will count the possible decoded messages that we have found
		String[] solution = new String [17577];// the solution array will store all possible solutions that we have found - we can have a maximum of 26*26*26 strings
		
		// next we add the plugs to our bombEnigmaMachine as specified:
		bombEnigmaMachine.addPlug('H', 'L');
		bombEnigmaMachine.addPlug('G', 'P');
		
		// next we create a reflector of type I and we add it to our bombEnigmaMachine
		Reflector myReflector = new Reflector ();
    	myReflector.initialise("ReflectorI");
    	bombEnigmaMachine.addReflector(myReflector);
    	
		//the next three loops will generate all possibilities for our three position
		for(int i=0; i<26; i++)
			for(int j=0; j< 26; j++)
				for(int q=0; q< 26; q++) {
					
					// creates the three rotors:
					BasicRotor bombRotor4 = new BasicRotor("V", i);
					BasicRotor bombRotor5 = new BasicRotor("III", j);
					BasicRotor bombRotor6 = new BasicRotor("II", q);
					
					// adds the three rotors to the bombEnigmaMachine:
			    	bombEnigmaMachine.addRotor(bombRotor4, 0);
			    	bombEnigmaMachine.addRotor(bombRotor5, 1);
			    	bombEnigmaMachine.addRotor(bombRotor6, 2);
			    	
			    	
			    	//reads the encodedMessage character by character and encodes each one of them:
			    	for(int index=0; index< encodedMessage.length(); index++) {
			    	   
			    	   char character = encodedMessage.charAt(index);
			    	   result[index] = bombEnigmaMachine.encodeLetter(character);
			    	   
			    	}
			    	
			    	String someSolution = new String (result); // someSolution will store every generated solution by a combination of rotors at a time
			    	if(someSolution.contains("ELECTRIC")) // if the generated solution contains the word we are trying to find, then we save that solution in the solution array
			    		{solution[contor] = someSolution + " Your rotors are in positions: " + i + ", "+ j + " and  "+ q;
			    		contor++;
			    		}
			       
			       System.out.println();
				
			      
			  }
		
		solution[contor] = "";
		
		// next we print out all the solution that we found:
		for(int index =0; index < contor; index++)
			System.out.println(solution[index]);
		
		bombEnigmaMachine.clearPlugboard(); // clears all plugs from the plugboard
   	    bombEnigmaMachine.setNumberOfPlugs(); // sets number of plugs to 0
	}
	
	public void challenge3() {
		//declares three rotors:
		BasicRotor br1;
		BasicRotor br2;
		BasicRotor br3;
		
		String[] rotorTypes= {null, "I", "II", "III", "IV", "V"}; // creates an array of type String with all rotor possible types 
		String encodedMessage="WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW"; // the message we need to decode
		char[] theMessage=encodedMessage.toCharArray();// transforms our String encodedMessage into an array of type char
		char [] result = new char[encodedMessage.length()];// this array will store all encoded letters for a possible combination of rotors at a time
		int contor = 0; // the contor will count the possible decoded messages that we have found
		String[] solution = new String [17577];// the solution array will store all possible solutions that we have found - we can have a maximum of 26*26*26 strings
		
		//adds the two plugs to our bombEnigma 
		bombEnigmaMachine.addPlug('M', 'F');
		bombEnigmaMachine.addPlug('O', 'I');
		
		// creates a new reflector of type I and adds it to the bombEnigmaMachine;
		Reflector reflector=new Reflector();
		reflector.initialise("ReflectorI");
		bombEnigmaMachine.addReflector(reflector);
		
		// generates all possible combinations of rotor types:
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				for(int k=1; k<=5; k++) {
					// creates three new rotors with the types corresponding to the indexes i, j, and k:
					br1=new BasicRotor(rotorTypes[i], 22);
					br2=new BasicRotor(rotorTypes[j], 24);
					br3=new BasicRotor(rotorTypes[k], 23);
					
					// adds the three rotors to the bombEnigmaMachine in slots 0, 1 and 2:
					bombEnigmaMachine.addRotor(br1, 0);
					bombEnigmaMachine.addRotor(br2, 1);
					bombEnigmaMachine.addRotor(br3, 2);
					
					//decodes the encoded letter char by char and stores the results in the char array named result
					for(int l=0; l<theMessage.length; l++) {
						result [l] =bombEnigmaMachine.encodeLetter(theMessage[l]);
					}
					System.out.println();
					
					String someSolution = new String (result); // someSolution will store every generated solution by a combination of rotors at a time
			    	if(someSolution.contains("JAVA")) // if the generated solution contains the word we are trying to find, then we save that solution in the solution array
			    		{solution[contor] = someSolution + " Your rotors are of types: " + i + ", "+ j + " and  "+ k;
			    		contor++;
			    		}
				}
			}
		}
		
		// next we print out all the solution that we found:
	    for(int index =0; index < contor; index++)
			System.out.println(solution[index]);
		
	}

}
