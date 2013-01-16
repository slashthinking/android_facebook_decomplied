package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1
  implements AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
{
  public Object a(View paramView)
  {
    AccessibilityNodeProviderCompat localAccessibilityNodeProviderCompat = this.a.a(paramView);
    if (localAccessibilityNodeProviderCompat != null);
    for (Object localObject = localAccessibilityNodeProviderCompat.a(); ; localObject = null)
      return localObject;
  }

  public void a(View paramView, int paramInt)
  {
    this.a.a(paramView, paramInt);
  }

  public void a(View paramView, Object paramObject)
  {
    this.a.a(paramView, new AccessibilityNodeInfoCompat(paramObject));
  }

  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return this.a.a(paramView, paramInt, paramBundle);
  }

  public boolean a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.b(paramView, paramAccessibilityEvent);
  }

  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.a(paramViewGroup, paramView, paramAccessibilityEvent);
  }

  public void b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.d(paramView, paramAccessibilityEvent);
  }

  public void c(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.c(paramView, paramAccessibilityEvent);
  }

  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.a(paramView, paramAccessibilityEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl.1
 * JD-Core Version:    0.6.0
 */