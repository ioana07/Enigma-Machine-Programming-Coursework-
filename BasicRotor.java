//the BasicRotor is a special rotor and therefore inherits methods and properties from the parent class Rotor
public class BasicRotor extends Rotor{
	
	//the constructor for BasicRotor takes the type and the initial position as parameters
	public BasicRotor (String type, int position) {
		
		this.setPosition(position);// calls setPosition method which sets the position of this BasicRotor to the one sent as argument
		this.initialise(type);// calls initialise method sending the type as parameter
		this.type = type;// saves the type sent as parameter into a variable called type
	}

	public void  setPosition(int position) {
		
		this.position = position;// sets the position of this BasicRotor to the one sent as parameter
	}
	
	public int getPosition() {
		return position;// returns the position of a BasicRotor
	}
	
	/*the initialise method will set the mapping for a BasicRotor object depending on its type
	 *for instance, if BasicRotor is of type I, then mapping will be { 4, 10, 12, 5, 11, 6, etc}
	 */
	public void initialise (String type) {
		
		if(type.equals("I"))// 
			this.mapping = new int[]  { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
		if(type.equals("II"))
			this.mapping = new int[] { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
		if(type.equals("III"))
			this.mapping = new int[] { 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
		if(type.equals("IV"))
			this.mapping = new int[]  {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
		if(type.equals("V"))
			this.mapping = new int[] { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };

		
		}
	// the substitute method takes an integer corresponding to a letter as a parameter, and then changes the index according to the mapping that was set
	public int substitute (int index) {
		index = index-this.getPosition();// substract the current position of the rotor from the index
		if(index<0)
			index=index+26;//if the result is negative, then add 26 so that we get a positive index which ranges from 0 to 25
		
		index=this.mapping[index]; //change index to the corresponding value in the mapping
		index= index+this.getPosition();// add the current position back to index
		if(index>25)
			index = index-26;// if index is now greater than 25, then substract 26 and get an index which ranges from 0 to 25
		return index; // returns the substituted index
	}
	//the substituteBack method creates an inverse mapping and reverses the action of the substitute method
	public int substituteBack (int index) {
		
		int [] inverseMapping = new int [26];
		for(int i=0; i<mapping.length; i++)
			inverseMapping[mapping[i]] = i;
		
		index = index-this.getPosition();
		if(index<0)
			index=index+26;
		index = inverseMapping[index];
		index = index+this.getPosition();
		if(index>25)
			index = index-26;
		
		return index;
		
	}
	
	// the rotate method is meant to rotate a rotor by one increment
	public void rotate () {

		
		if(this.getPosition() == 25)
			this.setPosition(0); //if the position of the rotor is now 25, then the next position possible will be 0
		else
			this.setPosition(this.getPosition()+1); //otherwise, the current position is increased by one increment
	}
	
}
