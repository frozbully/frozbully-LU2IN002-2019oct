
public class Creature extends Personnage {
	private Sac leSac;
	
	//Constructors
	public Creature() {
		super(Noms.getNom());
		leSac = new Sac();
	}
	
	//Getters
	public double getVitesse() {
		double vitesse = this.getPoids()/4.0 - leSac.getPoids() ;
		if (vitesse < 0) {
			return 0;
		}
		return vitesse;
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
	
	public void mangerOld() {
		Acc a;
		for (int i = 0; i < leSac.size(); i++) {
			a = leSac.obtenir(i);
			if (a instanceof Mangeable) {
				manger((Mangeable) a);
				return;
			}
			leSac.ajouter(a);	
		}
	}
	//fonction manger amelioree
	public void manger() {
		mangerRec(leSac);
	}
	private void mangerRec(Sac s) {
		Acc a;
		for (int i = 0; i < s.size(); i++) {
			a = s.obtenir(i);
			if (a instanceof Mangeable) {
				manger((Mangeable) a);
				return;
			}
			s.ajouter(a);
			if (a instanceof Sac) {
				mangerRec((Sac)a);
			}
		}
	}
	
	public void courir() {
		System.out.println(String.format("%s %.1f kg court a vitesse %.2f km/h avec %s", this.getNom(), this.getPoids(), this.getVitesse(), leSac.toString() ));
	}
}
