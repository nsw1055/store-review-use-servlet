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
public class Like {

	private Long rno;
	private String mid;
	private Long value;
	private Date regdate, updateDate ;
	
}
