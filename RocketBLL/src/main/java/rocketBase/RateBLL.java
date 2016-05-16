package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	private final static double  DINCOMEPCT1 = 0.28;
	private final static double DINCOMEPCT2 = 0.36;
	
	public static double getRate(int GivenCreditScore) throws RateException {
	

		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
		
		ArrayList<RateDomainModel> rates =RateDAL.getAllRates();
		double dInterestRate = 0;
		for(RateDomainModel r : rates)
		{
			if (GivenCreditScore > r.getiMinCreditScore())
			{
				dInterestRate = r.getdInterestRate();
			}
			
			else
			{
				break;
			}
			
		}
	
		if (dInterestRate ==0)
		{
			throw new RateException();
		}
		return dInterestRate;
		
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t)*(-1);
	}
	
	public static boolean checkIncomeExpenses(LoanRequest lq)
	{
		boolean bReturnValue = false;

		if ( ((lq.getIncome() / 12) * DINCOMEPCT1) > lq.getdAmount() )
		{		
			if ( (((lq.getIncome() / 12) + (lq.getExpenses())) * DINCOMEPCT2) > lq.getdAmount() )
			{
				bReturnValue = true;
			}	
		}
		
		return bReturnValue;
	}
	
}
