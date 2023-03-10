import java.util.ArrayList;

public class Board {
    private ArrayList<Property> properties;
    private ArrayList<Chance> chances;
    public Board(ArrayList<Property> properties,ArrayList<Chance> chances) {
        this.properties = properties;
        this.chances = chances;
    }

    public ArrayList<Chance> getChances() {
        return chances;
    }

    public void setChances(ArrayList<Chance> chances) {
        this.chances = chances;
    }

    public int getPropertiesSize(){
        return properties.size();
    }
    public Property getProperty(int position) {
        return properties.get(position);
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public Board(){
        this.properties = new ArrayList<>();
        this.properties.add(new Property(Constant.GO, Constant.NONE, 0, 0,false));
        this.properties.add(new Property(Constant.MEDITERRANEAN_AVENUE, Constant.PURPLE, 60, 2,true));
        this.properties.add(new Property(Constant.COMMUNITY_CHEST, Constant.NONE, 0, 0,false));
        this.properties.add(new Property(Constant.BALTIC_AVENUE, Constant.PURPLE, 60, 4,true));
        this.properties.add(new Property(Constant.INCOME_TAX, Constant.NONE, 0, 0,false));
        this.properties.add(new Property(Constant.READING_RAILROAD, Constant.NONE, 200, 25,true));
        this.properties.add(new Property(Constant.ORIENTAL_AVENUE, Constant.LIGHT_BLUE, 100, 6,true));
        this.properties.add(new Property(Constant.CHANCE, Constant.NONE, 0, 0,false));
        this.properties.add(new Property(Constant.VERMONT_AVENUE, Constant.LIGHT_BLUE, 100, 6,true));
        this.properties.add(new Property(Constant.CONNECTICUT_AVENUE, Constant.LIGHT_BLUE, 120, 8,true));
        this.properties.add(new Property(Constant.JUST_VISITING, Constant.NONE, 0, 0,false)); // !JAIL
        this.properties.add(new Property(Constant.ST_CHARLES_PLACE, Constant.PINK, 140, 10,true));
        this.properties.add(new Property(Constant.ELECTRIC_COMPANY, Constant.NONE, 150, 0,true));
        this.properties.add(new Property(Constant.STATES_AVENUE, Constant.PINK, 140, 10,true));
        this.properties.add(new Property(Constant.VIRGINIA_AVENUE, Constant.PINK, 160, 12,true));
        this.properties.add(new Property(Constant.PENNSYLVANIA_RAILROAD, Constant.NONE, 200, 25,true));
        this.properties.add(new Property(Constant.ST_JAMES_PLACE,Constant.ORANGE,180,14,true));
        this.properties.add(new Property(Constant.COMMUNITY_CHEST,Constant.NONE,0,0,false));
        this.properties.add(new Property(Constant.TENNESSEE_AVENUE,Constant.ORANGE,180,14,true));
        this.properties.add(new Property(Constant.NEW_YORK_AVENUE,Constant.ORANGE,200,16,true));
        this.properties.add(new Property(Constant.FREE_PARKING,Constant.NONE,0,0,false));
        this.properties.add(new Property(Constant.KENTUCKY_AVENUE,Constant.RED,220,18,true));
        this.properties.add(new Property(Constant.CHANCE,Constant.NONE,0,0,false));
        this.properties.add(new Property(Constant.INDIANA_AVENUE,Constant.RED,220,18,true));
        this.properties.add(new Property(Constant.ILLINOIS_AVENUE,Constant.RED,240,20,true));
        this.properties.add(new Property(Constant.B_RAILROAD,Constant.NONE,200,25,true));
        this.properties.add(new Property(Constant.ATLANTIC_AVENUE,Constant.YELLOW,260,22,true));
        this.properties.add(new Property(Constant.VENTNOR_AVENUE,Constant.YELLOW,260,22,true));
        this.properties.add(new Property(Constant.WATER_WORKS,Constant.NONE,150,10,true)); // tax should be corrected, depends on the results of dice
        this.properties.add(new Property(Constant.MARVIN_GARDENS,Constant.YELLOW,280,24,true));
        this.properties.add(new Property(Constant.GO_TO_JAIL,Constant.NONE,0,0,false));
        this.properties.add(new Property(Constant.PACIFIC_AVENUE,Constant.GREEN,300,26,true));
        this.properties.add(new Property(Constant.NORTH_CAROLINA_AVENUE,Constant.GREEN,300,26,true));
        this.properties.add(new Property(Constant.COMMUNITY_CHEST,Constant.NONE,0,0,false));
        this.properties.add(new Property(Constant.PENNSYLVANIA_AVENUE,Constant.GREEN,320,28,true));
        this.properties.add(new Property(Constant.SHORT_LINE_RAILROAD,Constant.NONE,200,0,true));
        this.properties.add(new Property(Constant.CHANCE,Constant.NONE,0,0,false));
        this.properties.add(new Property(Constant.PARK_PLACE,Constant.BLUE,350,35,true));
        this.properties.add(new Property(Constant.LUXURY_TAX,Constant.NONE,0,75,false));
        this.properties.add(new Property(Constant.BOARDWALK,Constant.BLUE,400,50,true));


        this.chances = new ArrayList<>();
        chances.add(new Chance("Advance to Go (Collect $200)",1));
        chances.add(new Chance("Bank pays you dividend of $50",2));
        chances.add(new Chance("Go Back 3 Spaces",3));
        chances.add(new Chance("Pay to bank. Pay for each player $50",4));
    }
}
