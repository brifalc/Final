package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void getInterestRateTest() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		for (RateDomainModel r : rates)
		{
			System.out.print ("Credit Score: " + r.getiMinCreditScore());
			System.out.print("");
			System.out.printf("Interest Rate: %f" , r.getdInterestRate());
			System.out.println("");
			
			if (r.getiMinCreditScore() == 600) {
				assertTrue(r.getdInterestRate() == 5.0);
			}
			if (r.getiMinCreditScore() == 650) {
				assertTrue(r.getdInterestRate() == 4.5);
			}
			if (r.getiMinCreditScore() == 700) {
				assertTrue(r.getdInterestRate() == 4.0);
			}
			if (r.getiMinCreditScore() == 750) {
				assertTrue(r.getdInterestRate() == 3.75);
			}
			if (r.getiMinCreditScore() == 800) {
				assertTrue(r.getdInterestRate() == 3.5);
			}
		}
		assert(rates.size() > 0);	
	}

}
