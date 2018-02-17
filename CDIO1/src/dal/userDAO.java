package dal;

import java.util.List;
import java.util.Scanner;

import dto.UserDTO;

public class userDAO implements IUserDAO{
	Scanner scanner = new Scanner(System.in);

	@Override
	public UserDTO getUser(int userId) throws DALException {	
		//brug for loop til at kører llisten igennem, og tjekker om ideeren er den samme. return userDTO
		return null;
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {//har skrevet "LISTnavn" da vi ikke har oprettet vores brugereliste - Mussab
		if(getUser(userId) == null) {
			LISTnavn.add(new User(userId, userName, ini, roles));
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
