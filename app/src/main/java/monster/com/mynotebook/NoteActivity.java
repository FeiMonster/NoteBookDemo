package monster.com.mynotebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.donkingliang.imageselector.utils.ImageSelectorUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.NoteBean;
import dao.NoteDao;

/**
 * Created by ASUS on 2017/5/2.
 */
public class NoteActivity extends AppCompatActivity{
    private EditText edt_title;
    private EditText edt_text;
    private ImageView iv_wenzi;
    private ImageView iv_home;
    private static final int REQUEST_CODE = 100;
    private ImageView iv_check;
    private ImageView iv_take;
    private List<NoteBean> notes;
    private String myTitle;
    private String myText;
    private String path;
    private String s;
    private ImageView iv_save;
    private String end;
    private ImageView ic_pic;
    private Bitmap bitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        initView();
        initEvent();

    }
    private void initView() {
        iv_check = (ImageView) findViewById(R.id.iv_check);
        iv_take  = (ImageView) findViewById(R.id.iv_take);
        edt_text = (EditText) findViewById(R.id.edt_text);
        edt_title = (EditText) findViewById(R.id.edt_titles);
        iv_wenzi = (ImageView) findViewById(R.id.iv_home);
        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_save = (ImageView) findViewById(R.id.iv_save);
        ic_pic = (ImageView) findViewById(R.id.iv_pic);
    }

    /**
     * 获取当前时间
     * @return
     */
    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date();
        String str = format.format(curDate);
        return str;
    }


    private void initEvent() {
        /**
         * 图库选择
         */
        iv_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = getTime();
                ImageSelectorUtils.openPhoto(NoteActivity.this, REQUEST_CODE, true, 0);


            }
        });
        iv_wenzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击编辑文字

            }
        });
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击主页
                toMainAcyivity();
            }
        });
        iv_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开相机
            }
        });
        /**
         * 保存记事
         */
        iv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end = getTime();
                addDatas();
                toMainAcyivity();
            }
        });
    }
    private void addDatas(){
        myTitle = edt_title.getText().toString();
        myText = edt_text.getText().toString();
        NoteBean noteBean = new NoteBean();
        noteBean.setTitle(myTitle);
        noteBean.setText(myText);
        noteBean.setImgge_path(path);
        noteBean.setCreatTime("创建时间:"+s);
        noteBean.setResiverTime("最后修改时间"+end);
        NoteDao.insertNote(noteBean);
    }
    private void toMainAcyivity() {
        Intent intent = new Intent(NoteActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 打开图库的接收数据的方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && data!=null){
            //成功
            //获取选择器返回的数据，图片的文件路径。
            ArrayList<String> images =  data.getStringArrayListExtra(
                    ImageSelectorUtils.SELECT_RESULT);
            for (int i = 0;i<images.size();i++){
                path = images.get(i);
                bitmap = BitmapFactory.decodeFile(path);
                ic_pic.setImageBitmap(bitmap);
            }
        }
    }


}
