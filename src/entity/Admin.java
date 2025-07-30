package entity;

public class Admin extends User {
	private int expInYeaer;
	
	public Admin() {
		super();
	}
	public Admin(int expInYeaer) {
		super();
		this.expInYeaer = expInYeaer;
	}
	
	public Admin(int id, String fullName, String email, String password, int expInYeaer) {
		super(id, fullName, email, password);
		this.expInYeaer = expInYeaer;
	}


	public int getExpInYeaer() {
		return expInYeaer;
	}

	public void setExpInYeaer(int expInYeaer) {
		this.expInYeaer = expInYeaer;
	}
	

	@Override
	public String toString() {
		return "Admin [expInYeaer=" + expInYeaer + ", id=" + id + ", fullName=" + fullName + ", email=" + email
				+ ", password=" + password + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
