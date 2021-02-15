package org.gogildong.review.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	private Long rno;
	private Long sno;
	private String mid;
	private String context;
	private Long score;
	private String img;
	private Date regdate, updateDate ;
	private Long lcount;
	private int value;
	
}
