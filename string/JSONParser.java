package string;

import org.json.*;

public class JSONParser {
    public static void main(String[] args) {
        String result = jsonParser("[{color: \"red\", value:\"#f00\"}," +
                        "{nested-colors: [{nested-color: [{ color:  \"green \", value:  \"#0f0 \"}, " +
                                                         "{color:  \"green-red \", value: \"#0f0#f00 \"}, " +
                                                         "{color: \"green-red-blue \", value: \"#0f0#f00#00f \"}]} ," +
                                         "{nested-color: [{ color:  \"green1 \", value:  \"#0f0 \"}, " +
                                                         "{color:  \"green-red1 \", value: \"#0f0#f00 \"}, " +
                                                         "{color: \"green-red-blue1 \", value: \"#0f0#f00#00f \"}]} ," +
                                         "{nested-color: [{ color:  \"green2 \", value:  \"#0f0 \"}, " +
                                                         "{color:  \"green-red2 \", value: \"#0f0#f00 \"}, " +
                                                         "{color: \"green-red-blue3 \", value: \"#0f0#f00#00f \"}] }]},  " +
                                                         "{ color:  \"blue \",   value:  \"#00f \"  },  " +
                                                         "{ color:  \"cyan \",   value:  \"#0ff \"  }, " +
                                                         "{ color:  \"magenta \",   value:  \"#f0f \"  },  " +
                                                         "{ color:  \"yellow \",   value:  \"#ff0 \"  },  " +
                                                         "{ color:  \"black \",   value:  \"#000 \"  } ]",
                "1->nested-colors->01->nested-color->00->color");
        System.out.println("Result:"+result);
    }

    public static String jsonParser(String jsonString, String indexAttribute) {
        StringBuilder strBuilder = new StringBuilder(indexAttribute);
        int index;
        String attri;
        JSONArray jArray = new JSONArray(jsonString);
        String returnValue = "";
        try {

            while (strBuilder.length() > 0 && strBuilder.indexOf("->") != -1) {
                index = Integer.parseInt(strBuilder.substring(0, strBuilder.indexOf("->")));
                System.out.println(index);
                strBuilder.delete(0, strBuilder.indexOf("->") + 2);
                if (strBuilder.indexOf("->") != -1) {
                    attri = strBuilder.substring(0, strBuilder.indexOf("->"));
                    strBuilder.delete(0, strBuilder.indexOf("->") + 2);
                    System.out.println(index + " " + attri);
                    jArray = jArray.getJSONObject(index).getJSONArray(attri);
                } else {
                    attri = strBuilder.toString();
                    strBuilder.setLength(0);
                    returnValue = jArray.getJSONObject(index).getString(attri);
                }
                System.out.println(index + " " + attri);
                System.out.println(strBuilder);

            }
        }
        catch(JSONException e) {
            returnValue="";
            e.printStackTrace();
        }

        return returnValue;
    }
}
