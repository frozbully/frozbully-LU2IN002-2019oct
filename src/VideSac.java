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
	
	public void effet(Avatar avatar){//vide le sac de celui qui tombe dessus
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
