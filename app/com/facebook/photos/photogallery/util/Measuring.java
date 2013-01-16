package com.facebook.photos.photogallery.util;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;

public class Measuring
{
  public static Rect a(Window paramWindow, View paramView)
  {
    Rect localRect1 = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    localRect1.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    Rect localRect2 = new Rect();
    paramWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    localRect1.offset(0, -localRect2.top);
    return localRect1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.util.Measuring
 * JD-Core Version:    0.6.0
 */