
public class Glouton extends Creature {
	//le glouton mange tout son inventaire d'un coup 
	
	public Glouton() {
		super();
	}
	
	@Override
	public void manger() {
		double p = -1;
		 while (p != getPoids()) {
			 p = getPoids();
			 mangerRec(getSac());
		 }
	}
}
