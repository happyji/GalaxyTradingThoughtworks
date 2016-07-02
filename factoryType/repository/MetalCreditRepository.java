package factoryType.repository;

import exception.BadStringException;

import java.util.HashMap;

public class MetalCreditRepository {

    private static HashMap<String, Double> MetalCreditMap = new HashMap<String, Double>();

    public static void add(String metal,double credit) throws BadStringException {
        if (!MetalCreditMap.containsKey(metal)){
            MetalCreditMap.put(metal, credit);
        }
    }

    public static Double getMetalValue(String metal){
        return MetalCreditMap.get(metal);
    }
}


