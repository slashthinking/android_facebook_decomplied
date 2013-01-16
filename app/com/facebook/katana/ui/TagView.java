package com.facebook.katana.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.Button;

public class TagView extends Button
{
  public long a;
  public float b;
  public float c;

  public TagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public int getFullHeight()
  {
    float f1 = -getPaint().ascent();
    float f2 = getPaint().descent();
    float f3 = getCompoundPaddingTop();
    return (int)(getCompoundPaddingBottom() + (f3 + (f1 + f2)));
  }

  public int getFullWidth()
  {
    float f = getPaint().measureText(getText().toString());
    int i = getCompoundPaddingLeft();
    int j = getCompoundPaddingRight();
    return (int)(f + i + j);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.TagView
 * JD-Core Version:    0.6.0
 */