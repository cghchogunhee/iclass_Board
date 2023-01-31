package org.iclass.vo;

import java.sql.Date;

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
	private int idx;
	private String writer;
	private String title;
	private String content;
	private int readCount; 
	private Date createdAt;
	private String ip;
	private int commentCount;
}
