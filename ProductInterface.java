/**   GUI w
 *    @author Andres Herrera U1536951 UNIVERSITY OF EAST LONDON
 *    @version 03/05/2017
 */
 
 //import the necessary packages
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import javax.swing.border.*;
public class ProductInterface extends JFrame implements ActionListener 

{
	private Product [] myProducts= new Product[10000];//initialize the array to handle 10000products
    private static int total=0;//this variable keeps track of thenumber of products created
    
	//add product function components	
	
	private JLabel addLinesL0= new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________");
	private JLabel addTitleL= new JLabel ("ADD A PRODUCT");
	private JLabel addNameL= new JLabel("assing name");
	private JTextField addNameF= new JTextField (50);
	private JLabel addStockL= new JLabel("     Set initial stock");
	private JTextField addStockF= new JTextField(15);
	private JLabel addPriceL= new JLabel("     Set price");
	private JTextField addPriceF= new JTextField(15);
	private JButton addProductB= new JButton ("   Add   ");
	private JLabel addLinesL= new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________");
	private JLabel space1= new JLabel("                  ");
	private JLabel space2= new JLabel("                  ");
	private JLabel space3= new JLabel("                                     ");
	private JLabel counter =new JLabel ("");
	
	//functionality componets
	
	private JLabel reStockTitleL= new JLabel("MANAGE PRODUCTS");
	private JLabel reStockNameL= new JLabel ("Name");
	private JTextField reStockNameF= new JTextField(74);
	private JLabel reStockQuantityL= new JLabel("Add stock");
	private JTextField reStockQuantityF= new JTextField(20);
	private JButton reStockB= new JButton("Re-stock");
	private JLabel addLinesL2= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                         ");

	private JLabel rePriceNameL= new JLabel("Name");
	private JLabel rePriceNewPriceL= new JLabel("New price");
	private JTextField rePriceNewPriceF= new JTextField(21);
	private JButton rePriceB= new JButton ("   Set   ");
	private JLabel addLinesL3= new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________");

	private JLabel sellNameL= new JLabel ("Name");
	private JLabel sellQuantityL= new JLabel ("Amount");
	private JTextField sellQuantityF= new JTextField (22);
	private JButton sellB= new JButton ("  Sell  ");
	private JLabel addLinesL4= new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________");
	
	//product info components
	
	private JLabel infoTitleL= new JLabel("GET PRODUCTS INFO");
	private JLabel infoNameL= new JLabel("Name");
	private JTextField infoNameF= new JTextField (61);
	private JButton infoB= new JButton ("Search");
	private JButton infoDisplayB= new JButton ("Display all products");
	private JLabel addLinesL5= new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________");

	//add HELP menu
	private JTextArea displayArea= new JTextArea(20,100);
	private JMenuBar bar= new JMenuBar();
	private JMenu help= new JMenu ("Help");
	private JMenuItem addMI= new JMenuItem("How to add a product");
	private JMenuItem manageMI= new JMenuItem("How to manage products");
	private JMenuItem infoMI= new JMenuItem("How to get product info");
	
	//the constructor	
	public ProductInterface()
	{
		setTitle("U1536951 Andres Herrera   ***STOCKER***");//sets the title at the top of the panel(window)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this defines what happens when we click on the cross(X), in this case we finish the program
		setSize(1450,710);//size of the window
		setLocation(1,1);//location that appears the window when you run the program
		setLayout(new FlowLayout());//this sets the type of layout we use, in this case we use flow layout.
		
		// add help components
		
		help.add(addMI);
		addMI.addActionListener(this);//this allows to decide what happens when user click on this button, the same for the rest from now on.
		help.add(manageMI);
		manageMI.addActionListener(this);
		help.add(infoMI);
		infoMI.addActionListener(this);
		bar.add(help);
		setJMenuBar(bar);
		bar.setBackground(Color.ORANGE);
	
		//add the addPanel components
		add(addLinesL0);
		add(addTitleL);
		add(addNameF);
		addNameF.setBorder(new TitledBorder("Set the name"));//this gives title to a JTextField
	    add(addStockF);
		addStockF.setBorder(new TitledBorder("Set initial stock"));//this gives title to a JTextField
		add(addPriceF);
		addPriceF.setBorder(new TitledBorder("Set price"));//this gives title to a JTextField
		add(addProductB);
		addProductB.addActionListener(this);// add a action listener to this button
		add(addLinesL);
		
		//add functionalPanel component
		add(reStockTitleL);
		add(reStockNameF);
		reStockNameF.setBorder(new TitledBorder("Enter the name of the product"));//this gives title to a JTextField
		add(addLinesL2);
		
		//reStock
		add(reStockQuantityF);
		reStockQuantityF.setBorder(new TitledBorder("Amount to add to stock"));//this gives title to a JTextField
		add(reStockB);
		reStockB.addActionListener(this);//add action listener to this button
		add(space1);
		
		//rePrice
		add(rePriceNewPriceF);
		rePriceNewPriceF.setBorder(new TitledBorder("Set new price"));//this gives title to a JTextField
		add(rePriceB);
		rePriceB.addActionListener(this);//add action listener to this button
		add(space2);
			
		//sell
		add(sellQuantityF);
		sellQuantityF.setBorder(new TitledBorder("Amount to sell"));//this gives title to a JTextField
		add(sellB);
		sellB.addActionListener(this);//add action listener to this button
		add(addLinesL3);
	
		//add infoPanel component
		add(infoTitleL);
		add(infoNameF);
		infoNameF.setBorder(new TitledBorder("Enter the name of the product"));//this gives title to a JTextField
		add(infoB);
		infoB.addActionListener(this);//add action listener to this button
		add(space3);
		add(infoDisplayB);
		infoDisplayB.addActionListener(this);//add action listener to this button
	    add(addLinesL5);
	    
		JScrollPane scroll= new JScrollPane(displayArea); //this creates a new scroldable panel, recieves a JTextArea as a parameter
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//set the behavior of the scroll bar
		add(scroll);//add the scroll bar
		add(counter);
		counter.setText("                                                           Total products: "+total);//we add this spaces to try to make apperar at the center
		
		getContentPane().setBackground(Color.lightGray);//this sets the color of the background of the panel(window)
		setVisible(true);////if we dont use this, the whole panel remains invisible
	
		//this is a welcome message that appear as soon as we run the program
		JOptionPane.showMessageDialog(null, "Welcome to STOCKER, a program to store and manage products."
											+"\nPlease keep the current window size for a better experience."
											, "WELCOME",JOptionPane.INFORMATION_MESSAGE);
		//this message follows the previos message and gives the user information on how to use the program	
		JOptionPane.showMessageDialog(null, "Use the ADD PRODUCT section at the top to add a product."
											+"\nUse the middle panel sections to manage your products and add stock, re-price or sell."
											+"\nGet product information using the SEARCH and DISPLAY ALL PRODUCTS bottons."
											+"\n\nAlternatively, use the 'Help' button located at the top left to get help on how to use Stocker."
											, "USEFUL INFORMATION",JOptionPane.INFORMATION_MESSAGE);//as part of the syntaxis, we use a comma and then the titlle we want to dispaly in the window message									
	}
	
	
	//this method helps us to find the index of the array by looking to its product name
	private int search(String productNameIn)
	{
		for(int i=0; i< total; i++)//in this for loop we dont go throughout all the array, we just go as big as the value of the variable 'total', and we make the loop more efficient
		{
			//Product tempProduct= myProducts[i];// this is in comment as I need to ask Aaron why they used this in the book
			String TempName= myProducts[i].getName();//this creates a string to hold the name of the product at the indice "i" to then compare it with the
			                                         //name we recive in the method paramiter (productNameIn)
			if (TempName.equals(productNameIn))//this makes the comparison with the 2 strings, if they are equal, then the method return the indice of the array
			                                   //that has that name.
			{
				return i;//here we are returning the indice of the array that contains the nama the user entered
			}
			
		}
		return -999;//we use this number to return an error		
	}
	
	
	public void actionPerformed(ActionEvent e)//here are all the events when the user clicks on the different buttons that apperar in the GUI
	{
		if(e.getSource()==addMI)//when user click on the 'how to add a product' menu from the 'Help' button
		{
			displayArea.setText("HOW TO ADD A PRODUCT"+"\n\nIn order to add a product just follow this steps:\n\n"
								+"1) Enter the name you want to assing to the product in the 'Set the name' field."
								+"\n2) Enter the amount you want assign as the initial stock for the product using the 'Set initial stock' field.\n"
								+"3) Enter the price you want to assing to the product using the 'Set Price' field.\n"
								+"4) Click on the 'Add' button to add the product."
								+"\n\nPlease note that no 2 products can have the same name, therefore always ase a unique name for each product." );
		}
		
		if(e.getSource()==manageMI)//when user click on the 'how to manage products' menu from the 'Help' button
		{
			displayArea.setText( "HOW TO MANAGE YOUR PRODUCTS\n"
								+"\nYou can manage your products using the middle panel functions."
								+"\nIn this section you can add stock, set a new price or sell a product."
								+"\n\nPlease follow this steps to ADD STOCK:"
								+"\n1) Enter the name of the product for wich you want to add stock using the 'Enter the name of the product' field.  Please ensure you enter the correct product name."
								+"\n2) Enter the amount you want to add to stock using the 'Amount to add to stock' field.  Please note that this functionality add stock to the current stock, it does not set a new stock."
								+"\n3) Click on the 'Re-stock' botton."
								+"\n\nPlease follow this steps to assing an existing product a NEW PRICE:"
								+"\n1) Enter the name of the product for wich you want to set a new price using the 'Enter the name of the product' field.  Please ensure you enter the correct product name."
								+"\n2) Enter the new price using the 'Set new price' field. Please ensure you use the correct number format. Decimal numbers must be separated by a period instead of a comma."
								+"\n3) Click on the 'Set' button to set the new price."
								+"\n\nPlease follow this steps to SELL A PRODUCT:"
								+"\n1) Enter the name of the product you want to sell using the 'Enter the name of the product' field.  Please ensure you enter the correct product name. "
								+"\n2) Enter the amount of units you want to sell using the 'Amoun to sell' field.  Please note you can only sell an amount equal or less than the current stock level."
								+"\n3) Click on the 'Sell' button.");	
		}
		
		if(e.getSource()== infoMI)//when user click on the 'how to get products info' menu from the 'Help' button
		{
			displayArea.setText( "HOW TO GET INFORMATION FROM THE PRODUCTS"
								+"\n\nUse this section to GET INFORMATION from the products."
								+"\nPlease folow this steps to search for a product:"
								+"\n1) Enter the name of the product you want to search for using the 'Enter the name of the product' field.  Please ensure you enter the product name correctly"
								+"\n2) Click on the 'Search' button. The display panel at the buttom will show the information of the product."
								+"\n\nHOW TO DISPLAY ALL PRODUCTS"
								+"\nSimply click on the 'Display all products' button and the display panel will show you the full list of the products created."
								+"" );
		}
		try//we use try as part of the error habdling, we initialize the try whereever we expect we maight have error, input error in this case.
		{  //at the end, there is a 'catch' statement than defines the type of error we are trying to catch. an example of how the 'try and catch' function works is...
		   //if for example we are expecting an integer and the user enters a double, or a character, we catch this errors to avoid the program to crash.(if we do not catch errors, the system will crah)	
			
			//add funtion
			if(e.getSource()==addProductB)//if addProduct button is pressed
			{
				if(addNameF.getText().length()==0 && addStockF.getText().length()==0 && addPriceF.getText().length()==0)//this checks if the user left all or some fields blank
				{
					JOptionPane.showMessageDialog
					(null,"Please fill out all fields to add a product!",
					"Error",JOptionPane.ERROR_MESSAGE);
				}
				
				else if(addNameF.getText().length()== 0)//error if user left the name field blank
				{
					JOptionPane.showMessageDialog
					(null,"Please enter the product name!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(addStockF.getText().length()== 0)//error if user left the stock field blank
				{
					JOptionPane.showMessageDialog
					(null,"Please enter the product initial stock!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(addPriceF.getText().length()== 0)//error if user left the price field  blank
				{
					JOptionPane.showMessageDialog
					(null,"Please enter the product price!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(Integer.parseInt(addStockF.getText())< 0)//error if user enters a stock less than 0, meaning using negative numbers
				{
					JOptionPane.showMessageDialog
					(null,"Initial stock cannot be less than 0!\nPlease try again!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(Double.parseDouble(addPriceF.getText())<= 0)//error if user enters a price less or equal than 0, meaning using negative numbers
				{
					JOptionPane.showMessageDialog
					(null,"Price cannot be equal or less than 0!\nPlease try again!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else
				{
					if(total ==0)//this allow to create the first product without cheking if duplicated items
					{
						myProducts[total]=new Product(addNameF.getText().toUpperCase(), Integer.parseInt(addStockF.getText()),Double.parseDouble(addPriceF.getText()));//this creates a product object by calling the construct and using as parameters the information entered by the user. creates the object at the indice defined by the 'total' variable
						
						displayArea.setText("\n You have created the following product:\n"
							                +" Product name: " + myProducts[total].getName() + "\n"
							                +" Initial stock: " + myProducts[total].getStockLevel() + "\n"
							                +" Price: " + myProducts[total].getPrice() + "\n\n\n"
							                +" Total number of products created: " + (total + 1));
						total ++;//this incremets by one the 'total'variable, this allow us to create the next object at the following indice, for example, if we create a product object, the firt indice will be 'total'= 0, by doing toal++; we add 1 to the 'total' variable, so the next indice will be total=1
						addNameF.setText("");
						addStockF.setText("");
						addPriceF.setText("");
						counter.setText("                                                           Total products: "+total);//this updates the text label that apperar at the buttom of the window
					}
					else
					{
						if( search(addNameF.getText().toUpperCase())==  -999)//we do this to avoid the user to create 2 products with the same name. the search method returns -999 if the name the user entered does not exist. if the name does not exist menas we can create such product.
						{
							myProducts[total]=new Product(addNameF.getText().toUpperCase(), Integer.parseInt(addStockF.getText()),Double.parseDouble(addPriceF.getText()));
						
							displayArea.setText("\n You have created the following product:\n"
							                +" Product name: " + myProducts[total].getName() + "\n"
							                +" Initial stock: " + myProducts[total].getStockLevel() + "\n"
							                +" Price: " + myProducts[total].getPrice() + "\n\n\n"
							                +" Total number of products created: " + (total + 1));
							total ++;
							addNameF.setText("");
							addStockF.setText("");
							addPriceF.setText("");
							counter.setText("                                                           Total products: "+total);
						}
						
						else//if the number returned by the search method is not -999 that means that the name is already in use by other product, we display and error message saying the name is in use.
						{   //this way we avoid creating two products with the same name
							JOptionPane.showMessageDialog
							(null,"No 2 products can have the same name!\nThis name is already in use.\nPlease enter a different name.",
							"Error",JOptionPane.ERROR_MESSAGE);	
						}
					}
					
					
					
					
				   
				   
				}			
			}
			
			if(e.getSource()== reStockB)//if reStock button is pressed
			{
				String nameEnteredFunction= reStockNameF.getText().toUpperCase();
				String quantityEnteredFunction= reStockQuantityF.getText();
				
				if (total==0)//if there are no produts created and the user clicks on the restock button, we disply this error
				{
					JOptionPane.showMessageDialog
					(null,"The are no products added, please add a product first!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(nameEnteredFunction.length()==0 || quantityEnteredFunction.length()==0)//this checks if the user left all or some fields blank
				{
					JOptionPane.showMessageDialog
					(null,"Please enter the name of the product and the amount to add to stock!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(Integer.parseInt(quantityEnteredFunction)<0)//this prevets the user to enter negative numbers
				{
					JOptionPane.showMessageDialog
					(null,"Negative numbers cannot be assign to stock!\nPlease try again",
					"Error",JOptionPane.ERROR_MESSAGE);		
				}
				
				else
				{
					int x= search(nameEnteredFunction);//we assing to the variable x the integer that the search method returned, meaning the indice of the array where the object with the name the user entered is!
					if(x == -999)//this displays an error if the name the user entered does not exist
					{
						JOptionPane.showMessageDialog
						(null,"No such product, please enter the product name correctly!",
						"Error",JOptionPane.ERROR_MESSAGE);	
					}
					else//this enables the restocking
					{
						myProducts[x].reStock(Integer.parseInt(quantityEnteredFunction));
						displayArea.setText("\n You added stock to the following product: \n"
							                + " Product name: " + myProducts[x].getName()
							                + "\n New stock: " + myProducts[x].getStockLevel());
						reStockNameF.setText("");
						reStockQuantityF.setText("");
					}				
				}				
			}//end if
			
			if(e.getSource()== rePriceB)//if the user click ob the reprice button this happnes...
			{
				String nameEnteredFunction= reStockNameF.getText().toUpperCase();
				String priceEntered= rePriceNewPriceF.getText();
				
				if (total==0)//if there are no produts created and the user clicks on the reprice button, we display this error
				{
					JOptionPane.showMessageDialog
					(null,"The are no products added, please add a product first!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(nameEnteredFunction.length()==0 || priceEntered.length()==0)//if the user left fields blank
				{
					JOptionPane.showMessageDialog
					(null,"Please enter the name of the product and the new price",
					"Error",JOptionPane.ERROR_MESSAGE);		
				}
				
				else if(Double.parseDouble(priceEntered)<0)//avoid user to enter negative numbers
				{
				    JOptionPane.showMessageDialog
					(null,"Negative numbers cannot be assign to the price!\nPlease try again.",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else
				{
					int x= search(nameEnteredFunction);
					if(x== -999)//if the name the user enterd does not exist
					{
						JOptionPane.showMessageDialog
						(null,"No such product, please enter the product name correctly!",
						"Error",JOptionPane.ERROR_MESSAGE);
					}
					else
					{//we enable the re price function
						myProducts[x].setPrice(Double.parseDouble(priceEntered));
						displayArea.setText("\nYou have updated the price for the following product:\n"
							                + "Product name: " + myProducts[x].getName()
							                + "\nNew price: " + myProducts[x].getPrice());
						reStockNameF.setText("");
						rePriceNewPriceF.setText(""); 		                	
					}
				}
			}//end if
			
			if(e.getSource()== sellB)//if user clicks on the 'sell' button this happends...
			{
				String nameEnteredSell= reStockNameF.getText().toUpperCase();
				String amountToSellEntered= sellQuantityF.getText();
				
				if (total==0)//if there are no produts created and the user clicks on the sell button, we disply this error
				{
					JOptionPane.showMessageDialog
					(null,"The are no products added, please add a product first!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(nameEnteredSell.length()==0 || amountToSellEntered.length()==0)//if user left fields in blank
				{
					JOptionPane.showMessageDialog
					(null,"Please enter the name of the product and the quantity you want to sell!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(Integer.parseInt(amountToSellEntered)<0)//prevents the user to enter negative numbers
				{
					JOptionPane.showMessageDialog
					(null,"Negative numbers cannot be assign to the amount you want to sell!\nPlease try again",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
		
				else
				{
					int x= search(nameEnteredSell);
					if (x== -999)//if the name the user enterd does not exist
					{
						JOptionPane.showMessageDialog
						(null,"No such product, please enter the product name correctly!",
						"Error",JOptionPane.ERROR_MESSAGE);	
					}
					
					else if(Integer.parseInt(amountToSellEntered) > myProducts[x].getStockLevel())//this is a check to make sure we have enough number of units of an item in stock to sell
					{
							JOptionPane.showMessageDialog
							(null,"Not enough items in stock to sell!\nPlease enter a quantity to sell less than or equal to: "+ myProducts[x].getStockLevel()+".",
							"Error",JOptionPane.ERROR_MESSAGE);		
					}
						
					else
					{	//enables the sell function
						myProducts[x].sell(Integer.parseInt(amountToSellEntered));
						displayArea.setText("\nYou sold " +amountToSellEntered +" units of "
							                + myProducts[x].getName()+ "\nThe total price of the sell was: "
							                + Integer.parseInt(amountToSellEntered) * myProducts[x].getPrice()+".\n"
							                +"The new stock for "+myProducts[x].getName() +" is: "+ myProducts[x].getStockLevel());
						reStockNameF.setText("");
						sellQuantityF.setText("");
					}
				}		
			}//end if
			
			if (e.getSource()== infoB)
			{
				String nameEnteredInfo= infoNameF.getText().toUpperCase();
				if (total==0)//if there are no products created and the user click on the search button
				{
					JOptionPane.showMessageDialog
					(null,"The are no products added, please add a product first!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
			
				else if(nameEnteredInfo.length()==0)//if the user left fields blank
				{
					JOptionPane.showMessageDialog
					(null,"Please enter the name of the product you want to see the details",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				else
				{
					int x=search(nameEnteredInfo);
					if (x== -999)//if the name the user entered does not exist
					{
						JOptionPane.showMessageDialog
						(null,"No such product, please enter the product name correctly!",
						"Error",JOptionPane.ERROR_MESSAGE);	
					}
					else
					{
						displayArea.setText("PRODUCT INFORMATION:\nProduct name: "+ myProducts[x].getName()
											+"\nProduct stock: " +myProducts[x].getStockLevel()
											+"\nProduct price: "+myProducts[x].getPrice());
						infoNameF.setText("");					
					}	
				}
			}//end if
			
			if(e.getSource()==infoDisplayB)//if the user clicks on the 'display all products' button
			{
				if (total==0)//if the user click on the button and there are no products created
				{
					JOptionPane.showMessageDialog
					(null,"The are no products added, please add a product first!",
					"Error",JOptionPane.ERROR_MESSAGE);	
				}
				
				else
				{
					displayArea.setText ("");
					displayArea.setText("                                                                                                                          "
									   +("LIST OF PRODUCTS\n"));//this prints a header at the top of the display area panel
						                                                                                
					for(int i=0; i<total;i++)//this loops goes as big as far as the value of the 'total' variable and prints tha details of each product created
					{	
					displayArea.setText(	displayArea.getText()// this takes what is on the display panel and keep it, then it adds the new information. basically this prints the information of the first product, and then without ereasing anything prints the info of the second product and so on
											//if we dont do this, the display area will only display the information of the last product
											+("...................................................................................................................................................")
												+("...................................................................................................................................................")
											+(".........................................................................\n")
											+("  #")+(i+1)+("\n")
						                    +("       Product name...: ")+myProducts[i].getName()
											+"\n       Product stock....: "+ myProducts[i].getStockLevel()
											+"\n       Product price.....: "+ myProducts[i].getPrice()+"\n\n" 
										   );
										   
					}
				}	
			}
		}//end try
		catch(NumberFormatException x)//if the user entered the wrong number format, this error is catched and we display a error message
		{
			JOptionPane.showMessageDialog
			(null,"Please enter the correct number format!",
			"Error",JOptionPane.ERROR_MESSAGE);	
		}
	}//end actionperfomed
		
	
}//end gui
