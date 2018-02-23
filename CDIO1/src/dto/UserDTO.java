package dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId;  //Interval 11-99, Benyttes når der skal foretages en afvejning til at identificere operatøren over for vægten.                   
	private String userName;  // min 2 - max 20 tegn              
	private String ini;         //initialer 2 til 4        
	private String role; //Gyldige roller: Admin, Pharmacist, Foreman, Operator
	private String cpr;
	private String password;

	public UserDTO(int userId, String userName, String ini, String role, String cpr, String password) {
		this.userId = userId;
		this.userName = userName;
		this.ini = ini;
		this.role = role;
		this.cpr = cpr;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getIni() {
		return ini;
	}
	
	public void setIni(String ini) {
		this.ini = ini;
	}
	
	public String getCpr() {
		return cpr;
	}
	
	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + role + "]";
	}

}