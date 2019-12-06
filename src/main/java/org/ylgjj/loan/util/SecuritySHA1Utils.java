package org.ylgjj.loan.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;
import org.ylgjj.loan.domain.Query;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class SecuritySHA1Utils {
 
    /**
     * @Comment SHA1实现
     * @Author Ron
     * @Date 2017年9月13日 下午3:30:36
     * @return
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
 
        byte[] byteArray = inStr.getBytes(StandardCharsets.UTF_8);
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


    /**
     * @Comment SHA1加密密码
     * @Author Ron
     * @Date 2017年9月12日 下午2:46:31
     * @return
     */
    public static String encodePassword(String psw) {
        if(StringUtils.isEmpty(psw)){
            return null;
        }else{
            return DigestUtils.sha1Hex(psw);
        }



    }







    /**
     * @Comment SHA1加密密码
     * @Author Ron
     * @Date 2017年9月12日 下午2:46:31
     * @return
     */
    public static Map encodePassword(Query psw,String key,String appid) {

        System.out.println("------------------ "+ psw.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append(key)
              //  .append("zjbzxbm").append(psw.getZjbzxbm())
                .append("zjhlx").append(psw.getZjhlx())

                .append("citybm").append(psw.getCitybm())
                .append("xingming").append(psw.getXingming())
                .append("zjhm").append(psw.getZjhm())
                .append("appid").append(appid);
        String sign = DigestUtils.sha1Hex(stringBuffer.toString());

        Map map = new HashMap();
        map.put("key",key);
        map.put("sign",sign);
        map.put("appid",appid);


        System.out.println("bufer:"+sign);
        return map;
    }

    public static void main(String[] args) throws Exception {
/*
        String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + shaEncode(str));
        System.out.println("DigestUtils SHA后：" + encodePassword(str));
*/

        Query query = new Query();

       // query.setZjbzxbm("C61080");
        query.setCitybm("C61080");
        query.setXingming("赵源");
        query.setZjhm("612724198409210339");
        query.setAppid("eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6InBhc3N3b3JkIiwidXNlciI6ImljYmMifQ.Lf2NUX6BPwrohD9mnLZ6U2Cd-E66SW0wYkBsTVTkIL8");
        encodePassword(query,"eyJhbGciOiJIUzUxMiJ9.eyJwYXNzd29yZCI6InBhc3N3b3JkIiwidXNlciI6ImljYmMifQ.uN4D22nkb2dI04ibDKiK_5CpnRwjj9-c5F4rF4IY-_QT4k3qAXLVFktgthDaExzh7ydv0Tdayls40cedo6150g",query.getAppid());




    }
}
 
//但是在实际的应用中，我们可以直接引入org.apache.commons.codec.digest.DigestUtils，然后按照如下方法调用加密即可。

//原文地址： https://blog.csdn.net/zyhlwzy/article/details/77967255

