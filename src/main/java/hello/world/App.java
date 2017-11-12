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
	
	// http://localhost:4567/hello.html
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        words.put("Haus", "das");
        words.put("Zimmer", "das");
        words.put("Hund", "der");
        words.put("Blume", "die");
        
        staticFiles.location("/public");
        get("/hello", (req, res) -> {
        		res.type("application/json");
        		return "{\"message\": \"Hello World!!!!!!!!!\"}";
        });
        
        get("/words", (req, res) -> {
    		res.type("application/json");
        	Gson gson = new Gson();
        	String json = gson.toJson(words);
        	return json;
        });
    }
}
