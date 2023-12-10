package nov07;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page226_1Servlet
 */
@WebServlet("/nov07/page226_1.do")
public class Page226_1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page226_1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = "select last_name, e.department_id, department_name "
				+ "from employees e, departments d "
				+ "where e.department_id = d.department_id";
		ArrayList al = new ArrayList();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next()) {
				WorkerDetail wd = new WorkerDetail();
				wd.last_name = rs.getString(1);//사원 이름
				wd.d_id = rs.getInt(2);//부서번호
				wd.d_name = rs.getString(3);//부서이름
				al.add(wd);
			}
			rs.close(); stmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 작업 중 문제발생!");
		}
		//페이지 전환(Forward)
		request.setAttribute("WD", al);
		RequestDispatcher rd = request.getRequestDispatcher("page226_1Result.jsp");
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







