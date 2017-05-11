package bean;

/**
 * Created by ASUS on 2017/5/2.
 */

class Note {
    private String imgPath;

    private String noteText;
    private boolean start;
    private String creatTime;
    private String reviseTime;
    public Note(String imgPath,String noteText,boolean start,String creatTime,String reviseTime){
        this.imgPath = imgPath;
        this.noteText = noteText;
        this.creatTime = creatTime;
        this.reviseTime = reviseTime;
        this.start = start;
    }
    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(String reviseTime) {
        this.reviseTime = reviseTime;
    }

}
