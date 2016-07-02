package factory;
import factoryType.ManagerBuilderImpl;

public abstract class ManagerBuilder {

    public static ManagerBuilder getInstance(){
         return new ManagerBuilderImpl();
    }

    public abstract void build();
}


