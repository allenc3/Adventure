import com.google.gson.Gson;

import java.util.Arrays;

public class Adventure {
    public static void main(String[] args) throws Exception{
        Gson gson = new Gson();

//        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
//        String url = "";
//        JsonStringRetriever.checkUrl(url);
//        String hi = JsonStringRetriever.convertUrlToString(url);
//        System.out.println(hi);

        Layout adventure;
        Room roomObjForTest;
        Room anotherTest;

        adventure = gson.fromJson(JsonStringRetriever
                .convertUrlToString(JsonStringRetriever.url), Layout.class);
        roomObjForTest = gson.fromJson(" {\n" +
                "      \"name\": \"MatthewsStreet\",\n" +
                "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
                "      \"items\": [\"coin\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"East\",\n" +
                "          \"room\": \"SiebelEntry\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }", Room.class);

        anotherTest = gson.fromJson(" {\n" +
                "      \"name\": \"MatthewsStreet\",\n" +
                "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
                "      \"items\": [\"coin\"],\n" +
                "      \"directions\": [\n" +
                "        {\n" +
                "          \"directionName\": \"East\",\n" +
                "          \"room\": \"SiebelEntry\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }", Room.class);

        System.out.println(anotherTest.getDirections()[0].equals(roomObjForTest.getDirections()[0]));
        System.out.println(roomObjForTest.equals(adventure.getRooms()[0]));
//        System.out.println(anotherTest.getDirections()[0].getRoom());
//        System.out.println(roomObjForTest.getDirections()[0].getRoom());
//        System.out.println(anotherTest.getDirections()[0].equals(roomObjForTest.getDirections()[0]));
//        System.out.println(roomObjForTest.getDirections()[0].equals(adventure.getRooms()[0].getDirections()[0]));
//        System.out.println(adventure.getRooms()[0].getName());


//        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
//        final HttpResponse<String> stringHttpResponse = Unirest.get(url).asString();
//        String stringFrom = JsonStringRetriever.makeAPIRequest(JsonStringRetriever.getUrl());
//        System.out.println(stringFrom);

//        System.out.println(stringHttpResponse.getStatus());

        //important
//        Layout adventure = gson.fromJson(stringFrom, Layout.class);
//        System.out.println(adventure.getStartingRoom());
//        System.out.println(adventure.getEndingRoom());
//        System.out.println(stringFrom);


//        for (int i = 0; i < adventure.getRooms().length; i++) {
//            System.out.println(adventure.getRooms()[i].getName());
//        }

//        for (int i = 0; i < adventure.getRooms().length; i++) {
//            for (int j = 0; j < adventure.getRooms()[i].getDirections().length; j++) {
//                System.out.print(adventure.getRooms()[i].getDirections()[j].getDirectionName() + " ");
//                System.out.print(adventure.getRooms()[i].getDirections()[j].getRoom() + " ");
//            }
//            System.out.println();
//        }



    }
}
