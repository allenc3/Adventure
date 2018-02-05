import com.example.Adventure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
                    AdventureOutput.proceedWithAdventure(currentRoom, started, reachEnd);
                    started = true;
                } else {
                    reachEnd = AdventureOutput.proceedWithAdventure(currentRoom, started, reachEnd);
                }
                Scanner scn = new Scanner(System.in);
                String userInput = scn.nextLine();

            }
        }



    }

