package adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import bean.NoteBean;
import monster.com.mynotebook.R;

/**
 * Created by ASUS on 2017/5/3.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private List<NoteBean> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public NoteAdapter(Context context,List<NoteBean> data ){
        mContext = context;
        mData = data;
        mInflater  = LayoutInflater.from(mContext);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.note_item,null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_text.setText(mData.get(position).getText());
        holder.tv_creat.setText(mData.get(position).getCreatTime());
        holder.tv_save.setText(mData.get(position).getResiverTime());
        holder.iv_myPic.setImageBitmap(BitmapFactory.decodeFile(mData.get(position).getImgge_path()));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_text;
        TextView tv_creat;
        TextView tv_save;
        ImageView iv_myPic;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            tv_creat = (TextView) itemView.findViewById(R.id.tv_creat);
            tv_save = (TextView) itemView.findViewById(R.id.tv_save);
            iv_myPic = (ImageView) itemView.findViewById(R.id.iv_myPic);
        }
    }
}
