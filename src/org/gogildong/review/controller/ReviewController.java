package org.gogildong.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.gogildong.common.controller.MultiController;
import org.gogildong.common.util.PageInfo;
import org.gogildong.common.util.PageMaker;
import org.gogildong.review.dao.ReviewDAO;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;

import lombok.extern.log4j.Log4j;

@WebServlet("/review/*")
@MultipartConfig(location = "C:\\upload")
@Log4j
public class ReviewController extends MultiController {
	private static final long serialVersionUID = 1L;

	private ReviewDAO reviewDAO;
	private StoreDAO storeDAO;

	public ReviewController() {
		super();
		reviewDAO = new ReviewDAO();
		storeDAO = new StoreDAO();
	}

	public String listGET(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 선택한 맛집 번호
		Long sno = Long.parseLong(req.getParameter("sno"));

		// 선택한 맛집
		Store store = storeDAO.getOne(sno);

		// 페이징
		PageInfo pageInfo = new PageInfo();

		pageInfo.setPage(getInt(req, "page", 1));
		pageInfo.setPerSheet(getInt(req, "perSheet", 3));
		pageInfo.setSno(sno);

		int total = reviewDAO.getTotal(sno);

		PageMaker pageMaker = new PageMaker(pageInfo, total);

		// 선택한 맛집의 리뷰리스트
		List<Review> review = reviewDAO.getReview(pageInfo);

		req.setAttribute("pageMaker", pageMaker);
		req.setAttribute("store", store);
		req.setAttribute("review", review);

		return "review/list";
	}

	public String registerGET(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String referer = req.getHeader("REFERER");

		Long sno = Long.parseLong(req.getParameter("sno"));

		Store store = storeDAO.getOne(sno);

		req.setAttribute("store", store);
		req.setAttribute("referer", referer);
		return "review/register";
	}

	public String registerPOST(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("UTF-8");
		Long sno = Long.parseLong(req.getParameter("sno"));
		String mid = req.getParameter("mid");
		String context = req.getParameter("context");
		Long score = Long.parseLong(req.getParameter("score"));
		Part filePart = req.getPart("img");
		String img = filePart.getSubmittedFileName();
		filePart.write(img);
		String referer = req.getParameter("referer");

		System.out.println(referer);

		Review review = Review.builder().sno(sno).mid(mid).context(context).score(score).img(img).build();

		reviewDAO.insert(review);
		reviewDAO.updateRcount(sno);

		return ("re:" + referer);

	}

	public String loginGET(HttpServletRequest req, HttpServletResponse res) throws Exception {

		return "member/login";
	}

	public String likePOST(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String referer = req.getHeader("Referer");

		System.out.println("like");
		Long rno = Long.parseLong(req.getParameter("rno"));
		String mid = req.getParameter("mid");
		System.out.println("----------------------------");
		System.out.println(mid);
		System.out.println("----------------------------");
		Like like = Like.builder().rno(rno).mid(mid).build();

		Like realLike = reviewDAO.selectLike(like);

		if (mid != "") {
			if (realLike == null) {
				reviewDAO.insertLike(like);
			} else if (realLike.getValue() == 1L) {
				reviewDAO.disLike(like);
			} else {
				reviewDAO.updateLike(like);
			}
		} else {
			System.out.println("like login");
			return "re:/member/login";
		}

		return "re:" + referer;

	}

	public String deletePOST(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Long sno = Long.parseLong(req.getParameter("sno"));

		Long rno = Long.parseLong(req.getParameter("rno"));

		String reviewmid = req.getParameter("mid");

		HttpSession session = req.getSession();

		String realmid = (String) (session.getAttribute("mid"));

		if (reviewmid.equals(realmid)) {
			reviewDAO.deleteReview(rno);
			reviewDAO.updateRcount(sno);
		} else {
			return "review/error";
		}
		return "re:/review/list?sno=" + sno;

	}

	public String modifyGET(HttpServletRequest request, HttpServletResponse response) {
		Long rno = Long.parseLong(request.getParameter("rno"));

		Review review = reviewDAO.getOne(rno);

		request.setAttribute("review", review);

		return "/review/modify";
	}

	public String modifyPOST(HttpServletRequest request, HttpServletResponse response) {

		try {
			Long rno = Long.parseLong(request.getParameter("rno"));
			String mid = request.getParameter("mid");
			String context = request.getParameter("context");
			Long score = Long.parseLong(request.getParameter("score"));
			String img = request.getParameter("img");

			Review review = Review.builder().context(context).score(score).img(img).rno(rno).build();

			reviewDAO.update(review);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "re:/store/list";

	}

}