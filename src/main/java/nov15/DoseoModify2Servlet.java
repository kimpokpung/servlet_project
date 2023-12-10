package nov15;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoseoModify2Servlet
 */
@WebServlet("/nov15/doseoModify2.do")
public class DoseoModify2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoseoModify2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");//한글처리
		String code = request.getParameter("CODE");
		String btn = request.getParameter("BTN");
		if(btn.equals("삭 제")) {
			int r = myDelete(code);
			response.sendRedirect("doseoDeleteResult.jsp?R="+r);
		}else if(btn.equals("변 경")) {
			int r = myUpdate(request);
			response.sendRedirect("doseoUpdateResult.jsp?R="+r);
		}
	}
	protected int myUpdate(HttpServletRequest req) {
		String q = "update doseo_tbl set title=?, writer=?, price=?, "
				+"publisher=?, out_date = to_date(?,'YY/MM/DD'), "
					+ "info=? where code=?";
		String code = req.getParameter("CODE");
		String title = req.getParameter("TITLE");
		String writer = req.getParameter("WRI");
		String publisher = req.getParameter("PUB");
		String price = req.getParameter("PRICE");
		String date = req.getParameter("DATE");
		String intro = req.getParameter("INTRO");
		Connection con=null; PreparedStatement pstmt=null; int result = -1;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, title); pstmt.setString(2, writer);
			pstmt.setInt(3, Integer.parseInt(price));
			pstmt.setString(4, publisher); pstmt.setString(5, date);
			pstmt.setString(6, intro); pstmt.setInt(7, Integer.parseInt(code));
			result = pstmt.executeUpdate();//update 실행
		}catch(Exception e) {
			System.out.println("도서정보 변경 중 문제발생!");
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	protected int myDelete(String code) {
		String q = "delete from doseo_tbl where code = ?";
		int result = -1;
		Connection con=null; PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(code));
			result = pstmt.executeUpdate();//delete 실행
		}catch(Exception e) {
			System.out.println("도서정보 삭제 중 문제발생!");
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}

}











