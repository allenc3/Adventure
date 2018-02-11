import java.util.Scanner;

public class Duel {


    /**
     * Starts duel between player and monster
     * @param adventure the adventure
     * @param currentRoom the current room
     * @param monster the monster player is dueling with
     * @return true if player defeats monster, false if player disengages.
     * @throws IllegalArgumentException if inputs are null
     */
    public boolean Duel(Layout adventure, Room currentRoom, Monster monster){
        if(adventure == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        Player player = adventure.getPlayer();

        while(true){
            Scanner scn = new Scanner(System.in);
            String userInput = scn.nextLine();

            if(attackCommand(userInput)){
                attackMonster(player, monster);
            } else if(attackWithItemCommand(userInput)){
                attackWithItem(player, monster, userInput);
            } else if(disengageCommand(userInput)) {
                System.out.println("Disengaged.");
                return false;
            } else if(statusCommand(userInput)) {
                printPlayerStatus(player, monster);
            } else if(listCommand(userInput)){
                player.printList();
            } else if(playerInfoCommand(userInput)){
                player.printList();
            } else if(exitCommand(userInput)){
                System.exit(1);
            } else {
                responseToInvalidInput(userInput);
            }

            checkIfPlayerLost(player, monster);
            boolean duelWon = removeMonster(adventure, currentRoom, monster);
            if(duelWon){
                levelUp(player, monster);
                return true;
            }
        }
    }

    /**
     * Determines if the user command is in the form of "attack"
     * @param userInput input by user
     * @return true if userInput is "attack", false otherwise
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean attackCommand(String userInput){
        if(userInput == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return userInput.equalsIgnoreCase("attack");
    }

    /**
     * Determines if the user command is in the form of "attack with anItem"
     * @param userInput input by user
     * @return true if userInput is "attack with anItem", false otherwise
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean attackWithItemCommand(String userInput){
        if(userInput == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        String userInputTrimmed = userInput.trim();
        String[] input = userInputTrimmed.split("\\s+", 3);
        if(input.length == 3){
            return input[0].equalsIgnoreCase("attack")
                    && input[1].equalsIgnoreCase("with");
        }
        return false;
    }

    /**
     * Determines if the user command is in the form of "disengage"
     * @param userInput input by user
     * @return true if userInput is disengage, false otherwise
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean disengageCommand(String userInput){
        if(userInput == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return userInput.equalsIgnoreCase("disengage");
    }

    /**
     * Determines if the user command is in the form of "status"
     * @param userInput input by user
     * @return true if userInput is status, false otherwise
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean statusCommand(String userInput){
        if(userInput == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return userInput.equalsIgnoreCase("status");
    }

    /**
     * Determines if the user command is in the form of "list"
     * @param userInput input by user
     * @return true if user command is in the form of "list", false otherwise.
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean listCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return userInput.equalsIgnoreCase("list");
    }

    /**
     * Determines if user command is in the form of "playerInfo"
     * @param userInput input by user
     * @return true if command is playerinfo, false otherwise
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean playerInfoCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return userInput.equalsIgnoreCase("playerInfo");
    }

    /**
     * Determines if user command is in the form of "exit" or "quit"
     * @param userInput input by user
     * @return true if user command is in the form of "exit" or "quit"
     * @throws IllegalArgumentException if userInput is null
     */
    public boolean exitCommand(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        userInput = userInput.trim();
        return (userInput.equalsIgnoreCase("quit")
                || userInput.equalsIgnoreCase("exit"));
    }

    /**
     * Player attacks monster while monster retaliates
     * @param player the player
     * @param monster the monster
     */
    public void attackMonster(Player player, Monster monster) {
        if(player == null || monster == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        double damageToMonster = player.getAttack() - monster.getDefense();
        monster.takeDamage(damageToMonster);
        if(monster.getHealth() > 0) {
            double damageToPlayer = monster.getAttack() - player.getDefense();
            player.takeDamage(damageToPlayer);
        }
    }

    /**
     * Player attacks monster with an item while monster retaliates
     * @param player the player
     * @param monster the monster
     */
    public void attackWithItem(Player player, Monster monster, String userInput) {
        if(player == null || monster == null || userInput == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String userInputTrimmed = userInput.trim();
        String[] input = userInputTrimmed.split("\\s+", 3);
        String item = input[2];

        Item itemObj = player.findItem(item);
        if(itemObj == null) {
            System.out.println("I do not have the item: " + item);
            return;
        }

        double damageToMonster = player.getAttack() + itemObj.getDamage() - monster.getDefense();
        monster.takeDamage(damageToMonster);
        if(monster.getHealth() > 0) {
            double damageToPlayer = monster.getAttack() - player.getDefense();
            player.takeDamage(damageToPlayer);
        }
    }

    /**
     * Prints the health bar of the player and the monster
     * @param player the player
     * @param monster the monster
     */
    public void printPlayerStatus(Player player, Monster monster){
        if(player == null || monster == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        printPlayerHealthBar(player);
        printMonsterHealthBar(monster);
    }

    /**
     * Prints player's health bar
     * @param player the player
     * @throws IllegalArgumentException if player is null
     */
    public void printPlayerHealthBar(Player player) {
        if(player == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String healthBlock = "\u2B1B";
        String noHealthBlock = "\u2B1C";
        double originalHealth = player.getOriginalHealth();
        double currentHealth = player.getHealth();

        if (player.getOriginalHealth() == 0) {
            originalHealth = currentHealth;
        }

        int fraction = (int) Math.round(currentHealth * 100 / originalHealth);

        System.out.print("Player's Health: ");
        for (int i = 0; i < 100; i+=5) {
            if(i < fraction){
                System.out.print(healthBlock);
            } else{
                System.out.print(noHealthBlock);
            }
        }
        System.out.println(" " + currentHealth + "/" + originalHealth);
    }

    /**
     * Prints the monster's health bar
     * @param monster the monster
     * @throws IllegalArgumentException if input is null
     */
    public void printMonsterHealthBar(Monster monster){
        if(monster == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        String healthBlock = "\u2B1B";
        String noHealthBlock = "\u2B1C";
        double originalHealth = monster.getOriginalHealth();
        double currentHealth = monster.getHealth();

        if(monster.getOriginalHealth() == 0){
            originalHealth = currentHealth;
        }

        int fraction = (int) Math.round(currentHealth * 100/originalHealth);

        System.out.print("Monster's Health: ");
        for (int i = 0; i < 100; i+=5) {
            if(i < fraction){
                System.out.print(healthBlock);
            } else{
                System.out.print(noHealthBlock);
            }
        }
        System.out.println(" " + currentHealth + "/" + originalHealth);
    }

    /**
     * Removes monster from game if health <= 0
     * @param adventure the adventure
     * @param currentRoom the room
     * @param monster the monster to be removed
     * @return true if monsters are removed, false otherwise
     * @throws IllegalArgumentException if inputs are null.
     */
    public boolean removeMonster(Layout adventure, Room currentRoom, Monster monster) {
        if(adventure == null || currentRoom == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        if(monster.getHealth() <= 0) {
            adventure.removeMonster(monster);
            currentRoom.removeMonster(monster.getName());
            return true;
        }
        return false;
    }

    /**
     * Allows player to level up
     * @param player the player
     * @param monster the monster defeated
     * @throws IllegalArgumentException if inputs are null
     */
    public void levelUp(Player player, Monster monster) {
        if(monster == null || player == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        int exp = (int) Math.round(((monster.getAttack() + monster.getDefense()) /
                2.0 + monster.getHealth())*20.0);

        boolean enoughExp = true;
        while(enoughExp) {

            int playerExp = player.getExperience();
            int expToLevelUp = experienceToLevelUp(player.getLevel());

            if(playerExp + expToLevelUp <= exp) {
                exp -= (playerExp + expToLevelUp);
                player.levelUp();
            } else {
                player.addExp(exp);
                enoughExp = false;
            }
        }

    }

    /**
     * Calculates the experience needed to level up.
     * @param level players current level
     * @return the experience need to level up
     */
    public int experienceToLevelUp(int level){
        if(level < 1){
            throw new IllegalArgumentException(ErrorConstants.LEVEL_LESS_THAN_ONE);
        }
        if(level == 1) {
            return 25;
        }
        if(level == 2) {
            return 50;
        }
        else{
            return (int) (Math.round((experienceToLevelUp(level - 1)
                    + experienceToLevelUp(level - 2))*1.1));
        }
    }

    /**
     * If input is invalid, prints message in the form of "I don't understand 'userInput'"
     * @param userInput input by user
     * @throws IllegalArgumentException if userInput is null
     */
    public void responseToInvalidInput(String userInput){
        if(userInput == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        System.out.println("I don't understand '" + userInput + "'");
    }

    /**
     * Checks if players health is or below 0
     * @param player the player
     * @param monster the monster
     * @throws IllegalArgumentException if player or monster is null
     */
    public void checkIfPlayerLost(Player player, Monster monster){
        if(player == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        if(player.getHealth() <= 0) {
            System.out.println("You were slain by " + monster.getName() + ". You died.");
            System.exit(1);
        }
    }




}
