import com.google.gson.Gson;

public class TestingData {

    Gson gson = new Gson();

    private String adventureString = "{\n" +
            "  \"startingRoom\": \"MatthewsStreet\",\n" +
            "  \"endingRoom\": \"Siebel1314\",\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Sword\",\n" +
            "          \"damage\": 3\n" +
            "        }\n" +
            "      ],\n" +
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
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Spear\",\n" +
            "          \"damage\": 5\n" +
            "        }\n" +
            "      ],\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Hollow man\",\n" +
            "        \"Skeleton\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"AcmOffice\",\n" +
            "      \"description\": \"You are in the ACM office.  " +
            "There are lots of friendly ACM people.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Halberd\",\n" +
            "          \"damage\": 6\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Wolf\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelNorthHallway\",\n" +
            "      \"description\": \"You are in the north hallway.  Y" +
            "ou can see Siebel 1112 and the door toward NCSA.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"NorthEast\",\n" +
            "          \"room\": \"Siebel1112\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Crystal Lizard\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1112\",\n" +
            "      \"description\": \"You are in Siebel 1112.  " +
            "There is space for two code reviews in this room.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Wand\",\n" +
            "          \"damage\": 4\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Winged Knight\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEastHallway\",\n" +
            "      \"description\": \"You are in the east hallway.  " +
            "You can see Einstein Bros' Bagels and a stairway.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Rock\",\n" +
            "          \"damage\": 2\n" +
            "        }\n" +
            "      ],\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Abyss Monster\",\n" +
            "        \"Sword Master\"\n" +
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
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Greatsword\",\n" +
            "          \"damage\": 10\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Dragon\",\n" +
            "        \"Dark Spirit\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"player\": {\n" +
            "    \"name\": \"Allen\",\n" +
            "    \"items\": [\n" +
            "      {\n" +
            "        \"name\": \"fist\",\n" +
            "        \"damage\": 1\n" +
            "      }\n" +
            "    ],\n" +
            "    \"attack\": 5,\n" +
            "    \"defense\": 5,\n" +
            "    \"health\": 15,\n" +
            "    \"level\": 1\n" +
            "  },\n" +
            "  \"monsters\": [\n" +
            "    {\n" +
            "      \"name\": \"Hollow Man\",\n" +
            "      \"attack\": 5,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 10\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Crystal Lizard\",\n" +
            "      \"attack\": 10,\n" +
            "      \"defense\": 10,\n" +
            "      \"health\": 20\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Abyss Monster\",\n" +
            "      \"attack\": 20,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 25\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dark Spirit\",\n" +
            "      \"attack\": 15,\n" +
            "      \"defense\": 5,\n" +
            "      \"health\": 25\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Skeleton\",\n" +
            "      \"attack\": 2,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 5\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Sword Master\",\n" +
            "      \"attack\": 30,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 15\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Winged Knight\",\n" +
            "      \"attack\": 10,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 30\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Wolf\",\n" +
            "      \"attack\": 10,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 15\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Giant\",\n" +
            "      \"attack\": 5,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 50\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dragon\",\n" +
            "      \"attack\": 15,\n" +
            "      \"defense\": 10,\n" +
            "      \"health\": 60\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private Layout adventureCopiedString = gson.fromJson(adventureString, Layout.class);

    private Layout adventure = gson.fromJson(ReadDataFromFilePath.readFilePath("siebel.json"),
            Layout.class);

    private Layout endingRoomUnreachable = gson.fromJson("{\n" +
            "  \"startingRoom\": \"MatthewsStreet\",\n" +
            "  \"endingRoom\": \"Siebel1314\",\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\":\"Sword\",\n" +
            "          \"damage\": 3.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"CAN'T GO ON LOOK AT ME\",\n" +
            "          \"room\": \"CAN'T GO ON LOOK AT ME\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEntry\",\n" +
            "      \"description\": \"You are in the west entry of Siebel Center.  " +
            "You can see the elevator, the ACM office, and hallways to the north and east.\",\n" +
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Spear\",\n" +
            "           \"damage\": 5.0\n" +
            "         }\n" +
            "      ],\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\":[\"Hollow man\", \"Skeleton\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"AcmOffice\",\n" +
            "      \"description\": \"You are in the ACM office.  " +
            "There are lots of friendly ACM people.\",\n" +
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Halberd\",\n" +
            "           \"damage\": 6.0\n" +
            "         }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\":[\"Skeleton\", \"Wolf\"]\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\":[\"Crystal Lizard\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1112\",\n" +
            "      \"description\": \"You are in Siebel 1112.  " +
            "There is space for two code reviews in this room.\",\n" +
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Wand\",\n" +
            "           \"damage\": 4.0\n" +
            "         }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\":[\"Winged Knight\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEastHallway\",\n" +
            "      \"description\": \"You are in the east hallway.  " +
            "You can see Einstein Bros' Bagels and a stairway.\",\n" +
            "      \"items\": [\n" +
            "\t {\n" +
            "           \"name\":\"Rock\",\n" +
            "           \"damage\": 2.0\n" +
            "         }\n" +
            "      ],\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\":[\"Abyss Monster\", \"Sword Master\"]\n" +
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
            "      \"description\": \"You are in the basement of Siebel.  You see tables with students working and door to computer labs.\",\n" +
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Greatsword\",\n" +
            "           \"damage\": 10.0\n" +
            "         }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\":[\"Dragon\", \"Dark Spirit\"]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"player\":{\n" +
            "\t\"name\": \"Allen\",\n" +
            "\t\"items\": [\n" +
            "\t  {\n" +
            "            \"name\": \"fist\",\n" +
            "            \"damage\": 1.0\n" +
            "          }\n" +
            "        ],\n" +
            "        \"attack\": 10.0,\n" +
            "        \"defense\": 10.0,\n" +
            "        \"health\": 100.0,\n" +
            "        \"level\": 1\n" +
            "  },\n" +
            "  \"monsters\": [ \n" +
            "    {\n" +
            "      \"name\": \"Hollow Man\",\n" +
            "      \"attack\": 5.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 10.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Crystal Lizard\",\n" +
            "      \"attack\": 10.0,\n" +
            "      \"defense\": 10.0,\n" +
            "      \"health\": 20.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Abyss Monster\",\n" +
            "      \"attack\": 20.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 25.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dark Spirit\",\n" +
            "      \"attack\": 15.0,\n" +
            "      \"defense\": 5.0,\n" +
            "      \"health\": 25.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Skeleton\",\n" +
            "      \"attack\": 2.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 5.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Sword Master\",\n" +
            "      \"attack\": 30.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 15.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Winged Knight\",\n" +
            "      \"attack\": 10.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 30.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Wolf\",\n" +
            "      \"attack\": 10.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 15.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Giant\",\n" +
            "      \"attack\": 5.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 50.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dragon\",\n" +
            "      \"attack\": 15.0,\n" +
            "      \"defense\": 10.0,\n" +
            "      \"health\": 60.0\n" +
            "    }\n" +
            "  ] \n" +
            "}", Layout.class);


    private Layout roomsNotConnected = gson.fromJson("{\n" +
            "  \"startingRoom\": \"MatthewsStreet\",\n" +
            "  \"endingRoom\": \"Siebel1314\",\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Sword\",\n" +
            "          \"damage\": 3\n" +
            "        }\n" +
            "      ],\n" +
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
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Spear\",\n" +
            "          \"damage\": 5\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"CHANGED DIRECTION\",\n" +
            "          \"room\": \"CHANGED ROOM\"\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Hollow man\",\n" +
            "        \"Skeleton\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"AcmOffice\",\n" +
            "      \"description\": \"You are in the ACM office. " +
            " There are lots of friendly ACM people.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Halberd\",\n" +
            "          \"damage\": 6\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Wolf\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelNorthHallway\",\n" +
            "      \"description\": \"You are in the north hallway.  You can see" +
            " Siebel 1112 and the door toward NCSA.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"NorthEast\",\n" +
            "          \"room\": \"Siebel1112\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Crystal Lizard\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1112\",\n" +
            "      \"description\": \"You are in Siebel 1112.  There is " +
            "space for two code reviews in this room.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Wand\",\n" +
            "          \"damage\": 4\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Winged Knight\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEastHallway\",\n" +
            "      \"description\": \"You are in the east hallway.  You can see " +
            "Einstein Bros' Bagels and a stairway.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Rock\",\n" +
            "          \"damage\": 2\n" +
            "        }\n" +
            "      ],\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Abyss Monster\",\n" +
            "        \"Sword Master\"\n" +
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
            "      \"description\": \"You are in the basement of Siebel.  You see tables " +
            "with students working and door to computer labs.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"Greatsword\",\n" +
            "          \"damage\": 10\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\n" +
            "        \"Dragon\",\n" +
            "        \"Dark Spirit\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"player\": {\n" +
            "    \"name\": \"Allen\",\n" +
            "    \"items\": [\n" +
            "      {\n" +
            "        \"name\": \"fist\",\n" +
            "        \"damage\": 1\n" +
            "      }\n" +
            "    ],\n" +
            "    \"attack\": 5,\n" +
            "    \"defense\": 5,\n" +
            "    \"health\": 15,\n" +
            "    \"level\": 1\n" +
            "  },\n" +
            "  \"monsters\": [\n" +
            "    {\n" +
            "      \"name\": \"Hollow Man\",\n" +
            "      \"attack\": 5,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 10\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Crystal Lizard\",\n" +
            "      \"attack\": 10,\n" +
            "      \"defense\": 10,\n" +
            "      \"health\": 20\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Abyss Monster\",\n" +
            "      \"attack\": 20,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 25\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dark Spirit\",\n" +
            "      \"attack\": 15,\n" +
            "      \"defense\": 5,\n" +
            "      \"health\": 25\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Skeleton\",\n" +
            "      \"attack\": 2,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 5\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Sword Master\",\n" +
            "      \"attack\": 30,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 15\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Winged Knight\",\n" +
            "      \"attack\": 10,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 30\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Wolf\",\n" +
            "      \"attack\": 10,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 15\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Giant\",\n" +
            "      \"attack\": 5,\n" +
            "      \"defense\": 0,\n" +
            "      \"health\": 50\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dragon\",\n" +
            "      \"attack\": 15,\n" +
            "      \"defense\": 10,\n" +
            "      \"health\": 60\n" +
            "    }\n" +
            "  ]\n" +
            "}", Layout.class);

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
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\":\"Sword\",\n" +
            "          \"damage\": 3.0\n" +
            "        }\n" +
            "      ],\n" +
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
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Spear\",\n" +
            "           \"damage\": 5.0\n" +
            "         }\n" +
            "      ],\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\":[\"Hollow man\", \"Skeleton\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"AcmOffice\",\n" +
            "      \"description\": \"You are in the ACM office.  " +
            "There are lots of friendly ACM people.\",\n" +
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Halberd\",\n" +
            "           \"damage\": 6.0\n" +
            "         }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\":[\"Skeleton\", \"Wolf\"]\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\":[\"Crystal Lizard\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Siebel1112\",\n" +
            "      \"description\": \"You are in Siebel 1112.  " +
            "There is space for two code reviews in this room.\",\n" +
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Wand\",\n" +
            "           \"damage\": 4.0\n" +
            "         }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"SiebelNorthHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\":[\"Winged Knight\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"SiebelEastHallway\",\n" +
            "      \"description\": \"You are in the east hallway.  " +
            "You can see Einstein Bros' Bagels and a stairway.\",\n" +
            "      \"items\": [\n" +
            "\t {\n" +
            "           \"name\":\"Rock\",\n" +
            "           \"damage\": 2.0\n" +
            "         }\n" +
            "      ],\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\":[\"Abyss Monster\", \"Sword Master\"]\n" +
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
            "      \"items\": [\n" +
            "         {\n" +
            "           \"name\":\"Greatsword\",\n" +
            "           \"damage\": 10.0\n" +
            "         }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"SiebelEastHallway\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\":[\"Dragon\", \"Dark Spirit\"]\n" +
            "    }\n" +
            "  ]", Room[].class);

    private String oldSiebel = "{\n" +
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
            "      \"description\": \"You are in Siebel 1112. " +
            " There is space for two code reviews in this room.\",\n" +
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
            "      \"description\": \"You are in Siebel 1314.  There are " +
            "happy CS 126 students doing a code review.\",\n" +
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

    public Layout getAdventure() {
        return adventure;
    }

    public Layout getAdventureCopiedString() {
        return adventureCopiedString;
    }


    public String getAdventureString() {
        return adventureString;
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

    public String getOldSiebel() {
        return oldSiebel;
    }
}
