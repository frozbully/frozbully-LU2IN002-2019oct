
public abstract class Acc {
	private static int cpt = 0;
	private int numero;
	private String categorie;
	
	//Constructors
	public Acc(String categorie) {
		this.categorie = categorie;
		cpt++;
		numero = cpt;
	}
	
	//Methods
	public abstract double getPoids();
	
	public int getNumero() {
		return numero;
	}
	@Override
	public String toString() {
		return String.format("%s No %d %.2f", categorie, numero, this.getPoids());
	}
}
