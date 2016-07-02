package factory;
import factoryType.repository.FactoryTypeRepository;
import java.util.ArrayList;

public class TransactionFactory {
    ArrayList<TransactionManager> transactionManagerList;
    ManagerBuilder builder;

    public TransactionFactory(){
        buildFactory();
    }

    public void buildFactory(){
        builder = ManagerBuilder.getInstance();
        builder.build();
    }

    public TransactionManager getInstanceOfType(String transaction) {
        transactionManagerList = FactoryTypeRepository.repository;
        for (int i=0;i< transactionManagerList.size();i++){
            if(transactionManagerList.get(i).isType(transaction))
                return transactionManagerList.get(i);
        }
        return transactionManagerList.get(0);
	}
}
