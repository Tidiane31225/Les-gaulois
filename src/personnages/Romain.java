package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean victoire = false;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force >= 0 : "La force d'un Romain doit être positive ou nulle.";
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public boolean isVictoire() {
		return victoire;
	}

	public void setVictoire(boolean victoire) {
		this.victoire = victoire;
	}

	public int getForce() {
		return force;
	}


	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	// Méthode pour équiper le Romain
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			parler("s'équipe avec un " + equipement.getNom() + ".");
			break;
		case 1:
			if (equipements[0] == equipement) {
				parler("possède déjà un " + equipement.getNom() + " !");
			} else {
				equipements[nbEquipement] = equipement;
				nbEquipement++;
				parler("s'équipe avec un " + equipement.getNom() + ".");
			}
			break;
		case 2:
			parler("est déjà bien protégé !");
			break;
		}
	}

	/*
	 * public void recevoirCoup(int forceCoup) { assert force >= 0 :
	 * "La force d'un Romain doit être positive ou nulle."; int actuf = force; force
	 * -= forceCoup; assert actuf > force : "La force du Romain doit diminuée."; if
	 * (force > 0) { parler("Aïe"); } else { parler("J'abandonne..."); }
	 * 
	 * }
	 */

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// switch (force) {
		// case 0:
		// parler("Aïe");
		// break;
		// default:
		// equipementEjecte = ejecterEquipement1();
		// parler("J'abandonne...");
		// break;
		// }
		// post condition la force a diminué
		if (force == oldForce) {
			this.victoire = true;
			parler("J'ai gagné !!!");

		}

		return equipementEjecte;
	}


	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
                    if ((equipements[i] != null &&
						equipements[i].equals(Equipement.BOUCLIER))) {
                         resistanceEquipement += 8;
                    } else {
                         System.out.println("Equipement casque");
                         resistanceEquipement += 5;
						}
					}
					texte += resistanceEquipement + "!";
          }
          parler(texte);
          if (forceCoup- resistanceEquipement >= 0) {
          forceCoup -= resistanceEquipement;
          return forceCoup;}
          else {
        	  return forceCoup= 0;
          }
}

private Equipement[] ejecterEquipement() {
	Equipement[] equipementEjecte = new Equipement[nbEquipement];
	System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
          //TODO
          int nbEquipementEjecte = 0;
          for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] == null) {
					continue;
				} else {
					equipementEjecte[nbEquipementEjecte] = equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
		}


	public static void main(String[] args) {

		// Enum equipements
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		System.out.println("Equipement 1 : " + casque);
		System.out.println("Equipement 2 : " + bouclier);

		// Méthode prendre parole
		Romain minus = new Romain("Minus", 6);

		// Romain s'equipe
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

		// Méthode parler
		minus.parler("Je suis le plus fort !");

		// Méthode recevoirCoup
		minus.recevoirCoup(1);
		minus.recevoirCoup(5);
	}


}
