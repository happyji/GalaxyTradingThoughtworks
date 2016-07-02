package factoryType.query;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exception.BadStringException;
import factory.TransactionManager;
import factoryType.repository.FactoryTypeRepository;
import factoryType.repository.MetalCreditRepository;
import util.*;


public class CreditQuery implements TransactionManager{
	private static Pattern pattern;
	private static Matcher matcher;
	private static CreditQuery INSTANCE = null;

	private CreditQuery(){
		pattern = Pattern.compile("^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$");
	}


    public static TransactionManager getInstance() {
        if(INSTANCE == null){
            INSTANCE = new CreditQuery();
            return  INSTANCE;
        }
        return INSTANCE;
    }

	@Override
	public boolean isType(String input) {
		matcher = pattern.matcher(input);
		if(matcher.matches())
		    return true;

		return false;
	}

	@Override
	public String executeTransaction(String input) {
		matcher = pattern.matcher(input);
		if(matcher.matches())
            return computeCreditQuery();

		return Constants.INVALID_OUTPUT;
	}

    private String computeCreditQuery(){
        int quantity = evaluateQuantity();
        double metalValue = getMetalCredit();
        if(quantity > 0 && metalValue > 0)
        return matcher.group(2)+ matcher.group(3)+ Constants.IS+ (quantity  * metalValue)+ Constants.CREDITS;
        else
        return Constants.INVALID_OUTPUT;

    }

    private double getMetalCredit() {
        try {
            return MetalCreditRepository.getMetalValue(matcher.group(3).trim());
        }
        catch (NullPointerException np){
            return -1;
        }

    }

    private int evaluateQuantity(){
        try{
            String[] transactionQuantity =  matcher.group(2).split(" ");
            String romanQuantity = GalacticSymbolToRomanConverter.convert(transactionQuantity);
            return RomanToArabicConverter.toArabic(romanQuantity);
        }
        catch (BadStringException e){
            return -1;
        }

    }
}
