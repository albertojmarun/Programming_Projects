package practica9;

import java.util.HashMap;

/**
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date January 12, 2021.
 */
public class Shop {
    private HashMap<String, Integer> prices;
    
    /**
     * Initialize the Map or Dictionary of the class.
     */
    public Shop(){
        prices = new HashMap<>();
    }
    
    /**
     * This function is to assign a new item on the Map or Dictionary.
     * @param product (String) that is the key of the item.
     * @param price (int) that is the value that correspond to the key of the item
     */
    public void setPrice(String product, int price){
        prices.put(product, price);
    }
    
    /**
     * This functions is to get the price of a Product inside the Map or Dictionary.
     * @param product String with the key to find the product inside the Map or Dictionary.
     * @return The price of the product if exist or -1 if the key doesn't exist.
     */
    public int getPrice(String product){
        int price = -1;
        
        if (prices.containsKey(product)){
            price = prices.get(product);
        }
        
        return price;
    }
    
    /**
     * This functions print on the Terminal the product and his price of every product inside the Map or Dictionary.
     */
    public void showProducts(){
        for(String product: prices.keySet()){
            System.out.printf("%s -> %d euro(s)\n", product, prices.get(product));
        }
    }
    
    /**
     * This functions is aplied to get the name of cheaper product stored in the prices HashMap.
     * @return the (String) name of the cheaper product on the Map or Dictionary.
     */
    public String getCheaper(){
        String cheaper_product = "";
        int cheaper_price = Integer.MAX_VALUE;
        
        for(String product: prices.keySet()){
            if(prices.get(product) < cheaper_price){
                cheaper_price = prices.get(product);
                cheaper_product = product;
            }
        }
        
        return cheaper_product;
    }
    
    public static void main(String[] args){
        Shop shop = new Shop();
        
        shop.setPrice("Gorras", 1512);
        shop.setPrice("Pantalones", 1);
        shop.setPrice("Zapatos", 155);
        shop.setPrice("Cartera", 18);
        shop.setPrice("Bolso", 1);
        shop.setPrice("Balones", 1);
        
        System.out.println(shop.getPrice("Gorras"));
        System.out.println(shop.getPrice("Chanclas"));
        
        System.out.println(shop.getCheaper());
        shop.showProducts();
    }
}
