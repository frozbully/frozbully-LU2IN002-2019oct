import java.awt.Color;
import java.awt.Graphics;

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
	
	@Override
	public void dessiner (Graphics g , Monde m) {
		int tc=m.getTailleCase();
		g.setColor(new Color(75 ,100 ,150));//couleur courante devient bleu
		g.fillRect(getX()*tc, getY()*tc, tc, tc);//carré plein
	}
}
