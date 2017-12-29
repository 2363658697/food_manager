package model;

import java.util.List;
import java.util.Map;

import tools.DbUtils;

public class MyFoodType {
    public Integer getTableCount(String str) {
        if (str == null) {
            str = "";
        }
        String sql = "select count(rowid) ct from foodtype where typename like '%" + str + "%'";
         List<Map<String, String>> list = null;
        try {
            list = DbUtils.query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer count = Integer.parseInt(list.get(0).get("CT").toString());
        return count;
    }

    public PageTools getTableList(String str, Integer curPage) {
        if (str == null) {
            str = "";
        }
        Integer totalCount = getTableCount(str);
        PageTools pageTools = new PageTools(curPage, null, totalCount);
        String sql = "select * from (select t.*,rownum rn from foodtype t where typename like '%" + str + "%'" + " order by t.typeid ) where rn>="
                + pageTools.getStartIndex() + "and rn<=" + pageTools.getEndIndex()+"order by typeid";
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
     *��Ӳ�ϵ
     * @param deskName ��ϵ��
     * @throws Exception
     */
    public void saveFoodType(String ftName) throws Exception{
        String sql="insert into foodtype values((select nvl(max(typeid),0)+1 from foodtype),'"+ftName+"')";
        DbUtils.excute(sql);
    }
    /**
     * ɾ����ϵ
     * @param deskId ��ϵ���
     * @throws Exception
     */
    public void deleteFoodType(String typeId) throws Exception{
        String sql="delete from foodtype where typeId="+typeId;
        DbUtils.excute(sql);
    }
    /**
     * ���²�ϵ
     * @param typeId ��ϵ���
     * @param ftName ��ϵ����
     * @throws Exception
     */
    public void updateFoodType(String typeId,String ftName) throws Exception{
        String sql="update foodtype set typename='"+ftName+"' where typeid="+typeId;
        DbUtils.excute(sql);
    }
    
    public String getTypeNameById(String typeID) throws Exception{
        String sql = "select TYPENAME from foodtype where TYPEID = " + typeID;
        String typeName = DbUtils.query(sql).get(0).get("TYPENAME").toString();
        return typeName;
    }
    
    public  List<Map<String, String>> getAllType() throws Exception{
        String sql = "select * from foodtype order by typeid";
         List<Map<String, String>> list = DbUtils.query(sql);
        return list;
    }
   
}
