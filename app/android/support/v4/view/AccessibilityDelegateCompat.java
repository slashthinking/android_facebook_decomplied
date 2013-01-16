package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat
{
  private static final AccessibilityDelegateCompat.AccessibilityDelegateImpl b;
  private static final Object c;
  final Object a = b.a(this);

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
      b = new AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl();
    while (true)
    {
      c = b.a();
      return;
      if (Build.VERSION.SDK_INT >= 14)
      {
        b = new AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl();
        continue;
      }
      b = new AccessibilityDelegateCompat.AccessibilityDelegateStubImpl();
    }
  }

  public AccessibilityNodeProviderCompat a(View paramView)
  {
    return b.a(c, paramView);
  }

  Object a()
  {
    return this.a;
  }

  public void a(View paramView, int paramInt)
  {
    b.a(c, paramView, paramInt);
  }

  public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    b.a(c, paramView, paramAccessibilityNodeInfoCompat);
  }

  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.d(c, paramView, paramAccessibilityEvent);
  }

  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return b.a(c, paramView, paramInt, paramBundle);
  }

  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return b.a(c, paramViewGroup, paramView, paramAccessibilityEvent);
  }

  public boolean b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return b.a(c, paramView, paramAccessibilityEvent);
  }

  public void c(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.c(c, paramView, paramAccessibilityEvent);
  }

  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.b(c, paramView, paramAccessibilityEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompat
 * JD-Core Version:    0.6.0
 */