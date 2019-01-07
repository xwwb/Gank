package xw.gank.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xw.gank.R;
import com.xw.library.utils.utils.Utils;

import java.util.List;

import xw.gank.info.BookBean;

/**
 * Created by Administrator on 2018/4/27.
 */

public class BookRecycleViewAdapter extends BaseRecycleAdapter<BookBean.BooksBean> {


    private OnItemClickListern onItemClickListern;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOnItemClickListern(OnItemClickListern onItemClickListern) {
        this.onItemClickListern = onItemClickListern;
    }

    public BookRecycleViewAdapter(List<BookBean.BooksBean> datas) {
        super(datas);
    }


    @Override
    protected void bindData(BaseViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListern!=null){
                    onItemClickListern.OnClickListern(position);
                }

            }
        });
        ImageView imageView = (ImageView) holder.getView(R.id.image);
        TextView textView = (TextView) holder.getView(R.id.textbook_title);
        TextView price = (TextView) holder.getView(R.id.text_price);
        BookBean.BooksBean booksBean = datas.get(position);
        String ebook_price = booksBean.getEbook_price();
        price.setText(""+ebook_price);
        String large = booksBean.getImages().getSmall();
        Utils.setPicassoImage(context,large,imageView,R.mipmap.plachold);
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycleviewbook_item;

    }
    public interface OnItemClickListern {
        void OnClickListern(int position);
    }
}
