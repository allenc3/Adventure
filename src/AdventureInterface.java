import com.example.Adventure;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureInterface {
//    public static void main(String[] args) throws Exception{
//        GsonBuilder builder = new GsonBuilder();
////        builder.excludeFieldsWithoutExposeAnnotation();
////        Gson gson = builder.create();
////
////        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
////        Layout adventure = gson.fromJson(JsonStringRetriever
////                .convertUrlToString(JsonStringRetriever.url), Layout.class);
////        System.out.println(JsonStringRetriever.convertUrlToString(JsonStringRetriever.url));

        public static void main(String[] args) throws UnirestException, MalformedURLException {

            Gson gson = new Gson();
            /**
             * Checks if url is valid, if not, prompts user to enter a valid url.
             */
//            boolean validUrl = false;
//            while(!validUrl){
//                Scanner scn = new Scanner(System.in)
//                validUrl = JsonStringRetriever.urlIsValid(JsonStringRetriever.url);
//                System.out.println("Please enter a valid url!");
//            }
            Layout adventure = gson.fromJson(JsonStringRetriever
                    .convertUrlToString(JsonStringRetriever.url), Layout.class);

            boolean exit = false;
            boolean reachEnd = false;
            boolean started = false;
            Room currentRoom = adventure.findNextRoom(adventure.getStartingRoom());

            ArrayList<String> currentItems = new ArrayList<String>();

            while(!exit){

                if(!started){
                    AdventureOutput.proceedWithAdventure(currentRoom, started, adventure.getEndingRoom());
                    started = true;
                } else {
                    AdventureOutput.proceedWithAdventure(currentRoom, started, adventure.getEndingRoom());
                }
                Scanner scn = new Scanner(System.in);
                String userInput = scn.nextLine();
//                System.out.println(userInput.length());

                // If user types go aDirection
                if(AdventureInput.goInADirectionCommand(userInput)){
                    Room checkForNull = AdventureInput.determineNextRoom(adventure, currentRoom, userInput);
                    if(checkForNull != null){
                        currentRoom = checkForNull;
                    }
                } else if(AdventureInput.takeItemCommand(userInput)){
                    currentItems.add(AdventureInput.takeItem(currentRoom, userInput));
                } else if(AdventureInput.dropItemCommand(userInput)){
                    AdventureInput.dropItem(currentRoom, userInput, currentItems);
                } else if(AdventureInput.exitCommand(userInput)){
                    exit = true;
                } else if(AdventureInput.listCommand(userInput)){
                    AdventureInput.printList(currentItems);
                }
                else{
                    AdventureInput.responseToInvalidInput(userInput);
                }

            }
        }
    }



