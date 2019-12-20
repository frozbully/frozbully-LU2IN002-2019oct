import java.awt.*;
import javax.swing.*;

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
