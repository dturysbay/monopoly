import java.util.ArrayList;

public class Property implements General{
    private String name;
    private String color;
    private int price;
    private int tax;
    private Player owner;
    private boolean propertyCanBeOwned;
    private ArrayList<Estate> estates;
    private ArrayList<Estate> estateHotels;

    public Property(String name, String color, int price, int tax, boolean propertyCanBeOwned) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.tax = tax;
        this.propertyCanBeOwned = propertyCanBeOwned;
        this.owner = null;
        this.estates = new ArrayList<>();
        this.estateHotels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getTax() {
        return tax;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    public boolean isOwned() {
        return owner != null;
    }

    public boolean isPropertyCanBeOwned() {
        return propertyCanBeOwned;
    }

    public void setPropertyCanBeOwned(boolean propertyCanBeOwned) {
        this.propertyCanBeOwned = propertyCanBeOwned;
    }

    public ArrayList<Estate> getEstates() {
        return estates;
    }

    public void addEstate(Estate estate,Player player){
        estates.add(estate);
        estate.setOwner(player);
    }

    public void displayCongratulationMessage(){
        System.out.println("Congratulations! "+"Property "+this.getName()+" belongs to "+this.getOwner().getName());
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public void displayInfo(){
        System.out.println(Constant.LEFT_ARROW + this.getName());
        System.out.println(Constant.LEFT_ARROW + this.getColor());
        System.out.println(Constant.LEFT_ARROW + this.getPrice());
        System.out.println(Constant.LEFT_ARROW + this.getTax());
    }
}
