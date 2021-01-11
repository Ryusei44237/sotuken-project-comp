package admin_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import admin_src.CLI_database_test;
import dto.account;

public class admin_dao {
	//①DBアクセスに必要な情報の定数を定義

	//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String url = "jdbc:mysql://localhost:3306/application?serverTimezone=JST";
	//ユーザ
	private static final String user = "root";
	//パスワード
	private static final String pw = "44237";

	public static ArrayList<List<String>> table_number1(int  tablenumber){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		account result = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM account ;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			ArrayList<List<String>> data = new ArrayList<>();
			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while( rs.next() ){
			String getid = rs.getString("id");
			String getname = rs.getString("name");
			String getmail = rs.getString("mail");
			String getpassword  = rs.getString("password");
			String getbirthday = rs.getString("birthday");
			String gettell = rs.getString("tell");
			String getcreate_at = rs.getString("create_at");
			String getupdate_at = rs.getString("update_at");
			data.add(Arrays.asList(getid,getname,getmail,getpassword,getbirthday,gettell,getcreate_at,getupdate_at));
			}
			return data;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static ArrayList<List<String>> table_number2(int  tablenumber){
		//アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try{
			//JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//SQL文の元を作成する
			String sql = "SELECT * FROM post";

			//SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);
			//SQLを実行し、DBから結果を受領する
			rs = pstmt.executeQuery();

			//return用のArrayList生成
			ArrayList<List<String>> data = new ArrayList<>();


			//next()の戻り値がfalseになるまでResultSetから
			//データを取得してArrayListに追加していく
			while( rs.next() ){
				String account_id = rs.getString("account_id");
				String contents = rs.getString("contents");
				String img = rs.getString("img");
				String tags = rs.getString("tags_id");
				String address = rs.getString("address");
				String create_at = rs.getString("create_at");
				data.add(Arrays.asList(contents,img,tags,account_id,address,create_at));
			}
			//中身の詰まったArrayListを返却する
			return data;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑫DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		//途中でExceptionが発生した時はnullを返す。
		return null;
	}
	public static ArrayList<List<String>> table_number3(int  tablenumber){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		account result = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM tags";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			ArrayList<List<String>> data = new ArrayList<>();
			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while( rs.next() ){
			String getid = rs.getString("id");
			String getname = rs.getString("name");
			data.add(Arrays.asList(getid,getname));
			}
			return data;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static ArrayList<List<String>> table_number4(int  tablenumber){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		account result = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM post_tags ;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			ArrayList<List<String>> data = new ArrayList<>();
			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while( rs.next() ){
			String id = rs.getString("id");
			String post_id = rs.getString("post_id");
			String tags_id = rs.getString("tags_id");
			data.add(Arrays.asList(id,post_id,tags_id));
			}
			return data;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static ArrayList<List<String>> table_number5(int  tablenumber){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		account result = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM follows ;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			ArrayList<List<String>> data = new ArrayList<>();
			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while( rs.next() ){
			String id = rs.getString("id");
			String account_id = rs.getString("account_id");
			String follow = rs.getString("follow");
			data.add(Arrays.asList(id,account_id,follow));
			}
			return data;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String[] insertAccount(String data[]){
		//②アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			//③JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//④データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//⑤SQL文の元を作成する
			//?をプレースホルダと言います。
			//後の手順で?に値を設定します。
			String sql = "insert into account values(?,?,?,?,?,?,?,?,?)";

			//⑥SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			//⑦プレースホルダに値を設定
			//第1引数→何番目の?に設定するか(1から数える)
			//第2引数→?に設定する値
			for(int i=0;i<9;i++) {
				pstmt.setString(i+1, data[i]);
			}

			System.out.println("アカウント登録完了！");
			//⑧SQLを実行し、DBから結果を受領する
			int result= pstmt.executeUpdate();


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String[] insertPost(String data[]){
		//②アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			//③JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//④データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//⑤SQL文の元を作成する
			//?をプレースホルダと言います。
			//後の手順で?に値を設定します。
			String sql = "insert into post values(?,?,?,?,?,?,?)";

			//⑥SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			//⑦プレースホルダに値を設定
			//第1引数→何番目の?に設定するか(1から数える)
			//第2引数→?に設定する値
			for(int i=0;i<7;i++) {
				pstmt.setString(i+1, data[i]);
			}

			System.out.println("投稿完了！");
			//⑧SQLを実行し、DBから結果を受領する
			int result= pstmt.executeUpdate();


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String[] insertTags(String data[]) {
		//②アクセスに必要な変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;

				try{
					//③JDBCドライバをロードする
					Class.forName("com.mysql.cj.jdbc.Driver");

					//④データベースと接続する(コネクションを取ってくる)
					//第1引数→接続先URL
					//第2引数→ユーザ名
					//第3引数→パスワード
					con = DriverManager.getConnection(url, user, pw);

					//⑤SQL文の元を作成する
					//?をプレースホルダと言います。
					//後の手順で?に値を設定します。
					String sql = "insert into tags values(?,?)";

					//⑥SQLを実行するための準備(構文解析)
					pstmt = con.prepareStatement(sql);

					//⑦プレースホルダに値を設定
					//第1引数→何番目の?に設定するか(1から数える)
					//第2引数→?に設定する値
					for(int i=0;i<2;i++) {
						pstmt.setString(i+1, data[i]);
					}

					System.out.println("アカウント登録完了！");
					//⑧SQLを実行し、DBから結果を受領する
					int result= pstmt.executeUpdate();


				}  catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} finally {
					//⑨DBとの切断処理
					try {
						//nullかチェックしないとNullPointerExceptionが
						//発生してしまうためチェックしている。
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
				}
				return null;
	}
	public static String[] insertPostTags(String data[]) {
		//②アクセスに必要な変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;

				try{
					//③JDBCドライバをロードする
					Class.forName("com.mysql.cj.jdbc.Driver");

					//④データベースと接続する(コネクションを取ってくる)
					//第1引数→接続先URL
					//第2引数→ユーザ名
					//第3引数→パスワード
					con = DriverManager.getConnection(url, user, pw);

					//⑤SQL文の元を作成する
					//?をプレースホルダと言います。
					//後の手順で?に値を設定します。
					String sql = "insert into post_tags values(?,?,?)";

					//⑥SQLを実行するための準備(構文解析)
					pstmt = con.prepareStatement(sql);

					//⑦プレースホルダに値を設定
					//第1引数→何番目の?に設定するか(1から数える)
					//第2引数→?に設定する値
					for(int i=0;i<3;i++) {
						pstmt.setString(i+1, data[i]);
					}

					System.out.println("完了！");
					//⑧SQLを実行し、DBから結果を受領する
					int result= pstmt.executeUpdate();


				}  catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} finally {
					//⑨DBとの切断処理
					try {
						//nullかチェックしないとNullPointerExceptionが
						//発生してしまうためチェックしている。
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
				}
				return null;
	}
	public static ArrayList<List<String>> accountinfo(int id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		account result = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM account where id= ? ;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			ArrayList<List<String>> data = new ArrayList<>();
			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while( rs.next() ){
			String getid = rs.getString("id");
			String getname = rs.getString("name");
			String getmail = rs.getString("mail");
			String getpassword  = rs.getString("password");
			String getbirthday = rs.getString("birthday");
			String gettell = rs.getString("tell");
			String getcreate_at = rs.getString("create_at");
			String getupdate_at = rs.getString("update_at");
			data.add(Arrays.asList(getid,getname,getmail,getpassword,getbirthday,gettell,getcreate_at,getupdate_at));
			}
			return data;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String[] updateaccount(String data2[]) {
		//②アクセスに必要な変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;

				try{
					//③JDBCドライバをロードする
					Class.forName("com.mysql.cj.jdbc.Driver");

					//④データベースと接続する(コネクションを取ってくる)
					//第1引数→接続先URL
					//第2引数→ユーザ名
					//第3引数→パスワード
					con = DriverManager.getConnection(url, user, pw);

					//⑤SQL文の元を作成する
					//?をプレースホルダと言います。
					//後の手順で?に値を設定します。
					String sql = "update account set id=?,name=?,mail=?,password=?,birthday=?,tell=?,token=?,create_at=?,update_at=? where id=?";

					//⑥SQLを実行するための準備(構文解析)
					pstmt = con.prepareStatement(sql);

					//⑦プレースホルダに値を設定
					//第1引数→何番目の?に設定するか(1から数える)
					//第2引数→?に設定する値
					for(int i=0;i<9;i++) {
						pstmt.setString(i+1, data2[i]);
					}
					pstmt.setInt(10,CLI_database_test.id);

					System.out.println("アカウント情報更新完了！");
					//⑧SQLを実行し、DBから結果を受領する
					int result= pstmt.executeUpdate();


				}  catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} finally {
					//⑨DBとの切断処理
					try {
						//nullかチェックしないとNullPointerExceptionが
						//発生してしまうためチェックしている。
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
				}
				return null;
	}
	public static ArrayList<List<String>> postinfo(int id){
		//アクセスに必要な変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try{
			//JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			//データベースと接続する(コネクションを取ってくる)
			//第1引数→接続先URL
			//第2引数→ユーザ名
			//第3引数→パスワード
			con = DriverManager.getConnection(url, user, pw);

			//SQL文の元を作成する
			String sql = "SELECT * FROM post where id=?;";

			//SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			//SQLを実行し、DBから結果を受領する
			rs = pstmt.executeQuery();
			//return用のArrayList生成
			ArrayList<List<String>> data = new ArrayList<>();


			//next()の戻り値がfalseになるまでResultSetから
			//データを取得してArrayListに追加していく
			while( rs.next() ){
				String account_id = rs.getString("account_id");
				String contents = rs.getString("contents");
				String img = rs.getString("img");
				String tags = rs.getString("tags_id");
				String address = rs.getString("address");
				String create_at = rs.getString("create_at");
				data.add(Arrays.asList(contents,img,tags,account_id,address,create_at));
			}
			//中身の詰まったArrayListを返却する
			return data;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑫DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		//途中でExceptionが発生した時はnullを返す。
		return null;
	}
	public static String[] updatepost(String data2[]) {
		//②アクセスに必要な変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;

				try{
					//③JDBCドライバをロードする
					Class.forName("com.mysql.cj.jdbc.Driver");

					//④データベースと接続する(コネクションを取ってくる)
					//第1引数→接続先URL
					//第2引数→ユーザ名
					//第3引数→パスワード
					con = DriverManager.getConnection(url, user, pw);

					//⑤SQL文の元を作成する
					//?をプレースホルダと言います。
					//後の手順で?に値を設定します。
					String sql = "update post set contents=?,tags_id=?,account_id=?,address=?,create_at=? where id=?";

					//⑥SQLを実行するための準備(構文解析)
					pstmt = con.prepareStatement(sql);

					//⑦プレースホルダに値を設定
					//第1引数→何番目の?に設定するか(1から数える)
					//第2引数→?に設定する値
					for(int i=0;i<5;i++) {
						pstmt.setString(i+1, data2[i]);
					}
					pstmt.setInt(6,CLI_database_test.id);

					System.out.println("アカウント情報更新完了！");
					//⑧SQLを実行し、DBから結果を受領する
					int result= pstmt.executeUpdate();


				}  catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} finally {
					//⑨DBとの切断処理
					try {
						//nullかチェックしないとNullPointerExceptionが
						//発生してしまうためチェックしている。
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
				}
				return null;
	}

}

