package Util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MaHoa {
    //md5
    //sha-1

    public static String toSHA1(String str){

        String salt = "afasvksasf;asfsffs.sadfdfadfmfglzx";
        String result = null;

        str = str +salt;
        try {
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA1");
            result = Base64.encodeBase64String(md.digest(dataBytes));
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toSHA1("123456"));
    }
}
