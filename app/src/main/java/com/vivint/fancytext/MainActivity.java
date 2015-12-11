package com.vivint.fancytext;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ImageSpan;
import android.util.Property;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView _fancyTextView;

    private final String _sampleText1 = "The Utah County Android Developers group is designed to foster the growth and development of Android developers in the Utah County area and all around Utah.";
    private SpannableString _sampleSpannableString = new SpannableString(_sampleText1);

    private static final Property<MutableForegroundColorSpan, Integer> ANIMATED_FOREGROUND_COLOR_PROPERTY =
            new Property<MutableForegroundColorSpan, Integer>(Integer.class, "ANIMATED_FOREGROUND_COLOR_PROPERTY") {

                @Override
                public Integer get(MutableForegroundColorSpan span) {
                    return span.getForegroundColor();
                }

                @Override
                public void set(MutableForegroundColorSpan object, Integer value) {
                    object.setForegroundColor(value);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BulletSpan bulletSpan = new BulletSpan(15, Color.BLACK);
        _sampleSpannableString.setSpan(bulletSpan, 0, _sampleText1.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.BLUE);
//        int groupNameIndex = _sampleText1.indexOf("Utah County Android Developers");
//        _sampleSpannableString.setSpan(backgroundColorSpan, groupNameIndex, groupNameIndex+30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        ImageSpan androidSpan = new ImageSpan(this, R.mipmap.ic_launcher);
//        int firstAndroid = _sampleText1.indexOf("Android");
//        _sampleSpannableString.setSpan(androidSpan,firstAndroid,firstAndroid+7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        FrameSpan frameSpan = new FrameSpan();
//        int growthStart = _sampleText1.indexOf("growth");
//        _sampleSpannableString.setSpan(frameSpan, growthStart, growthStart + 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        MutableForegroundColorSpan animatedColorSpan = new MutableForegroundColorSpan(255, Color.BLACK);
//        _sampleSpannableString.setSpan(animatedColorSpan, 0, _sampleText1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(animatedColorSpan, ANIMATED_FOREGROUND_COLOR_PROPERTY, Color.BLACK, Color.RED);
//        objectAnimator.setEvaluator(new ArgbEvaluator());
//        objectAnimator.setDuration(4000);
//        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
//        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                _fancyTextView.setText(_sampleSpannableString);
//            }
//        });
//        objectAnimator.start();



        _fancyTextView.setText(_sampleSpannableString);



    }

}
