package factory;

public interface TransactionManager {
	public boolean isType(String input);
	public String executeTransaction(String input);
}
