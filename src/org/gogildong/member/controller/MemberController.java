package org.gogildong.member.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gogildong.common.controller.MultiController;
import org.gogildong.member.dao.MemberDAO;
import org.gogildong.member.domain.Member;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class MemberController
 */
@Log4j
@WebServlet("/member/*")
public class MemberController extends MultiController {
	private static final long serialVersionUID = 1L;

	MemberDAO memberDAO = new MemberDAO();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String loginGET(HttpServletRequest request, HttpServletResponse response) {

		String referer = request.getHeader("Referer");
//		
//		System.out.println(referer);

//		Long sno = Long.parseLong(request.getParameter("sno"));
//		
		HttpSession session = request.getSession();
//		Store store = storeDAO.getOne(sno);

		session.setAttribute("referer", referer);

		return "member/login";
	}

	public String loginPOST(HttpServletRequest request, HttpServletResponse response) {

//			Long sno = Long.parseLong(request.getParameter("sno"));

//			Store store = storeDAO.getOne(sno);

		// String referer = request.getHeader("Referer");

//			log.info("--------------------------------");
//			log.info("--------------------------------");
//			log.info(referer);
//			log.info("--------------------------------");
//			log.info("--------------------------------");

		//
//			String asd = request.getParameter("referer");
//			
//			System.out.println(asd);

		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		HttpSession session = request.getSession();

		String referer = (String) (session.getAttribute("referer"));

		System.out.println(referer);

//		session.setAttribute("mid", mid);

//			session.setAttribute("store", store);
		Member member = memberDAO.getMemberInfo(mid);
		boolean isLogin = false;

		if(member == null)
			return "member/login";
		
		if(member.getMid().equals(mid)) {
			if(member.getMpw().equals(mpw)){
				session.setAttribute("mid", member.getMid());
				session.setAttribute("mname", member.getMname());
				isLogin = true;					
			} 
		}
						
		if(isLogin == true) {
			if(referer == null) {
				return "re:/store/list";
			} else {
				return "re:" + referer;
			}
		} else {
			return "member/login";
		}
	}
	public String logoutGET(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		String ref = req.getHeader("Referer");
				
		session.invalidate();
		return "re:" + ref;
	}
}
