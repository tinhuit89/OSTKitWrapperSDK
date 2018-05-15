package capo.mobile.sdk.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import capo.mobile.sdk.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitle;
    private Button btnCreateUser;
    private Button btnListUser;
    private Button btnTransDetail;
    private Button btnMakeTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initView();
        this.initData();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        btnCreateUser = (Button) findViewById(R.id.btnCreateUser);
        btnListUser = (Button) findViewById(R.id.btnListUser);
        btnTransDetail = (Button) findViewById(R.id.btnTransDetail);
        btnMakeTrans = (Button) findViewById(R.id.btnMakeTrans);
    }

    private void initData() {
        btnCreateUser.setOnClickListener(this);
        btnListUser.setOnClickListener(this);
        btnTransDetail.setOnClickListener(this);
        btnMakeTrans.setOnClickListener(this);
    }

    private void changeActivitys(Class activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    @Override
    public void onClick(View v) {
        if (v == btnCreateUser) {
            changeActivitys(MainTabActivty.class);
        } else if (v == btnListUser) {
            changeActivitys(MainTabActivty.class);
        } else if (v == btnTransDetail) {
            changeActivitys(MainTabActivty.class);
        } else if (v == btnMakeTrans) {
            changeActivitys(MainTabActivty.class);
        }
    }
}
