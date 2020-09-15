package IO.JSON;

public class Json {
    public static String FromObject(String key, String value){
        return "{\"" + key + "\":\"" + value + "\"}";
    }

    public static String FromObject(String key, int value){
        return "{\"" + key + "\":" + value + "}";
    }

    public static String FromObject(String key, Double value){
        return "{\"" + key + "\":" + value + "}";
    }
}
