
public class Plug {

	private char end1;// declares the first letter of one plug
	private char end2;// declares the second letter of one plug
	
	//the constructor Plug takes 2 letters as arguments and stores their values in the member variables end1 and end2
	public Plug(char end1, char end2) {
		this.end1 = end1;
		this.end2 = end2;
	}
	
	public char getEnd1() {
		
		return end1;// returns the letter corresponding to the first socket
	}
	
	public char getEnd2() {
		
		return end2;// returns the letter corresponding to the second socket
	}
	
	public void setEnd1(char end1) {
		
		this.end1 =  end1;// sets the value of the member variable end1 to the one passed as argument
	}
	
	public void setEnd2(char end2) {
		
		this.end2 =  end2; //sets the value of the member variable end2 to the one passed as argument
	}
	
	/*the encode method takes a typed in letter and compares it to the two ends;
	 * if the letter differs from both ends, then the method will return the letter itself
	 * if the letter matches one of the ends, the other end will be returned
	 */
	public char encode(char letterIn) {
		
		if (letterIn != end1 && letterIn != end2 )
			return letterIn;
		else
			if(letterIn == end1)
				return end2;
			else
				return end1;
	}
	//the clashesWith method checks whether any of the ends of the plug sent as parameter already exists
	public Boolean clashesWith(Plug plugin) {
		
		if(this.end1 == plugin.end1 || this.end2 == plugin.end2 || this.end1 == plugin.end2 || this.end2 == plugin.end1)
			return true;
		else
			return false;
	}
	
}
