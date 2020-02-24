package com.capg.corejava.wallet.service;

import com.capg.corejava.wallet.beans.Model;

public interface AccountService {

	int getLoginDetails(int userId);

	Model getLoginDetails(int userId, String password);

	int rechargeAccount(int userId1, double amount);

	double showBalance(int userId2);

	int transferAmount(int userId3, int userId4, double amount1);
}