package maven04.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.catalina.connector.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ConnectionFilter implements Filter{

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		SessionFactory sessionFactory;
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable t){
			Exception exception = new Exception("Falha ao criar sessionFactory",t);
			throw new ExceptionInInitializerError(exception);
		}
		
		req.setAttribute("SessionFactory", sessionFactory);
		
		System.out.println("-doFilter");
		chain.doFilter(req, res);
		

	}

	public void init(FilterConfig config) throws ServletException {

		
	}

}
