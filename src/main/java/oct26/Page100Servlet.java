package oct26;

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
 * Servlet implementation class Page100Servlet
 */
@WebServlet("/page100.do")
public class Page100Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page100Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String min = request.getParameter("MIN");
		String max = request.getParameter("MAX");
		String query1 = "select last_name, salary from employees "+
				"where salary between ? and ?";//PreparedStatment
		String query2 = "select last_name, salary from employees "+
				"where salary between "+min+" and "+max;//Statement
		ArrayList al = new ArrayList();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(query2);
			PreparedStatement pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, Integer.parseInt(min));//첫번째 물음표에 데이터 설정
			pstmt.setInt(2, Integer.parseInt(max));//두번째 물음표에 데이터 설정
			ResultSet rs = pstmt.executeQuery();
			int count = 0;//건 수를 위한 변수 선언
			while(rs.next()) {
				NameSalary ns = new NameSalary();
				String name = rs.getString(1);
				int salary = rs.getInt(2);
				ns.last_name = name;
				ns.salary = salary;
				al.add(ns);
				System.out.println(name+","+salary);
				count++;//건 수 누적
			}
			System.out.println("검색된 건 수 :"+al.size());
			rs.close();
			//stmt.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB처리 중 문제 발생!!!");
		}
		request.setAttribute("DATA", al);
		RequestDispatcher rd = request.getRequestDispatcher("page100Result.jsp");
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



