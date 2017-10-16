package com.etc.lzxp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * 针对showArticle.jsp判断用户是否登入
 */
//过滤器针对的路径文件
@WebFilter(urlPatterns={"/*"})
public class IsLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		/*HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse) req;
		//获取session
		HttpSession session = request.getSession();
		*/
		
		//获取session
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		//绝对路径
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
		+ request.getContextPath() + "/";
		
		//判断用户是否登入
		if (session.getAttribute("user") != null) {
			//继续执行下去
			chain.doFilter(req, res);	
			
		}else{
			//如果用户还未登入，则跳转页面
			response.sendRedirect(path+"login.html");
		}
	
	}

}
