package com.facebook.katana.provider;

import android.os.SystemClock;
import com.facebook.common.util.FileUtils.deleteFilesCallback;

class FacebookDatabaseHelper$24
  implements FileUtils.deleteFilesCallback
{
  public void a(boolean paramBoolean, String paramString)
  {
    long l = SystemClock.elapsedRealtime() - this.a;
    if (!paramBoolean)
      FacebookDatabaseHelper.a(this.b, paramString);
    if (l > 5000L)
      FacebookDatabaseHelper.a(this.b, "Long file deletion operation: " + l + "ms (" + paramString + ")");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.24
 * JD-Core Version:    0.6.0
 */