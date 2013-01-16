package com.facebook.orca.common.ui.overlay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.orca.ui.touch.DragMotionDetector;
import com.facebook.orca.ui.touch.SwipeableLayout;

public class SwipableOverlayLayout extends OverlayLayout
  implements SwipeableLayout
{
  private DragMotionDetector a;
  private boolean b;

  public SwipableOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
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
      this.b = this.a.a(paramMotionEvent);
    return this.b;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
      this.b = this.a.a(paramMotionEvent);
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.overlay.SwipableOverlayLayout
 * JD-Core Version:    0.6.0
 */