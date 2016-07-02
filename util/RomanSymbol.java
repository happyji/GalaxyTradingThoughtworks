package util;

public enum RomanSymbol {
	
	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(
			500), CM(900), M(1000);

	private int value;

	RomanSymbol(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}

	public static boolean isValidRomanSymbol(String symbol){
		try{
			RomanSymbol.valueOf(symbol);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static boolean isfirstTwoCharValidRomanSymbol(String romanNumber) {
		if(romanNumber.length()<2)
		return false;
		return isValidRomanSymbol(romanNumber.substring(0, 2));
		
	}

}
