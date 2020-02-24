package com.capg.corejava.wallet.dao;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.capg.corejava.wallet.beans.Model;

public class AccountDaoImp1 implements AccountDao {
	HashMap transactions = new HashMap<>();

	public void ScannerMap(int userId, String password, String name, int balance) {
		HashMap<Integer, Model> hmap = new HashMap<Integer, Model>();
		hmap.put(userId, new Model(password, name, balance));
		System.out.println("Account created successfully\n");
	}

	public Model hashMap(int userId) {

		HashMap accountEntry = new HashMap<>();
		accountEntry.put(10131, new Model("Prepaid", "Vaishali", 200));
		accountEntry.put(10132, new Model("postpaid", "rachana", 200));
		int keyToBeChecked;

		keyToBeChecked = userId;

		Iterator<Map.Entry<Integer, Model>> iterator = accountEntry.entrySet().iterator();

		boolean isKeyPresent = false;

		while (iterator.hasNext()) {

			Map.Entry<Integer, Model> entry = iterator.next();

			if (keyToBeChecked == entry.getKey()) {

				isKeyPresent = true;
			}
		}
		if (true) {
			Model a = (Model) accountEntry.get(userId);
			return a;
		} else
			return null;

	}

	public int getLoginDetails(int userId) {

		AccountDaoImp1 adi = new AccountDaoImp1();
		Model a = adi.hashMap(userId);

		if (a == null)
			return 0;
		else
			return userId;
	}

	public Model getLoginDetails(int userId, String password) {
		AccountDaoImp1 adi = new AccountDaoImp1();
		Model a = adi.hashMap(userId);
		if (a.getPassword().equals(password))
			return a;
		else
			return null;

	}

	public int rechargeAccount(int userId, double amount) {
		AccountDaoImp1 adi = new AccountDaoImp1();
		Model a = adi.hashMap(userId);
		double nb = a.getAccountBalance() + amount;
		a.setAccountBalance(nb);
		transactions.replace(userId, nb);
		return (int) nb;
	}

	public double showBalance(int userId2) {
		AccountDaoImp1 adi = new AccountDaoImp1();
		Model a = adi.hashMap(userId2);
		double nb = a.getAccountBalance();
		return nb;
	}

	public int transferAmount(int userId3, int userId4, double amount1) {

		AccountDaoImp1 adi = new AccountDaoImp1();
		Model a = adi.hashMap(userId3);
		Model b = adi.hashMap(userId4);

		double nc = b.getAccountBalance() + amount1;
		double nb = a.getAccountBalance() - amount1;

		a.setAccountBalance(nb);
		b.setAccountBalance(nc);

		transactions.replace(userId3, a);
		transactions.replace(userId4, b);
		System.out.println("New balance after transfering =" + nc);
		return 1;
	}
}