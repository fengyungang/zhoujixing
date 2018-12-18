package com.zhoujixing.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    //过期时间5分钟
    private static final long EXPIRE_TIME = 5*60*1000;

    /** 加密算法 */
    public final static String hashAlgorithmName = "SHA-256";
    /** 循环次数 */
    public final static int hashIterations = 16;

    /**
     * 校验token是否正确
     * @param token  密钥
     * @param username  用户名
     * @param secret  密码
     * @return   是否正确
     */
    public static boolean verify(String token,String username,String secret){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            System.out.println(algorithm);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username",username).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @param token
     * @return token中包含的用户名
     */
    public static String getUsername(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            Map<String, Claim> getClaims = jwt.getClaims();
            Claim claim = getClaims.get("username");
            String e = claim.asString();
            return e;
        }catch (JWTDecodeException e){
            return null;
        }
    }

    /**
     * 生成签名，5分钟后过期
     * @param username 用户名
     * @param secret 密码
     * @return 加密的token
     */
    public static String sing(String username,String secret){
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create().withClaim("username",username).withExpiresAt(date).sign(algorithm);

    }

    /**
     * SHA-256加密方法
     * @param password  要加密的字符串
     * @return
     */
    public static String sha256(String password){
        return new SimpleHash(hashAlgorithmName,password).toString();
    }

    public static void main(String[] args) {
        String str = new SimpleHash(hashAlgorithmName,"111").toString();
        System.out.println(str);
        System.out.println(str.length());
    }
}
