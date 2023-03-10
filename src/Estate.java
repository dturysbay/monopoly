public class Estate {
    private int taxForEstate = 200;
    private String name;
    private Player owner;
    private Integer tax;
    public Estate(){}
    public Estate(String name){
        this.name = name;
    }

    public Integer getTax() {
        return tax;
    }

    public int getTaxForEstate() {
        return taxForEstate;
    }

    public void setTaxForEstate(int taxForEstate) {
        this.taxForEstate = taxForEstate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
