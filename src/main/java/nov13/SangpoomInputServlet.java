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
 * Servlet implementation class SangpoomInputServlet
 */
@WebServlet("/nov13/sangpoomInput.do")
public class SangpoomInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SangpoomInputServlet() {
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
			String code = request.getParameter("CODE");//상품번호
			String title = request.getParameter("TITLE");//상품이름
			String price = request.getParameter("PRICE");//상품가격
			String nation = request.getParameter("NATION");//원산지
			String product_date = request.getParameter("P_DATE");//제조일
			String num = request.getParameter("NUM");//재고량
			String input_date = request.getParameter("IN_DATE");//입고일
			String q = "insert into sangpoom_tbl "
				+ "values(?,?,?,?,to_date(?,'YY/MM/DD'),?,to_date(?,'YY/MM/DD'))";
			int result = -1;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setInt(1, Integer.parseInt(code));//상품번호
				pstmt.setString(2, title);//상품이름
				pstmt.setInt(3, Integer.parseInt(price));//상품가격
				pstmt.setString(4, nation);//원산지
				pstmt.setString(5, product_date);//제조일
				pstmt.setInt(6, Integer.parseInt(num));//재고량
				pstmt.setString(7, input_date);//입고일
				result = pstmt.executeUpdate();//insert 실행
			}catch(Exception e) {
				System.out.println("DB 처리 중 문제발생!");
			}
			//페이지를 전환한다.(sangpoomInputResult.jsp)Forward/Redirect
			response.sendRedirect("sangpoomInputResult.jsp?R="+result);
		}else if(btn.equals("조 회")) {
			String q = "select code,title,price,nation,"
					+ "to_char(product_date,'YY/MM/DD'),num,"
					+ "to_char(input_date,'YY/MM/DD') from sangpoom_tbl";
			ArrayList<SangPoom> al = new ArrayList<SangPoom>();
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(q);
				while(rs.next()) {
					SangPoom sp = new SangPoom();
					sp.code = rs.getInt(1);
					sp.title = rs.getString(2);
					sp.price = rs.getInt(3);
					sp.nation = rs.getString(4);
					sp.p_date = rs.getString(5);
					sp.num = rs.getInt(6);
					sp.in_date = rs.getString(7);
					al.add(sp);
				}
				rs.close(); stmt.close(); con.close();
			}catch(Exception e) {
				System.out.println("DB 조회 중 문제 발생!");
			}//try의 끝
			request.setAttribute("SPLIST", al);
			RequestDispatcher rd = request.getRequestDispatcher(
					"sangpoomList.jsp");
			rd.forward(request, response);
		}//if의 끝
	}//doPost의 끝

}//서블릿의 끝















