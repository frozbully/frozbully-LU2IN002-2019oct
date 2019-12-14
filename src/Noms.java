
public class Noms {
	private static String[] tabNoms = {"Atchoum", "Dormeur", "Grincheux", "Joyeux", "Prof", "Simplet", "Teo", "Timide"};
	private static int n = 0;
	private static int nb = 0;
	
	//Methods
	public static String getNom() {
		if (n >= tabNoms.length) {
			n = 0;
			nb++;
		}
		if (nb == 0) {
			return tabNoms[n++];
		}
		return tabNoms[n++] + nb;
	}
}
