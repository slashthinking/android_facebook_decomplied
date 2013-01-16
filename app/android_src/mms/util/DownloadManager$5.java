package android_src.mms.util;

import android.widget.Toast;
import com.facebook.orca.debug.BLog;

class DownloadManager$5
  implements Runnable
{
  public void run()
  {
    try
    {
      Toast.makeText(DownloadManager.a(this.b), this.a, 1).show();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        BLog.e("DownloadManager", "Caught an exception in showErrorCodeToast");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.DownloadManager.5
 * JD-Core Version:    0.6.0
 */