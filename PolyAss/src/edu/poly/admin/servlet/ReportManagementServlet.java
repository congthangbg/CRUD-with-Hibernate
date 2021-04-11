package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.domain.FavoriteListVideoReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.entity.Favorite;
import edu.poly.entity.User;
import edu.poly.entity.Video;

@WebServlet("/ReportManagementServlet")
public class ReportManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			FavoriteUserReport(request, response);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	
		PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void FavoriteUserReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String videoUserId=request.getParameter("videoUserId");
			VideoDao vdao=new VideoDao();
			List<Video> vlist=vdao.findAll();
			if(videoUserId == null && vlist.size() > 0) {
				videoUserId=vlist.get(0).getVideoId();
			}
			FavoriteDao fdao=new FavoriteDao();
			//FavoriteUserReport
			List<FavoriteUserReport> list=fdao.reportFavoriteUser(videoUserId);
			
			//FavoriteListVideoReport
			List<FavoriteListVideoReport> listVRP=fdao.reportFavoriteListVideo();
			
			request.setAttribute("listVRP", listVRP);
			request.setAttribute("favList", list);
			request.setAttribute("vList", vlist);
			request.setAttribute("videoUserId", videoUserId);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
