package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;

public class PhotoButton extends ImageButton
{
  private boolean a;

  public PhotoButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public PhotoButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setBackgroundResource(2130838833);
  }

  public void a()
  {
    setClickable(true);
    clearColorFilter();
  }

  public void b()
  {
    setClickable(false);
    setColorFilter(-7829368);
  }

  protected void c()
  {
    setColorFilter(-7829368);
  }

  protected void d()
  {
    clearColorFilter();
  }

  protected void e()
  {
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = false;
      c();
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (!this.a))
      {
        d();
        e();
      }
      else if ((paramMotionEvent.getAction() == 2) && (!this.a))
      {
        float f1 = Math.abs(paramMotionEvent.getX() - getWidth() / 2);
        float f2 = Math.abs(paramMotionEvent.getY() - getHeight() / 2);
        if ((f1 > 200.0F) || (f2 > 200.0F))
        {
          d();
          this.a = true;
        }
      }
      else if (paramMotionEvent.getAction() == 3)
      {
        d();
        this.a = true;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.PhotoButton
 * JD-Core Version:    0.6.2
 */