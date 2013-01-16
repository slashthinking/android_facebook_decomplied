package com.facebook.katana.activity.composer;

import android.content.Context;
import java.io.File;

final class ComposerActivity$34 extends Thread
{
  public void run()
  {
    File localFile1 = ComposerActivity.c(this.a);
    if (localFile1.exists())
    {
      long l = System.currentTimeMillis();
      for (File localFile2 : localFile1.listFiles())
      {
        if ((!localFile2.exists()) || (l - localFile2.lastModified() <= 86400000L))
          continue;
        localFile2.delete();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.34
 * JD-Core Version:    0.6.0
 */