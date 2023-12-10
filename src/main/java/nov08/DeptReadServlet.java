package nov08;

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
 * Servlet implementation class DeptReadServlet
 */
@WebServlet("/nov08/deptRead.do")
public class DeptReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d_id = request.getParameter("DID");
		String q = "select department_id, department_name, "
				+ "manager_id, location_id from departments "
				+ "where department_id = ?";
		DeptInfo di = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(d_id));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {//조회 결과로 이동
				di = new DeptInfo();
				di.dept_id = rs.getInt(1);//부서번호
				di.dept_name = rs.getString(2);//부서이름
				di.man_id = rs.getInt(3);//관리자 사번
				di.loc_id = rs.getInt(4);//부서 위치 번호
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 작업 중 문제발생!");
		}
		request.setAttribute("D_INFO", di);
		RequestDispatcher rd = request.getRequestDispatcher("deptRead.jsp");
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







