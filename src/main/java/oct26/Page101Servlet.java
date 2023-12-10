package oct26;

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
 * Servlet implementation class Page101Servlet
 */
@WebServlet("/page101.do")
public class Page101Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page101Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String man1 = request.getParameter("MAN1");
		String man2 = request.getParameter("MAN2");
		String man3 = request.getParameter("MAN3");
		//Statement를 위한 쿼리
		String q1 = "select employee_id, last_name, salary, manager_id "+
				"from employees where manager_id in("+man1+","+man2+","+
				man3+")";
		//PreparedStatement를 위한 쿼리
		String q2 = "select employee_id, last_name, salary, manager_id "+
				"from employees where manager_id in(?,?,?)";
		ArrayList al = new ArrayList();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q1);
			int count = 0;//검색된 건 수를 위한 변수
			while(rs.next()) {
				NameSalary ns = new NameSalary();
				int sabeon = rs.getInt(1);//사번
				String name = rs.getString(2);//이름
				int salary = rs.getInt(3);//월급
				int manager = rs.getInt(4);//관리자의 사번
				ns.employee_id = sabeon;
				ns.last_name = name;
				ns.salary = salary;
				ns.manager_id = manager;
				al.add(ns);
				String result = sabeon+","+name+","+salary+","+manager;
				System.out.println(result);
				count++;
			}
			System.out.println("검색된 건 수 :"+count);
			rs.close(); 
			stmt.close();
			con.close();
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제 발생!");
		}
		request.setAttribute("DATA", al);
		RequestDispatcher rd = request.getRequestDispatcher("page101Result.jsp");
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
