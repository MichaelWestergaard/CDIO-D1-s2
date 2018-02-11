package dal;

import java.util.List;

import Simpel2lagsModel.DemoData.Ingredient;
import dto.UserDTO;

public class userDAO implements IUserDAO{

	@Override
	public UserDTO getUser(int userId) throws DALException {
		// TODO Auto-generated method stub
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

	@Override
	public void updateUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub
		
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

}
