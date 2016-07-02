package factoryType.mapper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exception.BadStringException;
import factory.TransactionManager;
import factoryType.repository.SymbolRomanRepository;


public class SymbolRomanMapper implements TransactionManager{
	private static Pattern pattern;
	private static Matcher matcher;
	private static SymbolRomanMapper INSTANCE = null;

    private SymbolRomanMapper(){
		pattern = Pattern.compile("^([a-z]+) is ([I|V|X|L|C|D|M])$");
	}


   public static TransactionManager getInstance() {

        if(INSTANCE == null)
        {
            INSTANCE = new SymbolRomanMapper();
            return  INSTANCE;
        }
        return INSTANCE;
    }

	@Override
	public boolean isType(String input) {
		matcher = pattern.matcher(input);
		if(matcher.matches()){
			return true;
		}
		return false;
	}

	@Override
	public String executeTransaction(String input) {
		matcher = pattern.matcher(input);
		if(matcher.matches())
			addSymbolRoman();

        return null;
	}

    private void addSymbolRoman() {
		try {
            String symbol = matcher.group(1).trim();
            String roman = matcher.group(2).trim();
            SymbolRomanRepository.add(symbol, roman);
        }
        catch (BadStringException bs){
            return ;
        }

    }


}
