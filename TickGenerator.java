/**
 * Created by Sead Musa 20/11/2016
 */

import java.util.Date;
import java.util.Vector;

public class TickGenerator implements Runnable
{
	private Vector<Stock> stocks=null; 

	TickGenerator( Vector<Stock> a)
	{
		stocks=a;
	}
	public void run()
	{
		while (true)
		{
			try
			{
				System.out.println("Wait 1 second...");
				for(int i=0;i<stocks.size();i++)
				{ 
					Stock stock=stocks.elementAt(i);
					int qtRandom = (int)(Math.random()*90);
					int signRandom=(int)(Math.random()*1000);
					double priceRandom=(double)(Math.random()*300);
					String tsign=null;
					if(signRandom<=500)
						tsign="+";
					else
						tsign="-";
					Tick temp=new Tick(new Date(), qtRandom, tsign, priceRandom);
					stock.addTick(temp);
					System.out.println(stock.getSymbol()+": "+temp.toString());
				}
				//I suppose that for every second there is a  tick transaction 
				Thread.sleep(1000);
				synchronized (stocks) 
				{
					stocks.notifyAll();
				}
			}
			catch (InterruptedException exc)
			{
				exc.printStackTrace();
			}
		}
	}


}
