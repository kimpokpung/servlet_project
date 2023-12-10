package nov02;

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
 * Servlet implementation class Page240Servlet
 */
@WebServlet("/page240.do")
public class Page240Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page240Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String did = request.getParameter("D_ID");
		String q = "select count(*) from employees where department_id = ?";
		int count = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(did));
			ResultSet rs = pstmt.executeQuery();
			rs.next();//무조건 조회결과가 존재하므로, 조회결과로 1번 이동한다.
			count = rs.getInt(1);
			request.setAttribute("CNT", count);
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제발생!");
		}
//		response.sendRedirect("page240Result.jsp?CNT="+count);
		RequestDispatcher rd = request.getRequestDispatcher("page240Result.jsp");
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
