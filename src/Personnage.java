
public abstract class Personnage extends Item {
	private double poids;
	
	//Constructors
	public Personnage(String nom, double poids) {
		super(nom);
		this.poids = poids;
	}
	
	public Personnage(String nom) {
		this(nom, Math.random()*100 +30);
	}
	
	//Getters
	protected double getPoids() {
		return poids;
	}
	
	//Methods
	protected void addPoids(double p) {
		if (p>0) {
			poids+=p;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %.1f kg", this.getNom(), poids);
	}
	
}
