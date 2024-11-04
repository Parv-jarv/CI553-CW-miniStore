package catalogue;

import java.io.Serializable;
import java.util.Collections;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
	@Override 
	public boolean add( Product pr )
	{
		for(Product prInList: this) {
			if(prInList.getProductNum().equals(pr.getProductNum())) {
				int quantity = pr.getQuantity()+prInList.getQuantity();				// merges objects of the same id or in this case product number
				prInList.setQuantity(quantity);
				return(true);
				
			}
		}
		return super.add( pr );
	}
 
}



