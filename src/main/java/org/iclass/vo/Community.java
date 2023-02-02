package org.iclass.vo;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Community {
	private long idx;
	private String writer;
	private String title;
	private String content;
	private int readCount; 
	private Timestamp createdAt;
	private String ip;
	private int commentCount;
}
	