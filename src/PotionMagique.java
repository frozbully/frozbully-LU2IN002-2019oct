import java.awt.Color;
import java.awt.Graphics;

public class PotionMagique extends Acc implements Mangeable {
	private double force;
	
	public PotionMagique() {
		super("potion magique");
		force = Math.random()*100.0 - 25.0;
	}
	
	@Override
	public double getPoids() {
		if (force < 0) {
			return 0;
		}
		return force;
	}

	//Methods
	@Override
	public String toString() {
		return String.format("potion No %d %.2fkg force :%.2f", this.getNumero(), this.getPoids()/50, force);
	}
	
	@Override
	public void dessiner(Graphics g, Monde m) {
		int tc=m.getTailleCase();
		g.setColor(new Color(255,0,255));
		g.fillOval(getX()*tc, getY()*tc, tc, tc);
	}
	
}
