package org.gogildong.store.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

	private Long sno;
	private String name;
	private String address;
	private double lat,lng;
	private Long rcount;
	private Date regdate, updateDate ;
	
}
