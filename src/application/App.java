package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.WeaponsDao;
import entity.Weapon;

public class App {

	public static void main(String[] args) {
		new App().start();
		
	}
	
	private WeaponsDao weaponsDao = new WeaponsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Weapons",
			"Display a Weapon",
			"Create a Weapon",
			"Delete a Weapon");
			

	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayWeapons();
				} else if (selection.equals("2")) {
					displayWeapon();
				} else if (selection.equals("3")) {
					createWeapon();
				} else if (selection.equals("4")) {
					deleteWeapon();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("Press enter to continue....");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}


	private void printMenu() {
		System.out.println("Select an Option:\n-----------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i)); 
		}
		
	}
	
	private void displayWeapons() throws SQLException {
		List<Weapon> weapons = weaponsDao.getWeapons();
		for (Weapon weapon : weapons) {
			System.out.println("Name: " + weapon.getName() + " Class: " + weapon.getWeaponClass());
		}
	}
	
	private void displayWeapon() throws SQLException {
		System.out.print("Enter Weapon Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Weapon weapon = weaponsDao.getWeaponById(id);
		System.out.println("Name: " + weapon.getName() + " Class: " + weapon.getWeaponClass());
	}
	
	private void createWeapon() throws SQLException {
		System.out.print("Enter new weapon name: ");
		String weaponName = scanner.nextLine();
		System.out.print("Enter new weapon class: ");
		String weaponClass = scanner.nextLine();
		weaponsDao.createNewWeapon(weaponName, weaponClass);
	}
	
	private void deleteWeapon() throws SQLException {
		System.out.print("Enter weapon id to be deleted: ");
		int id = Integer.parseInt(scanner.nextLine());
		weaponsDao.deleteWeaponById(id);
		
	}
}
