package nl.patdev.algoritmiek.first;
public enum Suit {
	KLAVEREN (0), SCHOPPEN (1), HARTEN (2), RUITEN (3);
	
	private int numeric;
	
	
	Suit(int numeric){
		this.numeric = numeric;
	}


	public int getNumeric() {
		return numeric;
	}


	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}
	
	public static Suit getByNumeric(int num){
		for(Suit number : Suit.values()){
			if(num == number.getNumeric()){
				return number;
			}
		}
		
		return null;
	}
}

