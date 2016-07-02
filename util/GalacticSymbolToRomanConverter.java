package util;
import exception.BadStringException;
import factoryType.repository.SymbolRomanRepository;

public class GalacticSymbolToRomanConverter{
	
	public static String convert(String[] symbols) throws BadStringException {
		StringBuilder quantityInRoman = new StringBuilder();
	    for(String symbol : symbols){
	    	if(SymbolRomanRepository.isValidSymbol(symbol))
	    		quantityInRoman.append(SymbolRomanRepository.getRomanSymbolEquivalent(symbol));
	    	else
	    		throw new BadStringException();
	    }
		return quantityInRoman.toString();
	}
}
