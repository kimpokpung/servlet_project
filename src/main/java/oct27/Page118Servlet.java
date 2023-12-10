package oct27;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page118Servlet
 */
@WebServlet("/page118.do")
public class Page118Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page118Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("NUM");
		//Statement를 위한 쿼리
		String qq = "select last_name, department_id from employees "+
				"where employee_id = "+num;
		//PreparedStatement를 위한 쿼리
		String q = "select last_name, department_id from employees "+
			"where employee_id = ?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(num));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);//이름
				int dept = rs.getInt(2);//부서번호
				System.out.println("이름:"+name+",부서번호:"+dept);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB처리 중 문제 발생!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



