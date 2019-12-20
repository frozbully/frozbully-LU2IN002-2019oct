import java.awt.*;
import javax.swing.*;

public class Jeu {
	private static final int TAILLE_CASE=30;
	private static final int NB_CASES=20;
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
	
	public void start(int nbCreatures, int nbAliments) throws InterruptedException {
		init(nbCreatures,nbAliments);
		monde.repaint(); //Redessine le graphisme
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000); // Ralenti l'affichage
			j1.seDeplacer();
			j1.rencontrerVoisins();
			monde.repaint(); //Redessine le graphisme
			Thread.sleep(1000); // Ralenti l'affichage
			j2.seDeplacer();
			j2.rencontrerVoisins();
			monde.repaint(); //Redessine le graphisme
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
	
	public static void main(String[] args) throws InterruptedException {
		//Creation denetre graphique et ses caracteristiques
		JFrame f = new JFrame();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creation du monde (qui est un paneau)
		Monde m = new Monde(NB_CASES,TAILLE_CASE);
		f.setContentPane(m); //Ajout du monde a la fenetre
		f.pack(); // Adaptation de la fenetre au panneau
		f.setVisible(true);
		
		new Jeu(m,new Avatar("Faraan",50.0,m,new Color(180,0,180)),new Avatar("Loann",60.0,m,new Color(0,255,0))).start(5,10);
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
	
	}
	//Q18
	
	Deuxieme Niveau :
	
	public abstract class Trap extends Item {
	private static int cpt = 0;
	private int numero;
	
	//Constructors
	public Trap(String categorie) {
		super(categorie);
		cpt++;
		numero = cpt;
	}
	//Getters
	
	public int getNumero() {
		return numero;
	}
	
	//Methods
	public abstract void effet(Avatar avatar);
	public String toString() {
		return String.format("%s No %d %.2f", this.getNom(), numero);
	}
}
	Troisième niveau : 
	
	import java.awt.Color;
	import java.awt.Graphics;

public class VideSac extends Trap {
	
	public VideSac() {
		super("videsac");
	}
	
	//Methods
	
	public String toString() {
		return String.format("videsac No %d ", this.getNumero());
	}
	
	public void effet(Avatar avatar){ //vide le sac de celui qui tombe dessus
		int i=1;
		while((avatar.getArrayListAcc()).size()!=0){
			(avatar.getArrayListAcc()).remove(i);
		}
	}
		
	public void dessiner (Graphics g , Monde m) {
		int tc=m.getTailleCase();
		g.setColor(new color(256,256,256));//couleur est blanche pour camoufler le trap
		g.fillRect(getX()*tc, getY()*tc, tc, tc);//carré plein
	}
	
}
*/
}
