package org.ylgjj.loan;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWT {

    /** 
    * @Title: generalKey 
    * @Description: 获取解析JWT和生成JWT的秘钥 
    * @param @param fromSys
    * @param @return 
    */
    public static SecretKey generalKey(String fromSys) {
        String stringKey = fromSys;//new Miner().getMiner("tokenKey").getString(fromSys);
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static Claims parseJWT(String jwt, String fromSys) {
        SecretKey key = generalKey(fromSys);
        Claims claims = Jwts.parser().setSigningKey(key).setAllowedClockSkewSeconds(3600 * 24).parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
    
    public static String createJWT(String staffId, String province, long expiresSecond , Claims claims, String fromSys){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 生成签名密钥
        SecretKey key = generalKey(fromSys);
        JwtBuilder builder = Jwts.builder()
            // 设置header, 可以调用setHeaderParams()方法同时设置token类型和加密算法，加密的默认值是HS256
            .setHeaderParam("typ", "JWT")
            // 添加构成JWT的参数, 自定义claim的属性, 也可以调用setId和setSubject等类自身方法
            .claim("staffId", staffId)
            .claim("province", province)
            .signWith(signatureAlgorithm, key);
        // 添加claims信息
        if(claims != null && !claims.isEmpty()) {
            builder.setClaims(claims);
        }
        // 添加Token过期时间
        if (expiresSecond  >= 0) {
            long expMillis = nowMillis + expiresSecond ;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }
        return builder.compact();
    }
    static  void main(String[] args){
        Map<String,Object> claims = new HashMap<String,Object>();//创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        claims.put("uid", "DSSFAWDWADAS...");
        claims.put("user_name", "admin");
        claims.put("nick_name","DASDA121");


       // createJWT("1","1",1000,claims,"123456");
    }
}