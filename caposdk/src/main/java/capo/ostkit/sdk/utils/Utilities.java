package capo.ostkit.sdk.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by TinhVC on 5/16/18.
 */

public class Utilities {
    public static String getTimestamp() {
//        Calendar calendar = Calendar.getInstance();
//        java.util.Date now = calendar.getTime();
//        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
////        return String.valueOf((currentTimestamp.getTime() / 1000L));
//        Log.d("caposdk", String.valueOf((currentTimestamp.getTime() / 1000L)));
//        Log.d("caposdk", String.valueOf(System.currentTimeMillis() / 1000));
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String hmacDigest(String msg, String keyString, String algo) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);
            byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));
            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {

        } catch (InvalidKeyException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        return digest;
    }
}
