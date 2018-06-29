package example.com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import example.com.library.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView clickToast;
    private TextView clickGlide;
    private TextView clickRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickToast = findViewById(R.id.click_toast);
        clickGlide = findViewById(R.id.click_glide);
        clickRefresh = findViewById(R.id.click_refresh);
        initClick();
    }

    private void initClick() {
        clickToast.setOnClickListener(this);
        clickGlide.setOnClickListener(this);
        clickRefresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.click_toast:
                ToastUtil.show(this,R.string.toast_namt,200);
                break;
            case R.id.click_glide:
                startActivity(new Intent(MainActivity.this,GlideActivity.class));
                break;
                case R.id.click_refresh:
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
                break;
        }
    }
}
