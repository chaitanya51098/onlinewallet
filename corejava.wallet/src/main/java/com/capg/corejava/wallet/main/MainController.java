package com.capg.corejava.wallet.main;

import java.util.Scanner;
import com.capg.corejava.wallet.beans.Model;
import com.capg.corejava.wallet.dao.*;
import com.capg.corejava.wallet.exception.WalletNoException;
import com.capg.corejava.wallet.service.*;

public class MainController {
	Scanner s = new Scanner(System.in);

	public int loginDetails() {

		System.out.print("Enter UserId:");
		int userId = s.nextInt();
		AccountServiceImp1 asi = new AccountServiceImp1();
		int a = (asi.getLoginDetails(userId));
		return a;
	}

	public Model passwordDetails(int userId) {

		System.out.print("Enter password:");
		String password = s.next();
		AccountServiceImp1 asi = new AccountServiceImp1();
		Model a1 = asi.getLoginDetails(userId, password);
		return a1;
	}

	public static void main(String[] args) throws WalletNoException {
		Scanner s = new Scanner(System.in);
		AccountDaoImp1 adi = new AccountDaoImp1();
		AccountServiceImp1 asi = new AccountServiceImp1();
		while (true) {
			System.out.println("------------PAYMENT WALLET-----------\n");
			System.out.println(" 1.Register\n 2.Add amount\n 3.Show balance\n 4.Transfer\n 5.Exit \n");
			System.out.print("Enter Your Chioce : ");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter Id:");
				int userId = s.nextInt();
				boolean k = asi.isValidId(userId);
				if (k) {
					System.out.println("enter password:");
					String password = s.next();
					boolean k1 = asi.isValidPassword(password);
					if (k1) {
						System.out.println("enter name:");
						String name = s.next();
						int balance = 0;
						adi.ScannerMap(userId, password, name, balance);
					}
				}
				break;
			case 2:
				MainController ui = new MainController();
				int a = ui.loginDetails();
				try {
					if (a == 0) {
						throw new WalletNoException("Invalid Number");
					}

				} catch (WalletNoException e) {
					System.out.println("ERROR: user not found");
					break;
				}
				Model a1 = ui.passwordDetails(a);
				try {
					if (a1 == null)
						throw new WalletNoException("Invalid password");
					else {
						System.out.println("\nLogged in succesfully");
					}
				}

				catch (WalletNoException e) {
					System.out.println("ERROR: Password is incorrect");
					break;
				}

				System.out.println("Add amount:");
				double amount = s.nextDouble();
				int i = asi.rechargeAccount(a, amount);
				System.out.println("Amount of " + amount + " Deposited Successfully\n");
				break;
			case 3:
				MainController ui3 = new MainController();
				int a2 = ui3.loginDetails();
				try {
					if (a2 == 0) {
						throw new WalletNoException("Invalid Number");
					}

				}

				catch (WalletNoException e) {
					System.out.println("ERROR: user not found");
					break;
				}
				Model a3 = ui3.passwordDetails(a2);
				try {
					if (a3 == null)
						throw new WalletNoException("Invalid password");
					else {
						System.out.println("\nLogged in Succesfully\n");
					}
				}

				catch (WalletNoException e) {
					System.out.println("ERROR: password is incorrect");
					break;
				}

				double a4 = asi.showBalance(a2);
				System.out.println("Balance in Your Wallet : " + a4 + "\n");
				break;
			case 4:
				MainController ui2 = new MainController();
				int a5 = ui2.loginDetails();
				try {
					if (a5 == 0) {
						throw new WalletNoException("Invalid Number");
					}

				}

				catch (WalletNoException e) {
					System.out.println("ERROR: user not found");
					break;
				}
				Model a6 = ui2.passwordDetails(a5);
				try {
					if (a6 == null)
						throw new WalletNoException("Invalid password");
					else {
						System.out.println("\nLogged in succesfully");
					}
				}

				catch (WalletNoException e) {
					System.out.println("ERROR: password incorrect");
					break;
				}

				System.out.println("\nEnter your userid:");
				int userId3 = s.nextInt();
				System.out.println("\nEnter another userid");
				int userId4 = s.nextInt();
				System.out.println("amount to be transfered:");
				double amount1 = s.nextInt();
				int z = asi.transferAmount(userId3, userId4, amount1);
				if (z == 1)
					System.out.println("\nTransfered Successfully\n");
				break;
			case 5:
				System.exit(0);
			}
		}

	}
}