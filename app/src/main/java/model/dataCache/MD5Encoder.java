package model.dataCache;

import java.security.MessageDigest;

/**
 * Created by ssw18 on 2017/8/7.
 */

public class MD5Encoder {
    /**
     * Md5Encoder
     *
     * @param string
     * @return
     * @throws Exception
     */
    public static String encode(String string) throws Exception {
        byte[] hash = MessageDigest.getInstance("MD5").digest(
                string.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}