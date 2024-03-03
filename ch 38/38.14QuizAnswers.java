import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class QuizAnswerServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
int count = 0;

int first = Integer.parseInt(req.getParameter("one").trim());
int second = Integer.parseInt(req.getParameter("two").trim());
int third = Integer.parseInt(req.getParameter("three").trim());
int fourth = Integer.parseInt(req.getParameter("four").trim());
int fifth = Integer.parseInt(req.getParameter("five").trim());
int sixth = Integer.parseInt(req.getParameter("six").trim());
int seventh = Integer.parseInt(req.getParameter("seven").trim());
int eighth = Integer.parseInt(req.getParameter("eight").trim());
int nineth = Integer.parseInt(req.getParameter("nine").trim());
int tenth = Integer.parseInt(req.getParameter("ten").trim());

if(23 + 10 == first)
count++;
if(29 + 5 == second)
count++;
if(20 + 10 == third)
count++;
if(25 + 3 == fourth)
count++;
if(28 + 9 == fifth)
count++;
if(28 + 10 == sixth)
count++;
if(23 + 8 == seventh)
count++;
if(25 + 8 == eighth)
count++;
if(24 + 5 == nineth)
count++;
if(21 + 6 == tenth)
count++;

out.println("<html><body>");

out.println("23 + 10 = "+first+""+( 23 + 10 == first ? "Correct" : "Wrong" ) + "<br>");
out.println("29 + 5 = "+second+""+( 29 + 5 == second ? "Correct" : "Wrong" )+ "<br>");
out.println("\n20 + 10 = "+third+""+( 20 + 10 == third ? "Correct" : "Wrong" )+ "<br>");
out.println("\n25 + 3 = "+fourth+""+( 25 + 3 == fourth ? "Correct" : "Wrong" )+ "<br>");
out.println("\n28 + 9 = "+fifth+""+( 28 + 9 == fifth ? "Correct" : "Wrong" )+ "<br>");
out.println("\n28 + 10 = "+sixth+""+( 28 + 10 == sixth ? "Correct" : "Wrong" )+ "<br>");
out.println("\n23 + 8 = "+seventh+""+( 23 + 8 == seventh ? "Correct" : "Wrong" )+ "<br>");
out.println("\n25 + 8 = "+eighth+""+( 25 + 8 == eighth ? "Correct" : "Wrong" )+ "<br>");
out.println("\n24 + 5 = "+nineth+""+( 24 + 5 == nineth ? "Correct" : "Wrong" )+ "<br>");
out.println("\n21 + 6 = "+tenth+""+( 21 + 6 == tenth ? "Correct" : "Wrong" )+ "<br>");

out.println("The total Correct count is : "+count);

out.println("</body></html>");

out.close();
}
