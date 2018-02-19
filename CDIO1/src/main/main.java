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
		
//		UserDTO dto = new UserDTO(2, "rtest", "test", "test", "test", "test");
//		FileOutputStream f;
//		try {
//			f = new FileOutputStream(new File("myObjects.txt"));
//			ObjectOutputStream o = new ObjectOutputStream(f);
//
//			// Write objects to file
//			o.writeObject(dto);
//
//			o.close();
//			f.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		FileInputStream fi;
//		try {
//			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
//			ObjectInputStream oi = new ObjectInputStream(fi);
//
//			// Read objects
//			UserDTO pr1 = (UserDTO) oi.readObject();
//
//			System.out.println(pr1.toString());
//
//			oi.close();
//			fi.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
	}

}
