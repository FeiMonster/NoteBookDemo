package base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import monster.com.mynotebook.gen.DaoMaster;
import monster.com.mynotebook.gen.DaoSession;

/**
 * Created by ASUS on 2017/5/2.
 */

public class BaseApplication extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
        setupDatabase();
    }

    private void setupDatabase() {
        //创建数据库note.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "note.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取dao对象管理者
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoInstant(){
        return daoSession;
    }
}
