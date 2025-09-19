package bookproject.com.market.v1.member;

public class Admin extends User {
	private String id = "Admin";
	private String password = "Admin1234";

	public Admin(String name, String phone) {
		super(name, phone);
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}