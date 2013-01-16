package com.facebook.katana.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhotoTagBase;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.app.AppInitLockHelper;
import java.io.File;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

public class MediaUploadService extends Service
{
  private AppSession a;
  private Context b;
  private MediaUploadWorker c;
  private volatile Looper d;
  private volatile MediaUploadService.ServiceHandler e;
  private final AppSessionListener f = new MediaUploadService.1(this);

  private static Intent a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MediaUploadService.class);
    localIntent.putExtra("type", 1);
    return localIntent;
  }

  private void a()
  {
    int i = this.c.c();
    if (i > 0)
    {
      AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
      PendingIntent localPendingIntent = PendingIntent.getService(this, 0, a(this.b), 268435456);
      localAlarmManager.set(3, SystemClock.elapsedRealtime() + i * 1000, localPendingIntent);
    }
  }

  public static void a(Context paramContext, int paramInt, Class<?> paramClass)
  {
    Intent localIntent = new Intent(paramContext, MediaUploadService.class);
    localIntent.putExtra("type", 7);
    localIntent.putExtra("upload_id", paramInt);
    localIntent.putExtra("exc_id", paramClass);
    paramContext.startService(localIntent);
  }

  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MediaUploadService.class);
    localIntent.putExtra("type", 6);
    localIntent.putExtra("upload_id", paramInt);
    localIntent.putExtra("exc_id", paramString);
    paramContext.startService(localIntent);
  }

  public static void a(Context paramContext, String paramString, FacebookPlace paramFacebookPlace)
  {
    File localFile1 = new File(paramContext.getDir("composer_temp", 0), "resized_" + StringUtils.a(6));
    File localFile2 = new File(paramString);
    try
    {
      ImageUtils.a(paramContext, localFile2, localFile1, 960, 960, 100);
      long l = paramFacebookPlace.mPageId;
      Intent localIntent = new Intent(paramContext, MediaUploadService.class);
      localIntent.putExtra("type", 8);
      localIntent.putExtra("profile_id", l);
      localIntent.putExtra("uri", localFile1.getAbsolutePath());
      paramContext.startService(localIntent);
      label121: return;
    }
    catch (ImageUtils.ImageException localImageException)
    {
      break label121;
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Collection<Long> paramCollection, String paramString4, long paramLong3, String paramString5)
  {
    Intent localIntent = new Intent(paramContext, MediaUploadService.class);
    localIntent.putExtra("type", 4);
    localIntent.putExtra("uri", paramString1);
    localIntent.putExtra("subject", paramString2);
    localIntent.putExtra("description", paramString3);
    localIntent.putExtra("profile_id", paramLong1);
    if (paramLong2 != -1L)
      localIntent.putExtra("extra_status_target_id", paramLong2);
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
      localIntent.putExtra("tags", new JSONArray(paramCollection).toString());
    if (paramString4 != null)
      localIntent.putExtra("extra_status_privacy", paramString4);
    if (paramLong3 != -1L)
      localIntent.putExtra("extra_place", paramLong3);
    localIntent.putExtra("camera_session_id", paramString5);
    paramContext.startService(localIntent);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean, List<? extends FacebookPhotoTagBase> paramList, long paramLong3, String paramString4, long paramLong4, String paramString5)
  {
    Intent localIntent = new Intent(paramContext, MediaUploadService.class);
    localIntent.putExtra("type", 3);
    localIntent.putExtra("aid", paramString2);
    localIntent.putExtra("caption", paramString3);
    localIntent.putExtra("profile_id", paramLong1);
    localIntent.putExtra("checkin_id", paramLong2);
    localIntent.putExtra("uri", paramString1);
    localIntent.putExtra("extra_photo_publish", paramBoolean);
    if ((paramList != null) && (!paramList.isEmpty()))
      localIntent.putExtra("tags", FacebookPhotoTagBase.a(paramList));
    localIntent.putExtra("extra_place", paramLong3);
    if (paramLong4 != -1L)
      localIntent.putExtra("extra_status_target_id", paramLong4);
    if (paramString4 != null)
      localIntent.putExtra("extra_status_privacy", paramString4);
    localIntent.putExtra("camera_session_id", paramString5);
    paramContext.startService(localIntent);
  }

  protected void a(Intent paramIntent)
  {
    if (paramIntent == null);
    while (true)
    {
      return;
      int i = paramIntent.getIntExtra("type", 0);
      switch (i)
      {
      default:
        throw new RuntimeException("unknown op " + i);
      case 1:
        a();
        break;
      case 2:
        this.c.b();
        stopSelf();
        break;
      case 3:
        this.c.b(paramIntent);
        a();
        break;
      case 4:
        this.c.a(paramIntent);
        a();
        break;
      case 5:
        int k = paramIntent.getIntExtra("upload_id", 0);
        String str = paramIntent.getStringExtra("req_id");
        if (k <= 0)
          continue;
        this.a.d(this.b, str);
        this.c.a(k);
        break;
      case 6:
        this.c.a(paramIntent.getIntExtra("upload_id", -1), paramIntent.getStringExtra("exc_id"));
        this.c.c();
        break;
      case 7:
        int j = paramIntent.getIntExtra("upload_id", -1);
        boolean bool = true;
        if (j != -1)
          bool = this.c.a(j, (Class)paramIntent.getSerializableExtra("exc_id"));
        if (!bool)
          continue;
        a();
        break;
      case 8:
        this.c.c(paramIntent);
        a();
      }
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    this.b = getApplicationContext();
    if (this.a == null)
    {
      this.a = AppSession.b(this.b, false);
      if (this.a != null)
        this.a.a(this.f);
    }
    else
    {
      this.c = new MediaUploadWorker(this.b, this.a);
      HandlerThread localHandlerThread = new HandlerThread("photo_upload_thread");
      localHandlerThread.start();
      this.d = localHandlerThread.getLooper();
      this.e = new MediaUploadService.ServiceHandler(this, this.d);
    }
    while (true)
    {
      return;
      stopSelf();
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.d != null)
      this.d.quit();
    if (this.c != null)
      this.c.a();
    if (this.a != null)
      this.a.b(this.f);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.e == null);
    for (int i = 2; ; i = 1)
    {
      return i;
      Message localMessage = this.e.obtainMessage();
      localMessage.arg1 = paramInt2;
      localMessage.obj = paramIntent;
      this.e.sendMessage(localMessage);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.MediaUploadService
 * JD-Core Version:    0.6.0
 */