package nov08;

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
 * Servlet implementation class DeptListServlet
 */
@WebServlet("/nov08/deptList.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = "select department_id, department_name from departments";
		ArrayList<DeptInfo> al = new ArrayList<DeptInfo>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next()) {
				DeptInfo di = new DeptInfo();
				di.dept_id = rs.getInt(1);
				di.dept_name = rs.getString(2);
				al.add(di);
			}
			rs.close(); stmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB처리 중 문제 발생!");
		}
		request.setAttribute("DEPTS", al);
		RequestDispatcher rd = request.getRequestDispatcher("deptListResult.jsp");
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







