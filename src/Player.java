import java.util.ArrayList;

/**
 * Defines a player object
 */
public class Player {

    /**
     * Variables initialized according to player's properties
     */
    private String name;
    private ArrayList<Item> items;
    private Double attack;
    private Double defense;
    private Double health;
    private int level;

    /**
     * @return name of player
     */
    public String getName() {
        return name;
    }

    /**
     * @return arraylist of items carried by player
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @return player's attack
     */
    public Double getAttack() {
        return attack;
    }

    /**
     * @return player's defense
     */
    public Double getDefense() {
        return defense;
    }

    /**
     * @return player's health
     */
    public Double getHealth() {
        return health;
    }

    /**
     * @return players level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Adds item in player inventory
     * @param item item to be added
     */
    public void addItem(Item item){
        if(item == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        this.items.add(item);
    }

    /**
     * Removes item in player inventory
     * @param indexToRemove index to remove item
     */
    public void removeItem(int indexToRemove){
        if(indexToRemove < 0 || indexToRemove >= items.size()){
            throw new IllegalArgumentException(ErrorConstants.INDEX_OUT_OF_RANGE);
        }
        this.items.remove(indexToRemove);
    }


    /**
     * Prints out player info
     */
    public void printPlayerInfo(){
        System.out.println("You are " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
    }

    /**
     * Prints the list of items the user currently has.
     * @throws IllegalArgumentException if userInventory is null
     */
    public void printList(){
        if(items == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        System.out.print("You are carrying ");
        if(items.size() == 0){
            System.out.println("nothing.");
        } else if(items.size() == 1){

            for (int i = 0; i < items.size(); i++) {
                if(i == items.size() - 1){
                    System.out.println("and " + items.get(i).getName());
                } else {
                    System.out.print(items.get(i).getName() + ", ");
                }
            }
        }
    }

}
