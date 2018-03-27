import java.util.ArrayList;
import java.util.Iterator;

public class Plugboard {
	
	private int numberOfPlugs = 0;
	private ArrayList<Plug> arrayOfPlugs =  new ArrayList<Plug>();
	
	
	/* the addPlug method takes two chars representing the 2 ends of a plug as parameters 
	 *  if the number of plugs is less than 13 and this plug doesn't clash with any of the existing ones
	 *  	then this plug is added and the number of plugs is incremented by 1
	 *  otherwise
	 *  	the method will return false
	 */
	public Boolean addPlug(char end1, char end2) {// the addPlug method takes two chars as parameters 
		if(numberOfPlugs < 13) {
		Plug newPlug = new Plug(end1, end2);
		Iterator<Plug>it = arrayOfPlugs.iterator();
		while(it.hasNext()) {
			
			if(newPlug.clashesWith((Plug)it.next()))
				return false;
			}
		arrayOfPlugs.add(newPlug);
		numberOfPlugs++;
		return true;
		   }
		return false;
	}
		
	public int getNumPlugs() {
		
		return numberOfPlugs; //returns the number of Plugs
	}
	
	public void setNumberOfPlugs () {
		
		numberOfPlugs = 0; //sets number of plugs to 0
	}
	
	public void clear() {
		
		arrayOfPlugs.clear(); // clears the array of plugs
	}
	
	public char substitute (char letter) {
		/*
		 * for each plug in the array of plugs, if the letter sent as parameters equals one of the ends, then the encoded letter is returned
		 * otherwise, the same letter is returned
		 */
		for(Plug plugIn : arrayOfPlugs) {
			if(plugIn.getEnd1() == letter || plugIn.getEnd2() == letter)
				return plugIn.encode(letter);
		
		}
		
		return letter;
	}
	
	
	
	

}
