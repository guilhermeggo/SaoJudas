package filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import dao.ConnectionFactory;

@WebFilter("/*")
public class ConnectionFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			ConnectionFactory.obtemConexao();
			chain.doFilter(request, response);
			ConnectionFactory.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
