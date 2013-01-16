package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.provider.PhotosProvider;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Map;

public class PhotosCreateAlbum extends ApiMethod
{
  private FacebookAlbum a;
  private Uri b;

  public PhotosCreateAlbum(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "photos.createAlbum", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("session_key", paramString1);
    this.e.put("call_id", "" + System.currentTimeMillis());
    this.e.put("name", paramString2);
    if (paramString3 != null)
      this.e.put("location", paramString3);
    if (paramString4 != null)
      this.e.put("description", paramString4);
    if (paramString5 != null)
      this.e.put("visible", paramString5);
  }

  private static Uri a(Context paramContext, FacebookAlbum paramFacebookAlbum)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("aid", paramFacebookAlbum.a());
    localContentValues.put("cover_pid", paramFacebookAlbum.b());
    localContentValues.put("owner", Long.valueOf(paramFacebookAlbum.c()));
    localContentValues.put("name", paramFacebookAlbum.d());
    localContentValues.put("created", Long.valueOf(paramFacebookAlbum.e()));
    localContentValues.put("modified", Long.valueOf(paramFacebookAlbum.f()));
    localContentValues.put("description", paramFacebookAlbum.g());
    localContentValues.put("location", paramFacebookAlbum.h());
    localContentValues.put("size", Integer.valueOf(paramFacebookAlbum.i()));
    localContentValues.put("visibility", paramFacebookAlbum.j());
    localContentValues.put("type", paramFacebookAlbum.l());
    localContentValues.put("object_id", Long.valueOf(paramFacebookAlbum.m()));
    return paramContext.getContentResolver().insert(PhotosProvider.e, localContentValues);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = new FacebookAlbum(paramJsonParser);
    this.b = a(this.o, this.a);
  }

  public FacebookAlbum g()
  {
    return this.a;
  }

  public Uri h()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosCreateAlbum
 * JD-Core Version:    0.6.0
 */