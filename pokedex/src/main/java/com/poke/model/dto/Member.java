package com.poke.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
	private String memberId;
	private String memberPw;
	private String memberNickName;
	private int age;
	private String email;
	private String phone;
	private Date enrollDate;
		
}
