package model;

import java.util.List;
import java.util.Map;

import tools.DbUtils;

public class MyFood {
    public Integer getTableCount(String str) {
        if (str == null) {
            str = "";
        }
        String sql = "select count(rowid) ct from food where foodname like '%" + str + "%'";
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
    public PageTools getTableList(String str, Integer curPage) {
        if (str == null) {
            str = "";
        }
        Integer totalCount = getTableCount(str);
        PageTools pageTools = new PageTools(curPage, null, totalCount);
        String sql = "select * from (select t.*,f.typename,rownum rn from food t inner join foodtype f on t.typeid=f.typeid where foodname like '%" + str + "%'"
                + " order by t.foodid ) where rn>=" + pageTools.getStartIndex() + " and rn<=" + pageTools.getEndIndex() + " order by FOODID";
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
     * ��Ӳ�Ʒ
     * @param typeId  ��ϵ���
     * @param foodName ��Ʒ����
     * @param price  ��Ʒ�۸�
     * @param path ͼƬ·��
     * @param introduce ��Ʒ���
     * @throws Exception
     */
    public void saveFoode(String typeId,String foodName,String price,String path,String introduce) throws Exception {
        String sql = "insert into food values((select nvl(max(foodid),0)+1 from food)," + typeId+",'"+foodName+"',"+price+", '"+path+"','"+introduce+"'"+ ")";
        DbUtils.excute(sql);
    }

   /**
    * ɾ����Ʒ
    * @param foodId ��Ʒ���
    * @throws Exception
    */
    public void deleteFood(String foodId) throws Exception {
        String sql = "delete from food where foodId=" + foodId;
        DbUtils.excute(sql);
    }
    
   /**
    * �޸Ĳ�Ʒ
    * @param foodId ��Ʒ���
    * @param price �۸�
    * @param typeId ��ϵ���
    * @param foodName ��Ʒ����
    * @param path ͼƬ·��
    * @param introduce ��Ʒ���
    * @throws Exception
    */
    public void updateFood(String foodId,String price,String typeId,String foodName,String path,String introduce) throws Exception{      
        String sql="update food set typeid="+typeId+" , price="+price+" , foodName='"+foodName+"' , path='"+path+"', introduce='"+introduce+"' where foodid="+foodId;
        DbUtils.excute(sql);
    }
 
}
