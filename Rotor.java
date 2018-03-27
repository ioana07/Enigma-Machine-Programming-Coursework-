// parent class from which BasicRotor and Reflector inherits attributes and methods
public abstract class Rotor {
	
	protected String name;
	protected int position;
	protected String type;
	protected int[] mapping= new int[26];
	protected int ROTORSIZE = 26;
	
	public abstract void  setPosition(int position);
	
	public abstract int getPosition();
	
	public abstract void initialise (String type);
	
	public  abstract int substitute (int index);


	
	

}
