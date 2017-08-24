/*
 * Implement a class that checks whether a given number is a prime using  the Runnable Interface 
 */
package threadUsage;

import java.util.Scanner;

public class PrimeCheckRunnable implements Runnable  {

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * Method which gets picked up by thread scheduler, once after the start() method is invoked
	 * This method will accept number from user and check if it is a prime number or not
	 */
	public void run() {
		Scanner scanner = new Scanner(System.in);// Constructs a new Scanner that produces values scanned from the input  stream.
		System.out.print("Enter the number:");
		int number = scanner.nextInt();// Scans the next token of the input as an int
		boolean flag = true; // boolean flag to check is prime no or not
		for (int i = 2; i < number; i++) { // prime number is divisible by 1 or its own number , so avoiding those numbers 
			if (number % 2 == 0) {// if number is divisible by any other number ,set flag to false 
				flag = false;
			}
		}

		if (flag == true) {// flag will be true if the number is not divisible by any number apart from  1 or its own number
			System.out.println(number + " is a prime number");
		}else{// flag will be false if the number is  divisile by any number apart from  1 or its own number
			System.out.println(number + " is not a prime number");
		}

	}

	public static void main(String[] args) {

		PrimeCheckRunnable primeCheck = new PrimeCheckRunnable();//creating object of PrimeCheckThread
		Thread thread = new Thread(primeCheck);//passing object of PrimeCheckRunnable so that the run method of PrimeCheckRunnable gets executed
		thread.start();//starting thread

	}

}
