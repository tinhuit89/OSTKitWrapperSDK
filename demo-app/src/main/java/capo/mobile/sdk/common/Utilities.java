package capo.mobile.sdk.common;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class Utilities {

    public static Boolean checkKeyValid(JSONObject jSonOb, String key) {
        try {
            if (!jSonOb.getString(key).equals(JSONObject.NULL)) {
                return true;
            } else {
                return false;
            }
        } catch (JSONException e) {
            return false;
        }
    }

    public static String getDataString(JSONObject jSonOb, String key) {

        if (!checkKeyValid(jSonOb, key)) {
            return "";
        }

        String result = "";
        try {
            if (!jSonOb.getString(key).equals(JSONObject.NULL)) {
                result = jSonOb.getString(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getRandom(int size) {
        Random randomGenerator = new Random();
        int indexRandom = randomGenerator.nextInt(size);
        return indexRandom;
    }
}


