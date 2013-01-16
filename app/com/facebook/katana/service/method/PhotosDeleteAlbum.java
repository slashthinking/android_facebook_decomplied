package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.provider.PhotosProvider;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Map;

public class PhotosDeleteAlbum extends ApiMethod
{
  private final long a;

  public PhotosDeleteAlbum(Context paramContext, Intent paramIntent, String paramString1, long paramLong, String paramString2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "photos.deleteAlbum", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.a = paramLong;
    this.e.put("session_key", paramString1);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("aid", paramString2);
  }

  protected void a(JsonParser paramJsonParser)
  {
    Uri localUri = Uri.withAppendedPath(PhotosProvider.g, Long.toString(this.a));
    ContentResolver localContentResolver = this.o.getContentResolver();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ((String)this.e.get("aid"));
    localContentResolver.delete(localUri, "aid IN(?)", arrayOfString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosDeleteAlbum
 * JD-Core Version:    0.6.0
 */