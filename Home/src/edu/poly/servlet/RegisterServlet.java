package edu.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import edu.poly.dao.UserDao;
import edu.poly.entity.User;
import edu.poly.utils.HibernateUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({"/RegisterServlet","/RegisterServlet/edit","/RegisterServlet/create",
	"/RegisterServlet/update","/RegisterServlet/delete","/RegisterServlet/reset"})
public class RegisterServlet extends HttpServlet {
	private UserDao userDao;
	

	public RegisterServlet() {
		super();
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=request.getRequestURL().toString();
		if(url.contains("edit")) {
			edit(request, response);
		}else if(url.contains("delete")) {
			delete(request, response);
		}else if(url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		
		findAllPage(request, response);

		request.getRequestDispatcher("/auth/register.jsp").forward(request,response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		if(url.contains("create")) {
			insert(request, response);
		}else if(url.contains("delete")) {
			delete(request, response);
		}else if(url.contains("update")) {
			update(request, response);
		}else if(url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		findAllPage(request, response);
		request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setRole(1);
			userDao.store(user);
			System.out.println(user);
			request.setAttribute("user", user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("userId"));
			
		try {
			User user=userDao.findById(id);
			BeanUtils.populate(user, request.getParameterMap());
			
			
			userDao.update(user);
			request.setAttribute("user", user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("userId"));
	try {
		userDao.delete(id);
		request.setAttribute("user", new User());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	protected void findAllPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int offset=0,limit=10;
			List<User> list=userDao.Paginate(offset, limit);
			
			request.setAttribute("listAll", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}		
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id=request.getParameter("userId");
			Integer id1=Integer.parseInt(id);
			User user=userDao.findById(id1);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}		

}
