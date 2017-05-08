package model;

public class Audience {
	private String email;
	private String username;
	private int id;
	public Audience(String email, String username, int id) {
		super();
		this.email = email;
		this.username = username;
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
