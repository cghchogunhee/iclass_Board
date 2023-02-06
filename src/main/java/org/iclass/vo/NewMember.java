package org.iclass.vo;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NewMember {
	private String id;
	private String name;
	private String password;
	private String email;
	private int age;
	private String gender;  
	private String hobbies;	//취미를  , 로 나열
	private Timestamp joinDate;
	
}
