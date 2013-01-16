package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.apache.http.entity.mime.content.StringBody;
import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.activity.media.PendingUploadActivity.UploadStatus;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.util.FacebookPlatform;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.entity.mime.content.InputStreamBodyWithSize;
import com.facebook.orca.protocol.base.DataStreamBody;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Lists;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhotosUpload extends ApiMethod
{
  private final String a;
  private FacebookPhoto b;
  private long f;

  public PhotosUpload(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener, String paramString4, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, String paramString5, long paramLong4, String paramString6, String paramString7)
  {
    super(paramContext, paramIntent, "POST", "photos.upload", Constants.URL.b(paramContext), paramServiceOperationListener, null);
    this.m = new PhotosUpload.PhotosUploadHttpListener(this);
    this.a = paramString3;
    this.f = 0L;
    this.e.put("method", this.c);
    this.e.put("v", "1.0");
    this.e.put("api_key", "882a8490361da98702bf97a021ddc14d");
    this.e.put("format", "JSON");
    this.e.put("session_key", paramString1);
    this.e.put("call_id", "" + System.currentTimeMillis());
    if (paramString2 != null)
      this.e.put("caption", paramString2);
    if (paramString4 != null)
      this.e.put("aid", paramString4);
    if (paramLong1 != -1L)
      this.e.put("checkin_id", Long.toString(paramLong1));
    if (paramLong2 != -1L)
      this.e.put("profile_id", Long.toString(paramLong2));
    this.e.put("published", Boolean.toString(paramBoolean));
    if (paramLong3 != -1L)
      this.e.put("place", Long.toString(paramLong3));
    if ((paramString5 != null) && (paramString5.length() > 0))
      this.e.put("tags", paramString5);
    if (paramLong4 != -1L)
      this.e.put("target_id", Long.toString(paramLong4));
    if ((paramString6 != null) && (paramString6.length() > 0))
      this.e.put("privacy", paramString6);
    if (!StringUtil.a(paramString7))
      this.e.put("nectar_module", paramString7);
  }

  private void h()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("pid", this.b.a());
    localContentValues.put("owner", Long.valueOf(this.b.c()));
    localContentValues.put("src", this.b.f());
    localContentValues.put("src_big", this.b.g());
    localContentValues.put("src_small", this.b.h());
    localContentValues.put("caption", this.b.d());
    localContentValues.put("created", Long.valueOf(this.b.e()));
    localContentValues.put("object_id", Long.valueOf(this.b.j()));
    if (this.b.l());
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("can_tag", Integer.valueOf(i));
      Uri localUri = Uri.withAppendedPath(PhotosProvider.c, this.b.b());
      this.o.getContentResolver().insert(localUri, localContentValues);
      return;
    }
  }

  private void i()
  {
    ContentResolver localContentResolver = this.o.getContentResolver();
    Uri localUri = Uri.withAppendedPath(PhotosProvider.f, this.b.b());
    Cursor localCursor = localContentResolver.query(localUri, PhotosUpload.AlbumQuery.a, null, null, null);
    if (localCursor.moveToFirst())
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("size", Integer.valueOf(1 + localCursor.getInt(localCursor.getColumnIndex("size"))));
      localContentResolver.update(localUri, localContentValues, null, null);
    }
    localCursor.close();
  }

  public long a(Uri paramUri)
  {
    String[] arrayOfString = { "_size" };
    Cursor localCursor = this.o.getContentResolver().query(paramUri, arrayOfString, null, null, null);
    int i = localCursor.getColumnIndexOrThrow("_size");
    localCursor.moveToFirst();
    return localCursor.getLong(i);
  }

  public PhotosUpload a(long paramLong)
  {
    this.e.put("vault_image_id", Long.toString(paramLong));
    this.f = paramLong;
    return this;
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.b = FacebookPhoto.a(paramJsonParser);
    h();
    i();
  }

  public void a(boolean paramBoolean)
  {
    if (this.l != null)
    {
      this.l.a();
      if (paramBoolean)
        a(this, PendingUploadActivity.UploadStatus.CANCELED.ordinal(), null, null);
      this.l = null;
    }
  }

  public void b()
  {
    String str = StringUtils.a(8) + ".jpg";
    try
    {
      localArrayList = Lists.a();
      if (this.f > 0L)
      {
        Log.e("Performing a Vault photo upload: " + this.f);
        localArrayList.add(new FormBodyPart("vault_image_id", new StringBody(Long.toString(this.f))));
      }
      while (true)
      {
        localArrayList.add(new FormBodyPart("method", new StringBody(this.c)));
        localArrayList.add(new FormBodyPart("v", new StringBody("1.0")));
        localArrayList.add(new FormBodyPart("api_key", new StringBody("882a8490361da98702bf97a021ddc14d")));
        localArrayList.add(new FormBodyPart("format", new StringBody((String)this.e.get("format"))));
        localArrayList.add(new FormBodyPart("session_key", new StringBody((String)this.e.get("session_key"))));
        localArrayList.add(new FormBodyPart("call_id", new StringBody((String)this.e.get("call_id"))));
        localArrayList.add(new FormBodyPart("sig", new StringBody(FacebookPlatform.a(this.e, f()))));
        if (this.e.get("caption") != null)
          localArrayList.add(new FormBodyPart("caption", new StringBody((String)this.e.get("caption"), Charset.forName("UTF-8"))));
        if (this.e.get("aid") != null)
          localArrayList.add(new FormBodyPart("aid", new StringBody((String)this.e.get("aid"))));
        if (this.e.get("profile_id") != null)
          localArrayList.add(new FormBodyPart("profile_id", new StringBody((String)this.e.get("profile_id"))));
        if (this.e.get("checkin_id") != null)
          localArrayList.add(new FormBodyPart("checkin_id", new StringBody((String)this.e.get("checkin_id"))));
        localArrayList.add(new FormBodyPart("published", new StringBody((String)this.e.get("published"))));
        if (this.e.get("place") != null)
          localArrayList.add(new FormBodyPart("place", new StringBody((String)this.e.get("place"))));
        if (this.e.get("tags") != null)
          localArrayList.add(new FormBodyPart("tags", new StringBody((String)this.e.get("tags"))));
        if (this.e.get("target_id") != null)
          localArrayList.add(new FormBodyPart("target_id", new StringBody((String)this.e.get("target_id"))));
        if (this.e.get("privacy") != null)
          localArrayList.add(new FormBodyPart("privacy", new StringBody((String)this.e.get("privacy"), Charset.forName("UTF-8"))));
        if (this.e.get("nectar_module") != null)
          localArrayList.add(new FormBodyPart("nectar_module", new StringBody((String)this.e.get("nectar_module"))));
        this.l = new HttpOperation(this.o, Constants.URL.b(this.o), localArrayList, this.m, true);
        this.l.b();
        return;
        if (!this.a.startsWith("content:"))
          break;
        Uri localUri = Uri.parse(this.a);
        localArrayList.add(new FormBodyPart("media", new InputStreamBodyWithSize(this.o.getContentResolver().openInputStream(localUri), "image/jpeg", str, a(localUri))));
      }
    }
    catch (Exception localException)
    {
      ArrayList localArrayList;
      while (this.q != null)
      {
        this.q.a_(this, 0, null, localException);
        break;
        File localFile = new File(this.a);
        localArrayList.add(new FormBodyPart("source", new DataStreamBody(localFile, "image/jpeg", localFile.getName())));
      }
    }
  }

  public FacebookPhoto g()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotosUpload
 * JD-Core Version:    0.6.0
 */