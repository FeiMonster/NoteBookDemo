package dao;

import java.util.List;

import base.BaseApplication;
import bean.NoteBean;

/**
 * Created by ASUS on 2017/5/3.
 */

public class NoteDao {
    /**
     * 增加数据的方法，如果有重复的则覆盖掉
     * @param noteBean
     */
    public static void insertNote(NoteBean noteBean){
        BaseApplication.getDaoInstant().getNoteBeanDao().insertOrReplace(noteBean);
    }

    /**
     * 删除单挑数据
     * @param noteBean
     */
    public static void deleteNote(NoteBean noteBean){
        BaseApplication.getDaoInstant().getNoteBeanDao().delete(noteBean);
    }

    /**
     * 更新数据
     * @param noteBean
     */
    public static void updateNote(NoteBean noteBean){
        BaseApplication.getDaoInstant().getNoteBeanDao().update(noteBean);
    }

    /**
     * 查询所有数据
     * @return
     */
    public static List<NoteBean> queryAll(){
        return BaseApplication.getDaoInstant().getNoteBeanDao().loadAll();
    }
}
