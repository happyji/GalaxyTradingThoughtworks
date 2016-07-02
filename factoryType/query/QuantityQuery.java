package factoryType.query;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import factoryType.repository.FactoryTypeRepository;
import util.*;
import exception.BadStringException;
import factory.TransactionManager;


public class QuantityQuery implements TransactionManager{
	private static Pattern pattern;
	private static Matcher matcher;
	private static QuantityQuery INSTANCE = null;
	
	private QuantityQuery(){
		pattern = Pattern.compile("^how much is ((?:\\w+[^0-9] )+)\\?$");
	}


    public static TransactionManager getInstance() {

        if(INSTANCE == null)
        {
            INSTANCE = new QuantityQuery();
            return  INSTANCE;
        }
        return INSTANCE;
    }

	@Override
	public boolean isType(String input) {
		matcher = pattern.matcher(input);
		if(matcher.matches())
		return true;
        else
		return false;
	}

	@Override
	public String executeTransaction(String input) {
		matcher = pattern.matcher(input);
		if(matcher.matches())
        return computeQuantityQuery();

        return Constants.INVALID_OUTPUT;
	}

    private String computeQuantityQuery(){
        int quantity = evaluateQuantity();
        if(quantity > 0)
        return matcher.group(1)+ Constants.IS+quantity;
        else
        return Constants.INVALID_OUTPUT;
    }

    private int evaluateQuantity(){
        try{
            String[] transactionQuantity = matcher.group(1).split(" ");
            String romanQuantity = GalacticSymbolToRomanConverter.convert(transactionQuantity);
            return RomanToArabicConverter.toArabic(romanQuantity);
        }
        catch (BadStringException e){
            return -1;
        }

    }

}
