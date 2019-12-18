
public class Jeu {
	private Monde monde;
	private Avatar j1;
	private Avatar j2;
	
	public Jeu(Monde monde, Avatar j1, Avatar j2) {
		this.monde = monde;
		this.j1 = j1;
		this.j2 = j2;
	}
	
	private void init(int nbC, int nbA) {
		double rand;
		for (int i = 0; i < nbC; i++) {
			rand = Math.random();
			
			if (rand < 0.2) {
				monde.ajouterItem(new Glouton());
			}else {
				monde.ajouterItem(new Creature());
			}
			
		}
		for (int i = 0; i < nbA; i++) {
			rand = Math.random();
			if (rand < 0.05) {
				monde.ajouterItem(new PotionMagique());
			}else if (rand < 0.1) {
				Sac s = new Sac();
				while(rand < 0.5) {
					s.ajouter(new Pomme());
					rand = Math.random();
				}
				monde.ajouterItem(s);
			}else {
				monde.ajouterItem(new Pomme());
			}
		}
	}
	
	public void start(int nbCreatures, int nbAliments) {
		init(nbCreatures,nbAliments);
		for (int i = 0; i < 5; i++) {
			monde.afficher();
			j1.seDeplacer();
			j1.rencontrerVoisins();
			monde.afficher();
			j2.seDeplacer();
			j2.rencontrerVoisins();
		}
		double scoreJ1 = j1.course();
		double scoreJ2 = j2.course();
		if (scoreJ1 > scoreJ2 ) {
			System.out.println(String.format("%s a gagne avec %.2f points contre %.2f points", j1.getNom(), scoreJ1, scoreJ2));
		}else if (scoreJ2 > scoreJ1) {
			System.out.println(String.format("%s a gagne avec %.2f points contre %.2f points", j2.getNom(), scoreJ2, scoreJ1));
		}else {
			System.out.println("EGALITE PARFAITE !!! Vous avez tous les deux "+scoreJ1+" points !");
		}
	}
	
	public static void main(String[] args) {
		Monde monde = new Monde(5,5);
		new Jeu(monde,new Avatar("Faraan",50.0,monde),new Avatar("Loann",60.0,monde)).start(3,5);
		Console.in.close();//Do not remove this line
	}
	/*public static void main(String[] args) {
	//Q5
	System.out.println("Question 5 :");
	Sac s1 = new Sac();
	s1.ajouter(new Pomme());
	s1.ajouter(new Pomme());
	System.out.println(s1);

	//Q9
	System.out.println("\nQuestion 9 :");
	Creature c = new Creature();
	c.courir();
	c.ajouter(s1);
	c.ajouter(new Pomme());
	c.ajouter(new Pomme());
	c.ajouter(new Pomme());
	c.courir();
	c.mangerOld();
	c.mangerOld();
	c.mangerOld();
	c.courir();
	
	//Manger amelioree
	System.out.println("\nManger amelioree :");
	c = new Creature();
	c.courir();
	c.ajouter(s1);
	c.courir();
	c.manger();
	c.manger();
	c.courir();
	
	//Q13
	System.out.println("\nQuestion 13 :");
	Monde world = new Monde(5, 5);
	world.ajouterItem(c);
	world.ajouterItem(new Creature());
	world.ajouterItem(new Creature());
	world.ajouterItem(new Pomme());
	world.ajouterItem(new Pomme());
	world.ajouterItem(new Pomme());
	Avatar faraan = new Avatar("faraan", 50.0, world);
	world.afficher();
	faraan.seDeplacer();
	world.afficher();
	
	}*/
}
