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

/**
 * Servlet implementation class Page144Servlet
 */
@WebServlet("/page144.do")
public class Page144Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page144Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mon = request.getParameter("MONTH");
		//PreparedStatement를 위한 쿼리
		String q = "select employee_id, hire_date, "
				+ "months_between(sysdate, hire_date) TENURE,"
				+ "add_months(hire_date,6) REVIEW, "
				+ "next_day(hire_date,'금요일'),"
				+ "last_day(hire_date) from employees "
				+ "where months_between(sysdate, hire_date) < ?";
		ArrayList al = new ArrayList();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(mon));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int sabeon = rs.getInt(1);//사번
				String hire_date = rs.getString(2);//입사일
				double month = rs.getDouble(3);//달 수
				String review = rs.getString(4);//급여 검토일
				String friday = rs.getString(5);//금요일
				String last_day = rs.getString(6);//마지막 날짜
				Page144 page144 = new Page144();
				page144.employee_id = sabeon;
				page144.hire_date = hire_date;
				page144.tenure = month;
				page144.review = review;
				page144.next_day = friday;
				page144.last_day = last_day;
				al.add(page144);
				String result=sabeon+","+hire_date+","+month+","+
						review+","+friday+","+last_day;
				System.out.println(result);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제 발생!");
		}
		request.setAttribute("DATA", al);
		RequestDispatcher rd = request.getRequestDispatcher("page144Result.jsp");
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



