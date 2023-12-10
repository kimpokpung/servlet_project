package nov15;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class DoseoListServlet
 */
@WebServlet("/nov15/doseoList.do")
public class DoseoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoseoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = "select code,title,writer,price,publisher,"
				+ "to_char(out_date,'YY/MM/DD'),info from doseo_tbl";
		ArrayList<Doseo> al = new ArrayList<Doseo>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next()) {
				Doseo doseo = new Doseo();
				doseo.code = rs.getInt(1);
				doseo.title = rs.getString(2);
				doseo.writer = rs.getString(3);
				doseo.price = rs.getInt(4);
				doseo.publisher = rs.getString(5);
				doseo.out_date = rs.getString(6);
				doseo.info = rs.getString(7);
				al.add(doseo);
			}
			rs.close(); stmt.close(); con.close();			
		}catch(Exception e) {
			System.out.println("도서 목록 검색 중 문제 발생!");
		}
		request.setAttribute("LIST", al);
		RequestDispatcher rd = request.getRequestDispatcher("doseoList.jsp");
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






