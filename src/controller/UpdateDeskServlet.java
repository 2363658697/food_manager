package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyDesk;

public class UpdateDeskServlet extends HttpServlet {
    MyDesk myDesk = new MyDesk();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String deskId=request.getParameter("did");
        String dState=request.getParameter("dstate");
        try {
            myDesk.updateDesk(deskId, dState);
            request.getRequestDispatcher("/listDesk").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
