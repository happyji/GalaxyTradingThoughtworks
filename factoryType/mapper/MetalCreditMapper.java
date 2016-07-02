package factoryType.mapper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exception.BadStringException;
import factory.TransactionManager;
import util.*;
import factoryType.repository.MetalCreditRepository;


public class MetalCreditMapper implements TransactionManager {
    private static Pattern pattern;
	private static Matcher matcher;
	private static MetalCreditMapper INSTANCE = null;

	private MetalCreditMapper(){
		pattern = Pattern.compile("((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$");
	}

    public static TransactionManager getInstance() {

        if(INSTANCE == null)
        {
            INSTANCE = new MetalCreditMapper();
            return  INSTANCE;
        }
        return INSTANCE;
    }

	@Override
	public boolean isType(String input){
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
        addMetalCredit();
        return null;
	}

    private void addMetalCredit(){
        try {
            String metal = matcher.group(2);
            double credit = computeCredit();
            MetalCreditRepository.add(metal, credit);
        }
        catch (BadStringException bs){
            return;
        }

    }

    private double computeCredit() {
        int totalCredits = evaluateTotalCredits();
        int quantity = evaluteQuantity();
        return (double) (totalCredits/quantity);
    }

    private int evaluateTotalCredits() {
        try {
            return Integer.parseInt(matcher.group(3).trim());
        }
        catch (NumberFormatException nf){
            return -1;
        }

    }

    private int evaluteQuantity(){
        try {
            String[] transactionQuantity = matcher.group(1).split(" ");
            String romanQuantity = GalacticSymbolToRomanConverter.convert(transactionQuantity);
            return RomanToArabicConverter.toArabic(romanQuantity);
        }
        catch (BadStringException e){
            return -1;
        }

    }

}
