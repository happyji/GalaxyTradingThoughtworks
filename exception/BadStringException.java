package exception;
import  util.Constants;

public class BadStringException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errDescription;
	
	public BadStringException(){
		errDescription = Constants.INVALID_OUTPUT;
	}

	public BadStringException(String errDesc){
	   errDescription = errDesc;
	 }

	 @Override
	 public String getMessage(){
	   return  errDescription; 
	 }

	 @Override
	 public String toString(){
	   return "Error : MyException ( " + errDescription + " )";
	 }
}
