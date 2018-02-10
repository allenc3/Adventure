import com.google.gson.Gson;

public class TestingStrings {

    Gson gson = new Gson();

    private Layout adventure = gson.fromJson
            (ReadDataFromUrl.parseUrlToString(ReadDataFromUrl.url), Layout.class);

    private String siebelFileContents = "{\n" +
            "  \"startingRoom\": \"MatthewsStreet\",\n" +
            "  \"endingRoom\": \"Siebel1314\",\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\"coin\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEntry\",\n" +
            "      \"description\": \"You are in the west entry of Siebel Center.  " +
            "You can see the elevator, the ACM office, and hallways to the north and east.\",\n" +
            "\t  \"items\": [\"sweatshirt\", \"key\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"MatthewsStreet\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"room\": \"AcmOffice\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"AcmOffice\",\n" +
            "      \"description\": \"You are in the ACM office.  " +
            "There are lots of friendly ACM people.\",\n" +
            "      \"items\": [\"pizza\", \"swag\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelNorthHallway\",\n" +
            "      \"description\": \"You are in the north hallway.  " +
            "You can see Siebel 1112 and the door toward NCSA.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }, \n" +
            "        {\n" +
            "          \"directionName\": \"NorthEast\",\n" +
            "          \"room\": \"Siebel1112\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1112\",\n" +
            "      \"description\": \"You are in Siebel 1112.  " +
            "There is space for two code reviews in this room.\",\n" +
            "      \"items\": [\"USB-C connector\", \"grading rubric\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEastHallway\",\n" +
            "      \"description\": \"You are in the east hallway.  " +
            "You can see Einstein Bros' Bagels and a stairway.\",\n" +
            "      \"items\": [\"bagel\", \"coffee\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"Siebel1314\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Down\",\n" +
            "          \"room\": \"SiebelBasement\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1314\",\n" +
            "      \"description\": \"You are in Siebel 1314.  " +
            "There are happy CS 126 students doing a code review.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelBasement\",\n" +
            "      \"description\": \"You are in the basement of Siebel.  " +
            "You see tables with students working and door to computer labs.\",\n" +
            "      \"items\": [\"pencil\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private Layout adventureForTest = gson.fromJson(siebelFileContents, Layout.class);

    private Layout endingRoomUnreachable = gson.fromJson("{\n" +
            "  \"startingRoom\": \"MatthewsStreet\",\n" +
            "  \"endingRoom\": \"Siebel1314\",\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\"coin\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"CHANGED DIRECTION HERE\",\n" +
            "          \"room\": \"CHANGED ROOM NAME HERE\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEntry\",\n" +
            "      \"description\": \"You are in the west entry of Siebel Center.  You can " +
            "see the elevator, the ACM office, and hallways to the north and east.\",\n" +
            "\t  \"items\": [\"sweatshirt\", \"key\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"MatthewsStreet\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"room\": \"AcmOffice\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"AcmOffice\",\n" +
            "      \"description\": \"You are in the ACM office.  There are lots " +
            "of friendly ACM people.\",\n" +
            "      \"items\": [\"pizza\", \"swag\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelNorthHallway\",\n" +
            "      \"description\": \"You are in the north hallway.  You can see " +
            "Siebel 1112 and the door toward NCSA.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }, \n" +
            "        {\n" +
            "          \"directionName\": \"NorthEast\",\n" +
            "          \"room\": \"Siebel1112\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1112\",\n" +
            "      \"description\": \"You are in Siebel 1112.  There is space for " +
            "two code reviews in this room.\",\n" +
            "      \"items\": [\"USB-C connector\", \"grading rubric\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEastHallway\",\n" +
            "      \"description\": \"You are in the east hallway.  You can see " +
            "Einstein Bros' Bagels and a stairway.\",\n" +
            "      \"items\": [\"bagel\", \"coffee\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"Siebel1314\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Down\",\n" +
            "          \"room\": \"SiebelBasement\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1314\",\n" +
            "      \"description\": \"You are in Siebel 1314.  There are happy " +
            "CS 126 students doing a code review.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelBasement\",\n" +
            "      \"description\": \"You are in the basement of Siebel.  You see " +
            "tables with students working and door to computer labs.\",\n" +
            "      \"items\": [\"pencil\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}", Layout.class);


    private Layout roomsNotConnected = gson.fromJson(ReadDataFromUrl.parseUrlToString(
            "https://courses.engr.illinois.edu/cs126/adventure/circular.json"), Layout.class);

    private Direction[] directionArrForTest = gson.fromJson("[\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }, \n" +
            "        {\n" +
            "          \"directionName\": \"NorthEast\",\n" +
            "          \"room\": \"Siebel1112\"\n" +
            "        }\n" +
            "      ]", Direction[].class);

    private Room[] roomArrForTest = gson.fromJson("[\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\"coin\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEntry\",\n" +
            "      \"description\": \"You are in the west entry of Siebel Center.  You can " +
            "see the elevator, the ACM office, and hallways to the north and east.\",\n" +
            "\t  \"items\": [\"sweatshirt\", \"key\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"MatthewsStreet\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"room\": \"AcmOffice\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"AcmOffice\",\n" +
            "      \"description\": \"You are in the ACM office.  There are lots " +
            "of friendly ACM people.\",\n" +
            "      \"items\": [\"pizza\", \"swag\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelNorthHallway\",\n" +
            "      \"description\": \"You are in the north hallway.  You can see " +
            "Siebel 1112 and the door toward NCSA.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }, \n" +
            "        {\n" +
            "          \"directionName\": \"NorthEast\",\n" +
            "          \"room\": \"Siebel1112\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1112\",\n" +
            "      \"description\": \"You are in Siebel 1112.  There is space for two " +
            "code reviews in this room.\",\n" +
            "      \"items\": [\"USB-C connector\", \"grading rubric\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEastHallway\",\n" +
            "      \"description\": \"You are in the east hallway.  You can see " +
            "Einstein Bros' Bagels and a stairway.\",\n" +
            "      \"items\": [\"bagel\", \"coffee\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"Siebel1314\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Down\",\n" +
            "          \"room\": \"SiebelBasement\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1314\",\n" +
            "      \"description\": \"You are in Siebel 1314.  There are happy " +
            "CS 126 students doing a code review.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelBasement\",\n" +
            "      \"description\": \"You are in the basement of Siebel.  You see " +
            "tables with students working and door to computer labs.\",\n" +
            "      \"items\": [\"pencil\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]", Room[].class);

    public Gson getGson() {
        return gson;
    }

    public Layout getAdventureForTest() {
        return adventureForTest;
    }

    public Layout getAdventure() {
        return adventure;
    }

    public String getSiebelFileContents() {
        return siebelFileContents;
    }

    public Layout getEndingRoomUnreachable() {
        return endingRoomUnreachable;
    }

    public Layout getRoomsNotConnected() {
        return roomsNotConnected;
    }

    public Direction[] getDirectionArrForTest() {
        return directionArrForTest;
    }

    public Room[] getRoomArrForTest() {
        return roomArrForTest;
    }


}
