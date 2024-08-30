import java.util.Scanner;
class StationaryShopManagement{
	
	//defining variable
    
	static Scanner sc = new Scanner(System.in);
    static int count = 0;
    static String[] itemName = new String[100];
    static int[] itemPrice = new int[100];
	
	// main method
    
	public static void main(String[] args) {
	       
	   int choice;
        do {
			
			//take choice as an input from user
			
   		    System.out.println("\n\nStationary Shop Management System");
			System.out.println();
            System.out.println("1. Add item");
			System.out.println();
            System.out.println("2. Display items");
			System.out.println();            
			System.out.println("3. Modify item");
			System.out.println();            
			System.out.println("4. Delete item");
			System.out.println();        
			System.out.println("5. Exit");
			System.out.println();            
			System.out.print("Enter your choice: ");
            choice = sc.nextInt();
			System.out.println();		
			System.out.println();
			//switch case
            
			switch (choice) {
                case 1:
                    addItem();
					System.out.println();
					//calling the method addItem
                    break;
                case 2:
                    displayItems();
					System.out.println();
					//calling the method displayItems
                    break;
                case 3:
                    modifyItem();
					System.out.println();
					//calling the method modifyItem
                    break;
                case 4:
                    deleteItem();
					System.out.println();
					//calling the method deleteItem
                    break;
                case 5:
                    printBill();
					System.out.println();
					//for exit button....     calling the method printBill and exit the code. 
                    System.out.println("Exiting program...");
					System.out.println();
                    break;
                default:
				//for invalid choice 
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    } 
		
		
		
		
	//method for add items in array.
    public static void addItem() {
        System.out.print("Enter item name: ");
        sc.nextLine();
        String name = sc.nextLine();
		System.out.println();
        System.out.print("Enter item price: ");
        int price = sc.nextInt();
		System.out.println();
        itemName[count] = name;
        itemPrice[count] = price;
        count++;
        System.out.println("Item added successfully.");
		System.out.println();
    }
	
		
		
		//method for display items
    public static void displayItems() {
        System.out.println("\n\nList of items:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + itemName[i] + " - " + itemPrice[i]);
			System.out.println();
        }
    }
		
		
		
		//method for modify item in array
    public static void modifyItem() {
        System.out.print("Enter item number to modify: ");
        int itemNumber = sc.nextInt() - 1;
        if (itemNumber < 0 || itemNumber >= count) {
            System.out.println("Invalid item number. Please try again.");
            return;
        }
        System.out.print("Enter new item name: ");
        sc.nextLine();
        String name = sc.nextLine();
		System.out.println();
        System.out.print("Enter new item price: ");
        int price = sc.nextInt();
		System.out.println();
        itemName[itemNumber] = name;
        itemPrice[itemNumber] = price;
        System.out.println("Item modified successfully.");
    }



		//method for delete item in array
    public static void deleteItem() {
        System.out.print("Enter item number to delete: ");
        int itemNumber = sc.nextInt() - 1;
		System.out.println();
        if (itemNumber < 0 || itemNumber >= count) {
            System.out.println("Invalid item number. Please try again.");
            return;
        }
        for (int i = itemNumber; i < count - 1; i++) {
            itemName[i] = itemName[i + 1];
            itemPrice[i] = itemPrice[i + 1];
        }
        count--;
        System.out.println("Item deleted successfully.");
		System.out.println();
    }
		
		
		
		
		//method for printbill and exit the program
    public static void printBill() {
        System.out.println("\n\nStationary Shop Bill");
        System.out.println("---------------------");
		System.out.println();
        int total = 0;
        for (int i = 0; i < count; i++) {
            System.out.println(itemName[i] + " - " + itemPrice[i]);
            total += itemPrice[i];
        }
       


    double GST = 0.18; // 18% GST
    double gstAmount = total * GST;
    double grandTotal = total + gstAmount;
    System.out.println("---------------------");
    System.out.println("Total (without GST): " + total);
    System.out.println("GST (18%): " + gstAmount);
    System.out.println("Grand Total: " + grandTotal);
	}
}
