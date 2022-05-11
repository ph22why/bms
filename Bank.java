package bms;

public class Bank {
	String account;
	String pw;
	String name;
	int balance;
	
	public Bank(String account, String pw, String name) {
		this.account = account;
		this.pw = pw;
		this.name = name;
		this.balance = 0;
	}
	void deposit(int money) {
		this.balance += money;
	}
	void withdraw(int money) {
		if(balance>=money) {
			this.balance -= money;
		}
	}
	void show() {
		//김사과님 계좌(10111)
		//잔액 : 1원
		System.out.println(name+"님 계좌("+account+")\n잔액 : "+balance+"원");
	}
}