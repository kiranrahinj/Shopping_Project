
package tables;
import Dao.userDao;
import com.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

   
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = res.getWriter()) 
        {
            try 
            {
                String email=req.getParameter("email");
                String pass=req.getParameter("pass");
                
                userDao ud=new userDao(Factory.getFactory());
               User us=(User)ud.getUserByEmailAndPassword(email, pass);
               HttpSession hs=req.getSession();
               
               if(us!=null)
               {
//                   hs.setAttribute("msg","SuccessFully Login");
                   hs.setAttribute("us", us);
                   if(us.getuType().equals("admin"))
                   {
                       res.sendRedirect("admin.jsp");
                   }
                   else
                   {
                       res.sendRedirect("normal.jsp");
                   }
               }
               else
               {
                   hs.setAttribute("msg","Invalid Credentials..");
                    res.sendRedirect("login.jsp");
               }
               
            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
          out.flush();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
