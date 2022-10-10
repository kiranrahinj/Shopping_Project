
package tables;

import com.Factory;
import Dao.categoryDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.hibernate.*;

@WebServlet(name = "productsData", urlPatterns = {"/productsData"})
@MultipartConfig(fileSizeThreshold = 1024*1024*10,
                 maxFileSize = 1024*1024*50,
                 maxRequestSize = 1024*1024*100)
public class productsData extends HttpServlet {

  
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = res.getWriter()) {
            
            try 
            {
                //fetching form values
                String pName=req.getParameter("pname");
                String pDesc=req.getParameter("pdesc");
                String pPrice=req.getParameter("price");
                int Price=Integer.parseInt(pPrice);
                String cate=req.getParameter("cat");
                int pCat=Integer.parseInt(cate);
                Part pic=req.getPart("pic");
                
                //getting category byb using cat id..
                SessionFactory factory=Factory.getFactory();
                categoryDao p=new categoryDao(factory);
                Category pcat=p.getCategoryById(pCat);
                
                //adding products
                Products pd=new Products();
                pd.setpName(pName);
                pd.setCategory(pcat);
                pd.setPrice(Price);
                pd.setPhoto(pic.getSubmittedFileName());
                pd.setpDesc(pDesc);
                
                //pic uploading...
                String path=req.getRealPath("components")+File.separator+"img"+File.separator+"products"+File.separator+pic.getSubmittedFileName();
//                System.out.print(path);
                
                FileOutputStream fos=new FileOutputStream(path);
                InputStream is=pic.getInputStream();
                
                byte data[]=new byte[is.available()];
                
                is.read(data);
                fos.write(data);
                fos.close();
                is.close();
                
                //saving data into db..
                Session ss=factory.openSession();
                Transaction tx = ss.beginTransaction();
                ss.save(pd);
                tx.commit();
                ss.close();
                 
                res.sendRedirect("admin.jsp");
                out.flush();
            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
 

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
