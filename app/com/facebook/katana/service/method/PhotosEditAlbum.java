package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.provider.PhotosProvider;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Map;

public class PhotosEditAlbum extends ApiMethod
{
  protected String a;

  public PhotosEditAlbum(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "photos.editAlbum", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("session_key", paramString1);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("name", paramString3);
    this.e.put("aid", paramString2);
    this.e.put("location", paramString4);
    this.e.put("description", paramString5);
    this.a = paramString6;
    if ((paramString6 != null) && (!paramString6.equals("custom")))
      this.e.put("visible", paramString6);
  }

  protected void a(JsonParser paramJsonParser)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", (String)this.e.get("name"));
    localContentValues.put("description", (String)this.e.get("description"));
    localContentValues.put("location", (String)this.e.get("location"));
    localContentValues.put("visibility", this.a);
    Uri localUri = Uri.withAppendedPath(PhotosProvider.f, (String)this.e.get("aid"));
    this.o.getContentResolver().update(localUri, localContentValues, null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosEditAlbum
 * JD-Core Version:    0.6.0
 */