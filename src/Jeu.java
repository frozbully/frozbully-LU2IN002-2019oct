
public class Jeu {
	public static void main(String[] args) {
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
	}
}
