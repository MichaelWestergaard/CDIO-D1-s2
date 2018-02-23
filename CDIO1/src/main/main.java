package main;
import UI.IUI;
import UI.TUI;

public class main {

	public static void main(String[] args) {
		
		IUI ui = new TUI();
		while (true){
		   ui.showMenu();
		}	
		
	}

}
