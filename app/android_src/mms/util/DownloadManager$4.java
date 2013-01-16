package android_src.mms.util;

import android.net.Uri;
import android.widget.Toast;
import android_src.mms.MmsException;
import com.facebook.orca.debug.BLog;

class DownloadManager$4
  implements Runnable
{
  public void run()
  {
    try
    {
      Toast.makeText(DownloadManager.a(this.b), DownloadManager.a(this.b, this.a), 1).show();
      return;
    }
    catch (MmsException localMmsException)
    {
      while (true)
        BLog.d("DownloadManager", localMmsException.getMessage(), localMmsException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.DownloadManager.4
 * JD-Core Version:    0.6.0
 */