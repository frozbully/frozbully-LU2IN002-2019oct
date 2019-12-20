
public abstract class Box extends Item {
	private static int cpt = 0;
	private int numero;
	private Monde monde;
	
	//Constructors
	public Box(String categorie) {
		super(categorie);
		cpt++;
		numero = cpt;
	}
	//Getters
	public abstract double getPoids();
	
	public int getNumero() {
		return numero;
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("%s No %d %.2f", this.getNom(), numero, this.getPoids());
	}
}
