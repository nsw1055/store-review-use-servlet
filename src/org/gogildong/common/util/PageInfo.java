package org.gogildong.common.util;

import lombok.Getter;
import lombok.Builder.Default;

@Getter
public class PageInfo {
	
	@Default
	private int page = 1;
	@Default
	private int perSheet = 5;
	
	private Long sno;
	public void setPage(int page) {
		if(page < 1) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public void setPerSheet(int perSheet) {
		
		if(perSheet > 10) {
			this.perSheet = 10;
			return;
		}
		
		if(perSheet < 3) {
			this.perSheet = 3;		
		}
		this.perSheet = perSheet;
	}
	
	public void setSno(Long sno) {
		this.sno = sno;
	}
	
	
	
}
