package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat
{
  static final ViewConfigurationCompat.ViewConfigurationVersionImpl a;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
      a = new ViewConfigurationCompat.FroyoViewConfigurationVersionImpl();
    while (true)
    {
      return;
      a = new ViewConfigurationCompat.BaseViewConfigurationVersionImpl();
    }
  }

  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return a.a(paramViewConfiguration);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewConfigurationCompat
 * JD-Core Version:    0.6.0
 */