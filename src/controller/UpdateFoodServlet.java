package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.MyFood;

public class UpdateFoodServlet extends HttpServlet {

    static String SAVE_DIR = "E:/images";

    MyFood myFood = new MyFood();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String foodId = null;
        String typeId = null;
        String foodName = null;
        String price = null;
        String path=null;
        String introduce=null;
        // �û����������ļ��ϴ��Ĺ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // ���ڴ������н����ļ�
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // �����ַ�����
        upload.setHeaderEncoding("UTF-8");

      //�������·����ȡ����·��
        ServletContext sContext=this.getServletContext();
        String name=sContext.getRealPath("style/images");
        
        try {
            // �������յ����ļ������ı���
            List<FileItem> items = upload.parseRequest(request);
            // ��ӡ�ϴ����ļ�����
            // System.out.println(fileItems.size());
            for (FileItem item : items) {
                // �ж��Ƿ����ı���
                if (item.isFormField()) {
                    if ("foodName".equals(item.getFieldName())) {
                        foodName = item.getString("UTF-8");
                    } else if ("typeId".equals(item.getFieldName())) {
                        typeId = item.getString();
                    } else if ("price".equals(item.getFieldName())) {
                        price = item.getString();
                    }else if ("introduce".equals(item.getFieldName())) {
                        introduce=item.getString("UTF-8");
                    }else if ("foodId".equals(item.getFieldName())) {
                        foodId=item.getString("UTF-8");
                    }
                } else {
                    // ��ȡ�ϴ����ļ���
                    String fileName = item.getName();
                    
                    // �ļ�����·��
                    String destPath = SAVE_DIR + "/" + fileName; 
                    
                    
                    path = "/" + fileName;

                    // ��ȡ������
                    InputStream iStream = item.getInputStream();
                    // ��������������ϴ����ļ������ڷ�����
                    FileOutputStream fOutputStream = new FileOutputStream(destPath);
                    byte[] bs = new byte[1024];
                    int read = -1;
                    while ((read = iStream.read(bs)) != -1) {
                        fOutputStream.write(bs, 0, read);
                    }
                    // �ر���ͨ��
                    iStream.close();
                    fOutputStream.close();

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        
        try {
            myFood.updateFood(foodId, price, typeId, foodName, path, introduce);
            request.getRequestDispatcher("/listFood").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
