import java.util.ArrayList;

public class Monde {
	private ArrayList<Item> listeItems;
	private int taille;
	
	//Constructor
	public Monde(int taille) {
		this.taille = taille;
		listeItems = new ArrayList<Item>();
	}
	//Getters
	public int getTaille() {
		return taille;
	}
	
	//Methods
	public int getPositionAlea() {
		return (int)(Math.random() * ((double)taille) );
	}
	
	public void ajouterItem(Item item) {
		item.setX(getPositionAlea());
		item.setY(getPositionAlea());
		if (!listeItems.add(item)) {
			System.out.println("couldn't add "+item+" to the world");
		}
	}
	
	public void supprimerItem(Item item) {
		listeItems.remove(item);
		item.setX(-1);
		item.setY(-1);
	}	
	
	public Item chercher(int x, int y) {
		Item it;
		for (int i = 0; i < listeItems.size(); i++) {
			it = listeItems.get(i);
			if (it.getX() == x && it.getY() == y) {
				return it;
			}
		}
		return null;
	}
	
	public ArrayList<Item> getVoisins(Item item) {
		Item it;
		ArrayList<Item> res = new ArrayList<Item>();
		for (int i = 0; i < listeItems.size(); i++) {
			it = listeItems.get(i);
			if (it.distance(item) <= 2 && !it.equals(item)) {
				res.add(it);
			}
		}
		return res;
	}
	
	private static String getNomCourt(String nom) {
		if (nom.length() >= 4) {
			return nom.substring(0, 4);
		}
		while (nom.length() < 4) {
			 if (nom.length()%2 == 0) {
				nom = nom+" ";
			}else {
				nom = " "+nom;
			}
		}
		return nom;
	}
	
	public void afficher() {
		Item it = null;
		System.out.print("    |");
		for (int x = 0; x < taille; x++) {
			System.out.print(getNomCourt(Integer.toString(x))+"|");
		}
		for (int y = 0; y < taille; y++) {
			System.out.print("\n"+getNomCourt(Integer.toString(y))+"|");
			for (int x = 0; x < taille; x++) {
				it = chercher(x,y);
				if (it != null) {
					System.out.print(getNomCourt(it.getNom())+"|");
				}else {
					System.out.print("    |");
				}
			}
		}
		System.out.print("\n");
	}
	
}
