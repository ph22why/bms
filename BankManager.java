package bms;

import java.util.Random;

public class BankManager {
	static Bank[][] arUser = new Bank[3][1000];
	static int[] arCnt = {0,0,0};
	
	String join(int bankChoice, String name, String pw) {
		Random r = new Random();
		
		//10000 ~ 99999
		//0 ~ 89999   + 10000
		String account = r.nextInt(90000)+10000+"";
		
		for (int i = 0; i < arCnt.length; i++) {	//	0	1	2
			for (int j = 0; j < arCnt[i]; j++) {	//0~10	0~3	0~5
				if(arUser[i][j].account.equals(account)) {
					account = r.nextInt(90000)+10000+"";
					i = -1;
					break;
				}
			}
		}
		
		switch(bankChoice) {
		case 1:
			//국민은행
			arUser[0][arCnt[0]] = new Kookmin(account, pw, name);
			arCnt[0]++;
			break;
		case 2:
			//신한은행
			arUser[1][arCnt[1]] = new Shinhan(account, pw, name);
			arCnt[1]++;
			break;
		case 3:
			//우리은행
			arUser[2][arCnt[2]] = new Woori(account, pw, name);
			arCnt[2]++;
			break;
		}
		
		return account;
	}
	
	Bank login(String account, String pw) {
		for (int i = 0; i < arCnt.length; i++) {
			for (int j = 0; j < arCnt[i]; j++) {
				if(arUser[i][j].account.equals(account)) {
					if(arUser[i][j].pw.equals(pw)) {
						//로그인 성공
						return arUser[i][j];
					}
				}
			}
		}
		return null;
	}
}