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
 * ���showArticle.jsp�ж��û��Ƿ����
 */
//��������Ե�·���ļ�
@WebFilter(urlPatterns={"/*"})
public class IsLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		/*HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse) req;
		//��ȡsession
		HttpSession session = request.getSession();
		*/
		
		//��ȡsession
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		//����·��
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
		+ request.getContextPath() + "/";
		
		//�ж��û��Ƿ����
		if (session.getAttribute("user") != null) {
			//����ִ����ȥ
			chain.doFilter(req, res);	
			
		}else{
			//����û���δ���룬����תҳ��
			response.sendRedirect(path+"login.html");
		}
	
	}

}
