import java.awt.*;
import javax.swing.*;
public class TestGraphismes {
	private static final int TAILLE_CASE=30;
	private static final int NB_CASES=20;
	
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
		
		Avatar jake = new Avatar("Jake", 79.5, m, blue); // Ajoute Jake dans le monde
		for (int i=0; i<10; i++) {
			Thread.sleep(1000); // Ralenti l'affichage
			jake.seDeplacer();
			m.repaint(); //Redessine le graphisme
		}
	}
}
