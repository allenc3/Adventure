/**
 * Defines a monster object
 */
public class Monster {

    /**
     * Variables initialized according to monster's properties
     */
    private String name;
    private Double attack;
    private Double defense;
    private Double health;

    /**
     * @return the name of the monster
     */
    public String getName() {
        return name;
    }

    /**
     * @return the monster's attack damage
     */
    public Double getAttack() {
        return attack;
    }

    /**
     * @return the monster's defense
     */
    public Double getDefense() {
        return defense;
    }

    /**
     * @return the health of the monster
     */
    public Double getHealth() {
        return health;
    }

    /**
     * Custom equals method to compare monsters
     * @param another monster obj
     * @return true if equal, false otherwise
     */
    public boolean equals(Monster another){
        if(another == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        return name.equals(another.name) && attack == another.attack
                && defense == another.defense && health == another.health;
    }


}
