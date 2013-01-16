package com.facebook.katana.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class TagSuggestionView extends LinearLayout
  implements View.OnTouchListener
{
  private float a;
  private float b;
  private int c;
  private Button d;
  private Button e;
  private float f;

  public TagSuggestionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903574, this);
    setPadding(0, 0, 0, 0);
    setBackgroundColor(0);
    this.d = ((Button)findViewById(2131296472));
    this.e = ((Button)findViewById(2131297864));
    this.d.setOnTouchListener(this);
    this.e.setOnTouchListener(this);
  }

  public void a()
  {
    this.e.setWidth(getFaceBoxWidth());
    this.e.setHeight(getFaceBoxHeight());
  }

  public int getFaceBoxHeight()
  {
    return (int)(2.5F * (this.c * this.f));
  }

  public int getFaceBoxWidth()
  {
    return (int)(1.8F * (this.c * this.f));
  }

  public int getFullHeight()
  {
    float f1 = -this.d.getPaint().ascent();
    float f2 = this.d.getPaint().descent();
    float f3 = this.d.getCompoundPaddingTop();
    return (int)(this.d.getCompoundPaddingBottom() + (f3 + (f1 + f2)) + getFaceBoxHeight());
  }

  public int getFullWidth()
  {
    float f1 = this.d.getPaint().measureText(this.d.getText().toString());
    int i = this.d.getCompoundPaddingLeft();
    return Math.max(this.d.getCompoundPaddingRight() + (i + (int)f1), getFaceBoxWidth());
  }

  public float getX()
  {
    return this.a;
  }

  public float getY()
  {
    return this.b;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return onTouchEvent(paramMotionEvent);
      this.d.setPressed(true);
      this.e.setPressed(true);
      continue;
      this.d.setPressed(false);
      this.e.setPressed(false);
    }
  }

  public void setEyeDistance(float paramFloat)
  {
    this.f = paramFloat;
    a();
  }

  public void setImageSize(int paramInt)
  {
    this.c = paramInt;
    a();
  }

  public void setX(float paramFloat)
  {
    this.a = paramFloat;
  }

  public void setY(float paramFloat)
  {
    this.b = paramFloat;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.TagSuggestionView
 * JD-Core Version:    0.6.0
 */