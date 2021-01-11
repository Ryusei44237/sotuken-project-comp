package admin_src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import admin_dao.admin_dao;
public class CLI_database_test {
	static Scanner scanner = new Scanner(System.in);
	public static int id=0;
	static int jobnumber=0;
	static int tablenumber=0;
	static String endpoint="continue";
	public static void main(String[] args) {

		for(int i=0;true;i++) {
			readme();//初期情報を表示
			jobnumber = scanner.nextInt();//作業番号を入力
			switchjob(jobnumber);//作業番号をswitchjobメソッドに送る
			if(endpoint.equals("continue")) {
				continue;
			}
			else if(endpoint.equals("end")) {
				System.out.println("システムを終了します");
				System.out.println("よろしいですか？？");
				System.out.print("y/n　　　");
				String judge=scanner.next();
				if(judge.equals("y")||judge.equals("Y")) {
					System.out.println("お疲れ様でした");
					break;
				}else if(judge.equals("n")||judge.equals("N")) {
					continue;
				}
			}
		}

	}
	public static void readme() {
		//行いたい作業を選択させる
		System.out.println("行いたい作業を選択してください。");
		String info[] = {"情報の参照　:1　","情報の挿入　:2　","情報の更新　:3　","情報の削除　:4　","各ページの表示　:5　","処理の終了　:6"};
		for(int i=0;i<6;i++) {
			if(i<5) {
				System.out.print(info[i]);
			}else if(i>=5) {
				System.out.println(info[i]);
			}
		}
		System.out.print("入力値 : ");


	}
//	作業番号を入力
	public static void switchjob(int jobnumber) {
		switch(jobnumber) {
			case 1://表示
				tableinfo();//テーブル情報を表示
				tablenumber = scanner.nextInt();//テーブル番号を入力
				switchtable(tablenumber);//入力された番号をswithする
				break;
			case 2://挿入
				tableinfo();//テーブル情報を表示
				tablenumber = scanner.nextInt();//テーブル番号を入力
				switchinserttable();//入力された番号をswitchする
				break;
			case 3://更新
				switchupdatetable();
				break;
			case 4://削除
				tableinfo();//テーブル情報を表示
				tablenumber = scanner.nextInt();//テーブル番号を入力
				switchdeletetable();
				break;
			case 5://ページの表示
				break;
			case 6://処理の終了
				endpoint="end";

		}
	}
//	操作するテーブルを選択
	public static void tableinfo() {
		String info[] = {"テーブル番号を入力してください。　",
						"（1）アカウントテーブル　",
						"（2）投稿テーブル　",
						"（3）タグテーブル　",
						"（4）投稿タグテーブル　",
						"（5）フォロワーテーブル"};
		for(int i=0;i<5;i++) {
			if(i<4) {
				System.out.print(info[i]);
			}else if(i>=4) {
				System.out.println(info[i]);
			}
		}
        System.out.print("数値を入力してください。 :");
	}
//	テーブル番号を選択
	public static void switchtable(int tablenumber){
		ArrayList<List<String>> data = new ArrayList<>();
		switch (tablenumber){
		  case 1:
			  data = admin_dao.table_number1(tablenumber);
			  for(int i=0; i<data.size();i++) {
				  System.out.println(data.get(i));
			  }
			  break;
		  case 2:
			  data = admin_dao.table_number2(tablenumber);
			  for(int i=0; i<data.size();i++) {
				  System.out.println(data.get(i));
			  }
			  break;
		  case 3:
			  data = admin_dao.table_number3(tablenumber);
			  for(int i=0; i<data.size();i++) {
				  System.out.println(data.get(i));
			  }
			  break;
		  case 4:
			  data = admin_dao.table_number4(tablenumber);
			  for(int i=0; i<data.size();i++) {
				  System.out.println(data.get(i));
			  }
			  break;
		  case 5:
			  data = admin_dao.table_number5(tablenumber);
			  for(int i=0; i<data.size();i++) {
				  System.out.println(data.get(i));
			  }
			  break;
		}
	}
//	挿入テーブルの選択
	public static void switchinserttable() {
		String[] data=null;
		switch (tablenumber){
			case 1://アカウントテーブルに挿入
				data = new String[9];
				String info[] = {"アカウントID　：　",
								"アカウントNAME　：　",
								"メールアドレス　：　",
								"パスワード　：　",
								"誕生日　：　",
								"電話番号　：　",
								"トークン　：　",
								"作成日　：　",
								"更新日　：　"};
				String[] result = new String[9];
				System.out.println("アカウントテーブルに挿入");
				for(int i=0;i<9;i++) {
					System.out.print(info[i]);
					data[i]= scanner.next();
				}
				result = admin_dao.insertAccount(data);
				break;
			case 2:
				data = new String[7];
				String info2[] = {"投稿ID","投稿内容","画像","タグID","アカウントID","アドレス","作成日"};
				result = new String[7];
				System.out.println("投稿テーブルに挿入");
				for(int i=0;i<7;i++) {
					System.out.print(info2[i]);
					data[i]= scanner.next();
				}
				result = admin_dao.insertPost(data);
				break;
			case 3:
				data = new String[2];
				String info3[] = {"タグID","タグ名前"};
				result = new String [2];
				System.out.println("タグテーブルに挿入");
				for(int i=0;i<2;i++) {
					System.out.print(info3[i]);
					data[i]= scanner.next();
				}
				result = admin_dao.insertTags(data);
				break;
			case 4:
				data = new String[3];
				String info4[] = {"ID","投稿ID","タグID"};
				result = new String [3];
				System.out.println("タグテーブルに挿入");
				for(int i=0;i<3;i++) {
					System.out.print(info4[i]);
					data[i]= scanner.next();
				}
				result = admin_dao.insertPostTags(data);
				break;
		}
	}
//	更新テーブルの選択
	public static void switchupdatetable() {
		//アカウントデータと投稿データの更新
		String[] data2=null;
		System.out.println("アカウントデータを更新したい場合は（１）。投稿データの更新をしたい場合は（２）を選択");
		int Number = scanner.nextInt();
		ArrayList<List<String>> data = new ArrayList<>();
		switch (Number) {
			case 1://アカウント情報の更新
				System.out.println("更新したいアカウントIDを入力してください。");
				id= scanner.nextInt();
				//現在登録されているアカウント情報の表示
				data = admin_dao.accountinfo(id);
				  for(int i=0; i<data.size();i++) {
					  System.out.println(data.get(i));
				  }
				  data2 = new String[9];
					String info[] = {"アカウントID　：　",
									"アカウントNAME　：　",
									"メールアドレス　：　",
									"パスワード　：　",
									"誕生日　：　",
									"電話番号　：　",
									"トークン　：　",
									"作成日　：　",
									"更新日　：　"};
					String[] result = new String[9];
					System.out.println("アカウント情報更新");
					for(int i=0;i<9;i++) {
						System.out.print(info[i]);
						data2[i]= scanner.next();
					}
					result = admin_dao.updateaccount(data2);
					break;
			case 2://アカウント更新情報の入力
				System.out.println("更新したい投稿IDを入力してください");
				id= scanner.nextInt();
				System.out.println(id);
				//投稿情報を表示
				data = admin_dao.postinfo(id);
				  for(int i=0; i<data.size();i++) {
					  System.out.println(data.get(i));
				  }
				  data2 = new String[9];
					String info2[] = {"投稿内容　:　","タグID　:　","アカウントID　:　","住所　:　","作成日　:　"};
					String[] resul2 = new String[5];
					System.out.println("アカウント情報更新");
					for(int i=0;i<5;i++) {
						System.out.print(info2[i]);
						data2[i]= scanner.next();
					}
					result = admin_dao.updatepost(data2);
					break;
		}
	}
//	削除テーブルの選択
	public static void switchdeletetable() {

	}
	public static void deleteinfo() {
		switch (tablenumber) {
			case 1:
				String tablename="account";//テーブル名を格納


		}
	}
}
