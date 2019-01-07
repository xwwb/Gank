package xw.gank.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.xw.gank.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnackBarActivity extends MyBaseActivity {


    @BindView(R.id.snackbar_fab)
    FloatingActionButton snackbarFab;
    @BindView(R.id.snackbar_container)
    CoordinatorLayout snackbarContainer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void initView() {
      immersionBar.titleBar(toolbar);
    }

    @Override
    protected void setListern() {


    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_snack_bar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.snackbar_fab)
    public void onViewClicked() {
        Snackbar.make(snackbarContainer, "这是一个SnackBar", Snackbar.LENGTH_SHORT)
                .setAction("action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(snackbarContainer, "Action 被点击", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .addCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(SnackBarActivity.this, "Snackbar隐藏", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        Toast.makeText(SnackBarActivity.this, "Snackbar显示", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }
}
