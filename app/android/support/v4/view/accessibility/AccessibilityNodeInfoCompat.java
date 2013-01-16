package android.support.v4.view.accessibility;

import android.os.Build.VERSION;

public class AccessibilityNodeInfoCompat
{
  private static final AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl a;
  private final Object b;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
      a = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl();
    while (true)
    {
      return;
      if (Build.VERSION.SDK_INT >= 14)
      {
        a = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl();
        continue;
      }
      a = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl();
    }
  }

  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    this.b = paramObject;
  }

  public Object a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    a.a(this.b, paramInt);
  }

  public void a(CharSequence paramCharSequence)
  {
    a.a(this.b, paramCharSequence);
  }

  public void a(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if (paramObject == null)
      {
        i = 0;
        continue;
      }
      if (getClass() != paramObject.getClass())
      {
        i = 0;
        continue;
      }
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)paramObject;
      if (this.b == null)
      {
        if (localAccessibilityNodeInfoCompat.b == null)
          continue;
        i = 0;
        continue;
      }
      if (this.b.equals(localAccessibilityNodeInfoCompat.b))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    if (this.b == null);
    for (int i = 0; ; i = this.b.hashCode())
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
 * JD-Core Version:    0.6.0
 */