package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import tools.DbUtils;

public class MyDesk {
    public Integer getTableCount(String str) {
        if (str == null) {
            str = "";
        }
        String sql = "select count(rowid) ct from desk where dname like '%" + str + "%'";
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
        String sql = "select * from (select t.*,rownum rn from desk t where dname like '%" + str + "%'" + " order by t.deskid ) where rn>="
                + pageTools.getStartIndex() + "and rn<=" + pageTools.getEndIndex()+"order by deskid";
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
     *Ìí¼Ó²Í×À
     * @param deskName ²Í×ÀÃû
     * @throws Exception
     */
    public void saveDesk(String deskName) throws Exception{
        String sql="insert into desk values((select max(deskid)+1 from desk),'"+deskName+"',0,'')";
        DbUtils.excute(sql);
    }
    /**
     * É¾³ý²Í×À
     * @param deskId ²Í×À±àºÅ
     * @throws Exception
     */
    public void deleteDesk(String deskId) throws Exception{
        String sql="delete from desk where deskid="+deskId;
        DbUtils.excute(sql);
    }
    /**
     * ÐÞ¸Ä²Í×À×´Ì¬
     * @param deskId ²Í×À±àºÅ
     * @throws Exception
     */
    public void updateDesk(String deskId,String dState) throws Exception{
        Integer integer=Integer.parseInt(dState);
        String sql="";
        if(integer==0){
            sql="update desk set dstate=1,dtime=sysdate where deskid="+deskId;       
        }else {
            sql="update desk set dstate=0,dtime='' where deskid="+deskId;
        }
        DbUtils.excute(sql);
    }
}
