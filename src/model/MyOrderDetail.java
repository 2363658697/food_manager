package model;

import java.util.List;
import java.util.Map;

import tools.DbUtils;

public class MyOrderDetail {
        public List<Map<String, String>> getOrderDetail(String orderId) throws Exception {
            String sql="select f.foodname,f.price,fd.gcount from foodorderdetail fd inner join food f on fd.foodid=f.foodid where orderid="+orderId;
            List<Map<String, String>> list=DbUtils.query(sql);
            return list;
        }
}
