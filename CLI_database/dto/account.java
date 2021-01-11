package dto;

public class account {
	private String id;
	private String name;
	private String mail;
	private String password;
	private String birthday;
	private String tell;
	private String token;
	private String create_at;
	private String update_at;
	private String count;

	public account(){

	}

	public account(String id , String name, String mail,String password,String birthday,String tell, String token,String create_at,String update_at){
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.birthday = birthday;
		this.tell = tell;
		this.token = token;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public account(String count,  String name,String password) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.count=count;
		this.name=name;
		this.password=password;
	}

	public account(String id, String name, String mail, String password, String birthday, String tell,
			String create_at, String update_at) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id=id;
		this.name=name;
		this.mail=mail;
		this.password=password;
		this.birthday=birthday;
		this.tell=tell;
		this.create_at=create_at;
		this.update_at=update_at;
	}

	public account(String count) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.count=count;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
}
