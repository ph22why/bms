package bms;

//500원 출금시 1000원 출금
public class Shinhan extends Bank{

	public Shinhan(String account, String pw, String name) {
		super(account, pw, name);
	}
	
	@Override
	void withdraw(int money) {
		money *= 2;
		super.withdraw(money);
	}
}