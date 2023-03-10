import java.util.ArrayList;

public class Railroad {
    ArrayList<String> railroads;
    public Railroad() {
        this.railroads = new ArrayList<>();
    }

    public ArrayList<String> getRailroads() {
        return railroads;
    }

    public void setRailroads(ArrayList<String> railroads) {
        this.railroads = railroads;
    }

    public void addRailroad(String railroad){
        railroads.add(railroad);
    }
}
