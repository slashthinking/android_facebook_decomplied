package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl extends AccessibilityDelegateCompat.AccessibilityDelegateStubImpl
{
  public Object a()
  {
    return AccessibilityDelegateCompatIcs.a();
  }

  public Object a(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    return AccessibilityDelegateCompatIcs.a(new AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl.1(this, paramAccessibilityDelegateCompat));
  }

  public void a(Object paramObject, View paramView, int paramInt)
  {
    AccessibilityDelegateCompatIcs.a(paramObject, paramView, paramInt);
  }

  public void a(Object paramObject, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    AccessibilityDelegateCompatIcs.a(paramObject, paramView, paramAccessibilityNodeInfoCompat.a());
  }

  public boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return AccessibilityDelegateCompatIcs.a(paramObject, paramView, paramAccessibilityEvent);
  }

  public boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return AccessibilityDelegateCompatIcs.a(paramObject, paramViewGroup, paramView, paramAccessibilityEvent);
  }

  public void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompatIcs.b(paramObject, paramView, paramAccessibilityEvent);
  }

  public void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompatIcs.c(paramObject, paramView, paramAccessibilityEvent);
  }

  public void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompatIcs.d(paramObject, paramView, paramAccessibilityEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl
 * JD-Core Version:    0.6.0
 */