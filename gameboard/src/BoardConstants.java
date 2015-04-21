package prettygoodgame;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BoardConstants{
    //Image locations
    String imgLoc1 = "../images/square.jpg";
    String imgLoc2 = "../images/triangle.jpg";
    String imgLoc3 = "../images/cross.jpg";
    String imgLoc4 = "../images/arrow.jpg";
    String imgLoc5 = "../images/etc.jpg";
    
    //Tile Constants
    public static int tileHeight = 20;
    public static int tileWidth = 20;
    
    //Create an enum type for you shape types
    public enum shapesList{SQUARE, TRIANGLE, ARROW, CROSS, ETC};
    
    //You'll need a map to point from a type of shape to the location of the image
    //use a static hashmap for that
    //whenever you need the location of a shape image
    //for example
    //shapeLoc.get(shapesList.SQUARE) will get the location of the square image
    public static final Map<String,String> shapeLoc;
    static{
        Map<String, String> aMap = new HashMap<>();
        aMap.put(shapesList.SQUARE, imgLoc1);
        aMap.put(shapesList.TRIANGLE, imgLoc2);
        aMap.put(shapesList.CROSS, imgLoc3);
        aMap.put(shapesList.ARROW, imgLoc4);
        aMap.put(shapesList.ETC, imgLoc5);
        shapeLoc = Collections.unmodifiableMap(aMap);
    }
    
}
    




