package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  private static final AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl a;
  private final Object b;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
      a = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl();
    while (true)
    {
      return;
      a = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl();
    }
  }

  public AccessibilityNodeProviderCompat()
  {
    this.b = a.a(this);
  }

  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    this.b = paramObject;
  }

  public AccessibilityNodeInfoCompat a(int paramInt)
  {
    return null;
  }

  public Object a()
  {
    return this.b;
  }

  public List<AccessibilityNodeInfoCompat> a(String paramString, int paramInt)
  {
    return null;
  }

  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
 * JD-Core Version:    0.6.0
 */