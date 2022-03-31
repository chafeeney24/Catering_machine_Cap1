package com.techelevator;

import com.techelevator.Utilities.Stocker;
import com.techelevator.item.Item;
import com.techelevator.view.DisplayMenu;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

public class CaTEringCapstoneCLI {



	private Menu menu;

	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		//CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		menu.run();



	}


}
