package BasicLifeSupport.TheCanterburyTales;

public class SpencersClass extends Hero {

	//fields and methods of Hero.java are all at your disposal
	
	public SpencersClass() {
		hp = 10;
		strength = 10;
		baseClass = "Minstrel";
	}
	
	// Possible class methods
	public void seduce() {}
	public void strumLyre() {}
	public void danceInCirclesAround() {}
		
	public void story(Hero user) {
		
		//Your story goes here!
		// The following is just examples of how you could use the diceRoll() method
		
		int initiative = diceRoll(5);
		System.out.println("\n" + name + " the " + baseClass + " has rolled a " + initiative + " for initiative");		
		if (initiative == 5) {
			System.out.println("You're raring for a fight!");
		} else if (initiative > 2) {
			System.out.println("You are willing to fight, but are somewhat indifferent...");
		} else {
			System.out.println("You are deathly scared to fight and decide to run away instead.");
		}
		
		int attackDamage = diceRoll(5);
		System.out.println("\n" + name + " the " + baseClass + " has rolled " + initiative + " for initiative");		
		printStats(user);
	}
	
}
