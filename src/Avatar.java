import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Avatar extends Personnage {
	private ArrayList<Creature> listeAmis;
	private ArrayList<Acc> listeAcc;
	private Monde monde;
	private Color color;
	//Constructors
	public Avatar(String nom, double poids, Monde monde, Color color) {
		super(nom, poids);
		listeAmis = new ArrayList<Creature>();
		listeAcc = new ArrayList<Acc>();
		monde.ajouterItem(this);
		this.monde = monde;
		this.color = color;
	}
	//Getters
	
	public ArrayList<Acc> getArrayListAcc(){
		return listeAcc;
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
	
	public void ramasser(Acc a) {
		if (a!=null) {
			monde.supprimerItem(a);
			listeAcc.add(a);
			System.out.println(this.getNom() + " ramasse " + a.getNom());
		}
	}
	
	public void rencontrerVoisins() {
		ArrayList<Item> voisins = monde.getVoisins(this);
		Item it;
		for (int i = 0; i < voisins.size(); i++) {
			it = voisins.get(i);
			if (it instanceof Acc) {
				ramasser((Acc)it);
			}else if (it instanceof Creature) {
				rencontrer((Creature) it);
			}else if (it instanceof Avatar) {
				System.out.println(this.getNom() + " salue " + it.getNom());
			}
		}
	}
	
	public void seDeplacer() {
		int x = -1;
		int y = -1;
		System.out.println("### Deplacement de "+getNom()+" ###");
		while (x < 0 || x > monde.getTaille()) {
			System.out.println("Entrer une abscisse entre [0,"+(monde.getTaille()-1)+"] :");
			x = Console.in.nextInt();
		}
		while (y < 0 || y > monde.getTaille()) {
			System.out.println("Entrer une ordonnee entre [0,"+(monde.getTaille()-1)+"] :");
			y = Console.in.nextInt();
		}
		System.out.println("Deplacement de "+this.getNom()+" de ("+this.getX()+","+this.getY()+") vers ("+x+","+y+")");
		this.setX(x);
		this.setY(y);
	}
	
	public String toString() {
		return String.format("%s %.1f kg %d ami(s) %d accessoire(s)", this.getNom(), this.getPoids(), listeAmis.size(), listeAcc.size()); 
	}
	
	public void dessiner (Graphics g , Monde m) {
		int tc=m.getTailleCase();
		g.setColor(color);//couleur courante devient bleu
		g.fillRect(getX()*tc, getY()*tc, tc, tc);//carré plein
	}	
}
