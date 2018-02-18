package dal;

import java.util.List;
import dto.UserDTO;

public class userDAO implements IUserDAO {
	private List<UserDTO> users;

	public UserDTO getUser(int userId) throws DALException {	
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserId()==userId) {
				return users.get(i);
			}
		}
		return null;
	}

	public List<UserDTO> getUserList() throws DALException {
		return users;
	}

	public void createUser(UserDTO user) throws DALException {
		if(getUser(user.getUserId()) == null) {
			users.add(user);
		}
	}

	public boolean checkPassword(String password) {

		char [] passwordArray = new char[password.length()];
		for (int i = 0; i < password.length(); i ++) {
			passwordArray[i] = password.charAt(i);
		}
		int counter = 0;
		boolean little = false, big = false, number = false, special = false;
		if (password.length()>=6) {
			for (int j = 0; j < passwordArray.length; j++) {
				if (passwordArray[j]>='A' && passwordArray[j]<='Z' && !big) {
					counter++;
					big = true;
				} else if (passwordArray[j]>='a' && passwordArray[j]<='z' && !little) {
					counter++;
					little = true;
				} else if (passwordArray[j]>='0' && passwordArray[j]<='9' && !number) {
					counter++;
					number = true;
				} else if (passwordArray[j]=='.' || passwordArray[j] =='-' || passwordArray[j] =='_' 
						|| passwordArray[j] == '+' || passwordArray[j] == '!' || passwordArray[j] == '?' || passwordArray[j] == '=' && !special) {
					counter++;
					special = true;
				}
			}
		}
		if (counter >= 3) {
			return true;

		} else {
			return false;
		}
	}

	public boolean checkUserName(String userName) {
		if(userName.length() >= 2 && userName.length() <= 20) {
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getUserName() != userName) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkIni(String ini) {
		if(ini.length() >= 2 && ini.length() <= 4) {
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIni() != ini) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkRole(String role) {
		if (role == "Admin" || role == "Pharmacist" || role == "Foreman" || role == "Operator") {
			return true;
		}
		return false;
	}

	public boolean checkCPR(String cpr) { // Ikke lavet
		return true;
	}

	public boolean checkId(int userId) {
		for(int i = 0; i < users.size(); i++) {

			if(users.get(i).getUserId() == userId) {
				return true;
			}
		}
		return false;
	}
	
	public void updateUserName(int userId, String userName) throws DALException { //Disse burde tag en int Id parameter? idk bg
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserId()==userId) {
				userName = users.get(i).getUserName();
			}
		}
	}

	public void updateIni(int userId, String ini) throws DALException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserId()==userId) {
				ini = users.get(i).getIni();
			}
		}
	}

	public void updateRole(int userId, String role) throws DALException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserId()==userId) {
				role = users.get(i).getIni();
			}
		}
	}

	public void updateCpr(int userId, String cpr ) throws DALException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserId()==userId) {
				cpr = users.get(i).getIni();
			}
		}
	}

	public void updatePassword() throws DALException {

	}

	public void deleteUser(int userId) throws DALException {
		if(users.contains(getUser(userId))) {			//Bør man også tjekke brugerens 'role'?
			users.remove(getUser(userId));
		}
	}

	public void updateUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub

	}

}