# DrawableTextView
A library that include ImageView &amp; TextView.

You can set the position of ImageView & TextView.


###Gradle

```groovy
dependencies {
    compile 'cn.timeface.widget:drawabletextview:1.0.0'
}
```


##Usage

layout.xml for DrawableTextView

```xml
<cn.timeface.widget.drawabletextview.DrawableTextView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_weight="1"
        android:gravity="center"
        app:drawableHeight="20dp"
        app:drawablePadding="8dp"
        app:drawablePosition="left"
        app:drawableSrc="@mipmap/ic_launcher"
        app:drawableWidth="20dp"
        app:scaleType="CENTER"
        app:text="1"
        app:textColor="#8db550"
        app:textGravity="center"
        app:textSize="16sp" />
```


attrs for DrawableTextView

```xml
<declare-styleable name="DrawableTextView">
    <attr name="drawablePosition" format="enum">
        <enum name="left" value="0" />
        <enum name="right" value="1" />
        <enum name="top" value="2" />
        <enum name="bottom" value="3" />
    </attr>
    <attr name="drawablePadding" format="dimension" />
    <attr name="drawableWidth" format="dimension" />
    <attr name="drawableHeight" format="dimension" />
    <attr name="drawableSrc" format="reference|color" />
    <attr name="scaleType" format="enum">
        <enum name="CENTER" value="0" />
        <enum name="CENTER_CROP" value="1" />
        <enum name="CENTER_INSIDE" value="2" />
        <enum name="FIT_CENTER" value="3" />
        <enum name="FIT_END" value="4" />
        <enum name="FIT_START" value="5" />
        <enum name="FIT_XY" value="6" />
        <enum name="MATRIX" value="7" />
    </attr>
    <attr name="text" format="string" />
    <attr name="textColor" format="color" />
    <attr name="textSize" format="dimension" />
    <attr name="textGravity" format="enum">
        <enum name="no_gravity" value="0" />
        <enum name="center_horizontal" value="1" />
        <enum name="left" value="3" />
        <enum name="center_vertical" value="16" />
        <enum name="center" value="17" />
        <enum name="right" value="5" />
        <enum name="top" value="48" />
        <enum name="bottom" value="80" />
    </attr>
</declare-styleable>
```


MainActivity.java for DrawableTextView

```java
DrawableTextView drawableTextView = (DrawableTextView) findViewById(R.id.dtv);
drawableTextView.setImageResource(R.mipmap.ic_launcher);
drawableTextView.setDrawablePosition(DrawableTextView.DrawablePosition.RIGHT);
drawableTextView.setDrawablePadding(20);
drawableTextView.setDrawableSize(new Point(20, 20));

drawableTextView.setText("DrawableTextView");
drawableTextView.setTextSize(18);
drawableTextView.setTextColor(Color.BLACK);
drawableTextView.setTextGravity(Gravity.CENTER);

drawableTextView.getTextView().setSingleLine(true);
...
drawableTextView.getImageView().setVisibility(View.GONE);
...
```

