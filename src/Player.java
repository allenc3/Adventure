import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

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
    private double attack;
    private double defense;
    private double health;
    private transient double originalHealth;
    private int level;
    private transient int experience = 0;

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
    public double getAttack() {
        return attack;
    }

    /**
     * @return player's defense
     */
    public double getDefense() {
        return defense;
    }

    /**
     * @return player's health
     */
    public double getHealth() {
        return health;
    }

    /**
     * @return players level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return original health of player
     */
    public double getOriginalHealth(){
        return originalHealth;
    }

    /**
     * @return the player's current experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets originalHealth
     */
    public void setOriginalHealth(){
        if(originalHealth == 0) {
            originalHealth = health;
        }
    }


    /**
     * Players health decreases according to damage
     * @param damage
     */
    public void takeDamage(double damage){
        if(damage < 0) {
            damage = 0;
        }
        health -= damage;
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
     * Finds an item in the player's inventory
     * @param inputItem the item to be found
     * @return the item if found, null otherwise.
     */
    public Item findItem(String inputItem){
        if(inputItem == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        for(Item item: items) {
            if(item.getName().equalsIgnoreCase(inputItem)){
                return item;
            }
        }
        return null;
    }

    /**
     * Player leveled up!
     * All attributes increase
     */
    public void levelUp(){
        level++;
        attack = Math.round(attack*1.5);
        defense = Math.round(defense*1.5);
        health = Math.round(originalHealth*1.3);
        originalHealth = health;
    }

    /**
     * Prints level up message
     */
    public void printLevelUp(){
        System.out.println("Level up!");
        System.out.println("You are now level " + level);
        System.out.println("Health: " + originalHealth + " Attack: " + attack +  " Defense: " + defense);
        System.out.println();
    }
    /**
     * Adds experience if experience is not sufficient to level up.
     * @param exp the exp to be added
     * @throws IllegalArgumentException if exp is negative
     */
    public void addExp(int exp) {
        if(exp < 0) {
            throw new IllegalArgumentException(ErrorConstants.NEGATIVE_EXP);
        }
        experience = exp;
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
            System.out.print("nothing.");
        } else if(items.size() == 1) {
            System.out.print(items.get(0).getName());
        } else if(items.size() == 2) {
            System.out.print(items.get(0).getName() + " and " + items.get(1).getName());
        } else {
            for (int i = 0; i < items.size(); i++) {
                if(i == items.size() - 1){
                    System.out.print("and " + items.get(i).getName());
                } else {
                    System.out.print(items.get(i).getName() + ", ");
                }
            }
        }
    }
}
