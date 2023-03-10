import java.util.ArrayList;
import java.util.Scanner;

public class Player implements General{
     private String name;
     private int balance = 4455; //-> equivalent of 2 000 000 KZT, 1USD ~ 448.84
     private int position;
     private ArrayList<Property> properties;
     public ArrayList<Property> getProperties() {
          return properties;
     }


     public Player(String name) {
          this.name = name;
          this.position = 0;
          this.properties = new ArrayList<>();
     }

     public String getName() {
          return name;
     }

     public int getBalance() {
          return balance;
     }

     public void addBalance(int amount) {
          balance += amount;
     }

     public void subtractBalance(double amount) {
          balance -= amount;
     }

     public int getPosition() {
          return position;
     }

     public void setPosition(int position) {
          this.position = position;
     }

     public boolean canBuyProperty(Property property) {
          return balance >= property.getPrice();
     }

     public void buyProperty(Property property) {
          subtractBalance(property.getPrice());
          properties.add(property);
          property.setOwner(this);
     }

     public void buyPropertyOnAuction(Property property, Integer auctionPrice){
          subtractBalance(auctionPrice);
          properties.add(property);
          property.setOwner(this);
     }

     public void buyEstate(int priceOfHouse){
          subtractBalance(priceOfHouse);
     }

     public boolean isOwner(Property property) {
          return properties.contains(property);
     }

     public void collectRent(Property property) {
          int rent = property.getTax();
          subtractBalance(rent);
          if(property.getOwner()!=null){
               property.getOwner().addBalance(rent);
          }
     }

     public boolean isBankrupt() {
          return balance < 0;
     }
     @Override
     public void displayInfo() {
          System.out.println(Constant.LEFT_ARROW+getName()+Constant.RIGHT_ARROW);
          System.out.println("Player " + name + " is at position " + position + ".");
          System.out.println("Player " + name + " has $" + balance + " and " + properties.size() + " properties:");
          int index = 0;
          for (Property property : properties) {
               System.out.println(index+1+" " + property.getName());
               index++;
          }
     }

     public int rollDice() {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Player " + name + ", press Enter to roll the dice.");
          scanner.nextLine();
          int dice1 = (int) (Math.random() * 6) + 1;
          int dice2 = (int) (Math.random() * 6) + 1;
          int total = dice1 + dice2;
          System.out.println("Player " + name + " rolled " + dice1 + " and " + dice2 + ".");
          System.out.println("Player " + name + " moves " + total +" rolles");
          return total;
     }
}