import java.util.ArrayList;

public class Monde {
	private ArrayList<Item> listeItems;
	private int taille;
	
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
		
	}	
}
