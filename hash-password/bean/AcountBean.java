package bean;

public class AcountBean {
	private String name;
	private String id;
	private String pw;

	public AcountBean(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public AcountBean(String id, String name, String pw) {
		super();
		this.name= name;
		this.id = id;
		this.pw = pw;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
