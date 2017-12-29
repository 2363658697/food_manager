package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyOrder;
import model.MyOrderDetail;
import model.PageTools;

public class OrderDetailServlet extends HttpServlet {
    MyOrderDetail detail = new MyOrderDetail();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        List<Map<String, String>> list;
        try {
            list = detail.getOrderDetail(orderId);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/detail/orderDetail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

}
