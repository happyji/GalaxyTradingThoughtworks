package factoryType.repository;
import factory.TransactionManager;
import java.util.ArrayList;

public class FactoryTypeRepository {

    public static ArrayList<TransactionManager> repository = new ArrayList<TransactionManager>();

    public static void add(TransactionManager tm){
        repository.add(tm);
    }

}
