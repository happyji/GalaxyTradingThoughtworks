package util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.BadStringException;


public class RomanToArabicConverter {

    private static boolean isValidRomanNumber(String romanNumber) {
		final String regex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(romanNumber);
		return matcher.matches();
	}

    public static int toArabic(String romanNumber) throws BadStringException  {
        if (romanNumber.isEmpty() || !isValidRomanNumber(romanNumber)){
            throw new BadStringException("not a roman number");
        }
        return convert(romanNumber);
    }

	private static int convert(String romanNumber) {
		int length = romanNumber.length();
		switch (length) {
		case 0:
			return 0;
		case 1:
			return valueOfOneChar(romanNumber);
		case 2:
			return valueOfFirstTwoChar(romanNumber);
		default:
			int value = valueOfFirstTwoChar(romanNumber);
			return RomanSymbol.isfirstTwoCharValidRomanSymbol(romanNumber) ? value+ convert(romanNumber.substring(2)) : value;
		}
    }

	private static int valueOfOneChar(String romanNumber) {
		return RomanSymbol.valueOf(romanNumber.substring(0, 1)).getValue();
	}

	private static int valueOfTwoChar(String romanNumber) {
		return RomanSymbol.valueOf(romanNumber.substring(0, 2)).getValue();
	}

	private static int valueOfFirstTwoChar(String romanNumber) {
		return RomanSymbol.isfirstTwoCharValidRomanSymbol(romanNumber) ? valueOfTwoChar(romanNumber)
				: valueOfOneChar(romanNumber) + convert(romanNumber.substring(1));
	}
}
