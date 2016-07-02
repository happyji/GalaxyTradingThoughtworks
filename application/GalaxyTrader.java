package application;
import java.io.IOException;

import factory.TransactionManager;
import util.InputFileReader;
import factory.TransactionFactory;


public class GalaxyTrader {

	private String transaction;
	private TransactionFactory transactionFactory;
	private TransactionManager transactionManager;
	
	public GalaxyTrader()
	{
		transactionFactory = new TransactionFactory();
		
	}

	private void showResult(String result)
	{
		if(result != null)
			System.out.println(result);
	}
	
	public void startTrading(String inputFileDir)
	{
		
		 try 
		 {
			InputFileReader.init(inputFileDir);
			transaction = InputFileReader.nextLine();

			while(transaction != null)
			{
				transactionManager = transactionFactory.getInstanceOfType(transaction);
				String result = transactionManager.executeTransaction(transaction);
				showResult(result);
				transaction = InputFileReader.nextLine();
			}
			
		 }
         catch (IOException  e)
		 {
			e.printStackTrace();
		 } 
		
	}

}
