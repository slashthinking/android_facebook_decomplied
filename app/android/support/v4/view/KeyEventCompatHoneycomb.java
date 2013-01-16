package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompatHoneycomb
{
  public static boolean a(int paramInt)
  {
    return KeyEvent.metaStateHasNoModifiers(paramInt);
  }

  public static boolean a(int paramInt1, int paramInt2)
  {
    return KeyEvent.metaStateHasModifiers(paramInt1, paramInt2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompatHoneycomb
 * JD-Core Version:    0.6.0
 */