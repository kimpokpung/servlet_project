package nov13;

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
 * Servlet implementation class SangpoomUpdateServlet
 */
@WebServlet("/nov13/sangpoomUpdate.do")
public class SangpoomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SangpoomUpdateServlet() {
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
		request.setCharacterEncoding("EUC-KR");
		String btn = request.getParameter("BTN");//버튼의 제목
		if(btn.equals("수정")) {
			String code = request.getParameter("CD");//상품번호
			String title = request.getParameter("TITLE");//상품이름
			String price = request.getParameter("PRICE");//가격
			String nation = request.getParameter("NATION");//원산지
			String p_date = request.getParameter("P_DATE");//제조일
			String num = request.getParameter("NUM");//재고량
			String i_date = request.getParameter("IN_DATE");//입고일
			String q = "update sangpoom_tbl set title=?,price=?,nation=?,"
					+ "product_date=to_date(?,'YY/MM/DD'),num=?,"
					+ "input_date=to_date(?,'YY/MM/DD') where code=?";
			int result = -1;//변경 결과를 저장하기 위한 변수 선언
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setString(1, title); pstmt.setInt(2, Integer.parseInt(price));
				pstmt.setString(3, nation); pstmt.setString(4, p_date);
				pstmt.setInt(5, Integer.parseInt(num));
				pstmt.setString(6, i_date); pstmt.setInt(7, Integer.parseInt(code));
				result = pstmt.executeUpdate();//update 실행
				pstmt.close(); con.close();
			}catch(Exception e) {
				System.out.println("상품정보 변경 중 문제발생!");
			}
			//redirect(sangpoomUpdateResult.jsp)
			response.sendRedirect("sangpoomUpdateResult.jsp?R="+result);
		}else if(btn.equals("삭제")) {
			String code = request.getParameter("CD");//상품번호
			String q = "delete from sangpoom_tbl where code=?";
			int result = -1;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setInt(1, Integer.parseInt(code));
				result = pstmt.executeUpdate();//delete실행
				pstmt.close(); con.close();
			}catch(Exception e) {
				System.out.println("삭제 작업 중 문제 발생");
			}
			response.sendRedirect("sangpoomDeleteResult.jsp?R="+result);
		}//if의 끝
	}//doPost의 끝

}//서블릿의 끝














