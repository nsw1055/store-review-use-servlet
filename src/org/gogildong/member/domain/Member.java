package org.gogildong.member.domain;

import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Member {

	private String mid, mpw, mname, email;
	private Date regdate,updateDate;
}
