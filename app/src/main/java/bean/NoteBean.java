package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ASUS on 2017/5/2.
 */
@Entity
public class NoteBean {
    private String imgge_path;
    @Unique
    private String title;
    private String text;
    private String creatTime;
    private String resiverTime;
    @Generated(hash = 1763391926)
    public NoteBean(String imgge_path, String title, String text, String creatTime,
            String resiverTime) {
        this.imgge_path = imgge_path;
        this.title = title;
        this.text = text;
        this.creatTime = creatTime;
        this.resiverTime = resiverTime;
    }
    @Generated(hash = 451626881)
    public NoteBean() {
    }
    public String getImgge_path() {
        return this.imgge_path;
    }
    public void setImgge_path(String imgge_path) {
        this.imgge_path = imgge_path;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getCreatTime() {
        return this.creatTime;
    }
    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }
    public String getResiverTime() {
        return this.resiverTime;
    }
    public void setResiverTime(String resiverTime) {
        this.resiverTime = resiverTime;
    }
}
