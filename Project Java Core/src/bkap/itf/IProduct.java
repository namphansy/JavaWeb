package bkap.itf;

import java.util.Scanner;

public interface IProduct {
	
	final float MIN_INTEREST_RATE = 0.2f;
	public void inputData(Scanner sc);
	public void displayData();
	public void calProfit();
}
