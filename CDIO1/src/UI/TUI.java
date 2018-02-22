package UI;

import java.io.IOException;
import java.util.Scanner;

import dal.IUserDAO;
import dal.IUserDAO.DALException;
import dal.userDAO;
import dto.UserDTO;

public class TUI implements IUI {
	Scanner scan = new Scanner(System.in);
	userDAO userdata;

	public TUI(IUserDAO data) {
		this.userdata = (userDAO) data;
	}

	public void showMenu() {

		try {
			userdata.getUserList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		int userID = 0;
		String username = null;
		String ini = null;
		String role = null; //Gyldige roller: Admin, Pharmacist, Foreman, Operator
		String cpr = null;
		try {
			while(userID == 0) {
				System.out.println("Enter user ID (11-99): ");
				int desiredID = scan.nextInt();

				if(!userdata.checkId(desiredID) && desiredID >= 11 && desiredID <= 99) { //Skal have oprettet "checkUsername" i DAO. Skal returnere true, hvis brugernavnet er gyldigt og ledigt.
					userID = desiredID;
				} else {
					System.out.println("The user ID, you entered, is either taken or invalid.");
				}
			}


			while(username == null) {
				System.out.println("Enter username (2-20 characters): ");
				String desiredUsername = scan.next();

				if(userdata.checkUserName(desiredUsername)) { //Skal have oprettet "checkUsername" i DAO. Skal returnere true, hvis brugernavnet er gyldigt og ledigt.
					username = desiredUsername;
				} else {
					System.out.println("The username, you entered, is either taken or invalid.");
				}
			}

			while(ini == null) {
				System.out.println("Enter your initials (2-4 characters): ");
				String desiredIni = scan.next().toUpperCase();

				if(userdata.checkIni(desiredIni)) { //Skal have oprettet "checkIni" i DAO. Skal returnere true, hvis initialerne er gyldige.
					ini = desiredIni;
				} else {
					System.out.println("The initials, you entered, are invalid.");
				}
			}

			while(role == null) {
				System.out.println("Enter your role: ");
				String desiredRole = scan.next();

				if(userdata.checkRole(desiredRole)) { //Skal have oprettet "checkRole" i DAO. Skal returnere true, hvis rollen er gyldig.
					role = desiredRole;
				} else {
					System.out.println("The role, you entered, is invalid.");
				}
			}

			while(cpr == null) {
				System.out.println("Enter your CPR: ");
				String desiredCPR = scan.next();

				if(userdata.checkCPR(desiredCPR)) { //Skal have oprettet "checkCPR" i DAO. Skal returnere true, hvis nummeret er gyldigt og ledigt.
					cpr = desiredCPR;
				} else {
					System.out.println("The CPR, you entered, is either taken or invalid.");
				}
			}

			userdata.createUser(userID, username, ini, role, cpr); //Skal have ordnet "createUser" i DAO, så den tager imod disse parametre, og selv generere ID og password.

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listUsers() {
		System.out.println(" --- | List Users | --- ");
		try {
			for(int i = 0;i < userdata.getUserList().size();i++) {
				System.out.println(userdata.getUserList().get(i));
			}

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void editUser() {
		System.out.println(" --- | Edit User | --- ");

		boolean userFound = false;
		int chosenID = 0;

		while(!userFound) {
			System.out.println("Enter the ID of the user you want to edit: ");		
			int enteredID = scan.nextInt();	

			if(userdata.checkId(enteredID)) { //Skal have oprettet "checkID" i DAO. Skal returnere true, hvis ID'et findes.
				try {
					System.out.println("You've entered the ID of user with username: '" + userdata.getUser(enteredID).getUserName() + "' and initials: '" + userdata.getUser(enteredID).getIni() + "'."); //Skal have lavet get-metoder
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

		try {
			System.out.println("Do you want to edit this user?\n[1] Yes\n[2] No");
			int action = scan.nextInt();

			if(action == 1) {
				System.out.println("What would you like to edit?\n[1] Username\n[2] Initials\n[3] Role\n[Any other number] Return to 'Edit User'");
				int action2 = scan.nextInt();

				switch(action2) {
				case 1: //Ændring af username
					String username = null;

					while(username == null) {
						System.out.println("Enter username (2-20 characters): ");
						String desiredUsername = scan.next();

						if(userdata.checkUserName(desiredUsername)) {
							username = desiredUsername;
						} else {
							System.out.println("The username, you entered, is either taken or invalid.");
						}
					}

					userdata.updateUserName(chosenID, username);
					break;

				case 2: //Ændring af initialer
					String ini = null;

					while(ini == null) {
						System.out.println("Enter your initials (2-4 characters): ");
						String desiredIni = scan.next().toUpperCase();

						if(userdata.checkIni(desiredIni)) {
							ini = desiredIni;
						} else {
							System.out.println("The initials, you entered, are invalid.");
						}
					}

					userdata.updateIni(chosenID, ini); //Skal have ændret "updateIni", så den tager imod (int, String) parametre
					break;

				case 3: //Ændring af rolle
					String role = null;

					while(role == null) {
						System.out.println("Enter your role: ");
						String desiredRole = scan.next();

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
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void deleteUser() {
		System.out.println(" --- | Delete User | --- ");

		boolean userFound = false;
		int chosenID = 0;

		while(!userFound) {
			System.out.println("Enter the ID of the user you want to delete: ");		
			int enteredID = scan.nextInt();	

			if(userdata.checkId(enteredID)) { //Skal have oprettet "checkID" i DAO. Skal returnere true, hvis ID'et findes.
				try {
					System.out.println("You've entered the ID of user with username: '" + userdata.getUser(enteredID).getUserName() + "' and initials: '" + userdata.getUser(enteredID).getIni() + "'."); //Skal have lavet get-metoder
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
			try {
				userdata.deleteUser(chosenID);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The user has been deleted.");
			break;
		case 2:
			showMenu();
			break;
		default:
			showMenu();
		}
	}

	//Vigtigt: Skal have lavet en returnToMainMenu-metode
}
