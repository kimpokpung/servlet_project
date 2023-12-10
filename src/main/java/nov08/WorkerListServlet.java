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
 * Servlet implementation class WorkerListServlet
 */
@WebServlet("/nov08/workerList.do")
public class WorkerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = "select employee_id, last_name, "
				+ "department_name, e.department_id "
				+ "from employees e, departments d "
				+ "where e.department_id = d.department_id";
		ArrayList<Worker> al = new ArrayList<Worker>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next()) {
				Worker w = new Worker();
				w.emp_id = rs.getInt(1);//사번
				w.name = rs.getString(2);//이름
				w.dept_name = rs.getString(3);//부서이름
				w.dept_id = rs.getInt(4);//부서번호
				al.add(w);
			}
			rs.close(); stmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 작업 중 문제발생!");
		}
		request.setAttribute("WORKER", al);
		RequestDispatcher rd = request.getRequestDispatcher("workerListResult.jsp");
		rd.forward(request, response);
	}
}















