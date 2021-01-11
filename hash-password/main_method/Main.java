package main_method;

import java.util.Scanner;

import bean.AcountBean;
import util.GenerateHashedPw;
import util.GenerateHashedPw2;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("名前：");
		String name = sc.nextLine();
		System.out.print("ID：");
		String salt = sc.nextLine();
		System.out.print("Pw：");
		String password = sc.nextLine();

		String hashedStr = GenerateHashedPw.getSafetyPassword(password, salt);
		String hashedStr2 = GenerateHashedPw2.getSafetyPassword2(hashedStr,salt);
		//StudentBeanクラスのインスタンス生成
				AcountBean student = new AcountBean(name,salt,hashedStr);

				//生成したインスタンスを引数にDBアクセスロジックを呼び出す
				//staticなメソッドなのでクラスから直接呼出し可能
				System.out.println(name+salt+hashedStr+" : "+hashedStr2);
//				AcountDao.insertAcount( student );


	}

}
