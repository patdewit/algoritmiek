package nl.patdev.algoritmiek.first;

public enum Number {
	TWEE (0), DRIE (1), VIER (2), VIJF (3), ZES (4), ZEVEN (5), ACHT (6), NEGEN (7), TIEN (8), BOER (9), VROUW (10), KONING (11), AAS (12);
	
	private int numeric;
	
	
	Number(int numeric){
		this.numeric = numeric;
	}


	public int getNumeric() {
		return numeric;
	}


	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}
	
	public static Number getByNumeric(int num){
		for(Number number : Number.values()){
			if(num == number.getNumeric()){
				return number;
			}
		}
		
		return null;
	}
}
