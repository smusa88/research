/**
 * Created by Sead Musa 20/11/2016
 */

import java.util.Date;

public class Tick {
	private  Date timestamp= new Date();
	private int qshares=0;
	private String sign="+";
	private double price=0;
	
	public Tick(Date a,int b,String c,double d) {
		
		timestamp=a;
		qshares=b;
		sign=c;
		price=d;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getQshares() {
		return qshares;
	}
	public void setQshares(int qshares) {
		this.qshares = qshares;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString()
	{
		
		return "Tick Transiction at time: "+timestamp+" of qt: "+qshares+" with sign "+sign+" and price: "+price;
		
		
	}
}