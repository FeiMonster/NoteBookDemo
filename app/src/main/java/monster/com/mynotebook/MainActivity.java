package monster.com.mynotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import adapter.NoteAdapter;
import bean.NoteBean;
import dao.NoteDao;

public class MainActivity extends AppCompatActivity {
    private ImageButton search;
    private ImageButton add_note;
    private RecyclerView recyclerView;
    private List<NoteBean> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        clickEvents();
        initDatas();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        NoteAdapter adapter = new NoteAdapter(MainActivity.this,mData);
        recyclerView.setAdapter(adapter);

    }

    private void initDatas() {
        mData = new ArrayList<NoteBean>();
        mData = NoteDao.queryAll();
    }

    private void initViews() {
        search = (ImageButton) findViewById(R.id.search);
        add_note = (ImageButton) findViewById(R.id.add_note);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    private void clickEvents() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //搜索按钮


            }
        });
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NoteActivity.class);
                startActivity(intent);
            }
        });
    }


}
