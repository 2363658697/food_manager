package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyDesk;

public class DeleteDeskServlet extends HttpServlet {

    MyDesk myDesk = new MyDesk();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deskId = request.getParameter("did");
        try {
            myDesk.deleteDesk(deskId);
            request.getRequestDispatcher("/listDesk").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}
