package factoryType;
import factory.TransactionManager;
import factoryType.repository.FactoryTypeRepository;
import util.Constants;

public class InvalidInput implements TransactionManager{

    private static InvalidInput INSTANCE = null;
	
	private InvalidInput()
	{}


    public static TransactionManager getInstance() {

        if(INSTANCE == null)
        {
            INSTANCE = new InvalidInput();
            return  INSTANCE;
        }
        return INSTANCE;
    }

	@Override
	public boolean isType(String input) {
		return true;
	}

	@Override
	public String executeTransaction(String input) {
		return Constants.INVALID_OUTPUT;
	}

}
