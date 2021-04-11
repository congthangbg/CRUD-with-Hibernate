package edu.poly.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.entity.User;
import edu.poly.utils.CheckData;
import edu.poly.utils.HibernateUtils;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet({ "/UserManagement", "/UserManagement/create", "/UserManagement/update", "/UserManagement/delete",
		"/UserManagement/edit", "/UserManagement/reset" })
public class UserManagementServlet extends HttpServlet {
	private UserDao userDao;

	public UserManagementServlet() {
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		try {
			if (url.contains("edit")) {
				edit(request,response);
			} else if (url.contains("delete")) {
				delete(request, response);
			} else if (url.contains("reset")) {
				reset(request,response);
			}
			
			findAll(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);// chuyển hg và hiển thị trang
																						// USER_MANAGEMENT
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		try {
			if (url.contains("create")) {
				create(request, response);

			} else if (url.contains("delete")) {
				delete(request,response);

			} else if (url.contains("update")) {
				update(request, response);
			} else if (url.contains("reset")) {
				reset(request, response);
			}

			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error" + e.getMessage());
		}
		//PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		response.sendRedirect(request.getContextPath()+"/UserManagement");
	}


	private void reset(HttpServletRequest request, HttpServletResponse response) {
		User user=new User();
		request.setAttribute("user", user);
		
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userId=request.getParameter("userId");
			User user= userDao.findById(userId);
			System.out.println(user);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error edit :" + e.getMessage());
			throw e;
		}
	}
	private void create(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		BeanUtils.populate(user, request.getParameterMap());
		response.setContentType("text/plain");
		boolean check = true;
		try {
			if (CheckData.isNull(request.getParameter("userId"))) {
				check = false;
				request.setAttribute("error", "Chưa nhập UserId !");
			} else if (CheckData.isNull(request.getParameter("fullname"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập Fullname !");
			} else if (CheckData.isNull(request.getParameter("password"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập password !");
			} else if (CheckData.isNull(request.getParameter("email"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập email !");
			}
			List<User> list = userDao.findAll2();

			for (User user2 : list) {
				if (CheckData.isExist(user.getUserId(), user2.getUserId())) {
					check = false;
					request.setAttribute("user", user);
					request.setAttribute("error", "User id đã tồn tại!");
				}
			}
			if (check == true) {
				PrintWriter out=response.getWriter();
				UserDao dao = new UserDao();
				dao.insert(user);
				out.print(user); 
				request.setAttribute("user", user);
				System.out.println(user);
				request.setAttribute("message", "Insert success!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error :" + e.getMessage());
			throw e;

		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		BeanUtils.populate(user, request.getParameterMap());
		boolean check = true;
		try {
			if (CheckData.isNull(request.getParameter("userId"))) {
				check = false;
				request.setAttribute("error", "Chưa nhập UserId !");
			} else if (CheckData.isNull(request.getParameter("fullname"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập Fullname !");
			} else if (CheckData.isNull(request.getParameter("password"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập password !");
			} else if (CheckData.isNull(request.getParameter("email"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập email !");
			}
			List<User> list = userDao.findAll2();

			if (check == true) {
				UserDao dao = new UserDao();
				dao.update(user);
				request.setAttribute("message", "Update success!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error :" + e.getMessage());
			throw e;

		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userId=request.getParameter("userId");
			User user= userDao.findById(userId);
			System.out.println(user);
			
			userDao.delete(user);	
			request.setAttribute("message", "Delete success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error delete: "+e.getMessage());
			throw e;
		}
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageStr = request.getParameter("page");
		String limitStr = request.getParameter("limit");

		try {
			int page1 = pageStr == null ? 1 : Integer.parseInt(pageStr);
			int limit = limitStr == null ? 5 : Integer.parseInt(limitStr);
			if (page1 < 1) {
				page1 = 1;
			}
			if (page1 >= limit - 1) {
				page1 = limit-1;
			}
			int offset = limit * (page1 - 1);

			List<User> list = userDao.findAll(offset, limit);
			request.setAttribute("page1", page1);
			request.setAttribute("userList", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "FindAll not found!!! " + e.getMessage());
			throw e;
		}
	}

	private void findAll2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {

			List<User> list = userDao.findAll2();
			request.setAttribute("userList", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "FindAll not found!!! " + e.getMessage());
			throw e;
		}
	}
}
