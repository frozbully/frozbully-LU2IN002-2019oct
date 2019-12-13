
public class Jeu {
	public static void main(String[] args) {
		Sac s1 = new Sac();
		Pomme p1 = new Pomme();
		Pomme p2 = new Pomme();
		s1.ajouter(p1);
		s1.ajouter(p2);
		
		System.out.println(s1);
	}
}
