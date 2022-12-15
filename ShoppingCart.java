import java.util.ArrayList;

public class ShoppingCart
{
    private String customerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> cartItems;

    public ShoppingCart()
    {
        customerName = "none";
        currentDate = "January 1, 2016";
        cartItems = new ArrayList<>();
    }

    public ShoppingCart(String name, String date)
    {
        customerName = name;
        currentDate = date;
        cartItems = new ArrayList<>();
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public String getDate()
    {
        return this.currentDate;
    }

    public void addItem(ItemToPurchase item)
    {
        cartItems.add(item);
    }

    public void removeItem(String itemName)
    {
        boolean check = false;
        for (int i = 0; i < cartItems.size(); i++)
        {
            if (cartItems.get(i).getName().equals(itemName)) {
                check = true;
                cartItems.remove(i);
                break;
            }
        }
        if (check == false)
        {
            System.out.println("Item not found in cart. Nothing removed.");
        }
    }

    public void modifyItem(ItemToPurchase item)
    {
        boolean check = false;
        for (int i = 0; i < cartItems.size(); i++)
        {
            if (cartItems.get(i).getName().equals(item.getName()))
            {
                check = true;
                if (item.getDescription() != "none")
                {
                    cartItems.get(i).setDescription(item.getDescription());
                }
                if (item.getPrice() != 0)
                {
                    cartItems.get(i).setPrice(item.getPrice());
                }
                if (item.getQuantity() != 0)
                {

                    cartItems.get(i).setQuantity(item.getQuantity());
                }
                break;
            }
        }
        if (check == false)
        {
            System.out.println("Item not found in cart. Nothing modified.");
        }
    }

    public int getNumItemsInCart()
    {
        int numItems = 0;
        for (int i = 0; i < cartItems.size(); i++)
        {
            numItems = numItems + cartItems.get(i).getQuantity();
        }
        return numItems;
    }

    public int getCostOfCart()
    {
        int totalCost = 0;
        for (int i = 0; i < cartItems.size(); i++)
        {
            totalCost = totalCost + (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
        }
        return totalCost;
    }

    public void printTotal()
    {
        int cost = 0;
        int total = 0;
        System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate());
        System.out.println("Number of Items: " + getNumItemsInCart() + "\n");
        if (cartItems.size() == 0)
        {
            System.out.println("SHOPPING CART IS EMPTY");
        }

        for (int i = 0; i < cartItems.size(); i ++)
        {
            cost = cartItems.get(i).getPrice() * cartItems.get(i).getQuantity();
            total = total + cost;
            System.out.println(cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity() + " @ $" + cartItems.get(i).getPrice() + " = $" +cost);
        }
        System.out.println("\nTotal: $" + total);
    }

    public void printDescriptions()
    {
        System.out.println(getCustomerName() + "'s - " + getDate() + "\n");
        System.out.println("Item Descriptions");

        for (int i = 0; i < cartItems.size(); i++)
        {
            System.out.println(cartItems.get(i).getName() + ": " + cartItems.get(i).getDescription());
        }
    }

}
