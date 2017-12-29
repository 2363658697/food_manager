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
     * 分页
     * @param str 列名
     * @param curPage 数据页
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
     * 添加菜品
     * @param typeId  菜系编号
     * @param foodName 菜品名称
     * @param price  菜品价格
     * @param path 图片路径
     * @param introduce 菜品简介
     * @throws Exception
     */
    public void saveFoode(String typeId,String foodName,String price,String path,String introduce) throws Exception {
        String sql = "insert into food values((select nvl(max(foodid),0)+1 from food)," + typeId+",'"+foodName+"',"+price+", '"+path+"','"+introduce+"'"+ ")";
        DbUtils.excute(sql);
    }

   /**
    * 删除菜品
    * @param foodId 菜品编号
    * @throws Exception
    */
    public void deleteFood(String foodId) throws Exception {
        String sql = "delete from food where foodId=" + foodId;
        DbUtils.excute(sql);
    }
    
   /**
    * 修改菜品
    * @param foodId 菜品编号
    * @param price 价格
    * @param typeId 菜系编号
    * @param foodName 菜品名称
    * @param path 图片路径
    * @param introduce 菜品简介
    * @throws Exception
    */
    public void updateFood(String foodId,String price,String typeId,String foodName,String path,String introduce) throws Exception{      
        String sql="update food set typeid="+typeId+" , price="+price+" , foodName='"+foodName+"' , path='"+path+"', introduce='"+introduce+"' where foodid="+foodId;
        DbUtils.excute(sql);
    }
 
}
