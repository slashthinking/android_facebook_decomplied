package android_src.mms.util;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import android_src.mms.MmsException;
import android_src.mms.pdu.NotificationInd;
import android_src.mms.pdu.PduPersister;
import com.facebook.orca.debug.BLog;

public class DownloadManager
{
  private static DownloadManager g;
  private final Context a;
  private final Handler b;
  private final SharedPreferences c;
  private boolean d;
  private final SharedPreferences.OnSharedPreferenceChangeListener e = new DownloadManager.1(this);
  private final BroadcastReceiver f = new DownloadManager.2(this);

  private DownloadManager(Context paramContext)
  {
    this.a = paramContext;
    this.b = new Handler();
    this.c = PreferenceManager.getDefaultSharedPreferences(paramContext);
    this.c.registerOnSharedPreferenceChangeListener(this.e);
    paramContext.registerReceiver(this.f, new IntentFilter("android.intent.action.SERVICE_STATE"));
    this.d = a(this.c);
  }

  private String a(Uri paramUri)
  {
    return "";
  }

  public static void a(Context paramContext)
  {
    if (g != null)
      BLog.d("DownloadManager", "Already initialized.");
    g = new DownloadManager(paramContext);
  }

  static boolean a(SharedPreferences paramSharedPreferences)
  {
    return a(paramSharedPreferences, c());
  }

  static boolean a(SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    return true;
  }

  public static DownloadManager b()
  {
    if (g == null)
      throw new IllegalStateException("Uninitialized.");
    return g;
  }

  static boolean c()
  {
    return false;
  }

  public void a(int paramInt)
  {
    this.b.post(new DownloadManager.5(this, paramInt));
  }

  public void a(Uri paramUri, int paramInt)
  {
    try
    {
      if ((((NotificationInd)PduPersister.a(this.a).a(paramUri)).c() < System.currentTimeMillis() / 1000L) && (paramInt == 129))
      {
        this.b.post(new DownloadManager.3(this));
        SqliteWrapper.a(this.a, this.a.getContentResolver(), paramUri, null, null);
        return;
      }
    }
    catch (MmsException localMmsException)
    {
      while (true)
        BLog.d("DownloadManager", localMmsException.getMessage(), localMmsException);
    }
    if (paramInt == 135)
      this.b.post(new DownloadManager.4(this, paramUri));
    while (true)
    {
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("st", Integer.valueOf(paramInt));
      SqliteWrapper.a(this.a, this.a.getContentResolver(), paramUri, localContentValues, null, null);
      break;
      if (this.d)
        continue;
      paramInt |= 4;
    }
  }

  public boolean a()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.DownloadManager
 * JD-Core Version:    0.6.0
 */