package com.facebook.katana.provider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.annotations.FromApplication;

public class LegacyKeyValueStore
{
  private final ContentResolver a;
  private final Uri b;
  private final Uri c;
  private final String d;
  private final String e;
  private final String[] f;
  private final String[] g;
  private final FbErrorReporter h;

  public LegacyKeyValueStore(@FromApplication ContentResolver paramContentResolver, Uri paramUri1, Uri paramUri2, String paramString1, String paramString2, String paramString3, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramContentResolver;
    this.b = paramUri1;
    this.c = paramUri2;
    this.d = paramString2;
    this.e = paramString3;
    this.h = paramFbErrorReporter;
    this.g = new String[] { paramString1 };
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.e;
    this.f = arrayOfString;
  }

  String a(String paramString)
  {
    Uri localUri = Uri.withAppendedPath(this.c, paramString);
    Cursor localCursor = this.a.query(localUri, this.f, null, null, null);
    Object localObject1 = null;
    if (localCursor != null);
    try
    {
      boolean bool = localCursor.moveToFirst();
      localObject1 = null;
      if (bool)
      {
        String str = localCursor.getString(0);
        localObject1 = str;
      }
      return localObject1;
    }
    finally
    {
      localCursor.close();
    }
    throw localObject2;
  }

  public void a()
  {
    this.a.delete(this.b, null, null);
  }

  void b(String paramString)
  {
    this.a.delete(this.b, this.d + "=" + DatabaseUtils.sqlEscapeString(paramString), null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.LegacyKeyValueStore
 * JD-Core Version:    0.6.0
 */