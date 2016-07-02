import application.GalaxyTrader;

/*
 * Driver program to launch Galaxy Trading
 */
public class Main {

	public static void main(String[] args){
		GalaxyTrader gt = new GalaxyTrader();
		gt.startTrading(System.getProperty("user.dir")+"/src/input.txt");
	}
}
