import java.util.Scanner;

public class ShoppingCartManager {
    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
        System.out.println();
    }

    public static void outputShoppingCart(ShoppingCart cart){
        System.out.println("\nOUTPUT SHOPPING CART");
        cart.printTotal();
        System.out.println();
    }
    public static void outputItemDescriptions (ShoppingCart cart){
        System.out.println("\nOUTPUT ITEMS' DESCRIPTION");
        cart.printDescriptions();
        System.out.println();
    }
    public static void addItem(ShoppingCart cart, Scanner scnr){
        ItemToPurchase item = new ItemToPurchase();
        System.out.println("\nADD ITEM TO CART");
        System.out.println("Enter the item name:");
        String name = scnr.nextLine();
        item.setName(name);
        System.out.println("Enter the item description:");
        String description = scnr.nextLine();
        item.setDescription(description);
        System.out.println("Enter the item price:");
        int price = scnr.nextInt();
        item.setPrice(price);
        System.out.println("Enter the item quantity:");
        int quantity = scnr.nextInt();
        item.setQuantity(quantity);
        cart.addItem(item);
    }
    public static void removeItem(ShoppingCart cart, Scanner scnr){
        System.out.println("\nREMOVE ITEM FROM CART");
        System.out.println("Enter name of item to remove:");
        String name = scnr.nextLine();
        cart.removeItem(name);
    }
    public static void changeItemQuantity(ShoppingCart cart, Scanner scnr){
        ItemToPurchase item = new ItemToPurchase();
        System.out.println("\nCHANGE ITEM QUANTITY");
        System.out.println("Enter the item name:");
        item.setName(scnr.nextLine());
        scnr.nextLine();
        System.out.println("Enter the new quantity:");
        item.setQuantity(scnr.nextInt());
        cart.modifyItem(item);

    }

    public static void executeMenu(char choice, ShoppingCart cart, Scanner scnr) {
        switch (choice)
        {
            case 'a':
                addItem(cart, scnr);
                break;
            case 'd':
                removeItem(cart, scnr);
                break;
            case 'c':
                changeItemQuantity(cart, scnr);
                break;
            case 'i':
                outputItemDescriptions (cart);
                break;
            case 'o':
                outputShoppingCart(cart);
                break;
            case 'q':
                System.out.println("quit!");
                break;
            default:
                System.out.println("Please enter a valid option.");
                break;
        }
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String customerName;
        String date;
        char choice = ' ';

        System.out.println("Enter Customer's Name:");
        customerName = scnr.nextLine();
        System.out.println("Enter Today's Date:");
        date = scnr.nextLine();
        System.out.println("\nCustomer Name: " + customerName);
        System.out.println("Today's Date: " + date + "\n");

        ShoppingCart cart = new ShoppingCart(customerName, date);

        while(true)
        {
            printMenu();
            System.out.println("Choose an option: ");
            choice = scnr.next().charAt(0);
            scnr.nextLine();
            if (choice == 'q')
            {
                break;
            }
            if (choice == 'a' || choice == 'd' || choice == 'c' || choice == 'i' || choice == 'o')
            {
                executeMenu(choice, cart, scnr);
            }
            else
            {
                boolean check = true;
                while(check)
                {
                    System.out.println("Choose an option: ");
                    choice = scnr.next().charAt(0);
                    scnr.nextLine();
                    if (choice == 'a' || choice == 'd' || choice == 'c' || choice == 'i' || choice == 'o')
                    {
                        check = false;
                        executeMenu(choice, cart, scnr);
                    }
                }
            }
        }
    }


}