public class BaieAlea extends Acc implements Mangeable {
	private int alea;
	
	public BaieAlea() {
		super("baiealea");
		Random rand = new Random(); 
		int alea = rand.nextInt(21);
	}
	
	//Getters
	@Override
	public double getPoids() {
		if(alea==0){
			return 0,1;
		}
		if(this.getNumero()%2==0){
			return 2;
		}
		else{
			return 15;
		}
		
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("baiealea No %d %.2fkg", this.getNumero(), this.getPoids());
	}
}
