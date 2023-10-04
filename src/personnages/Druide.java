package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	@SuppressWarnings("unused")
	private int effetPotionMin;
	@SuppressWarnings("unused")
	private int effetPotionMax;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public int forcePotion = 1;

	public int preparerPotion() {
		Random random = new Random();
		int forceAleatoire = random.nextInt(this.effetPotionMax - this.effetPotionMin + 1) + this.effetPotionMin;
		this.forcePotion = forceAleatoire;
		System.out.println("Potion préparée avec une force de " + forcePotion);
		if (forcePotion > 7) {
			parler(" J'ai préparé une super potion de force");
		} else {
			parler(" Je n'ai pas eu tout les ingrédients pour préparer ma Potion ");
		}
		return forcePotion;
	}

	public void booster(Gaulois gaulois, Druide druide) {
		if (gaulois.getNom().equals("Obélix")) {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			int forcePotion = preparerPotion();
			gaulois.boirePotion(forcePotion);
		}
	}

	// public void Random(preparerPotion);
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();

	}
}
