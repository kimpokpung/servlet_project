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

@WebServlet("/oct30.do")
public class Oct30Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Oct30Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("EID");//입력한 사번을 가져옴
		//PreparedStatement를 위한 쿼리
		String q = "select * from employees where employee_id = ?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(id));//첫번째 ?에 사번(정수)을 넣는다.
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {//조회 결과가 존재하는 경우
				Sawon sawon = new Sawon();
				sawon.emp_id = rs.getInt(1);//사번을 위한 변수
				sawon.first = rs.getString(2);//성을 위한 변수
				sawon.name = rs.getString(3);//이름을 위한 변수
				sawon.email = rs.getString(4);//이메일을 위한 변수
				sawon.phone = rs.getString(5);//전화번호를 위한 변수
				sawon.date = rs.getString(6);//입사일을 위한 변수
				sawon.code = rs.getString(7);//업무코드
				sawon.salary = rs.getInt(8);//월급
				sawon.comm = rs.getDouble(9);//커미션
				sawon.manager = rs.getInt(10);//관리자 사번
				sawon.dept = rs.getInt(11);//부서번호
				request.setAttribute("SAWON", sawon);
			}else {//조회 결과가 존재하지 않는 경우
				request.setAttribute("R", "NO");
			}
		}catch(Exception e) {
			System.out.println("DB 처리 중 문제 발생!!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("oct30Result.jsp");
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






