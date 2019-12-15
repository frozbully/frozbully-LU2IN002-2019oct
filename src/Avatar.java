import java.util.ArrayList;

public class Avatar extends Personnage {
	private ArrayList<Creature> listeAmis;
	private ArrayList<Acc> listeAcc;
	
	//Constructors
	public Avatar(String nom, double poids) {
		super(nom, poids);
	}
	
	//Methods
	public boolean estAmi(Creature c) {
		return listeAmis.contains(c);
	}
	
	public void devenirAmi(Creature c) {
		if (this.estAmi(c)) {
			System.out.println(c.getNom()+ " est deja ami avec " +this.getNom());
		}else {
			listeAmis.add(c);
			System.out.println(c.getNom()+ " deviens ami avec " +this.getNom());			
		}
	}
	
	public void perdreAmi(Creature c) {
		if (listeAmis.remove(c)) {
			System.out.println(c.getNom()+ " n'est plus ami avec " +this.getNom());
		}else {
			System.out.println(c.getNom()+ " ne fais pas partie des amis de " +this.getNom());
		}
	}
	
	public void rencontrer(Creature c) {
		if (listeAcc.size() == 0) {
			this.perdreAmi(c);
		}else {
			Acc gift = listeAcc.remove(0);
			if (gift.getPoids() > 0.5) {
				this.devenirAmi(c);
			}
			c.ajouter(gift);
		}
	}
	
	public double course() {
		double distance = 0;
		Creature c;
		for (int i = 0; i < listeAmis.size(); i++) {
			c = listeAmis.get(i);
			c.manger();
			c.courir();
			distance += c.getVitesse();
		}
		return distance;
	}
	
	public Creature getCreaturePlusRapide() {
		Creature rapide = null;
		Creature c;
		if (listeAmis.size() > 0) {
			rapide = listeAmis.get(0);
		}
		for (int i = 1; i < listeAmis.size(); i++) {
			c = listeAmis.get(i);
			if (c.getVitesse() > rapide.getVitesse()) {
				rapide = c;
			}
		}
		return rapide;
	}
	
	public int compterAccMangeable() {
		int somme = 0;
		Acc a;
		for (int i = 0; i < listeAcc.size(); i++) {
			a = listeAcc.get(i);
			if (a instanceof Mangeable) {
				somme++;
			}else if (a instanceof Sac) {
				somme += mangeableDansSac((Sac)a); 
			}
		}
		return somme;
	}
	private int mangeableDansSac(Sac s) {
		int somme = 0;
		Acc a;
		for (int i = 0; i < s.size(); i++) {
			a = s.obtenir(i);
			if (a instanceof Mangeable) {
				somme ++;
				s.ajouter(a);
			}else if (a instanceof Sac) {
				s.ajouter(a);
				somme += mangeableDansSac((Sac)a);
			}else {
				s.ajouter(a);
			}
		}
		return somme;
	}
	
	
	public String toString() {
		return String.format("%s %.1f kg %d ami(s) %d accessoire(s)", this.getNom(), this.getPoids(), listeAmis.size(), listeAcc.size()); 
	}
	
}