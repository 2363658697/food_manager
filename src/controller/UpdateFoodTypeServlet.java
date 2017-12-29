package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyFoodType;

public class UpdateFoodTypeServlet extends HttpServlet {
    MyFoodType myFoodType = new MyFoodType();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String typeId = request.getParameter("typeId");
        String ftName = request.getParameter("ftName");
        try {
            myFoodType.updateFoodType(typeId, ftName);
            request.getRequestDispatcher("/listFoodType").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}
