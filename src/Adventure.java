import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Adventure {
    public static void main(String[] args) throws Exception{
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        Layout adventure = gson.fromJson(JsonStringRetriever
                .convertUrlToString(JsonStringRetriever.url), Layout.class);
        System.out.println(JsonStringRetriever.convertUrlToString(JsonStringRetriever.url));


    }
}
