package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyDesk;
import model.MyFoodType;
import model.PageTools;


public class FoodTypeServlet extends HttpServlet {
    MyFoodType  myFoodType = new MyFoodType();
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("ftName");
        String curPage = request.getParameter("curPage");
        Integer curPageIndex = 1;
        if (curPage != null) {
            curPageIndex = Integer.parseInt(curPage);
        }
        PageTools list = myFoodType.getTableList(str, curPageIndex);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/detail/cuisineList.jsp").forward(request, response);
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

} 
