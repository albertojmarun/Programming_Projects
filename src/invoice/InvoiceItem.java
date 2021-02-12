/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

/**
 * This class is about an Invoice Team.
 * @version 1.0
 * @author Alberto Marun
 * @date February 2021.
 */
public class InvoiceItem {
    private String product_name;
    private int quantity;
    private double product_price;
    
    public void setProductName(String value){
        this.product_name = value;
    }
    
    public String getProductName(){
        return this.product_name;
    }
    
    public void setQuantity(int value){
        this.quantity = value;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public void setProductPrice(double value){
        this.product_price = value;
    }
    
    public double getProductPrice(){
        return this.product_price;
    }
    
    public double getTotalPrice(){
        return (getQuantity() * getProductPrice());
    }
    
    @Override
    public String toString(){
        String whole_product;
        
        whole_product = "Producto: " + getProductName() + 
                        " - Cantidad: " + getQuantity() +
                        " - Precio Total: " + getProductPrice() + " €";
        
        return whole_product;
    }
    
    public static InvoiceItem parseInvoiceItem(String product){
        String[] parts = product.split(" ");
        
        InvoiceItem item = new InvoiceItem();
        
        item.setProductName(parts[1]);
        item.setQuantity( Integer.parseInt(parts[4]) );
        item.setProductPrice( Double.parseDouble(parts[8]) / item.getQuantity() );
        
        return item;
    }
    
    public static void main(String[] args){
        InvoiceItem item = new InvoiceItem();
        
        item = parseInvoiceItem("Producto: Manzana - Cantidad: 2 - Precio Total: 3 €");
        
        System.out.println();
        
        System.out.println(item.getProductName());
        System.out.println(item.getQuantity());
        System.out.println(item.getProductPrice());
    }
}
