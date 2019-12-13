
public class Sac extends Acc {
	private Acc[] tab;
	private int cpt;
	
	//Constructors
	public Sac(int n) {
		super("sac");
		tab = new Acc[n];
		cpt = 0;
	}
	
	public Sac() {
		super("sac");
		tab = new Acc[10];
		cpt = 0;
	}
	
	//Methods
	public int size() {
		return tab.length;
	}
	
	public void ajouter(Acc a) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == null) {
				tab[i] = a;
				cpt++;
			return;
			}
		}
		System.out.println("Pas de place");
	}
	
	public Acc obtenir(int i) {
		if (tab[i] == null) {
			return null;
		}
		Acc res = tab[i];
		tab[i]=null;
		cpt--;
		return res;
	}
	@Override
	public double getPoids() {
		double res=0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				res += tab[i].getPoids();
			}
		}
		return res;
	}
	@Override
	public String toString() { //TODO better toString using toString(int n) 
		String res = String.format("sac No %d %.2f contient %d accessoires sur %d places", this.getNumero(), this.getPoids(), cpt, this.size());
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				res += "\n\t" + tab[i].toString();
			}
		}
		return res;
	}
	
}
