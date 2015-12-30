package com.majian.apple.ibu.utils;

import java.security.MessageDigest;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {

	public final static String TYPE = "AES";

	public static byte[] AESencode(byte[] data, String key) {

		try {
			byte[] raw = key.getBytes("UTF-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, TYPE);
			Cipher cipher = Cipher.getInstance(TYPE);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			return cipher.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String AESencode(String data, String key) {
		byte[] srcData = data.getBytes();
		byte[] endata = AESencode(srcData, key);
		return HEX.toHex(endata);
	}

	public static byte[] AESdecode(byte[] data, String key) {
		try {
			byte[] raw = key.getBytes("UTF-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, TYPE);
			Cipher cipher = Cipher.getInstance(TYPE);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			return cipher.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String AESdecode(String data, String key) {
		byte[] endata = data.getBytes();
		byte[] dedata = AESdecode(endata, key);
		return new String(dedata);
	}

	public static String md5(String data) {
		String s = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data.getBytes());
			byte[] tmp = md.digest();
			s = HEX.toHex(tmp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String SHA1(String data) {
		String s = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(data.getBytes("UTF-8"));
			byte[] tmp = md.digest();
			s = HEX.toHex(tmp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String getKey(String seed) {
		return CryptoUtil.SHA1(seed).substring(0, 16);
	}

	public static String getSeed() {
		Random rand = new Random(System.currentTimeMillis());
		return Integer.toString(1000 + rand.nextInt(10000000));
	}
}
