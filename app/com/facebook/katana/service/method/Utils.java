package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.katana.provider.PhotosProvider;

class Utils
{
  private static final String[] a = { "size" };

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = Uri.withAppendedPath(PhotosProvider.f, paramString);
    Cursor localCursor = localContentResolver.query(localUri, a, null, null, null);
    if ((localCursor.moveToFirst()) && (localCursor.getInt(0) != paramInt))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("size", Integer.valueOf(paramInt));
      localContentResolver.update(localUri, localContentValues, null, null);
    }
    localCursor.close();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.Utils
 * JD-Core Version:    0.6.0
 */