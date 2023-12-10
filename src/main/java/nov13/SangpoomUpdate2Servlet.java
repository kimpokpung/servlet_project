package nov13;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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
import javax.xml.ws.Response;

/**
 * Servlet implementation class SangpoomUpdate2Servlet
 */
@WebServlet("/nov13/sangpoomUpdate2.do")
public class SangpoomUpdate2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SangpoomUpdate2Servlet() {
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
		if(btn.equals("삭제")) {
			int r = doDelete(request);
			response.sendRedirect("sangpoomDeleteResult.jsp?R="+r);
		}else if(btn.equals("수정")){
			doUpdate(request, response);
		}
	}
	
	protected int //void
	doDelete(HttpServletRequest req//, HttpServletResponse resp
			) //throws ServletException, IOException 
	{
		String code = req.getParameter("CD");//상품번호
		String q = "delete from sangpoom_tbl where code=?";
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(code));
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DB삭제중 오류 발생");
			System.out.println(e.getMessage());
		}finally {
			try {
				con.close(); pstmt.close();
			} catch (Exception e) {
				
			}
		}
		//resp.sendRedirect("sangpoomDeleteResult.jsp?R="+result);
		return result;
	}
	
	protected void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("CD");//상품번호
		String title = req.getParameter("TITLE");//상품이름
		String price = req.getParameter("PRICE");//가격
		String nation = req.getParameter("NATION");//원산지
		String p_date = req.getParameter("P_DATE");//제조일
		String num = req.getParameter("NUM");//재고량
		String i_date = req.getParameter("IN_DATE");//입고일
		String q = "update sangpoom_tbl set title=?,price=?,nation=?,"
				+ "product_date=to_date(?,'YY/MM/DD'),num=?,"
				+ "input_date=to_date(?,'YY/MM/DD') where code=?";
		int result = -1;//변경 결과를 저장하기 위한 변수 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, title); pstmt.setInt(2, Integer.parseInt(price));
			pstmt.setString(3, nation); pstmt.setString(4, p_date);
			pstmt.setInt(5, Integer.parseInt(num));
			pstmt.setString(6, i_date); pstmt.setInt(7, Integer.parseInt(code));
			result = pstmt.executeUpdate();//update 실행
		} catch (Exception e) {
			System.out.println("DB수정중 문제 발생");
		}finally {
			try {
				con.close(); pstmt.close();
			} catch (Exception e) {
			}
		}
		resp.sendRedirect("sangpoomUpdateResult.jsp?R="+result);
	}
	
}
