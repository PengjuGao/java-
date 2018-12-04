package com.platform.base.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Miscellaneous methods for calculating digests.
 * <p>Mainly for internal use within the framework; consider
 * <a href="http://commons.apache.org/codec/">Apache Commons Codec</a> for a
 * more comprehensive suite of digest utilities.
 *
 * @since 3.0
 */
public abstract class DigestUtils {

    private final static String DES = "DES";

    private static final String MD5_ALGORITHM_NAME = "MD5";

    private static final char[] HEX_CHARS =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    public static byte[] md5Digest(String text) {
        AssertUtils.notNull(text);
        return digest(MD5_ALGORITHM_NAME, text.getBytes());
    }

    public static byte[] md5Digest(byte[] bytes) {
        return digest(MD5_ALGORITHM_NAME, bytes);
    }


    public static String md5Hex(String text) {
        AssertUtils.notNull(text);
        return md5Hex(text.getBytes());
    }

    /**
     * Return a hexadecimal string representation of the MD5 digest of the given
     * bytes.
     * @param bytes the bytes to calculate the digest over
     * @return a hexadecimal digest string
     */
    public static String md5Hex(byte[] bytes) {
        return digestAsHexString(MD5_ALGORITHM_NAME, bytes);
    }

    /**
     * Append a hexadecimal string representation of the MD5 digest of the given
     * bytes to the given {@link StringBuilder}.
     * @param bytes the bytes to calculate the digest over
     * @param builder the string builder to append the digest to
     * @return the given string builder
     */
    public static StringBuilder appendMd5DigestAsHex(byte[] bytes, StringBuilder builder) {
        return appendDigestAsHex(MD5_ALGORITHM_NAME, bytes, builder);
    }

    /**
     * Creates a new {@link java.security.MessageDigest} with the given algorithm. Necessary
     * because {@code MessageDigest} is not thread-safe.
     */
    private static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        }
        catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Could not find MessageDigest with algorithm \"" + algorithm + "\"", ex);
        }
    }

    private static byte[] digest(String algorithm, byte[] bytes) {
        return getDigest(algorithm).digest(bytes);
    }

    private static String digestAsHexString(String algorithm, byte[] bytes) {
        char[] hexDigest = digestAsHexChars(algorithm, bytes);
        return new String(hexDigest);
    }

    private static StringBuilder appendDigestAsHex(String algorithm, byte[] bytes, StringBuilder builder) {
        char[] hexDigest = digestAsHexChars(algorithm, bytes);
        return builder.append(hexDigest);
    }

    private static char[] digestAsHexChars(String algorithm, byte[] bytes) {
        byte[] digest = digest(algorithm, bytes);
        return encodeHex(digest);
    }

    private static char[] encodeHex(byte[] bytes) {
        char chars[] = new char[32];
        for (int i = 0; i < chars.length; i = i + 2) {
            byte b = bytes[i / 2];
            chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
            chars[i + 1] = HEX_CHARS[b & 0xf];
        }
        return chars;
    }


    public static void main(String[] args) throws Exception {
    	/*Rg1xQToEm9VA0DrfipNZFflQRKMvZdTk------2016-04-25 10:14:53
    	Rg1xQToEm9VA0DrfipNZFcywk1cqGxAY------2016-04-25 10:14:59
    	Rg1xQToEm9WOIigsiaik3X3rF72kxIdF------2016-04-25 10:15:00
    	Rg1xQToEm9WOIigsiaik3T1t6wpQzI2S------2016-04-25 10:15:01*/
        String data = "2016-04-25 10:14:53";
        String key = "uid1234567";
        System.out.println(data);
        data = desEncrypt(key,data);
        System.out.println(data);
        data = desDecrypt(key, data);
        System.out.println( data);

        //System.err.println(desEncrypt("2012-01-08 18:11:05", "2012-01-08 18:11:06"));
        
        String value ="Ifh8eEmbD88VEDiPXEwo1vmKyj0cJSK/";
        if(value.contains("/")){
        	value = value.replace("/", "");
        	System.out.println(value);
        }
        
    }
   

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public static String desEncrypt(String key,String data) throws Exception {
        byte[] bt = desEncrypt(key.getBytes(),data.getBytes());
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws java.io.IOException
     * @throws Exception
     */
    public static String desDecrypt(String key,String data)throws Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = desDecrypt(key.getBytes(), buf);
        return new String(bt);
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] desEncrypt(byte[] key,byte[] data) throws Exception {
    	 KeyGenerator kgen = KeyGenerator.getInstance("AES");
         SecureRandom sr=SecureRandom.getInstance("SHA1PRNG");
         sr.setSeed(key);
         kgen.init(128, sr);
        // 生成一个可信任的随机数源
       // SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }


    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] desDecrypt(byte[] key,byte[] data) throws Exception {
    	 KeyGenerator kgen = KeyGenerator.getInstance("AES");
         SecureRandom sr=SecureRandom.getInstance("SHA1PRNG");
         sr.setSeed(key);
         kgen.init(128, sr);
    	// 生成一个可信任的随机数源
       // SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    public static String fromBase64(String val) throws IOException {
        if(val==null) return null;
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] data= base64Decoder.decodeBuffer(val);
        return new String(data);
    }

    public static String toBase64(Object val) throws IOException {
        if (val==null) return null;
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(val.toString().getBytes());
    }

}

