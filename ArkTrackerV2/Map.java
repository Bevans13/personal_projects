import java.lang.reflect.Constructor;

public class Map {
    
private String MAP_NAME;

    public Map() {
        MAP_NAME = "Default Constructor MAP_NAME Declaration";
    }

    public Map(String m) {
        MAP_NAME = m;
    }

    public String getMAP_NAME() {
        return MAP_NAME;
    }
}
