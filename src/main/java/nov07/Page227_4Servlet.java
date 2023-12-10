package nov07;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatemen;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page227_4Servlet
 */
@WebServlet("/nov07/page227_4.do")
public class Page227_4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page227_4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String munja = request.getParameter("CHAR");
		String q = "select last_name, department_name "
				+ "from employees e, departments d "
				+ "where e.department_id = d.department_id and "
				+ "	last_name like '%'|| ? || '%'";
		ArrayList<WorkerDetail> al = new ArrayList<WorkerDetail>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, munja);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				WorkerDetail wd = new WorkerDetail();
				wd.last_name = rs.getString(1);//사원 이름
				wd.d_name = rs.getString(2);//부서 이름
				al.add(wd);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 작업 중 문제 발생!");
		}
		request.setAttribute("DETAIL", al);
		RequestDispatcher rd = request.getRequestDispatcher("page227_4Result.jsp");
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

class Tiger {}





