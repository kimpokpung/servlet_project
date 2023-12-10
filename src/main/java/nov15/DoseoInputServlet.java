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
 * Servlet implementation class DoseoInputServlet
 */
@WebServlet("/nov15/doseoInput.do")
public class DoseoInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoseoInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");//한글처리
		String code = request.getParameter("CODE");//도서번호
		String title = request.getParameter("TITLE");//도서이름
		String writer = request.getParameter("WRITER");//저자
		String price = request.getParameter("PRICE");//가격
		String company = request.getParameter("COM");//출판사
		String open_date = request.getParameter("OPEN");//출판일
		String intro = request.getParameter("INTRO");//도서 개요
		String q = "insert into doseo_tbl "
				+ "values(?,?,?,?,?,to_date(?,'YY/MM/DD'),?)";
		int result = -1;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(code));
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setInt(4, Integer.parseInt(price));
			pstmt.setString(5, company);
			pstmt.setString(6, open_date);
			pstmt.setString(7, intro);
			result = pstmt.executeUpdate();//insert실행
			pstmt.close(); con.close();
		}catch(Exception e) {
			System.out.println("도서 등록 중 문제 발생!");
		}
		response.sendRedirect("doseoInputResult.jsp?R="+result);
	}

}















