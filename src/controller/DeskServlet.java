package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyDesk;
import model.PageTools;

public class DeskServlet extends HttpServlet {
    MyDesk myDesk = new MyDesk();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("dname");
        String curPage = request.getParameter("curPage");
        Integer curPageIndex = 1;
        if (curPage != null) {
            curPageIndex = Integer.parseInt(curPage);
        }
        PageTools list = myDesk.getTableList(str, curPageIndex);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/detail/boardList.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
