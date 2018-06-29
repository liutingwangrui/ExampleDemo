package example.com.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import example.com.library.util.glide.GlideLoadImgUtil;

/**
 * Created by Administrator on 2018/6/29 0029.
 */

public class GlideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ImageView normalGlide=findViewById(R.id.normal_glide);
        ImageView circleGlide=findViewById(R.id.circle_glide);
        ImageView roundGlide=findViewById(R.id.round_glide);
        GlideLoadImgUtil.loadImageView(this,normalGlide,"http://img03.tooopen.com/uploadfile/downs/images/20110714/sy_20110714135215645030.jpg");
        GlideLoadImgUtil.loadCircleImageView(this,circleGlide,"http://img03.tooopen.com/uploadfile/downs/images/20110714/sy_20110714135215645030.jpg");
        GlideLoadImgUtil.loadRoundImageView(this,roundGlide,"http://img03.tooopen.com/uploadfile/downs/images/20110714/sy_20110714135215645030.jpg");
    }
}
