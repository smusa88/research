/**
 * Created by Sead Musa 20/11/2016
 */

import java.util.Vector;

public class StockPriceGenerator implements Runnable{

	private Vector<Stock> stocks=null; 

	StockPriceGenerator( Vector<Stock> a)
	{
		stocks=a;	
	}

	@Override
	public void run() {

		while (true)
		{

			try
			{
				//wait for 15 minute to calculate the stock price and the index all share
				Thread.sleep(900000);
				double indexAllShare=1;
				for(int j=0;j<stocks.size();j++)
				{
					Stock stock =stocks.elementAt(j);
					System.out.println("The dividend yield  for "+stock.getSymbol()+" is: "+stock.getDividendYield());
					double somma1=0;
					double somma2=0;
					for(int i=0;i<stock.getSetTick().size();i++)
					{
						Tick temp=stock.getSetTick().elementAt(i);
						int minutes=Utility.getLast15Minute(temp.getTimestamp());
						if(minutes<=15)
						{
						somma1+=temp.getPrice()*temp.getQshares();
						somma2+=temp.getQshares();
						}
					}
					double result=somma1/somma2;
					System.out.println("The sotck price for "+stock.getSymbol()+" is: "+result);
					indexAllShare*=result;
				}
				indexAllShare=Math.pow(Math.E, Math.log(indexAllShare)/stocks.size());
				System.out.println("the GBCE All Share Index IS: "+indexAllShare);
				synchronized (stocks) {
					stocks.wait();
				}

			}
			catch (InterruptedException exc)
			{
				exc.printStackTrace();
			}
		}
	}




}
