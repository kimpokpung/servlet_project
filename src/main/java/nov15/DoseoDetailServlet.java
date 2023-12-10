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
 * Servlet implementation class DoseoDetailServlet
 */
@WebServlet("/nov15/doseoDetail.do")
public class DoseoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoseoDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");
		String q = "select code,title,writer,price,publisher,"
			+ "to_char(out_date,'YYYY-MM-DD'), info from doseo_tbl where code=?";
		Doseo doseo = null;//조회결과를 저장할 변수 선언
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(code));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				doseo = new Doseo();
				doseo.code = rs.getInt(1); doseo.title = rs.getString(2);
				doseo.writer = rs.getString(3); doseo.price = rs.getInt(4);
				doseo.publisher = rs.getString(5); 
				doseo.out_date = rs.getString(6); doseo.info = rs.getString(7);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("도서 상세 조회 중 문제발생!");
		}
		request.setAttribute("DOSEO", doseo);
		RequestDispatcher rd = request.getRequestDispatcher("doseoDetail.jsp");
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







