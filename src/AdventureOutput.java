public class AdventureOutput {

    public static void main(String[] args) {

    }
    public void proceedWithAdventure(Room aRoom){
//        if(aRoom.getName() = )
        System.out.println(aRoom.getDescription());
        System.out.print("This room contains: ");
        if(aRoom.getItems().length == 0){
            System.out.println("This room contains nothing!");
        } else {
            for (int i = 0; i < aRoom.getItems().length; i++) {
                if (i == aRoom.getItems().length - 1);
            }
        }

        System.out.print("From here, you can go: ");
        for (int i = 0; i < aRoom.getDirections().length; i++) {
            if(i == aRoom.getDirections().length - 1){
                System.out.println("or " + aRoom.getDirections()[i].getDirectionName());
            } else{
                System.out.print(aRoom.getDirections()[i].getDirectionName() + ", ");
            }
        }
    }

}
