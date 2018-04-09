package BasicLifeSupport.TheCanterburyTales;

public class LogansClass extends Hero {
	
	// fields and methods of Hero.java
	
	public LogansClass() {
		hp = 10;
		strength = 5;
		baseClass = "Common House Cat";
	}
	
	public void batWithPaw() {}
	public void purrLoudly() {}
	public void scratch() {}
	
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
		
		int attackDamage = diceRoll(20);
		System.out.println("\n" + name + " the " + baseClass + " has rolled " + initiative + " for initiative");		
		printStats(user);
		
	}
}
