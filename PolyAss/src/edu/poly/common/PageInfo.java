package edu.poly.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute=new HashedMap();
	//pageRoute định nghĩa danh sách các địa chỉ sẽ thực hiện include vào trang layout.jsp
	static {
		//sử dụng khối tĩnh để khởi tạo thành phần cho pageRoute
		
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/users/users.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Report Management", "/admin/reports/reports.jsp", null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management", "/admin/videos/videos.jsp", null));
		pageRoute.put(PageType.HOME_MANAGEMENT_PAGE, new PageInfo("Home Management", "/admin/home/home.jsp", null));
		
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home Page", "/views/home/home.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login Page", "/site/users/login.jsp", null));
		pageRoute.put(PageType.SITE_REGISTATION_PAGE, new PageInfo("Registration Page", "/site/users/Registration.jsp", null));
		pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change Password Page", "/site/users/change-password.jsp", null));
		pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile", "/views/users/edit-profile.jsp", null));
		pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password Page", "/site/users/forgot-password.jsp", null));
		pageRoute.put(PageType.SITE_DETAIL_PAGE, new PageInfo("Detail Page", "/site/videos/detail.jsp", null));
		pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Share Page", "/site/videos/share.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorite Page", "/site/videos/favorite.jsp", null));
	}
	
	//prepareAndForward cho phép chuyển nội dung cho trang layout.jsp 
	public static void prepareAndForward(HttpServletRequest request,HttpServletResponse response,PageType pageType) throws ServletException, IOException {
		PageInfo page=pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}
	public static void prepareAndForwardView(HttpServletRequest request,HttpServletResponse response,PageType pageType) throws ServletException, IOException {
		PageInfo page=pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}
	
	private String title;
	private String contenUrl;
	private String scripUrl;
	

	
	public PageInfo(String title, String contenUrl, String scripUrl) {
		super();
		this.title = title;
		this.contenUrl = contenUrl;
		this.scripUrl = scripUrl;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContenUrl() {
		return contenUrl;
	}
	public void setContenUrl(String contenUrl) {
		this.contenUrl = contenUrl;
	}
	public String getScripUrl() {
		return scripUrl;
	}
	public void setScripUrl(String scripUrl) {
		this.scripUrl = scripUrl;
	}
	
	
	
}
