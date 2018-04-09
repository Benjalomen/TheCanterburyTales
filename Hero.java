package BasicLifeSupport.TheCanterburyTales;

import java.util.Scanner;
import java.util.Random;

public class Hero {
	
	Scanner input = new Scanner(System.in);		
	
	// Variables that ALL Heros will have (regardless of type)
	int hp;
	int strength;
	String baseClass;
	String name;
	
	// Default hero constructor
	public Hero() {
		hp = 10;
		strength = 10;
	}

	// Print out user's current stats
	public void printStats(Hero user) {
		System.out.println("HP:  " + hp);
		System.out.println("Strength:  " + strength);
		System.out.println("Base Class:  " + baseClass);
		
		if (hp == 0)
			deathPrompt(user);
	}
	
	//If player dies, then restart game
	public void deathPrompt(Hero user) {
		System.out.println("\nYou have died...\n");
		System.out.println("Would you like to continue?");
		System.out.println("\t1) Yes");
		System.out.println("\t2) No\n");
		int continueGame = input.nextInt();
		if (continueGame == 1) {
			story(user);
		}
	}
	// Random number generator with strength value as a highest bound!
	public int diceRoll(int boundaryNumber) {
		Random generator = new Random();
		int trulyRandomNumber = generator.nextInt(boundaryNumber);
		return trulyRandomNumber;
	}
	
	// Returns the
	public void attack(Enemy npc) {
		int damage = diceRoll(strength);
		npc.hp -= damage;		// decrease the enemy's hp by the amount of the attack
		System.out.println(name + " the " + baseClass + " has dealt " + damage + " to " + npc.name);
	}
	
	// story method that should be different for each base class
	public void story(Hero user) {
		System.out.println("THIS METHOD NEEDS TO BE OVERRWRITTEN!!");
	}
	
	// Menu to navigate to different stories
	public void displayAdventure(Hero user) {
		
		final int colwidth = 10;
		final int rowheight = 10;
		
		//Player Start Position
		int xpos = 2;
		int ypos = 2;
		
		//Chest Position
		int chestx = 7;
		int chesty = 3;
		
		boolean herosword = false;
		
		//Ogre Position
		int ogrex = 6;
		int ogrey = 7;
		
		Random combat = new Random();
		
		boolean gameloop = true;
		
		Scanner keyboard = new Scanner(System.in);
		
		do {
			String[][] map = new String[rowheight][colwidth];

			// initialize map to all 0
			for (int row = 0; row < map.length; row++) {
				for (int col = 0; col < map[row].length; col++) {
					map[row][col] = " . ";
				}
				System.out.println("");
			}

			// init map
			for (int row = 0; row < rowheight; row++) {
				map[row][0] = " O ";
				map[row][colwidth - 1] = " O ";
			}

			for (int col = 0; col < colwidth; col++) {
				map[0][col] = " O ";
				map[rowheight - 1][col] = " O ";
			}

			// Hero
			map[xpos][ypos] = " @ ";

			if (herosword == true) {
				map[xpos][ypos] = " @/";
			}

			// Chest
			map[chestx][chesty] = "-#-";

			// Ogre
			map[ogrex][ogrey] = " X ";

			for (int row = 0; row < map.length; row++) {
				for (int col = 0; col < map[row].length; col++) {
					System.out.print(map[row][col]);
				}
				System.out.println("");
			}

			// Combat
			if (xpos == ogrex && ypos == ogrey) {
				if (herosword == false) {
					System.out.println("The ogre enjoys a nice snack after a long day of grunting and scratching his bum");
					System.out.println("GAME OVER");
					gameloop = false;
				} else if (herosword == true) {
					int diceroll = 1 + combat.nextInt(10);
					if (diceroll <= 7) {
						System.out.println("Bravely you raise your sword to fight the Ogre before you,\nafter an exhausting battle you stand triumphantly\natop his head, pull your sword from between his\neyes, and continue on your journey.");
					} else {
						System.out.println("You fought well, unfortunately the Ogre fought better.");
						System.out.println("GAME OVER");
						gameloop = false;
					}
				}
			}

			// Chest
			if (xpos == chestx && ypos == chesty) {
				System.out.println("It's dangerous to go alone take this!");
				herosword = true;
			}

			// Keyboard Controls
			String direction = keyboard.nextLine();

			switch (direction) {
			case "w":
				xpos -= 1;
				break;
			case "s":
				xpos += 1;
				break;
			case "a":
				ypos -= 1;
				break;
			case "d":
				ypos += 1;
				break;
			}

			// Wall Barriers
			if (xpos <= 0) {
				xpos += 1;
			} else if (xpos >= 9) {
				xpos -= 1;
			} else if (ypos <= 0) {
				ypos += 1;
			} else if (ypos >= 9) {
				ypos -= 1;
			}

		} while (gameloop == true);
		
		
	}
	
}
