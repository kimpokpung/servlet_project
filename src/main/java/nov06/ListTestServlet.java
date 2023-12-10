package nov06;

import java.io.IOException;
import java.util.ArrayLis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListTestServlet
 */
@WebServlet("/ListTestServlet")
public class ListTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList al1 = new ArrayList();
		al1.add(100);//정수 저장
		al1.add(3.14);//실수 저장
		al1.add("KOR");//문자열 저장
		Employee e1 = new Employee();//첫번째 사원
		e1.employee_id = 100;//사번
		e1.first_name = "홍";//성
		e1.last_name = "길동";//이름
		e1.department_id = 500;//부서번호
		al1.add(e1);//Employee객체 저장
		Employee e2 = new Employee();//두번째 사원
		e2.employee_id = 101; e2.first_name = "오"; e2.last_name = "길동";
		e2.department_id = 600;//부서번호
		al1.add(e2);//Employee객체 저장
		int count = al1.size();
		System.out.println("저장된 데이터의 갯수:"+count);
	}
}
class Employee {
	int employee_id;//사번
	String first_name;//성
	String last_name;//이름
	int department_id;//부서번호
}















