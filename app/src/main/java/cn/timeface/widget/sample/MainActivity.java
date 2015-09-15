package cn.timeface.widget.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.timeface.widget.drawabletextview.DrawableTextView;

public class MainActivity extends AppCompatActivity {

    DrawableTextView drawableTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawableTextView = (DrawableTextView) findViewById(R.id.dtv);
    }

    public void OnTextClick(View view) {
        switch (drawableTextView.getDrawablePosition()) {
            case LEFT:
                drawableTextView.setDrawablePosition(DrawableTextView.DrawablePosition.RIGHT);
                break;
            case RIGHT:
                drawableTextView.setDrawablePosition(DrawableTextView.DrawablePosition.TOP);
                break;
            case TOP:
                drawableTextView.setDrawablePosition(DrawableTextView.DrawablePosition.BOTTOM);
                break;
            case BOTTOM:
                drawableTextView.setDrawablePosition(DrawableTextView.DrawablePosition.LEFT);
                break;
        }
    }
}
