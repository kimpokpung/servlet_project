package oct27;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page160Servlet
 */
@WebServlet("/page160.do")
public class Page160Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page160Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("NAME");
		//PreparedStatement를 위한 쿼리
		String q = "select to_char(salary,'$99,999.00') salary "
				+ "from employees where last_name = ?";
		//Statement를 위한 쿼리
		String qq = "select to_char(salary,'$99,999.00') salary "
				+ "from employees where last_name = '"+name+"'";
		String salary = "";
		String url = "page160Result.jsp?SAL=";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {//조회결과로 1번 이동, 조회결과가 1건이므로.
				salary = rs.getString(1);
				url = url + salary;
				request.setAttribute("SALARY", salary);
			}else {
				url = url + "NO";
				request.setAttribute("SALARY", "NO");
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제발생!");
		}
		//page160Result.jsp로 페이지 전환(Redirect, Forward)
		//response.sendRedirect(url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




