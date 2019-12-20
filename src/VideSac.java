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
	
	public void effet(Avatar avatar){
		int i=1;
		while((avatar.getArrayListAcc()).size()!=0){
			(avatar.getArrayListAcc()).remove(i);
		}
	}
		
	public void dessiner(Graphics g, Monde m) {
		int tc=m.getTailleCase();
		g.setColor(new Color(45,45,45));
		g.fillOval(getX()*tc, getY()*tc, tc, tc);
	}
	
}
