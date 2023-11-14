package GroupTask1;
import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) 
	{
	
		Scanner s = new Scanner(System.in);
		
		int numCOL, numROW;
		String input; 
	
		System.out.println();
		System.out.println("TWO DIMENSIONAL ARRAY");
		System.out.println();
		
		do 
		{
		    System.out.print("Enter number of columns (Maximum 10): "); // ASKING THE USER TO ENTER 10 MAX NUMBERS
		    numCOL = s.nextInt();
		    if (numCOL >= 10) 
		    {
		        System.out.print("Please enter a value less than or equal to 10: "); 
		    }
		} while (numCOL >= 10);

		do 
		{
		    System.out.print("Enter number of rows (Maximum 10): "); // ASKING THE USER TO ENTER 10 MAX NUMBERS
		    numROW = s.nextInt();
		    if (numROW >= 10) 
		    {
		        System.out.print("Please enter a value less than or equal to 10: ");
		    }
		} while (numROW >= 10);
		
		int[][] table = new int [numROW][numCOL];
		
		
		System.out.println();
		System.out.println("Enter the values for the 2d Array: ");
		
		for(int i = 0; i < numROW; i++)
		{
			for(int j = 0; j < numCOL; j++)
			{
				System.out.print("Row [" + (i + 1) + "] Column [" + (j + 1) + "] : ");
				table[i][j] = s.nextInt();
			}
				
		}
		
		int option;
		while(true)
		{
			System.out.println();
			System.out.println("Menu: Array");
			System.out.println("[1]: Display Array");
			System.out.println("[2]: Search Array");
			System.out.println("[3]: Update Array");
			System.out.println("[4]: Delete Array");
			System.out.println("[5]: Exit");
			
			System.out.println();
			System.out.print("Choose Option: ");
			option = s.nextInt();
				
			
			switch(option)
			{
			
				case 1: // DISPLAY ARRAY
				{
				    do 
				    {
				        System.out.println("Elements in the 2D Array: ");
				        for (int i = 0; i < numROW; i++) 
				        {
				            for (int j = 0; j < numCOL; j++) 
				            {
				                System.out.print(table[i][j] + " ");
				            }
				            System.out.println();
				        }
	
				        System.out.println();
				        System.out.print("Do you want to display the array again (Y | N): "); // ASKING THE USER IF THEY WANT TO DISPLAY THE ARRAY AGAIN.
				        input = s.next();
	
				        if (input.equalsIgnoreCase("n")) 
				        {
				            break;
				        } 
				        else if (!input.equalsIgnoreCase("y")) 
				        {
				            System.out.print("Please enter valid input (Y | N): ");
				            input = s.next();
				        }
				    } while (input.equalsIgnoreCase("y"));
				    break;
				}
	
				case 2: // SEARCHING ARRAY
				{
				    do
			    	{
				    	System.out.println("Enter the position you want to search");
					
    					while(true)
    					{
    						System.out.print("Row: ");
    						numROW = s.nextInt();
    						
    						if(numROW < 1 || numROW > table.length)
    						{
    							System.out.print("Invalid Row Range. Please enter the valid range.");
    							System.out.println();
    						}
    						else
    						{
    							break;
    						}
    					}
    					
    					while(true)
    					{
    						System.out.print("Column: ");
    						numCOL = s.nextInt();
    						
    						if(numCOL < 1 || numCOL > table[0].length)
    						{
    							System.out.print("Invalid Column Range. Please enter the valid range.");
    							System.out.println();
    						}
    						else
    						{
    							break;
    						}
    						
    					}
    			
    					numROW--;
    					numCOL--;	
    						
    					for(int i = 0; i <= numROW; i++)
    					{
    						for(int j = 0; j <= numCOL; j++)
    						{
    							if( i == numROW && j == numCOL)
    							{
    								System.out.print("Value is " + table[numROW][numCOL]);
    								System.out.println();
    							}
    						}
    					}
    	
    					System.out.println();
    				        System.out.print("Do you want to search a value in the array again (Y | N): ");
    				        input = s.next();
    	
    				        if (input.equalsIgnoreCase("n")) 
    				        {
    				            break;
    				        } 
    				        else if (!input.equalsIgnoreCase("y")) 
    				        {
    				            System.out.print("Please enter valid input (Y | N): ");
    				            input = s.next();
    				        }
				    } while (input.equalsIgnoreCase("y"));
				    break;
				}
					
				case 3: // UPDATE ARRAY
				{
				    do
				    {
				        System.out.println("Enter the position of the value you want to update");
						int upd_numROW, upd_numCOL;
						
						while(true)
						{
							System.out.print("Row: ");
							upd_numROW = s.nextInt();
							
							if(upd_numROW < 1 || upd_numROW > table.length)
							{
								System.out.print("Invalid Row Range. Please enter the valid range.");
								System.out.println();
							}
							else
							{
								break;
							}
						}
	
						while(true)
						{
							System.out.print("Column: ");
							upd_numCOL = s.nextInt();
							
							if(upd_numCOL < 1 || upd_numCOL > table[0].length)
							{
								System.out.print("Invalid Column Range. Please enter the valid range.");
								System.out.println();
							}
							else
							{
								break;
							}
						}
						
						
						upd_numROW--;
						upd_numCOL--;
						
						for (int i = 0; i < table.length; i++) {
							for (int j = 0; j < table[i].length; j++) {
								if (i == upd_numROW && j == upd_numCOL) {
									System.out.print("Enter the value you want to update at Row[" + (i + 1) + "] Column[" + (j + 1) + "] : ");
									int newValue = s.nextInt();
									
									table[upd_numROW][upd_numCOL] = newValue;
									System.out.println();
									System.out.println("Value updated successfully.");
									break;
								}
							}
						}
						
						System.out.println();
				        System.out.print("Do you want to update the value in the array again (Y | N): ");
				        input = s.next();
	
				        if (input.equalsIgnoreCase("n")) 
				        {
				            break;
				        } 
				        else if (!input.equalsIgnoreCase("y")) 
				        {
				            System.out.print("Please enter valid input (Y | N): ");
				            input = s.next();
				        }
				    } while (input.equalsIgnoreCase("y"));
				    break;	
				}
				
				case 4: // DELETE ARRAY
				{
					do
					{
					    System.out.println("Enter the position of the value you want to delete");
						int del_numROW, del_numCOL;
						
						while(true)
						{
							System.out.print("Row: ");
							del_numROW = s.nextInt();
							
							if(del_numROW < 1 || del_numROW > table.length)
							{
								System.out.print("Invalid Row Range. Please enter the valid range.");
								System.out.println();
							}
							else
							{
								break;
							}
						}

						while(true)
						{
							System.out.print("Column: ");
							del_numCOL = s.nextInt();
							
							if(del_numCOL < 1 || del_numCOL > table[0].length)
							{
								System.out.print("Invalid Column Range. Please enter the valid range.");
								System.out.println();
							}
							else
							{
								break;
							}
						}
						
						del_numROW--;
						del_numCOL--;
						
						for(int i = 0; i <= del_numROW; i++)
						{
							for(int j = 0; j <= del_numCOL; j++)
							{
								if( i == del_numROW && j == del_numCOL)
								{
								
									table[del_numROW][del_numCOL] = 0;
									System.out.println();
									System.out.println("Value deleted successfully.");
									break;
								}
							}
						}
						
						System.out.println();
				        System.out.print("Do you want to delete a value in the array again (Y | N): ");
				        input = s.next();
	
				        if (input.equalsIgnoreCase("n")) 
				        {
				            break;
				        } 
				        else if (!input.equalsIgnoreCase("y")) 
				        {
				            System.out.print("Please enter valid input (Y | N): ");
				            input = s.next();
				        }
				    } while (input.equalsIgnoreCase("y"));
				    break;
				}
	
				case 5: // EXIT ARRAY
			    {
			        System.out.println();
			        System.out.print("Do you want to exit (Y | N)? ");
			        input = s.next();

			        if (input.equalsIgnoreCase("Y")) 
			        {
			        	System.out.println();
			            System.out.println("Exiting program.");
			            System.out.println("Thank you for using the program.");
			            return;
			        } 
			        else if (input.equalsIgnoreCase("N")) 
			        {
			            
			        } 
			        else {
			            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
			        }
			        break;
			    }
				
				default:
					System.out.println("ERROR. Invalid Input!");
					System.out.println("Please try again");
					break;
			}	
		}
	}
}
