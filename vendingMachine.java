//A Java implementation of VendingMachine.
//Original in C++ by Liu Ling,
//Modified by Jianjin Deng
//Main added later for testing.
import java.util.*;


public class vendingMachine
{
	private int credit;
	private LinkedList<String> stock;
	
	//Maximum size of vendingMachine
	private static final int MAX = 10;


//************************************************
//Constructor
//vendingmachine starts empty.
//************************************************
vendingMachine()
{
	credit = 0;
	stock  = new LinkedList<String>(); // Empty stock.

}

//************************************************
//A coin is given to the vendingMachine.
//Must be a dime, quarter or dollar.
//Ignores invalid input
//************************************************
public int coin (int coin)
{	
	if (coin == 10 || coin == 25 || coin == 100)
	{
		if (credit < 90)
		{
			credit = credit + coin;
			return credit;
		}
		else 
		{
			System.out.println("No need more money!!!");
			return coin;
		} 
	}
	else
	{
		System.out.println("Coin is not accpted!!!");
		return coin;
	}
}

//************************************************
//User asks for a specific chocolate.
//Returns the change and the sets the
//parameter StringBuffer variable Choc.
//If not enough money or no chocolates,
//returns money and a blank string.
//************************************************
public int getChoc (StringBuffer choc)
{
	int change;	
	if (credit < 90)
	{
	   change = 0;
	   choc.replace (0, choc.length(), "");
	   System.out.println("No enough money!!!");
	   return credit;  
	   
	}	
	int idx = stock.indexOf(choc.toString());
	if (stock.size() <= 0 || idx == -1)
	{
	    change = 0;
		choc.replace (0, choc.length(), "");
		System.out.println("Sold out!");
		return credit;  
		   
	}	
	choc.replace (0, choc.length(), (String) stock.remove(idx));	
	change = credit - 90;
	credit = 0;	
	return (change);
}

//************************************************
//Adds one new piece of chocolate to the machine
//If machine is full, nothing happens
// The Vending Machine can only accept three types
// of chocolate.  
//************************************************
public void addChoc (String choc)
{
	if (stock.size() >= MAX)
	{
		System.out.println("The machine is full !!!");
		return;
	} 

if (choc == "c1" || choc == "c2" || choc == "c3")
{
	stock.add (choc);
	return;
}else
{
	System.out.println(choc + " is not accpted!!!");
	return;
}
}

//************************************************
//mainV1() for initial testing.
//************************************************
public static void main (String[] argv)
{
	StringBuffer choc = new StringBuffer ("xx");
	vendingMachine v = new vendingMachine ();
	v.addChoc ("c1");
	v.addChoc ("c2");
	v.addChoc ("c2");
	v.addChoc ("c4");
	v.addChoc ("c3");
	
	// First get
	v.coin (10);
	v.coin (25);
	v.coin (100);
	choc.replace (0, choc.length(), "c1");  // choose a specific chocolate
	int change = v.getChoc (choc);
	System.out.println ("First get, chocolate type: " + choc + ", change: " + change + "\n");
	
	// Second get
	v.coin (100);
	choc.replace (0, choc.length(), "c1"); // choose a specific chocolate
	change = v.getChoc (choc);
	System.out.println ("Second get, chocolate type: " + choc + ", change: " + change + "\n");
	
	// Third get
	v.coin (25);
	v.coin (25);
	choc.replace (0, choc.length(), "c2");  // choose a specific chocolate
	change = v.getChoc (choc);
	System.out.println ("Third get, chocolate type: " + choc + ", change: " + change + "\n");
}

} // End class vendingMachine
