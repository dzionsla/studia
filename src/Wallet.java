import java.util.*;

public class Wallet {
	private ArrayList<BusinessCardO> wallet = new ArrayList<>();
	
	public void addBusinessCard(BusinessCardO card){
	    wallet.add(card);
	}

	public void printAllBusinessCards(){
		for (BusinessCardO object: wallet) {
			object.print();
		}
	}
	
	public void showByCity(String city) {
		for (BusinessCardO card : wallet) {
			if (card.getCity() == city) {
				card.print();
			}
		}
	}
	
	
}
