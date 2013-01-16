package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.apache.http.entity.mime.content.StringBody;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FacebookVideoUploadResponse;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.util.FacebookPlatform;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.entity.mime.content.InputStreamBodyWithSize;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VideoUpload extends ApiMethod
  implements ApiMethodCallback
{
  private final String a;
  private final int b;
  private FacebookVideoUploadResponse f;
  private String g;

  public VideoUpload(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt, String paramString5, String paramString6, long paramLong2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "POST", "video.upload", Constants.URL.b(paramContext), paramServiceOperationListener, null);
    this.m = new VideoUpload.VideoUploadListener(this);
    this.a = paramString4;
    this.b = paramInt;
    this.e.put("method", this.c);
    this.e.put("v", "1.0");
    this.e.put("api_key", "882a8490361da98702bf97a021ddc14d");
    this.e.put("format", "JSON");
    this.e.put("session_key", paramString1);
    this.e.put("call_id", String.valueOf(System.currentTimeMillis()));
    if (paramLong1 != -1L)
      this.e.put("id", String.valueOf(paramLong1));
    if (paramString2 != null)
      this.e.put("title", paramString2);
    if (paramString3 != null)
      this.e.put("description", paramString3);
    if (paramString5 != null)
      this.e.put("privacy", paramString5);
    if (paramString6 != null)
      this.e.put("tags", paramString6);
    if (paramLong2 != -1L)
      this.e.put("place", Long.toString(paramLong2));
  }

  private long a(Uri paramUri)
  {
    String[] arrayOfString = { "_size" };
    Cursor localCursor = this.o.getContentResolver().query(paramUri, arrayOfString, null, null, null);
    int i = localCursor.getColumnIndexOrThrow("_size");
    localCursor.moveToFirst();
    return localCursor.getLong(i);
  }

  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt, String paramString4, String paramString5, long paramLong2)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    String str;
    for (Object localObject = null; ; localObject = str)
    {
      return localObject;
      VideoUpload localVideoUpload = new VideoUpload(paramContext, null, localAppSession.b().sessionKey, paramString1, paramString2, paramString3, paramLong1, paramInt, paramString4, paramString5, paramLong2, null);
      str = localAppSession.a(paramContext, localVideoUpload, 1001, 1020, null);
      localVideoUpload.c(str);
      SystemTrayNotificationManager.a(paramContext, Integer.parseInt(str), paramString1, paramString2, paramString3);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.f, this.a, this.b);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.f = FacebookVideoUploadResponse.a(paramJsonParser);
  }

  public void b()
  {
    String str1 = this.a.toString();
    String str2 = ".3gp";
    int i = str1.lastIndexOf(".");
    if (i != -1)
      str2 = str1.substring(i, str1.length());
    String str3 = StringUtils.a(8) + str2;
    try
    {
      ArrayList localArrayList = Lists.a();
      Object localObject;
      long l2;
      if (this.a.startsWith("content:"))
      {
        Uri localUri = Uri.parse(this.a);
        localObject = this.o.getContentResolver().openInputStream(localUri);
        l2 = a(localUri);
      }
      while (true)
      {
        localArrayList.add(new FormBodyPart("media", new InputStreamBodyWithSize((InputStream)localObject, "video/3gpp", str3, l2)));
        localArrayList.add(new FormBodyPart("method", new StringBody(this.c)));
        localArrayList.add(new FormBodyPart("v", new StringBody("1.0")));
        localArrayList.add(new FormBodyPart("api_key", new StringBody("882a8490361da98702bf97a021ddc14d")));
        localArrayList.add(new FormBodyPart("format", new StringBody((String)this.e.get("format"))));
        localArrayList.add(new FormBodyPart("session_key", new StringBody((String)this.e.get("session_key"))));
        localArrayList.add(new FormBodyPart("call_id", new StringBody((String)this.e.get("call_id"))));
        localArrayList.add(new FormBodyPart("sig", new StringBody(FacebookPlatform.a(this.e, f()))));
        if (this.e.get("id") != null)
          localArrayList.add(new FormBodyPart("id", new StringBody((String)this.e.get("id"))));
        if (this.e.get("title") != null)
          localArrayList.add(new FormBodyPart("title", new StringBody((String)this.e.get("title"), Charset.forName("UTF-8"))));
        if (this.e.get("description") != null)
          localArrayList.add(new FormBodyPart("description", new StringBody((String)this.e.get("description"), Charset.forName("UTF-8"))));
        if (this.e.get("privacy") != null)
          localArrayList.add(new FormBodyPart("privacy", new StringBody((String)this.e.get("privacy"), Charset.forName("UTF-8"))));
        if (this.e.get("place") != null)
          localArrayList.add(new FormBodyPart("place", new StringBody((String)this.e.get("place"))));
        if (this.e.get("tags") != null)
          localArrayList.add(new FormBodyPart("tags", new StringBody((String)this.e.get("tags"))));
        this.l = new HttpOperation(this.o, Constants.URL.g(this.o), localArrayList, this.m, true);
        this.l.b();
        break;
        localObject = new FileInputStream(this.a);
        long l1 = new File(this.a).length();
        l2 = l1;
      }
    }
    catch (Exception localException)
    {
      if (this.q != null)
        this.q.a_(this, 0, null, localException);
    }
  }

  public void c(String paramString)
  {
    this.g = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.VideoUpload
 * JD-Core Version:    0.6.0
 */