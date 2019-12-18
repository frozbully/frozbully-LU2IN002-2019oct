import java.awt.*;
import javax.swing.*;

public class Pomme extends Acc implements Mangeable {
	private double rayon;
	
	public Pomme() {
		super("pomme");
		rayon = Math.random()*4 + 3 ;
	}
	
	//Getters
	@Override
	public double getPoids() {
		return (4.0/3000)*Math.PI*Math.pow(rayon, 3);
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("pomme No %d %.2fkg %.2fcm", this.getNumero(), this.getPoids(), rayon);
	}
	
	@Override
	public void dessiner(Graphics g, Monde m) {
		int tc=m.getTailleCase();
		g.setColor(new Color(255,0,0));
		g.fillOval(getX()*tc, getY()*tc, tc, tc);
	}
}
