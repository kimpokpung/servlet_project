package dbtest;

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
 * Servlet implementation class DBConServlet
 */
@WebServlet("/dbcon.do")
public class DBConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("YEAR");
		String query = "select last_name, hire_date "+
				"from employees where hire_date like '"+name+"%'";
		String query2 = "select last_name, hire_date "+
				"from employees where hire_date like ? || '%' ";
		//프로그램을 통한 SQL은 세미콜론을 붙이지 않는다.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			System.out.println("DB접속 성공!!!");
//			Statement stmt = con.createStatement();	
//			stmt.executeQuery(query);
			PreparedStatement pstmt = con.prepareStatement(query2);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			int count = 0;//건수를 위한 변수
			while(rs.next()) {
				String workerName = rs.getString(1);
				String hire_date = rs.getString(2);
				System.out.println(workerName+","+hire_date);
				count++;
			}
			System.out.println("검색된 건 수:"+count);
			rs.close();//사용해제
			pstmt.close();//사용해제
			con.close();//연결해제
			
			System.out.println("쿼리 전송 성공!!!");
			System.out.println(query);
		}catch(Exception e) {
			System.out.println("DB접속 실패!!!");
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
