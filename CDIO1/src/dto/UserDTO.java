package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId;  //Interval 11-99, Benyttes når der skal foretages en afvejning til at identificere operatøren over for vægten.                   
	private String userName;  // min 2 - max 20 tegn              
	private String ini;         //initialer 2 til 4        
	private String role; //Gyldige roller: Admin, Pharmacist, Foreman, Operator
	private String cpr; //mussab  Cpr nummner int eller string / det skal være en String - Mussab
	private String password; //Mussab  Din nye adgangskode skal opfylde følgende regler:
   /* Adgangskoden skal indeholde mindst 6 tegn af mindst tre af de følgende fire kategorier: små bogstaver (’a’ til ’z’), store bogstaver (’A’ til ’Z’), cifre (’0’ til ’9’) og specialtegn (som defineret herunder).
    Undgå at bruge dit fornavn, efternavn eller bruger-ID som en del af din adgangskode, da dette vil medføre problemer med at logge ind på nogle systemer og tjenester på DTU, især Windows-tjenester.
    Anvend blot følgende special-tegn: {'.', '-', '_', '+', '!', '?', '='} */


	
	public UserDTO(int userId, String userName, String ini, String role, String cpr, String password) {
        this.userId = userId;
        this.userName = userName;
        this.ini = ini;
        this.role = role;
        this.cpr = cpr;
        this.password = password;
	}
	 
//	public UserDTO() {
//		this.role = new ArrayList<>();
//	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId() {
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
	public void setIni(int Id, String ini) {
		this.ini = ini;
	}
	public String getCpr() {
		return cpr;
	}
	public void setCpr() {
		this.cpr = cpr;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @param role
	 * @return true if role existed, false if not
	 */


	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + role + "]";
	}
	
	
	
}
