/**
File:  Main.java
Author:  Benja Gooder
Purpose:  Main method for new DND text adventure
Date: 04/09/2018
*/

package BasicLifeSupport.TheCanterburyTales;

// So that the user can input crapola
import java.util.Scanner;

// Importing the other files
import BasicLifeSupport.TheCanterburyTales.Hero;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		

		// Create new hero character and initialize to null character
		Hero user = null;
		
		
		// Choosing hero's base class
		System.out.println("~~~~~~~~~~~~~~~~~ The Canterbuy Tales ~~~~~~~~~~~~~~~~~~");
		System.out.println("Please choose your class:");
		System.out.println("\t1) Common House Cat");
		System.out.println("\t2) Pacifist");
		System.out.println("\t3) Minstrel");
		int classChoice = input.nextInt();
		if (classChoice == 1) {
			user = new LogansClass();
		} else if (classChoice == 2) {
			user = new BenjasClass();
		} else if (classChoice == 3) {
			user = new SpencersClass();
		} else
			System.out.println("Not an option...");
			
		// Choose the hero's name
		System.out.println("\nPlease type the name of this new " + user.baseClass);
		user.name = input.next();
		
		// Begin the adventure
		//user.displayAdventure(user);
		user.story(user);
		
	}

}
