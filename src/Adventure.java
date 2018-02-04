import com.google.gson.Gson;

public class Adventure {
    public static void main(String[] args) throws Exception{
        Gson gson = new Gson();
        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        JsonStringRetriever.urlIsValid(url);

    }
}
