package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyFood;
import model.MyFoodType;
import model.PageTools;


public class FoodServlet extends HttpServlet {

    MyFood myFood = new MyFood();
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("fName");
        String curPage = request.getParameter("curPage");
        Integer curPageIndex = 1;
        if (curPage != null) {
            curPageIndex = Integer.parseInt(curPage);
        }
        PageTools list = myFood.getTableList(str, curPageIndex);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/detail/foodList.jsp").forward(request, response);
    }

    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.doGet(request, response);
    }

}
