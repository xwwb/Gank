package xw.gank.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xw.gank.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//    //    getWindow().setEnterTransition(new Explode());
//       getWindow().setEnterTransition(new Slide());
   //     getWindow().setEnterTransition(new Fade());
        setContentView(R.layout.activity_test);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    //    getWindow().setExitTransition(new Explode());
      //  getWindow().setExitTransition(new Slide());
      //  getWindow().setExitrTransition(new Fade());
    }
}
