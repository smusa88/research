/**
 * Created by Sead Musa 20/11/2016
 */

import java.util.Vector;

public class Controller {

	public static void main(String[] args) {
		Stock TEA=new Stock("TEA","Common",0,0,100);
		Stock POP=new Stock("POP","Common",8,0,100);
		Stock ALE=new Stock("ALE","Common",23,0,60);
		Stock GIN=new Stock("GIN","Preferred",8,0.02,100);
		Stock JOE=new Stock("JOE","Common",13,0,250);
		Vector<Stock> stocks=new Vector<Stock>();
		stocks.add(TEA);
		stocks.add(POP);
		stocks.add(ALE);
		stocks.add(GIN);
		stocks.add(JOE);
		TickGenerator r = new TickGenerator(stocks);
		StockPriceGenerator r1=new StockPriceGenerator(stocks);
		Thread t = new Thread(r);
		t.start();
		Thread t1 = new Thread(r1);
		t1.start();
	}

}
