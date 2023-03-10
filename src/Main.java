import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        start();
    }
    public static ArrayList<Player> registration( Integer numberOfPlayers,Scanner in){
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = in.next();
            players.add(new Player(name));
        }
        return players;
    }

    public static void ownTheProperty(Property property, Player player,ArrayList<Player> players,Board board, Scanner in){
        //                own the property method
        boolean isRailroad = property.getName().equals(Constant.B_RAILROAD) ||
                property.getName().equals(Constant.READING_RAILROAD) ||
                property.getName().equals(Constant.PENNSYLVANIA_RAILROAD) ||
                property.getName().equals(Constant.SHORT_LINE_RAILROAD);
        System.out.println("Current position is: " + property.getName());
        System.out.println("Dear Player " + player.getName() + " would you like to own the property?");
        String answer = in.next();
        if (answer.equalsIgnoreCase("yes")) {
            property.setOwner(player);
            player.buyProperty(property);
            property.displayCongratulationMessage();
            player.subtractBalance(property.getPrice());
            if(isRailroad){
                Railroad railroad = new Railroad();
                railroad.addRailroad("railroad");
                int railroadsAmount = railroad.getRailroads().size();
                board.getProperties().get(5).setTax(railroadsAmount*25);
            }
        } else {
            //                    Auction if current player rejects to buy the property
            HashMap<Player, Integer> auction = new HashMap<>();
            for (Player playerOfAuction : players) {
                if (!playerOfAuction.getName().equals(player.getName())) {
                    System.out.println("Auction starts");
                    System.out.println(playerOfAuction.getName() + " please enter the price you offer");
                    int price = in.nextInt();
                    auction.put(playerOfAuction, price);
                }
            }
            for (Player playerOfAuction : auction.keySet()) {
                System.out.println(playerOfAuction.getName() + " Offered to buy for " + auction.get(playerOfAuction));
            }

            Player offeredMaxPlayer = auction.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            Integer offeredMaxPlayerPrice = auction.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
            offeredMaxPlayer.buyPropertyOnAuction(property,offeredMaxPlayerPrice);
            offeredMaxPlayer.displayInfo();
            property.displayCongratulationMessage();
        }
    }

    public static void payTax(Property property,Player player){
        //                pay tax action
        System.out.println(Constant.LEFT_ARROW+property.getName());
        System.out.println(Constant.LEFT_ARROW+property.getOwner().getName());
        System.out.println("Player "+player.getName()+" You are on the owned property of "+property.getOwner().getName()+" you need to pay tax for rent");
        player.collectRent(property);
        System.out.println("Your balance "+player.getBalance());
        System.out.println("Owners balance "+property.getOwner().getBalance());
    }

    public static void checkMultipleTaxToThree(Player player){
        ArrayList<String> colorsOfMyProperties = new ArrayList<>();
        for (Property playersProperty:
                player.getProperties()) {
            colorsOfMyProperties.add(playersProperty.getColor());
        }
        Map<String, Long> counts =
                colorsOfMyProperties.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Long count = Long.valueOf(0);

        for (String color: counts.keySet()) {
            if(counts.get(color)>=3){
                count = counts.get(color);
            }
        }

        if(count>=3){
            System.out.println(player.getName()+" has more than three properties of the same color, and now increases the amount of tax of his properties");
            for (Property playersProperty:
                    player.getProperties()) {
                playersProperty.setTax(playersProperty.getTax()*3);
            }
        }
    }
    public static void playActiveProperties(Property property,Player player,Board board,ArrayList<Player> players){
        property.displayInfo();
        if(property.getName().equals(Constant.LUXURY_TAX))  {
            System.out.println("You have to pay Luxury tax");
            player.subtractBalance(75);
        } else if (property.getName().equals(Constant.INCOME_TAX)) {

            System.out.println("Woops, unfortunately, Player "+player.getName()+" you have to pay income tax 10% or 200$");
            int sum = 0;
            if(player.getProperties().size()>=1){
                for (Property propertyOfPlayer:
                        player.getProperties()) {
                    sum = sum+propertyOfPlayer.getTax();
                }
                player.subtractBalance(sum*0.1);
                player.displayInfo();

            }else {
                player.subtractBalance(200);
                player.displayInfo();
            }
        } else if (property.getName().equals(Constant.GO_TO_JAIL)) {
            System.out.println("Sorry, you are in the Jail, you will have to pay 105$ as fine");
            player.setPosition(10);
            player.subtractBalance(105);
        }else if(property.getName().equals(Constant.B_RAILROAD) ||
                property.getName().equals(Constant.READING_RAILROAD) ||
                property.getName().equals(Constant.PENNSYLVANIA_RAILROAD) ||
                property.getName().equals(Constant.SHORT_LINE_RAILROAD)){
            if(!player.isOwner(property) && property.isOwned()){
                player.subtractBalance(property.getTax());
                property.getOwner().addBalance(property.getTax());
            }
        }else if(property.getName().equals(Constant.CHANCE)){
            ArrayList<Chance> chances = board.getChances();
            Random r = new Random();

            int randomitem = r.nextInt(chances.size());
            Chance randomChance = chances.get(randomitem);
            System.out.println(Constant.LEFT_ARROW+" Your Chance is "+randomChance.getDescription());
            if(randomChance.getId() == 1){
                player.setPosition(0);
                player.addBalance(1113);
                player.displayInfo();
            } else if (randomChance.getId() == 2) {
                player.addBalance(50);
                player.displayInfo();
            } else if (randomChance.getId() ==3) {
                player.setPosition(player.getPosition()-3);
                player.displayInfo();
            } else if (randomChance.getId() == 4) {
                player.subtractBalance(players.size()*50);
            }
        }
    }

    public static void ownEstate(Property property,Player player, Scanner in){
            int priceOfHouse = 0;
            switch (property.getColor()){
                case Constant.YELLOW, Constant.RED:
                    priceOfHouse = 150;
                    break;
                case Constant.PINK, Constant.ORANGE:
                    priceOfHouse = 100;
                    break;
                case Constant.PURPLE, Constant.LIGHT_BLUE:
                    priceOfHouse = 50;
                    break;
                case Constant.GREEN, Constant.BLUE:
                    priceOfHouse = 200;
                    break;
            }
            System.out.println("You are on your property, would you like to get the house in order to get more income?");
            String answer = in.next();

            if(answer.equalsIgnoreCase("yes")){
                if(property.getEstates().size()<4){
                    property.addEstate(new Estate("HOUSE"),player);
                    player.buyEstate(priceOfHouse);
                }
            }
            if(property.getEstates().size()>4){
                System.out.println("Would you like to get the hotel?");
                answer = in.next();
                if(answer.equalsIgnoreCase("yes")){
                    property.addEstate(new Estate("HOTEL"),player);
                }
            }
            if(property.getEstates().size()>=1){
                property.setTax(property.getTax()+200*property.getEstates().size());
            }
    }

    public static void start(){
        Scanner in = new Scanner(System.in);

        Integer numberOfPlayers = in.nextInt();
        ArrayList<Player> players = registration(numberOfPlayers,in);
        Board board = new Board();

        Player winner = null;

        while (true) {
            for (Player player : players) {
                int rollDice = player.rollDice();
                Property property;

                if(player.getPosition()+rollDice < board.getPropertiesSize()){
                    player.setPosition(rollDice+player.getPosition());
                }else {
                    player.addBalance(1113);
                    player.setPosition(rollDice-(board.getPropertiesSize()-player.getPosition()));
                    System.out.println("Congratulations, You passed one loop, you will get additional 1113$");
                    player.displayInfo();
                }

                property = board.getProperty(player.getPosition());

                if(!player.isBankrupt()) {
                    if (!property.isOwned() && property.isPropertyCanBeOwned()) {
                        ownTheProperty(property,player,players,board,in);
                    }
                    else if (property.isPropertyCanBeOwned() && property.isOwned()&&!property.getOwner().getName().equals(player.getName())) {
                        payTax(property,player);
                    } else if (property.getOwner()!=null && property.getOwner().getName().equals(player.getName())) {
                        ownEstate(property,player,in);
                    } else if(!property.isPropertyCanBeOwned()){
                        playActiveProperties(property,player,board,players);
                    }
                }else{
                    players.remove(player);
                }

                if(player.getProperties().size()>=3){
                    checkMultipleTaxToThree(player);
                }

                //            winner
                if(players.size() == 1){
                    System.out.println("Congratulations! The winner is : \n"+Constant.LEFT_ARROW+player.getName());
                    winner = player;
                    break;
                }
            }

            if(winner != null){
                System.out.println("Game is over!");
                break;
            }
        }
    }
}
