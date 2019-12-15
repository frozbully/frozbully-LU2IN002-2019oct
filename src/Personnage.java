
public abstract class Personnage {
	private String nom;
	private double poids;
	
	//Constructors
	public Personnage(String nom, double poids) {
		this.nom = nom;
		this.poids = poids;
	}
	
	public Personnage(String nom) {
		this(nom, Math.random()*100 +30);
	}
	
	//Getters
	protected double getPoids() {
		return poids;
	}
	protected String getNom() {
		return nom;
	}
	
	//Methods
	protected void addPoids(double p) {
		if (p>0) {
			poids+=p;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %.1f kg", nom, poids);
	}
	
}