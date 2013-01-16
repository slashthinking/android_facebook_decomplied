package com.facebook.katana.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import com.facebook.common.util.FileUtil;
import java.io.File;
import java.io.InputStream;

public class RingtoneUtils
{
  private Context a;
  private ContentResolver b;
  private AssetManager c;
  private FileUtil d;
  private File e;

  public RingtoneUtils(Context paramContext, ContentResolver paramContentResolver, AssetManager paramAssetManager, FileUtil paramFileUtil)
  {
    this.a = paramContext;
    this.b = paramContentResolver;
    this.c = paramAssetManager;
    this.d = paramFileUtil;
  }

  public String a(Context paramContext)
  {
    a();
    b();
    String str = c();
    if (str == null)
      d();
    return str;
  }

  public void a()
  {
    this.d.a("/sdcard/media/audio/notifications").mkdirs();
    this.e = this.d.a("/sdcard/media/audio/notifications/facebook_ringtone_pop.m4a");
  }

  public void b()
  {
    if (!this.e.exists())
    {
      InputStream localInputStream = this.c.open("pop.m4a");
      this.d.a(localInputStream, this.e);
    }
  }

  public String c()
  {
    Cursor localCursor = this.b.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data" }, "_data=?", new String[] { "/sdcard/media/audio/notifications/facebook_ringtone_pop.m4a" }, null);
    Uri localUri;
    if (localCursor != null)
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getColumnIndexOrThrow("_id");
        localUri = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "" + localCursor.getInt(i));
        if (localUri != null)
          label97: localCursor.close();
      }
    while (true)
    {
      String str = null;
      if (localUri == null);
      while (true)
      {
        return str;
        if (localCursor.moveToNext())
          break;
        break label97;
        str = localUri.toString();
      }
      localUri = null;
      break label97;
      localUri = null;
    }
  }

  public void d()
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.fromFile(this.e));
    this.a.sendBroadcast(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.RingtoneUtils
 * JD-Core Version:    0.6.0
 */