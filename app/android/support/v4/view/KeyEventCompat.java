package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class KeyEventCompat
{
  static final KeyEventCompat.KeyEventVersionImpl a;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
      a = new KeyEventCompat.HoneycombKeyEventVersionImpl();
    while (true)
    {
      return;
      a = new KeyEventCompat.BaseKeyEventVersionImpl();
    }
  }

  public static boolean a(KeyEvent paramKeyEvent)
  {
    return a.b(paramKeyEvent.getMetaState());
  }

  public static boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    return a.a(paramKeyEvent.getMetaState(), paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat
 * JD-Core Version:    0.6.0
 */