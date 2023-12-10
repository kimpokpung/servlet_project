package oct27;

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

import oct26.NameSalary;

/**
 * Servlet implementation class Page106Servlet
 */
@WebServlet("/page106.do")
public class Page106Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page106Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salary = request.getParameter("SAL");
		String code = request.getParameter("CODE");
		//Statement를 위한 쿼리
		String q1 = "select employee_id, last_name, job_id, salary "+
			"from employees "+
			"where salary >= "+salary+" and job_id like '%"+code+"%' ";
		//PreparedStatement를 위한 쿼리
		String q2 = "select employee_id, last_name, job_id, salary "+
			"from employees "+
			"where salary >= ? and job_id like '%' || ? || '%'";
		ArrayList al = new ArrayList();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q2);
			pstmt.setInt(1, Integer.parseInt(salary));
			pstmt.setString(2, code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1);//사번
				String irum = rs.getString(2);//이름
				String job = rs.getString(3);//업무 코드
				int sal = rs.getInt(4);//월급
				NameSalary ns = new NameSalary();
				ns.employee_id = num;
				ns.last_name = irum;
				ns.job_id = job;
				ns.salary = sal;
				al.add(ns);
				String result=num+","+irum+","+job+","+sal;
				System.out.println(result);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제 발생!");
		}
		request.setAttribute("DATA", al);
		RequestDispatcher rd = request.getRequestDispatcher("page106Result.jsp");
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
