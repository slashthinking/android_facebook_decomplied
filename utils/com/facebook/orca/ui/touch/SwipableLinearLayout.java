package com.facebook.orca.ui.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class SwipableLinearLayout extends LinearLayout
  implements SwipeableLayout
{
  private DragMotionDetector a;
  private SwipableLinearLayout.OnLayoutListener b;
  private boolean c;

  public SwipableLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void a(DragMotionDetector paramDragMotionDetector)
  {
    this.a = paramDragMotionDetector;
  }

  public void b()
  {
    this.a = null;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
      this.c = this.a.a(paramMotionEvent);
    return this.c;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b != null)
      this.b.a();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c)
      this.c = this.a.a(paramMotionEvent);
    return this.c;
  }

  public void setLayoutListener(SwipableLinearLayout.OnLayoutListener paramOnLayoutListener)
  {
    this.b = paramOnLayoutListener;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.ui.touch.SwipableLinearLayout
 * JD-Core Version:    0.6.2
 */