package android.support.v4.view;

import android.view.View;

class ViewCompat$BaseViewCompatImpl
  implements ViewCompat.ViewCompatImpl
{
  public int a(View paramView)
  {
    return 2;
  }

  long a()
  {
    return 10L;
  }

  public void a(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
  }

  public boolean a(View paramView, int paramInt)
  {
    return false;
  }

  public void b(View paramView)
  {
    paramView.postInvalidateDelayed(a());
  }

  public void b(View paramView, int paramInt)
  {
  }

  public int c(View paramView)
  {
    return 0;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.BaseViewCompatImpl
 * JD-Core Version:    0.6.0
 */