package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import UI.IUI;
import UI.TUI;
import dal.IUserDAO;
import dal.userDAO;
import dto.UserDTO;

public class main {

	public static void main(String[] args) {
		
		IUserDAO data = new userDAO();
		IUI ui = new TUI(data);
		while (true){
		   ui.showMenu();
		}	
		
	}

}
