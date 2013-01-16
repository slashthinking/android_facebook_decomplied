package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

public class ViewCompat
{
  static final ViewCompat.ViewCompatImpl a;

  static
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 16) || (Build.VERSION.CODENAME.equals("JellyBean")))
      a = new ViewCompat.JBViewCompatImpl();
    while (true)
    {
      return;
      if (i >= 14)
      {
        a = new ViewCompat.ICSViewCompatImpl();
        continue;
      }
      if (i >= 11)
      {
        a = new ViewCompat.HCViewCompatImpl();
        continue;
      }
      if (i >= 9)
      {
        a = new ViewCompat.GBViewCompatImpl();
        continue;
      }
      a = new ViewCompat.BaseViewCompatImpl();
    }
  }

  public static int a(View paramView)
  {
    return a.a(paramView);
  }

  public static void a(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    a.a(paramView, paramAccessibilityDelegateCompat);
  }

  public static boolean a(View paramView, int paramInt)
  {
    return a.a(paramView, paramInt);
  }

  public static void b(View paramView)
  {
    a.b(paramView);
  }

  public static void b(View paramView, int paramInt)
  {
    a.b(paramView, paramInt);
  }

  public static int c(View paramView)
  {
    return a.c(paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat
 * JD-Core Version:    0.6.0
 */