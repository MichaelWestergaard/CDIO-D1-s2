package main;
import UI.IUI;
import UI.TUI;
import dal.IUserDAO;
import dal.userDAO;

public class main {

	public static void main(String[] args) {
		
		IUserDAO data = new userDAO();
		IUI ui = new TUI(data);
		while (true){
		   ui.showMenu();
		}
		
	}

}
