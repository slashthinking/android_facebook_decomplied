package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.provider.PhotosProvider;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Map;

public class PhotosDeletePhoto extends ApiMethod
{
  private final String a;
  private final String b;
  private boolean f;

  public PhotosDeletePhoto(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "photos.deletePhoto", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("session_key", paramString1);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("pid", paramString3);
    this.a = paramString2;
    this.b = paramString3;
  }

  private void h()
  {
    ContentResolver localContentResolver = this.o.getContentResolver();
    Uri localUri = Uri.withAppendedPath(PhotosProvider.f, "" + this.a);
    Cursor localCursor = localContentResolver.query(localUri, PhotosDeletePhoto.AlbumQuery.a, null, null, null);
    if (localCursor.moveToFirst())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("cover_pid"));
      if ((str != null) && (str.equals(this.b)))
        this.f = true;
      int i = localCursor.getInt(localCursor.getColumnIndex("size"));
      if (i - 1 >= 0)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("size", Integer.valueOf(i - 1));
        localContentResolver.update(localUri, localContentValues, null, null);
      }
    }
    localCursor.close();
  }

  protected void a(JsonParser paramJsonParser)
  {
    Uri localUri = Uri.withAppendedPath(PhotosProvider.c, this.a);
    ContentResolver localContentResolver = this.o.getContentResolver();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.b;
    localContentResolver.delete(localUri, "pid IN(?)", arrayOfString);
    h();
  }

  public boolean g()
  {
    return this.f;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosDeletePhoto
 * JD-Core Version:    0.6.0
 */