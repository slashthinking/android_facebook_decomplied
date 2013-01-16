package com.karmascience.gifts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;

public class SkipFreeScrollView extends ScrollView
{
  private final GestureDetector a = new GestureDetector(paramContext, new SkipFreeScrollView.YScrollDetector(this));

  public SkipFreeScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public SkipFreeScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SkipFreeScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFadingEdgeLength(0);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((super.onInterceptTouchEvent(paramMotionEvent)) && (this.a.onTouchEvent(paramMotionEvent)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((paramView2 instanceof WebView));
    while (true)
    {
      return;
      super.requestChildFocus(paramView1, paramView2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.widget.SkipFreeScrollView
 * JD-Core Version:    0.6.0
 */