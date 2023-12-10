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
 * Servlet implementation class Page198Servlet
 */
@WebServlet("/page198.do")
public class Page198Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page198Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("NAME");
		//PreparedStatement를 위한 쿼리
		String q = "select last_name, e.department_id, department_name "
				+ "from employees e, departments d "
				+ "where e.department_id = d.department_id "
				+ "	and lower(last_name) = lower(?)";
		//Statement를 위한 쿼리
		String qq = "select last_name, e.department_id, department_name "
				+ "from employees e, departments d "
				+ "where e.department_id = d.department_id "
				+ "	and lower(last_name) = lower('"+name+"')";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();//조회결과 0건 혹은 1건
			if(rs.next()) {//조회결과가 존재하는 경우
				Employees emp = new Employees();
				emp.name = rs.getString(1);//사원의 이름
				emp.dept_id = rs.getInt(2);//부서번호
				emp.dept_name = rs.getString(3);
				request.setAttribute("EMP", emp);//Employees객체를 내장객체에 저장
			}else {//조회결과가 존재하지 않는 경우
				request.setAttribute("EMP", null);
			}
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제발생!!!");
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher("page198Result.jsp");
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






