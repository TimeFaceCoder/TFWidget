package cn.timeface.widget.drawabletextview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author wxw
 * @from 2015/9/15
 * @TODO ImageView + TextView 组件
 */
public class DrawableTextView extends LinearLayout {

    public enum DrawablePosition {
        LEFT, RIGHT, TOP, BOTTOM
    }

    private ImageView ivDrawable;
    private TextView tvContent;

    private ImageView.ScaleType mScaleType;
    private DrawablePosition mDrawablePosition = DrawablePosition.LEFT;
    private Drawable mDrawable;
    private int mDrawablePadding = 0;
    private int mDrawableWidth = LayoutParams.WRAP_CONTENT;// ImageView Width
    private int mDrawableHeight = LayoutParams.WRAP_CONTENT;// ImageView Height

    private ColorStateList mTextColor;
    private int mTextSize = 0;
    private int mTextGravity = 0;
    private String mTextContent;

    public DrawableTextView(Context context) {
        super(context);
        init();
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DrawableTextView, defStyleAttr, 0);
        mScaleType = ImageView.ScaleType.values()[a.getInt(R.styleable.DrawableTextView_scaleType, 3)];
        mDrawable = a.getDrawable(R.styleable.DrawableTextView_drawableSrc);
        mDrawablePadding = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawablePadding, -1);
        mDrawableWidth = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableWidth, LayoutParams.WRAP_CONTENT);
        mDrawableHeight = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableHeight, LayoutParams.WRAP_CONTENT);
        mDrawablePosition = DrawablePosition.values()[a.getInt(R.styleable.DrawableTextView_drawablePosition, 0)];
        mTextSize = a.getDimensionPixelOffset(R.styleable.DrawableTextView_textSize, -1);
        mTextGravity = a.getInt(R.styleable.DrawableTextView_textGravity, -1);
        mTextColor = a.getColorStateList(R.styleable.DrawableTextView_textColor);
        mTextContent = a.getString(R.styleable.DrawableTextView_text);
        a.recycle();
        init();
    }

    private void init() {
        ivDrawable = new ImageView(getContext());
        LayoutParams lp = new LayoutParams(mDrawableWidth, mDrawableHeight);
        ivDrawable.setLayoutParams(lp);

        tvContent = new TextView(getContext());

        if (mTextSize > 0) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        }

        if (!TextUtils.isEmpty(mTextContent)) {
            setText(mTextContent);
        }

        if (mTextColor != null) {
            setTextColor(mTextColor);
        }

        if (mTextGravity > 0) {
            setTextGravity(mTextGravity);
        }

        if (mDrawablePadding > 0) {
            setDrawablePadding(mDrawablePadding);
        }

        showContent();
        setScaleType(mScaleType);
    }

    private void showContent() {
        switch (mDrawablePosition) {
            case LEFT:
                setOrientation(HORIZONTAL);
                this.removeAllViews();
                this.addView(ivDrawable);
                this.addView(tvContent);
                break;
            case RIGHT:
                setOrientation(HORIZONTAL);
                this.removeAllViews();
                this.addView(tvContent);
                this.addView(ivDrawable);
                break;
            case TOP:
                setOrientation(VERTICAL);
                this.removeAllViews();
                this.addView(ivDrawable);
                this.addView(tvContent);
                break;
            case BOTTOM:
                setOrientation(VERTICAL);
                this.removeAllViews();
                this.addView(tvContent);
                this.addView(ivDrawable);
                break;
        }

        if (ivDrawable != null && mDrawable != null) {
            ivDrawable.setImageDrawable(mDrawable);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null && mScaleType != scaleType) {
            mScaleType = scaleType;
            ivDrawable.setScaleType(mScaleType);
        }
    }

    public void setDrawablePosition(DrawablePosition drawablePosition) {
        if (drawablePosition != null && mDrawablePosition != drawablePosition) {
            mDrawablePosition = drawablePosition;
            setDrawablePadding(mDrawablePadding);
            showContent();
        }
    }

    public DrawablePosition getDrawablePosition() {
        return mDrawablePosition;
    }

    public void setDrawablePadding(int drawablePadding) {
        mDrawablePadding = drawablePadding;
        if (tvContent != null) {
            switch (mDrawablePosition) {
                case LEFT:
                case RIGHT:
                    tvContent.setPadding(mDrawablePadding, 0, mDrawablePadding, 0);
                    break;
                case TOP:
                case BOTTOM:
                    tvContent.setPadding(0, mDrawablePadding, 0, mDrawablePadding);
                    break;
            }
        }
    }

    public void setDrawableSize(Point size) {
        if (ivDrawable != null) {
            mDrawableWidth = size.x;
            mDrawableHeight = size.y;
            LayoutParams lp = new LayoutParams(mDrawableWidth, mDrawableHeight);
            ivDrawable.setLayoutParams(lp);
        }
    }

    public void setTextSize(float textSize) {
        if (tvContent != null) {
            tvContent.setTextSize(textSize);
        }
    }

    public void setTextSize(int unit, int textSize) {
        if (tvContent != null) {
            tvContent.setTextSize(unit, textSize);
        }
    }

    public void setTextGravity(int gravity) {
        if (tvContent != null) {
            tvContent.setGravity(gravity);
        }
    }

    public void setText(String text) {
        if (text != null && tvContent != null) {
            mTextContent = text;
            tvContent.setText(mTextContent);
        }
    }

    public void setTextColor(ColorStateList textColor) {
        if (textColor != null && tvContent != null) {
            mTextColor = textColor;
            tvContent.setTextColor(mTextColor);
        }
    }

    public void setTextColor(int textColor) {
        if (tvContent != null) {
            tvContent.setTextColor(textColor);
        }
    }

    public void setImageResource(int resId) {
        if (ivDrawable != null) {
            ivDrawable.setImageResource(resId);
        }
    }

    public TextView getTextView() {
        return tvContent;
    }

    public ImageView getImageView() {
        return ivDrawable;
    }

}
