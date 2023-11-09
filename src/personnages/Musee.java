package personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophee;

	public Musee() {
		trophees = new Trophee[200];
		nbTrophee = 0;
	}

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < trophees.length) {
			Trophee nouveauTrophee = new Trophee(gaulois, equipement);
			trophees[nbTrophee] = nouveauTrophee;
			nbTrophee++;
			System.out.println(gaulois.getNom() + " a fait un don au musée.");
		} else {
			System.out.println("Le musée est plein, impossible de recevoir de nouveaux trophées.");
		}
	}
}
