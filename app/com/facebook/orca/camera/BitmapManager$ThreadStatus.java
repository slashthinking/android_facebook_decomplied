package com.facebook.orca.camera;

import android.graphics.BitmapFactory.Options;

class BitmapManager$ThreadStatus
{
  public BitmapManager.State a = BitmapManager.State.ALLOW;
  public BitmapFactory.Options b;

  public String toString()
  {
    String str;
    if (this.a == BitmapManager.State.CANCEL)
      str = "Cancel";
    while (true)
    {
      return "thread state = " + str + ", options = " + this.b;
      if (this.a == BitmapManager.State.ALLOW)
      {
        str = "Allow";
        continue;
      }
      str = "?";
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.BitmapManager.ThreadStatus
 * JD-Core Version:    0.6.0
 */