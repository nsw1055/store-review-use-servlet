package org.gogildong.store.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gogildong.common.controller.MultiController;
import org.gogildong.common.util.PageInfo;
import org.gogildong.common.util.PageMaker;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;

import lombok.extern.log4j.Log4j;

@WebServlet("/store/*")
@Log4j
public class StoreController extends MultiController {
	
	private StoreDAO storeDAO;
	
	public StoreController() {
		super();
		storeDAO = new StoreDAO();
	}
	
	public String listGET(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//페이징
		PageInfo pageInfo = new PageInfo();

		pageInfo.setPage(getInt(req, "page", 1));
		pageInfo.setPerSheet(getInt(req, "perSheet", 3));

		int total = storeDAO.getTotal();
		
		PageMaker pageMaker = new PageMaker(pageInfo, total);

		List<Store> stores = storeDAO.getAll(pageInfo);
		
		stores.forEach(store -> log.info(store));
		
		req.setAttribute("pageMaker", pageMaker);
		req.setAttribute("stores", stores);
		
		return "store/list";

	}
	

}
