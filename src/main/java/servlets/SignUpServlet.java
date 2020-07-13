package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;
    
    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }
    
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        //System.out.println( "sign up" );
        
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        
        if (login == null || pass == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        
        accountService.addNewUser(new UserProfile(login, pass, "EMAIL"));
    
        //response.setContentType("text/html;charset=utf-8");
        //response.getWriter().println(json);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}