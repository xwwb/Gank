package xw.gank.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xw.gank.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xw.gank.custom.ShowPoPuperWindow;

public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                ShowPoPuperWindow.showIosDialog(this);
                break;
            case R.id.button1:
                ShowPoPuperWindow.showIosNoTitleDialog(this);
                break;

            case R.id.button2:
                ShowPoPuperWindow.showMaterialDialog(this,2);
                break;
            case R.id.button3:
                ShowPoPuperWindow.NormalListDialog(this);
                break;
            case R.id.button4:
                ShowPoPuperWindow.NormalListDialogTwo(this);
                break;
        }
    }
}
