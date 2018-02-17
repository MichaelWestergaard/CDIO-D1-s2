package UI;

import java.util.Scanner;
import dal.userDAO;

public class TUI {
	Scanner scan = new Scanner(System.in);
	userDAO userdata;
	
	public TUI(userDAO userdata) {
		this.userdata = userdata;
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
		default:
			showMenu();
		}
	}
	
	public void createUser() {
		
	}
	
	public void listUsers() {
		
	}
	
	public void editUser() {
		
	}
	
	public void deleteUser() {
		
	}
}
