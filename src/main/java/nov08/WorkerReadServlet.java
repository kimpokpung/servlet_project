package nov08;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkerReadServlet
 */
@WebServlet("/nov08/workerRead.do")
public class WorkerReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkerReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클릭한 사원번호로 조회
		String id = request.getParameter("SABEON");
		String q = "select employee_id, first_name,"
				+ "last_name, email, phone_number,"
				+ "to_char(hire_date,'YYYY/MM/DD'), job_id,"
				+ "salary, commission_pct, manager_id,"
				+ "department_id from employees where employee_id = ?";
		WorkerInfo wi = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				wi = new WorkerInfo();
				wi.emp_id = rs.getInt(1);//사번
				wi.f_name = rs.getString(2);//성
				wi.l_name = rs.getString(3);//이름
				wi.email = rs.getString(4);//이메일
				wi.phone = rs.getString(5);//전화번호
				wi.hire_date = rs.getString(6);//입사일
				wi.job_id = rs.getString(7);//업무코드
				wi.salary = rs.getInt(8);//월급
				wi.commission = rs.getDouble(9);//커미션
				wi.man_id = rs.getInt(10);//관리자 사번
				wi.dept_id = rs.getInt(11);//부서번호
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 작업 중 문제발생!");
		}
		request.setAttribute("INFO", wi);
		RequestDispatcher rd = request.getRequestDispatcher("workerInfo.jsp");
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





