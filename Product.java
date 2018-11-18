/**   w CLASS TO CREATE PRODUCT OBJECTS
 *    @author Andres Herrera U1536951 UNIVERSITY OF EAST LONDON
 *    @version 03/05/2017
 */
public class Product 
{
	//the attributes
	private String name;
	private int stockLevel;
	private double price;
	
	//the constructor
	public Product (String nameIn, int StockLevelIn, double priceIn)
	{
		name= nameIn;
		stockLevel= StockLevelIn;
		price= priceIn;
	}
	//the methods
	
	//method to restock
	public int reStock(int amountIn)
	{
		stockLevel= stockLevel + amountIn;
		return stockLevel;
	}
	
	//method to sell
	public double sell (int quantityIn)
	{
	
		stockLevel= stockLevel - quantityIn;
			
		
		return quantityIn * price;
			
	}
	
	//method to set a new price
	public void setPrice (double priceIn)
	{
		price= priceIn;
	}
	
	//method to get the prduct name
	public String getName()
	{
		return name;
	}
	
	//method to get the prduct stock level
	public int getStockLevel()
	{
		return stockLevel;
	}
	
	//method to get the prduct price
	public double getPrice()
	{
		return price;
	}
}
