package oct30;

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
 * Servlet implementation class Oct30_1Servlet
 */
@WebServlet("/oct30_1.do")
public class Oct30_1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oct30_1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept = request.getParameter("DEPT");
		String q = "select * from departments where department_id = ?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(dept));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {//조회결과가 존재하는 경우
				Dept dpt = new Dept();
				dpt.dept_id = rs.getInt(1);//부서번호를 저장
				dpt.name = rs.getString(2);//부서이름을 저장
				dpt.manager_id = rs.getInt(3);//관리자 사번을 저장
				dpt.loc_id = rs.getInt(4);//위치번호를 저장
				request.setAttribute("DEPT", dpt);
			}else {//조회결과가 존재하지 않는 경우
				request.setAttribute("DEPT", null);
			}
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제발생!!!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("oct30_1Result.jsp");
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





