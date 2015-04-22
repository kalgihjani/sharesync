/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reg;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class sendmail extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static String CLIENT_ID = "<put your client id here>.apps.googleusercontent.com";
  private static String CLIENT_SECRET = "<put your client secret here>";

  private static String REDIRECT_URI = "http://hellopratixadrive.appspot.com/hellodevanshi";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
    
        try {
           String rcvid=request.getParameter("skydrive_acc");
       
           String code=accesscode.randomAlphaNumeric(15);
           //String sendrid="";
           
           String gmailCode=request.getParameter("code");
           
           HttpTransport httpTransport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();
   
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
        .setAccessType("offline")
        .setApprovalPrompt("auto").build();
    
    String url = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();
   
   // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //  String code = br.readLine();
    
    GoogleTokenResponse response1 = flow.newTokenRequest(gmailCode).setRedirectUri(REDIRECT_URI).execute();
    GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response1);
    
    String accesstoken=response1.getAccessToken();
    System.out.println(response1.getExpiresInSeconds());
           session.setAttribute("acc_code", code);
           session.setAttribute("gmailToken", accesstoken);
           // JOptionPane.showMessageDialog(null, "" +sendrid+ "in sendmail");
           Mail m1=new Mail();
           int a=m1.sendMail(rcvid,code);
          // System.out.println(a);
           //JOptionPane.showMessageDialog(null, a);
           response.sendRedirect("reg_finalstep.jsp");
           
       
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
