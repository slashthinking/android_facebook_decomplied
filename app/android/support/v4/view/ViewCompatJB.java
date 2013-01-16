package android.support.v4.view;

import android.view.View;

public class ViewCompatJB
{
  public static void a(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }

  public static void a(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }

  public static int b(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompatJB
 * JD-Core Version:    0.6.0
 */