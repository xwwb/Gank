package xw.gank.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.xw.gank.R;

/**
 * Created by skysoft on 2018/9/21.
 */

public class CustDialog extends View {
    public CustDialog(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycleview_empty_layout, null);

    }

}
