package UI;

import java.util.Scanner;

import dal.IUserDAO;
import dal.IUserDAO.DALException;
import dal.userDAO;

public class TUI implements IUI {
	Scanner scan = new Scanner(System.in);
	userDAO userdata;
	
	public TUI(IUserDAO data) {
		this.userdata = (userDAO) data;
	}
	
	public void showMenu() {
		System.out.println(" --- | MENU | --- ");
		System.out.println("[1] Create User\n[2] List Users\n[3] Edit User\n[4] Delete User\n[5] Exit");
		
		int action = scan.nextInt();
		
		switch (action) {
		case 1:
			createUser();
			break;
		case 2:
			listUsers();
			break;
		case 3:
			editUser();
			break;
		case 4:
			deleteUser();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			showMenu();
		}
	}
	
	public void createUser() {
		System.out.println(" --- | Create User | --- ");
		
		String username;
		String ini;
		String role; //Gyldige roller: Admin, Pharmacist, Foreman, Operator
		String cpr;
		
		while(username == null) {
			System.out.println("Enter username (2-20 characters): ");
			String desiredUsername = scan.nextLine();
			
			if(userdata.checkUsername(desiredUsername)) { //Skal have oprettet "checkUsername" i DAO. Skal returnere true, hvis brugernavnet er gyldigt og ledigt.
				username = desiredUsername;
			} else {
				System.out.println("The username, you entered, is either taken or invalid.");
			}
		}
		
		while(ini == null) {
			System.out.println("Enter your initials (2-4 characters): ");
			String desiredIni = scan.nextLine().toUpperCase();
			
			if(userdata.checkIni(desiredIni)) { //Skal have oprettet "checkIni" i DAO. Skal returnere true, hvis initialerne er gyldige.
				ini = desiredIni;
			} else {
				System.out.println("The initials, you entered, are invalid.");
			}
		}
		
		while(role == null) {
			System.out.println("Enter your role: ");
			String desiredRole = scan.nextLine();
			
			if(userdata.checkRole(desiredRole)) { //Skal have oprettet "checkRole" i DAO. Skal returnere true, hvis rollen er gyldig.
				role = desiredRole;
			} else {
				System.out.println("The role, you entered, is invalid.");
			}
		}
		
		while(cpr == null) {
			System.out.println("Enter your CPR: ");
			String desiredCPR = scan.nextLine();
			
			if(userdata.checkCPR(desiredCPR)) { //Skal have oprettet "checkCPR" i DAO. Skal returnere true, hvis nummeret er gyldigt og ledigt.
				cpr = desiredCPR;
			} else {
				System.out.println("The CPR, you entered, is either taken or invalid.");
			}
		}
		
		try {
			userdata.createUser(username, ini, role, cpr); //Skal have ordnet "createUser" i DAO, så den tager imod disse parametre, og selv generere ID og password.
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listUsers() {
		System.out.println(" --- | List Users | --- ");
		try {
			userdata.showUsers(); //Skal have udfyldt "showUsers" i DAO.
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void editUser() {
		System.out.println(" --- | Edit User | --- ");
		
		boolean userFound = false;
		int chosenID;
		
		while(!userFound) {
			System.out.println("Enter the ID of the user you want to edit: ");		
			int enteredID = scan.nextInt();	
			
			if(userdata.checkID()) { //Skal have oprettet "checkID" i DAO. Skal returnere true, hvis ID'et findes.
				try {
					System.out.println("You've entered the ID of user with username: '" + userdata.getUsername(enteredID) + "' and initials: '" + userdata.getIni(enteredID) + "'."); //Skal have lavet get-metoder
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				userFound = true;
				chosenID = enteredID;
			} else {
				System.out.println("The ID, you entered, is non-existent.");
			}
		}
		
		System.out.println("Do you want to edit this user?\n[1] Yes\n[2] No");
		int action = scan.nextInt();
		
		if(action == 1) {
			System.out.println("What would you like to edit?\n[1] Username\n[2] Initials\n[3] Role\n[Any other number] Return to 'Edit User'");
			int action2 = scan.nextInt();
			
			switch(action2) {
			case 1: //Ændring af username
				String username;
				
				while(username == null) {
					System.out.println("Enter username (2-20 characters): ");
					String desiredUsername = scan.nextLine();
					
					if(userdata.checkUsername(desiredUsername)) {
						username = desiredUsername;
					} else {
						System.out.println("The username, you entered, is either taken or invalid.");
					}
				}
				
				userdata.updateUserName(chosenID, username);
				break;
				
			case 2: //Ændring af initialer
				String ini;
				
				while(ini == null) {
					System.out.println("Enter your initials (2-4 characters): ");
					String desiredIni = scan.nextLine().toUpperCase();
					
					if(userdata.checkIni(desiredIni)) {
						ini = desiredIni;
					} else {
						System.out.println("The initials, you entered, are invalid.");
					}
				}
				
				userdata.updateIni(chosenID, ini); //Skal have ændret "updateIni", så den tager imod (int, String) parametre
				break;
				
			case 3: //Ændring af rolle
				String role;
				
				while(role == null) {
					System.out.println("Enter your role: ");
					String desiredRole = scan.nextLine();
					
					if(userdata.checkRole(desiredRole)) {
						role = desiredRole;
					} else {
						System.out.println("The role, you entered, is invalid.");
					}
				}
				
				userdata.updateRole(chosenID, role); //Skal have ændret "updateRole", så den tager imod (int, String) parametre
				break;
				
			default:
				editUser();
			}			
		} else {
			editUser();
		}
	}
	
	public void deleteUser() {
		System.out.println(" --- | Delete User | --- ");
		
		boolean userFound = false;
		int chosenID;
		
		while(!userFound) {
			System.out.println("Enter the ID of the user you want to delete: ");		
			int enteredID = scan.nextInt();	
			
			if(userdata.checkID()) { //Skal have oprettet "checkID" i DAO. Skal returnere true, hvis ID'et findes.
				try {
					System.out.println("You've entered the ID of user with username: '" + userdata.getUsername(enteredID) + "' and initials: '" + userdata.getIni(enteredID) + "'."); //Skal have lavet get-metoder
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				userFound = true;
				chosenID = enteredID;
			} else {
				System.out.println("The ID, you entered, is non-existent.");
			}
		}
		
		System.out.println("Do you want to delete this user?\n[1] Yes\n[2] No");
		int action = scan.nextInt();
		
		switch(action) {
		case 1:
			userdata.deleteUser(chosenID);
			System.out.println("The user has been deleted.");
			break;
		case 2:
			deleteUser();
			break;
		default:
			deleteUser();
		}
	}
	
	//Vigtigt: Skal have lavet en returnToMainMenu-metode
}