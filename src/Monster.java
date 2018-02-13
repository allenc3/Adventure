import com.google.gson.annotations.SerializedName;

/**
 * Defines a monster object
 */
public class Monster {

    /**
     * Variables initialized according to monster's properties
     */
    private String name;
    private double attack;
    private double defense;
    private double health;
    private transient double originalHealth;
    
    /**
     * @return the name of the monster
     */
    public String getName() {
        return name;
    }

    /**
     * @return the monster's attack damage
     */
    public double getAttack() {
        return attack;
    }

    /**
     * @return the monster's defense
     */
    public double getDefense() {
        return defense;
    }

    /**
     * @return the health of the monster
     */
    public double getHealth() {
        return health;
    }

    /**
     * Original health will only be initialized when take damage is called. Default value is 0.0
     * @return original health of the monster.
     */
    public double getOriginalHealth() {
        return originalHealth;
    }

    /**
     * Custom equals method to compare monsters
     * @param another monster obj
     * @return true if equal, false otherwise
     * @throws IllegalArgumentException if input is null
     */
    public boolean equals(Monster another){
        if(another == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        return name.equals(another.name) && attack == another.attack
                && defense == another.defense && health == another.health;
    }


    /**
     * @param damage the damage taken
     */
    public void takeDamage(double damage) {
        if(originalHealth == 0) {
            this.originalHealth += this.health;
        }
        if(damage < 0){
            damage = 0;
        }
        this.health -= damage;
    }


}
