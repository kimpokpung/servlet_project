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
 * Servlet implementation class DoseoInput2Servlet
 */
@WebServlet("/nov15/doseoInput2.do")
public class DoseoInput2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoseoInput2Servlet() {
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
		Doseo doseo = new Doseo();
		doseo.code = Integer.parseInt(code); doseo.title = title;
		doseo.writer = writer; doseo.price = Integer.parseInt(price);
		doseo.publisher = company; doseo.out_date = open_date;
		doseo.info = intro;
		myPost(doseo, response);
	}
	protected void myPost(Doseo d, HttpServletResponse resp) throws ServletException, IOException{
		String q = "insert into doseo_tbl "
				+ "values(?,?,?,?,?,to_date(?,'YY/MM/DD'),?)";
		int result = -1; 
		PreparedStatement pstmt = null; Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, d.code); pstmt.setString(2, d.title);
			pstmt.setString(3, d.writer); pstmt.setInt(4, d.price);
			pstmt.setString(5, d.publisher); pstmt.setString(6, d.out_date);
			pstmt.setString(7, d.info);
			result = pstmt.executeUpdate();//insert 실행
		}catch(Exception e) {
			System.out.println("도서 정보 등록 중 문제발생!");
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		resp.sendRedirect("doseoInputResult.jsp?R="+result);
	}//데이터 베이스에 삽입

}













