package in.jpsolution.okhttplibrary.Helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

/**
 * Created by Win10 on 10-03-2017.
 */

public class Utils {
    /***
     * Create json request
     * @param keys
     * @param values
     * @return String jsonObject
     */

   ///for createJsonRequest
    public static String createJsonRequest(String keys[], String values[]){
        JSONObject jsonObject = new JSONObject();
        try {
            for (int i = 0; i < keys.length; i++) {
                jsonObject.put(keys[i],values[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }


    public static String getFile(Bitmap path) {
        Bitmap bm = null;
        ByteArrayOutputStream baos = null;
        byte[] b = null;
        String encodeString = null;
        try {
            bm = BitmapFactory.decodeFile(String.valueOf(path));
            baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
            b = baos.toByteArray();
            encodeString = Base64.encodeToString(b, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeString;
    }

    public static String setImage(Bitmap path){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        path.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return imageString.trim();
    }
}
