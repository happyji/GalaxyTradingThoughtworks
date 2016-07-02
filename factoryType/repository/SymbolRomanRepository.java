package factoryType.repository;
import exception.BadStringException;
import util.RomanSymbol;
import java.util.HashMap;

public class SymbolRomanRepository {

    private static HashMap<String, RomanSymbol> symbolMap = new HashMap<String, RomanSymbol>();


    public static void add(String symbol,String roman) throws BadStringException {
        if (RomanSymbol.isValidRomanSymbol(roman) && !symbolMap.containsKey(symbol))
        symbolMap.put(symbol, RomanSymbol.valueOf(roman));
        else
        throw new BadStringException("Not a valid Roman Symbol");

    }

    public static String getRomanSymbolEquivalent(String symbol){
        return symbolMap.get(symbol).toString();
    }

    public static boolean isValidSymbol(String symbol){
        return symbolMap.get(symbol) != null;
    }
}
