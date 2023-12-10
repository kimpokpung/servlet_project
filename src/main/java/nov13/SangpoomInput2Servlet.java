package nov13;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class SangpoomInput2Servlet
 */
@WebServlet("/nov13/sangpoomInput2.do")
public class SangpoomInput2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SangpoomInput2Servlet() {
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
		request.setCharacterEncoding("euc-kr");//POST인 경우의 한글처리
		String btn = request.getParameter("BTN");//버튼의 제목 
		if(btn.equals("등 록")) {
			myInsert(request, response);
		}else if(btn.equals("조 회")) {
			mySelect(request, response);
		}
	}
	protected void mySelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String q = "select code,title,price,nation,"
				+ "to_char(product_date,'YY/MM/DD'),num,"
				+ "to_char(input_date,'YY/MM/DD') from sangpoom_tbl";
		ArrayList<SangPoom> list = new ArrayList<SangPoom>();
		Connection con=null; Statement stmt=null; ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			stmt = con.createStatement();
			rs = stmt.executeQuery(q);
			while(rs.next()) {
				SangPoom sp = new SangPoom();
				sp.code = rs.getInt(1); sp.title = rs.getString(2);
				sp.price = rs.getInt(3); sp.nation = rs.getString(4);
				sp.p_date = rs.getString(5); sp.num = rs.getInt(6);
				sp.in_date = rs.getString(7);
				list.add(sp);
			}
		}catch(Exception e) {
			System.out.println("상품 전체 조회 중 문제 발생!");
		}finally {
			try {
				rs.close(); stmt.close(); con.close();
			}catch(Exception e) {}
		}
		request.setAttribute("SPLIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("sangpoomList.jsp");
		rd.forward(request, response);
	}
	protected void myInsert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String q = "insert into sangpoom_tbl "
			+ "values(?,?,?,?,to_date(?,'YY/MM/DD'),?,to_date(?,'YY/MM/DD'))";
		String code = request.getParameter("CODE");//상품번호
		String title = request.getParameter("TITLE");//상품이름
		String price = request.getParameter("PRICE");//상품가격
		String nation = request.getParameter("NATION");//원산지
		String product_date = request.getParameter("P_DATE");//제조일
		String num = request.getParameter("NUM");//재고량
		String input_date = request.getParameter("IN_DATE");//입고일
		int result = -1; Connection con = null;	PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(code));
			pstmt.setString(2, title); pstmt.setInt(3, Integer.parseInt(price));
			pstmt.setString(4, nation); pstmt.setString(5, product_date);
			pstmt.setInt(6, Integer.parseInt(num));
			pstmt.setString(7, input_date);
			result = pstmt.executeUpdate();//insert실행
		}catch(Exception e) {
			System.out.println("상품등록 중 문제발생!");
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		response.sendRedirect("sangpoomInputResult.jsp?R="+result);
	}

}












