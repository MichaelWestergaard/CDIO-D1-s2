package dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.UserDTO;

public class userDAO implements IUserDAO {
	Scanner scanner = new Scanner(System.in);


	@Override
	public UserDTO getUser(int userId) throws DALException {	
		//brug for loop til at kører llisten igennem, og tjekker om ideeren er den samme. return userDTO
		return null;
	}
	private List<UserDTO> users;

	@Override
	public List<UserDTO> getUserList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		if(getUser(user.getUserId()) == null) {
			users.add(new UserDTO(user.getUserId(), user.getUserName(), user.getIni(), user.getRole(), user.getCpr(), user.getPassword()));
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

	@Override
	public void deleteUser(int userId) throws DALException {
		if(LISTnavn.contains(getUser(userId))) {			//Bør man også tjekke brugerens 'role'?
			LISTnavn.remove(getUser(userId));
			System.out.println("Brugeren er blevet fjernet.");
		}

		else {
			System.out.println("Der findes ingen bruger med dette ID.");
		}

	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void showUsers() throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void showUser(int id) throws DALException {
		// TODO Auto-generated method stub

	}

	//	@Override
	//	public void showUsers() throws DALException {
	//		System.out.println("Liste af brugerne:");
	//		for (String s : data.getAllUsers()) {
	//			System.out.println(s);
	//		}
	//	}
	//
	//	@Override
	//	public void showUser(int id) throws DALException {
	//		System.out.print("Indtast id: ");
	//		String input = scanner.next();
	//		int id = Integer.parseInt(input);
	//		String user;
	//		try {
	//			user = data.getUserName(id) + data.getUserAmount(id); 
	//			//i vores tilfælde hvad er data, fra tui klassen i sidste uges opgave?
	//			System.out.println(user);
	//		} catch (UserNotFoundException e) {
	//			System.out.println("Denne bruger er ikke fundet");
	//			e.printStackTrace();
	//		}
	//	}

}
