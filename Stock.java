/**
 * Created by Sead Musa 20/11/2016
 */

import java.util.Vector;

public class Stock {
	private String symbol=null;
	private String type="Common";
	private int lDividend=0;
	private double fDividend=0;
	private int pValue=0;
	private Vector<Tick> setTick=new Vector<Tick>();
	
	Stock(String a,String b,int c,double d, int e)
	{
		symbol=a;
		type=b;
		lDividend=c;
		fDividend=d;
		pValue=e;
		
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		System.out.print("ciao mondo");
	}
	
	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getlDividend() {
		return lDividend;
	}


	public void setlDividend(int lDividend) {
		this.lDividend = lDividend;
	}


	public double getfDividend() {
		return fDividend;
	}


	public void setfDividend(double fDividend) {
		this.fDividend = fDividend;
	}


	public int getpValue() {
		return pValue;
	}


	public void setpValue(int pValue) {
		this.pValue = pValue;
	}


	public Vector<Tick> getSetTick() {
		return setTick;
	}


	public void setSetTick(Vector<Tick> setTick) {
		this.setTick = setTick;
	}
	
	public void addTick(Tick a)
	{
		setTick.add(a);	
	}

	
	public double getDividendYield()
	{
		double dividendYield=0;
		if (type.equals("Common"))	
			dividendYield= lDividend/setTick.lastElement().getPrice();
		else
		{
			dividendYield=fDividend*pValue/setTick.lastElement().getPrice();
			
		}
		return dividendYield;
	}
	

}
