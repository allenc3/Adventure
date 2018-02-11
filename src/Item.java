/**
 * Defines an item object
 */
public class Item {
    /**
     * Variables initialized according to item's properties
     */
    private String name;
    private Double damage;

    /**
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * @return the damage of the item
     */
    public Double getDamage() {
        return damage;
    }

    /**
     * Constructor for item
     * @param name item name
     * @param damage item damage
     * @throws IllegalArgumentException if name or damage is null
     */
    public Item(String name, Double damage){
        if(name == null || damage == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        this.name = name;
        this.damage = damage;
    }

    /**
     * Custom equals to method for items
     * @param another item
     * @return true if equals, false otherwise
     */
    public boolean equals(Item another){
        if(another == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        return name.equals(another.name) && damage == another.damage;
    }


}
