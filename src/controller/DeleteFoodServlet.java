package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyFood;


public class DeleteFoodServlet extends HttpServlet {
    MyFood myFood = new MyFood();
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodId = request.getParameter("foodId");
        try {
            myFood.deleteFood(foodId);
            request.getRequestDispatcher("/listFood").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}
