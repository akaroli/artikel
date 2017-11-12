package hello.world;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
	private static HashMap<String,String> words = new HashMap<String, String>();
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        words.put("Haus", "das");
        
        staticFiles.location("/public");
        get("/hello", (req, res) -> {
        		res.type("application/json");
        		return "{\"message\": \"Hello World!!!!!!!!!\"}";
        });
        
        get("/words", (req, res) -> {
        	Gson gson = new Gson();
        	String json = gson.toJson(words);
        	return json;
        });
    }
}
