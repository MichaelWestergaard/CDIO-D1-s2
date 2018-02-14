package dal;

import java.util.List;
import java.util.Scanner;
import dto.UserDTO;

public class userDAO implements IUserDAO{
	Scanner scanner = new Scanner(System.in);

	public void showMenu() {
		System.out.println(" --- [MENU] --- ");
		System.out.println("[1] Find en bruger\n[2] Få bruger liste\n[3] Lav en ny bruger\n[4] Opdater oplysninger for en bruger\n[5] Slet en bruger");
		int action = scanner.nextInt();
		switch (action) {
			case 1:
				getUser();
				break;
			case 2:
				getUserList();
				break;
			case 3:
				createUser();
				break;
			case 4:
				updateUser();
				break;
			case 5:
				deleteUser();
	
			default:
				showMenu();
		}
	}
	
	
	
	
	
	
	
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
		System.out.println("Indtast bruger id: ");
		int id = scanner.nextInt();
		
		System.out.println("Hvad vil du redigere?\n[1] Navn\n[2] Ini\n[3] Rolle ");
		int action = scanner.nextInt();
		switch (action) {
			case 1:
				System.out.println("Skriv et nyt brugernavn: ");
				String newName = scanner.next();
				UserDTO.setUserName(newName);
				break;
			case 2:
				System.out.println("Skriv det nye Ini: ");
				String newIni = scanner.next();
				UserDTO.setIni(newIni);
				break;
			case 3:
				System.out.println("Vælg den nye rolle: ");
				String newIni = scanner.next();
				UserDTO.setIni(newIni);
				break;
			default:
				System.out.println("Ugyldig indtastning");
				showMenu();
		}
	}
		
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
