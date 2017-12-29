package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyFoodType;


public class DeleteFoodTypeServlet extends HttpServlet {
    MyFoodType  myFoodType = new MyFoodType();

	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeId = request.getParameter("typeId");
        try {
            myFoodType.deleteFoodType(typeId);
            request.getRequestDispatcher("/listFoodType").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}


	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
