package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ViewPager$MyAccessibilityDelegate extends AccessibilityDelegateCompat
{
  ViewPager$MyAccessibilityDelegate(ViewPager paramViewPager)
  {
  }

  public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    int i = 1;
    super.a(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.a(ViewPager.class.getName());
    if ((ViewPager.a(this.b) != null) && (ViewPager.a(this.b).b() > i));
    while (true)
    {
      paramAccessibilityNodeInfoCompat.a(i);
      if ((ViewPager.a(this.b) != null) && (ViewPager.b(this.b) >= 0) && (ViewPager.b(this.b) < -1 + ViewPager.a(this.b).b()))
        paramAccessibilityNodeInfoCompat.a(4096);
      if ((ViewPager.a(this.b) != null) && (ViewPager.b(this.b) > 0) && (ViewPager.b(this.b) < ViewPager.a(this.b).b()))
        paramAccessibilityNodeInfoCompat.a(8192);
      return;
      int j = 0;
    }
  }

  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    if (super.a(paramView, paramInt, paramBundle));
    while (true)
    {
      return i;
      switch (paramInt)
      {
      default:
        i = 0;
        break;
      case 4096:
        if ((ViewPager.a(this.b) != null) && (ViewPager.b(this.b) >= 0) && (ViewPager.b(this.b) < -1 + ViewPager.a(this.b).b()))
        {
          this.b.setCurrentItem(1 + ViewPager.b(this.b));
          continue;
        }
        i = 0;
        break;
      case 8192:
        if ((ViewPager.a(this.b) != null) && (ViewPager.b(this.b) > 0) && (ViewPager.b(this.b) < ViewPager.a(this.b).b()))
        {
          this.b.setCurrentItem(-1 + ViewPager.b(this.b));
          continue;
        }
        i = 0;
      }
    }
  }

  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.d(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager.MyAccessibilityDelegate
 * JD-Core Version:    0.6.0
 */