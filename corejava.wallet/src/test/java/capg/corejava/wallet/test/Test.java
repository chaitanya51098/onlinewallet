package capg.corejava.wallet.test;

import java.util.HashMap;
import com.capg.corejava.wallet.dao.AccountDaoImp1;
import junit.framework.TestCase;
import com.capg.corejava.wallet.beans.Model;

public class Test extends TestCase {

	AccountDaoImp1 t=new AccountDaoImp1();
	HashMap<Integer, Model> hmap = new HashMap<Integer, Model>();
	
	
	public void test1() {
		assertEquals(10131,t.getLoginDetails(10131));
	}
	public void test2() {
		assertEquals(800,t.rechargeAccount(10131,600.0));
	}
	public void test3() {
		assertEquals(1,t.transferAmount(10131, 10132, 400));
	}

}
