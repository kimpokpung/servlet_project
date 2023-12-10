package nov15;

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
 * Servlet implementation class DoseoDetail2Servlet
 */
@WebServlet("/nov15/doseoDetail2.do")
public class DoseoDetail2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoseoDetail2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");
		myGet(code, request);
		RequestDispatcher rd = request.getRequestDispatcher("doseoDetail.jsp");
		rd.forward(request, response);
	}

	protected void myGet(String code, HttpServletRequest req) {
		String q = "select code,title,writer,price,publisher,"
				+ "to_char(out_date,'YYYY-MM-DD'), info from doseo_tbl where code=?";
		Doseo doseo = null;//조회결과를 저장할 변수 선언
		Connection con=null; PreparedStatement pstmt=null; ResultSet rs =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(code));
			rs = pstmt.executeQuery();//select 실행
			if(rs.next()) {
				doseo = new Doseo();
				doseo.code = rs.getInt(1); doseo.title = rs.getString(2);
				doseo.writer = rs.getString(3); doseo.price = rs.getInt(4);
				doseo.publisher = rs.getString(5);
				doseo.out_date = rs.getString(6); doseo.info = rs.getString(7);
			}
		}catch(Exception e) {
			System.out.println("도서 상세 조회 중 문제발생!");
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		req.setAttribute("DOSEO", doseo);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





