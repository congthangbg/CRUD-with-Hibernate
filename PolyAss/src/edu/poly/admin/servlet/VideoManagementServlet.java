package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.UploadUtils;
import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;
import edu.poly.entity.Video;
import edu.poly.utils.CheckData;

/**
 * Servlet implementation class VideoManagementServlet
 */
@MultipartConfig
@WebServlet({"/VideoManagement","/VideoManagement/create","/VideoManagement/update",
	"/VideoManagement/delete","/VideoManagement/edit","/VideoManagement/reset"})
public class VideoManagementServlet extends HttpServlet {
	private VideoDao videoDao;
	
	public VideoManagementServlet() {
		this.videoDao=new VideoDao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		try {
			if(url.contains("edit")) {
				edit(request, response);
			}else if (url.contains("delete")) {
				delete(request, response);
			}else if (url.contains("reset")) {
				reset(request, response);
			}
			
			
			findPaga(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		try {
			if(url.contains("create")) {
				create(request, response);
			}else if (url.contains("delete")) {
				delete(request, response);
			}else if (url.contains("update")) {
				update(request, response);
			}else if (url.contains("reset")) {
				reset(request, response);
			}
			
			findPaga(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
		}
		
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Video video=new Video();
		BeanUtils.populate(video, request.getParameterMap());
		boolean check = true;
		try {
			if(CheckData.isNull(video.getVideoId())) {
				check = false;
				request.setAttribute("error", "Chưa nhập videoId !");
			}else if (CheckData.isNull(video.getTitle())) {
				check = false;
				request.setAttribute("video", video);
				request.setAttribute("error", "Chưa nhập video title !");
			}else if (CheckData.isNull(video.getView().toString())) {
				check = false;
				request.setAttribute("video", video);
				request.setAttribute("error", "Chưa nhập video view !");
			}
			List<Video> list=videoDao.findAll();
			for (Video video2 : list) {
				if(CheckData.isExist(video.getVideoId(), video2.getVideoId())) {
					check=false;
					request.setAttribute("video", video);
					request.setAttribute("error", "Video id đã tồn tại");
				}
			}
			if(check==true) {
				if(request.getPart("cover").getSize()==0) {
					video.setPoster("uploads/img.png");
				}else {
					video.setPoster("uploads/" + UploadUtils.processUploadField("cover", request, "/uploads", video.getVideoId()));
				}
				
				videoDao.insert(video);
				request.setAttribute("message", "Insert video success!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
			throw e;
		}
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Video video=new Video();
		boolean check = true;
		BeanUtils.populate(video, request.getParameterMap());
		try {
				if(CheckData.isNull(video.getVideoId())) {
					check = false;
					request.setAttribute("error", "Chưa nhập videoId !");
				}else if (CheckData.isNull(video.getTitle())) {
					check = false;
					request.setAttribute("video", video);
					request.setAttribute("error", "Chưa nhập video title !");
				}else if (CheckData.isNull(video.getView().toString())) {
					check = false;
					request.setAttribute("video", video);
					request.setAttribute("error", "Chưa nhập video view !");
				}
				if(check==true) {
					Video oldVideo=videoDao.findById(video.getVideoId());
					
					if(request.getPart("cover").getSize()==0) {
						video.setPoster(oldVideo.getPoster());
					}else {
						video.setPoster("uploads/" + UploadUtils.processUploadField("cover", request, "/uploads", video.getVideoId()));
							
					}
					
					videoDao.update(video);
					request.setAttribute("video", video);
					request.setAttribute("message", "Update video success!!!");
				}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
			throw e;
		}
	
	}
	protected void findPaga(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageStr=request.getParameter("page");
		String limitStr=request.getParameter("limit");
		
		try {
			int page1=pageStr==null? 1 : Integer.parseInt(pageStr);
			int limit=limitStr==null? 5 : Integer.parseInt(limitStr);
			if(page1 <1) {
				page1=1;
			}
			
			int offset=(page1 -1) * limit;
			if (page1 >= limit-1) {
				page1=1;
			}
			List<Video> list=videoDao.findPaga(offset, limit);
			request.setAttribute("listVideo", list);
			request.setAttribute("page1", page1);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
			throw e;
		}
	
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String videoId=request.getParameter("videoId");
		try {
			Video video=videoDao.findById(videoId);
			request.setAttribute("video", video);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
			throw e;
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String videoId=request.getParameter("videoId");
		try {
			Video video=videoDao.findById(videoId);
			videoDao.delete(video);
			request.setAttribute("message", "Delete video success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
			throw e;
		}
	}
	protected void reset(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			Video video=new Video();
			//video.setPoster("images/laptop.png");
			request.setAttribute("video", video);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error : "+e.getMessage());
			throw e;
		}
	}
}
