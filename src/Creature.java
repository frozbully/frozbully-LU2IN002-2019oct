
public class Creature extends Personnage {
	private Sac leSac;
	
	//Constructors
	public Creature() {
		super(Noms.getNom());
		leSac = new Sac();
	}
	
	//Getters
	public double getVitesse() {
		double poids = this.getPoids()/4.0 - leSac.getPoids() ;
		if (poids < 0) {
			return 0;
		}
		return poids;
	}
	
	//Methods
	public void ajouter(Acc a) {
		if (leSac.getPoids() + a.getPoids() < this.getPoids()) {
			leSac.ajouter(a);
		}else {
			System.out.println("Trop lourd");
		}
	}
	
	public void manger(Mangeable m) {
		this.addPoids(m.getPoids());
	}
	
	public void manger() {//TODO pour aller plus loin la methode cherche aussi le contenu des sac dans leSac
		for (int i = 0; i < leSac.size(); i++) {
			Acc a = leSac.obtenir(i);
			if (a instanceof Mangeable) {
				manger((Mangeable) a);
				return;
			}
		}
	}
	
	public void courir() {
		System.out.println(String.format("%s court a vitesse %.2f km/h avec %s", this.toString(), this.getVitesse(), leSac.toString() ));
	}
}
