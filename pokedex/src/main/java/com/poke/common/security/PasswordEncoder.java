package com.poke.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncoder extends HttpServletRequestWrapper{

	public PasswordEncoder(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		if(name.contains("password")) {		// contains해서 패스워드가 있는것들은 다 암호화해라
			String ori=super.getParameter(name);
			System.out.println("password 원본 : "+ori);
			String change=getSHA512(ori);
			System.out.println("password 변경 : "+change);
			return change;
		}
		return super.getParameter(name); // password가 아닌애들은 암호화 안거치고 반환함
	}
	
	private String getSHA512(String oriVal) {
		//java.security.MessageDigest클래스를 이용
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] oridatabyte=oriVal.getBytes();
		md.update(oridatabyte);//sha-512방식으로 암호화처리
		byte[] encryptData=md.digest();
		//문자열로 변환하기 위해서 Base64클래스가 제공하는 인코더를 이용
		String encryptStr=Base64.getEncoder().encodeToString(encryptData);
		
		return encryptStr;
		
	}
	
}
