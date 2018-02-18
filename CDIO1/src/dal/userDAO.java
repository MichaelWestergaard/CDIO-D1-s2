package dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.UserDTO;

public class userDAO implements IUserDAO {

	public UserDTO getUser(int userId) throws DALException {	
		//brug for loop til at kører llisten igennem, og tjekker om ideeren er den samme. return userDTO
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserId()==userId) {
				
				return users.get(i);
			}
		}
		return null;
	}
	private List<UserDTO> users;

	public List<UserDTO> getUserList() throws DALException {
		// TODO Auto-generated method stub
		return null;
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

	public void updateUserName(int userId, String userName) throws DALException { //Disse burde tag en int Id parameter? idk bg
		UserDTO.setUserName(userName);
	}


	public void updateIni(int userId, int ini) throws DALException {

	}

	public void updateRole() throws DALException {

	}

	public void updateCpr(int userId, String cpr ) throws DALException {

	}

	public void updatePassword() throws DALException {

	}

	public void deleteUser(int userId) throws DALException {
		if(LISTnavn.contains(getUser(userId))) {			//Bør man også tjekke brugerens 'role'?
			LISTnavn.remove(getUser(userId));
			System.out.println("Brugeren er blevet fjernet.");
		}

		else {
			System.out.println("Der findes ingen bruger med dette ID.");
		}

	}

	public void updateUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub

	}

	public void showUsers() throws DALException {
		// TODO Auto-generated method stub

	}

	public void showUser(int id) throws DALException {
		// TODO Auto-generated method stub

	}

}

