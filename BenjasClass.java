package BasicLifeSupport.TheCanterburyTales;

public class BenjasClass extends Hero {

	//fields and methods of Hero.java
	
	public BenjasClass() {
		hp = 10;
		strength = 5;
		baseClass = "Pacifist";
	}
	
	//Possible class methods
	public void castSpell() {}
	public void coerce() {}
	public void hungerStrike() {}
	
	public void story(Hero user) {
		
		//Your story goes here!
		
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
		System.out.println("\n" + name + " the " + baseClass + " has rolled " + attackDamage + " for initiative");		
		printStats(user);
		
	}
	
}
