package model;

import java.util.List;
import java.util.Map;

import tools.DbUtils;

public class MyOrder {
    public Integer getTableCount() {
        String sql = "select count(rowid) ct from foodorder order by orderid";
         List<Map<String, String>> list = null;
        try {
            list = DbUtils.query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer count = Integer.parseInt(list.get(0).get("CT").toString());
        return count;
    }
    /**
     * ��ҳ
     * @param str ����
     * @param curPage ����ҳ
     * @return
     */
    public PageTools getTableList(Integer curPage) {

        Integer totalCount = getTableCount();
        PageTools pageTools = new PageTools(curPage, null, totalCount);
        String sql = "select * from (select f.*,d.dname,rownum rn  from foodorder f inner join desk d on f.deskid=d.deskid order by f.orderid)  where rn>=" + pageTools.getStartIndex() + " and rn<=" + pageTools.getEndIndex() + " order by ORDERID";
         List<Map<String, String>> list = null;
        try {
            list = DbUtils.query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageTools.setData(list);
        return pageTools;
    }
    
    /**
     * ͨ��������Ż�ȡ�ö������ܼ۸�
     * @param orderId �������
     * @return  String
     */
    public  String getAllPrice(String orderId){
        String sql = "select sum(f.price*fd.gcount) as price from foodorderdetail fd inner join food f on fd.foodid=f.foodid where orderid="+orderId;
        String string="";
        try {
            List<Map<String, String>> list = DbUtils.query(sql);
            string= list.get(0).get("PRICE").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }
    
    /**
     * �޸Ķ���״̬
     * @param orderId �������
     * @throws Exception
     */
    public void updateOrder(String orderId) throws Exception {
        String sql="update foodorder set orderstate=1 where orderid="+orderId;
        DbUtils.excute(sql);
    }
    
}
