/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import java.io.Serializable;

/**
 * This class is about an Invoice Team.
 * @version 1.0
 * @author Alberto Marun
 * @date February 2021.
 */
public class InvoiceItem implements Serializable{
    private String product_name;
    private int quantity;
    private double product_price;
    
    /**
     * Assign a new value to the Name of the InvoiceItem.
     * @param value (String) New name to the InvoiceItem, can not be null.
     */
    public void setProductName(String value){
        if(value != null){
            this.product_name = value;
        }
    }
    
    /**
     * Acces to the InvoiceItem name and know, what value it has.
     * @return (String) the actual name of the product.
     */
    public String getProductName(){
        return this.product_name;
    }
    
    /**
     * Assign a Quantity to the InvoiceItem.
     * @param value (int) needs to be greater than zero.
     */
    public void setProductQuantity(int value){
        if(value > 0){
            this.quantity = value;
        }
    }
    
    /**
     * Access to the Quantity of the InvoiceItem itself.
     * @return (int) Actual quantity of the InvoiceItem.
     */
    public int getProductQuantity(){
        return this.quantity;
    }
    
    /**
     * Assign a Price to the InvoiceItem.
     * @param value (double) New price that needs to be greater than zero.
     */
    public void setProductPrice(double value){
        if(value > 0){
            this.product_price = value;
        }
    }
    
    /**
     * Access to the actual price of the InvoiceItem.
     * @return (double) Actual price of the InvoiceItem.
     */
    public double getProductPrice(){
        return this.product_price;
    }
    
    /**
     * This function return the total price of the InvoiceItem.
     * @return (double) Multiplication between the Quantity and the Price of a product.
     */
    public double getTotalPrice(){
        return (getProductQuantity() * getProductPrice());
    }
    
    /**
     * Function to get an String from the Information of the InvoiceItem.
     * @return (String) With the Information of the InvoiceItem with a specific format.
     */
    @Override
    public String toString(){
        return  "Producto: " + getProductName() + " - Cantidad: " + getProductQuantity() + " - Precio Total: " + getTotalPrice() + " €";
    }
    
    /**
     * This function creates an InvoiceItem from a String.
     * @param product (String) That contains the whole information about a Product.
     * @return (InvoiceItem) InvoiceItem that contains the information about the product.
     */
    public static InvoiceItem parseInvoiceItem(String product){
        String[] parts = product.split(" ");
        InvoiceItem item = new InvoiceItem();
        
        item.setProductName(parts[1]);
        item.setProductQuantity( Integer.parseInt(parts[4]) );
        item.setProductPrice( Double.parseDouble(parts[8]) / item.getProductQuantity() );
        
        return item;
    }
}
