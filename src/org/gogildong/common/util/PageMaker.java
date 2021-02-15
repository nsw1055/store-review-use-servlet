package org.gogildong.common.util;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

	private boolean prev;
	private boolean next;
	private int start;
	private int end;
	private PageInfo pageInfo;
	private int total;
	
	public PageMaker(PageInfo pageInfo, int total) {
		
		this.total = total;
		this.pageInfo = pageInfo;
		
		//보이는 게시글
		int perSheet = pageInfo.getPerSheet();
		
		//현재 페이지 번호
		int currentPage = pageInfo.getPage();
		
		//임시 마지막 번호
		int tempEnd = currentPage+2;
		
		//시작페이지
		int startPage = currentPage-2;

		//진짜 마지막 페이지
		int realEnd = (int)(Math.ceil(total / (perSheet*1.0)));
		
		if(startPage<1) {
			start = 1;
			tempEnd += (7-tempEnd);
		}else {
			start = startPage;
		}
		
		end = realEnd < tempEnd ? realEnd : tempEnd; 
		
		prev = start > 1;

		next = end * perSheet < total ? true : false;
		
	}
	
}
