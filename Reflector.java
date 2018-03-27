
public class Reflector extends Rotor {
	
	
	public void  setPosition(int position) {
		
		this.position = position; // sets the position of the reflector to the one sent as parameter
	}
	
	public int getPosition() {
		return position;// returns the position of the reflector
	}
	
	// next method initialises the mapping of the reflector depending on its type
	public void initialise (String type) {
		
		if(type.equals("ReflectorI"))
			this.mapping = new int[] { 24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19 };
		if(type.equals("ReflectorII"))
			this.mapping = new int[] { 5, 21, 15, 9, 8, 0, 14, 24, 4, 3, 17, 25, 23, 22, 6, 2, 19, 10, 20, 16, 18, 1, 13, 12, 7, 11 };
			
	}
	
	// next method takes a given index as parameter and returns the one corresponding to it in the mapping
	public int substitute (int index) {
		
		return this.mapping[index];
	}
}
	

