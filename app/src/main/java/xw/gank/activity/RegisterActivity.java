package xw.gank.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xw.gank.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xw.gank.info.RegisterBean;
import xw.gank.retrofit.ApiService;
import xw.gank.retrofit.ConstantApi;
import xw.gank.retrofit.RetrofitUtils;
import xw.gank.utils.RegexUtils;

public class RegisterActivity extends MyBaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.til_account)
    TextInputLayout tilAccount;
    @BindView(R.id.tiet_password)
    EditText tietPassword;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.re_password)
    TextInputLayout rePassword;
    @BindView(R.id.textInputLayout)
    LinearLayout textInputLayout;

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        immersionBar.titleBar(toolbar);
    }

    @Override
    protected void setListern() {
        etAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 11) {
                    boolean basePhone = RegexUtils.isBasePhone(s.toString());
                    if (basePhone) {
                        tilAccount.setErrorEnabled(false);
                    } else {
                        tilAccount.setErrorEnabled(true);
                        tilAccount.setError("请输入正确的手机号");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tietPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 8) {
                    tilPassword.setErrorEnabled(false);
                } else {
                    tilPassword.setErrorEnabled(true);
                    tilPassword.setError("密码长度必须大于8");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        repassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = tietPassword.getText().toString();
                if (s.length() >= 8) {
                    tilPassword.setErrorEnabled(false);
                    if (!password.equals(s.toString())) {
                        tilPassword.setErrorEnabled(true);
                        tilPassword.setError("两次密码不一致");
                    }
                } else {
                    tilPassword.setErrorEnabled(true);
                    tilPassword.setError("密码长度必须大于8");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    public void register(View view) {
        String count = etAccount.getText().toString();
        String password = tietPassword.getText().toString();
        String repassword = this.repassword.getText().toString();
        if (TextUtils.isEmpty(count) && TextUtils.isEmpty(password) && TextUtils.isEmpty(repassword)) {
            Toast.makeText(this, "注册信息不完整,请核对", Toast.LENGTH_SHORT).show();
        } else {
            register(count, password, repassword);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void register(String count, String password, String repassword) {
        RetrofitUtils.getInstance(this, ConstantApi.AboutAndroidUrlBase).create(ApiService.class).register(count, password, repassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        if (registerBean.getErrorCode() == -1) {
                            Toast.makeText(context, "" + registerBean.getErrorMsg(), Toast.LENGTH_SHORT).show();
                        } else if (registerBean.getErrorCode() == 0) {
                            Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
                        }

                        Log.i("=======onNext", registerBean.getErrorMsg() + "====" + registerBean.getErrorCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("=======onError", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
