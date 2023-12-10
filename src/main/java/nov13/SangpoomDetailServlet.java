package nov13;

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
 * Servlet implementation class SangpoomDetailServlet
 */
@WebServlet("/nov13/sangpoomDetail.do")
public class SangpoomDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SangpoomDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");
		String q = "select code,title,price,nation,"+
			"to_char(product_date,'YY/MM/DD'),num,"
			+ "to_char(input_date,'YY/MM/DD') from sangpoom_tbl "
			+ "where code = ?";
		SangPoom sp = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, Integer.parseInt(code));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				sp = new SangPoom();
				sp.code = rs.getInt(1);		sp.title = rs.getString(2);
				sp.price = rs.getInt(3);	sp.nation = rs.getString(4);
				sp.p_date = rs.getString(5); sp.num = rs.getInt(6);
				sp.in_date = rs.getString(7);
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e) {
			//System.out.println(e.getMessage());//1줄짜리 문장 출력
			e.printStackTrace();//여러줄짜리 문장출력 
			System.out.println("제품 상세 조회 중 문제발생!");
		}
		request.setAttribute("SP", sp);
		RequestDispatcher rd = request.getRequestDispatcher("sangpoomDetail.jsp");
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
