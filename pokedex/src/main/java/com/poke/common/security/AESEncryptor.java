package com.poke.common.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

//양방향 암호화/복호화 메소드를 제공하는 클래스 만들기
//암호화, 복호화하는 key를 잘 관리해야한다.
//AES방식으로 암호화, 복호화 메소드 만들어보자.!

public class AESEncryptor {
	//1. key값 생성 및 가져오기 -> 유일한값으로 고정되어야함.
	// 1) 생성된 key가 있으면 그 key를 가져와 활용
	// 2) 생성된 key가 없으면 그 key를 생성해서 가져와 활용
	//key는 특정 파일에 저장하고 관리함.
	private static SecretKey key;
	private String path;//key저장된 파일의 경로
	
	public AESEncryptor() { // 생성자에 넣어놓음
		//key클래스 생성 및 가져오는 로직
		this.path=AESEncryptor.class.getResource("/").getPath();
		System.out.println(this.path);
		this.path=this.path.substring(0,this.path.indexOf("classes"));
		File keyFile=new File(this.path+"pokelove.po");
		if(keyFile.exists()) {
			try(ObjectInputStream ois
					=new ObjectInputStream(
							new FileInputStream(keyFile));){
				AESEncryptor.key=(SecretKey)ois.readObject();
				
			}catch(IOException|ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			getGeneraterKey();
		}
	}
	
	private void getGeneraterKey() {
		SecureRandom rnd=new SecureRandom();
		KeyGenerator keygen=null;
		try(ObjectOutputStream oos=new ObjectOutputStream(
				new FileOutputStream(this.path+"/pokelove.po"));) {
			keygen=KeyGenerator.getInstance("AES");
			keygen.init(128,rnd);
			
			AESEncryptor.key=keygen.generateKey();
			
			oos.writeObject(AESEncryptor.key);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//암호화메소드 설정하기
	public static String encryptData(String oridata) 
			throws Exception{
		Cipher cipher=Cipher.getInstance("AES"); // Cipher 암호화 처리해주는 객체
		cipher.init(Cipher.ENCRYPT_MODE, AESEncryptor.key);
		
		byte[] oribyte=oridata.getBytes(Charset.forName("UTF-8"));
		byte[] encbyte=cipher.doFinal(oribyte);
		return Base64.getEncoder().encodeToString(encbyte);
	}
	
	//복호화메소드설정하기
	public static String decryptData(String encdata) throws Exception{
		Cipher cipher=Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, AESEncryptor.key);
		
		byte[] encbyte=Base64.getDecoder()
					.decode(encdata.getBytes(Charset.forName("UTF-8")));
		byte[] decryptbyte=cipher.doFinal(encbyte);
		
		return new String(decryptbyte);
	}
	
	
}
