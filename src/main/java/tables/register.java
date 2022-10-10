
package tables;

import com.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import org.hibernate.*;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
        res.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = res.getWriter()) 
        {
            try 
            {
                 String name=req.getParameter("nm");
            String email=req.getParameter("email");
            String pass=req.getParameter("pass");
            String phone=req.getParameter("pn");
            String add=req.getParameter("add");
           
            User us=new User(name,email,pass,phone,add,"normal");
            
            Session ss=Factory.getFactory().openSession();
            Transaction tx=ss.beginTransaction();
            ss.save(us);
            tx.commit();            
            ss.close();
           
              HttpSession hs=req.getSession();
           hs.setAttribute("msg", "SucessFully Register!!!");
            
           res.sendRedirect("register.jsp");
            
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
