package com.facebook.photos.analytics;

import android.net.Uri;
import android.os.Build;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.orca.common.util.StringUtil;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PhotoFlowLogger
{
  private final AnalyticsLogger a;
  private final FbErrorReporter b;
  private String c;
  private boolean d;
  private String e;
  private String f;
  private int g = -1;

  public PhotoFlowLogger(AnalyticsLogger paramAnalyticsLogger, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramAnalyticsLogger;
    this.b = paramFbErrorReporter;
    this.c = null;
  }

  private PhotoFlowLogger a(boolean paramBoolean, Uri paramUri)
  {
    HashMap localHashMap = Maps.a();
    if (paramUri != null)
      localHashMap.put("uri", paramUri.getPath());
    if (paramBoolean);
    for (String str = "true"; ; str = "false")
    {
      localHashMap.put("has_video", str);
      a(PhotoFlowLogger.Event.PICKED_MEDIA, localHashMap, null);
      return this;
    }
  }

  private void a(PhotoFlowLogger.Event paramEvent, Map<String, String> paramMap, String paramString)
  {
    a(paramEvent, paramMap, "user_event", this.c, paramString);
  }

  public PhotoFlowLogger a()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("ex_tag_screen", PhotoFlowLogger.TagScreen.PRODUCTION.toString());
    a(PhotoFlowLogger.Event.TAG_CANCELLED, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("multi_success", Integer.toString(paramInt1));
    localHashMap.put("multi_fail", Integer.toString(paramInt2));
    localHashMap.put("media_attachment_count", Integer.toString(paramInt1 + paramInt2));
    localHashMap.put("has_video", "false");
    localHashMap.put("has_photo", "true");
    if (paramInt2 > 0)
    {
      localHashMap.put("upload_fail", "true");
      a(PhotoFlowLogger.Event.COMPOSER_POST_FAILURE, localHashMap, null);
    }
    while (true)
    {
      return this;
      a(PhotoFlowLogger.Event.COMPOSER_UPLOAD_SUCCESS, localHashMap, null);
    }
  }

  public PhotoFlowLogger a(Uri paramUri)
  {
    HashMap localHashMap = Maps.a();
    if (paramUri != null)
      localHashMap.put("uri", paramUri.getPath());
    a(PhotoFlowLogger.Event.EXTERNAL_VIDEO, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger a(PhotoFlowLogger.ComposerType paramComposerType)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("composer_type", paramComposerType.toString().toLowerCase());
    a(PhotoFlowLogger.Event.LAUNCHED_MULTIPICKER, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger a(Class<?> paramClass, String paramString)
  {
    if (paramClass != null);
    for (String str = paramClass.toString(); ; str = "null")
    {
      HashMap localHashMap = Maps.a();
      localHashMap.put("ex_type", str);
      if (!StringUtil.a(paramString))
        localHashMap.put("ex_msg", paramString);
      a(PhotoFlowLogger.Event.UPLOAD_EXCEPTION, localHashMap, null);
      return this;
    }
  }

  public PhotoFlowLogger a(String paramString1, String paramString2)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("source_act", paramString1);
    localHashMap.put("target", paramString2);
    a(PhotoFlowLogger.Event.STARTED_FLOW_MULTIPICKER, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger a(boolean paramBoolean)
  {
    HashMap localHashMap = Maps.a();
    if (paramBoolean);
    for (String str = "true"; ; str = "false")
    {
      localHashMap.put("is_text", str);
      localHashMap.put("ex_tag_screen", PhotoFlowLogger.TagScreen.CONSUMPTION.toString());
      a(PhotoFlowLogger.Event.TAG_CREATED, localHashMap, null);
      return this;
    }
  }

  public PhotoFlowLogger a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    HashMap localHashMap = Maps.a();
    String str1;
    if (paramBoolean)
    {
      str1 = "true";
      localHashMap.put("has_video", str1);
      if (!paramBoolean)
        break label112;
    }
    label112: for (String str2 = "false"; ; str2 = "true")
    {
      localHashMap.put("has_photo", str2);
      localHashMap.put("media_attachment_count", Integer.toString(paramInt1));
      localHashMap.put("tags_user", Integer.toString(paramInt2));
      localHashMap.put("composer_set_privacy", paramString1);
      if (!StringUtil.a(paramString2))
        localHashMap.put("target_id", paramString2);
      a(PhotoFlowLogger.Event.COMPOSER_POST, localHashMap, null);
      return this;
      str1 = "false";
      break;
    }
  }

  public PhotoFlowLogger a(boolean paramBoolean, String paramString)
  {
    HashMap localHashMap = Maps.a();
    if (paramBoolean);
    for (String str = "true"; ; str = "false")
    {
      localHashMap.put("is_text", str);
      localHashMap.put("tag_src", paramString);
      localHashMap.put("ex_tag_screen", PhotoFlowLogger.TagScreen.PRODUCTION.toString());
      a(PhotoFlowLogger.Event.TAG_CREATED, localHashMap, null);
      return this;
    }
  }

  public PhotoFlowLogger a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PhotoFlowLogger.ComposerType paramComposerType)
  {
    HashMap localHashMap = Maps.a();
    String str1;
    String str2;
    if (paramBoolean1)
    {
      str1 = "true";
      localHashMap.put("checkin", str1);
      if (!paramBoolean2)
        break label94;
      str2 = "true";
      label31: localHashMap.put("share", str2);
      if (!paramBoolean3)
        break label101;
    }
    label94: label101: for (String str3 = "true"; ; str3 = "false")
    {
      localHashMap.put("external", str3);
      localHashMap.put("composer_type", paramComposerType.toString().toLowerCase());
      a(PhotoFlowLogger.Event.COMPOSER_INIT, localHashMap, null);
      return this;
      str1 = "false";
      break;
      str2 = "false";
      break label31;
    }
  }

  public PhotoFlowLogger a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    HashMap localHashMap = Maps.a();
    String str1;
    label36: String str2;
    if (!StringUtil.a(paramString))
    {
      if (paramBoolean2)
        localHashMap.put("vault_fbid", paramString);
    }
    else
    {
      if (!paramBoolean4)
        break label103;
      str1 = "true";
      localHashMap.put("gridview", str1);
      localHashMap.put("has_video", "false");
      if (!paramBoolean1)
        break label110;
      str2 = "true";
      label64: localHashMap.put("media_selected", str2);
      if (!paramBoolean3)
        break label117;
      a(PhotoFlowLogger.Event.PICKED_MEDIA_IMPLICIT, localHashMap, null);
    }
    while (true)
    {
      return this;
      localHashMap.put("uri", paramString);
      break;
      label103: str1 = "false";
      break label36;
      label110: str2 = "false";
      break label64;
      label117: a(PhotoFlowLogger.Event.PICKED_MEDIA, localHashMap, null);
    }
  }

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  public void a(long paramLong)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("load_time", Long.toString(paramLong));
    a(PhotoFlowLogger.Event.CAMERA_DONE_LOADING, localHashMap, null);
  }

  public void a(PhotoFlowLogger.Event paramEvent, Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(paramEvent.toString().toLowerCase());
    localHoneyClientEvent.d("composer");
    if (paramMap == null)
      paramMap = Maps.a();
    paramMap.put("photos_event_type", paramString1);
    if (this.d)
      paramMap.put("flow_tainted", "true");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHoneyClientEvent.b((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if (!StringUtil.a(paramString2))
      localHoneyClientEvent.h(paramString2);
    if (!StringUtil.a(paramString3))
      localHoneyClientEvent.g(paramString3);
    this.a.b(localHoneyClientEvent);
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public void a(String paramString, Exception paramException)
  {
    if (paramException == null)
      Log.a("CameraException", paramString);
    while (true)
    {
      HashMap localHashMap = Maps.a();
      localHashMap.put("ex_msg", paramString);
      if (paramException != null)
        localHashMap.put("ex_type", paramException.toString());
      localHashMap.put("layout_orientation", this.e);
      localHashMap.put("device_orientation", this.f);
      localHashMap.put("camera_index", String.valueOf(this.g));
      localHashMap.put("product", Build.PRODUCT);
      localHashMap.put("device", Build.DEVICE);
      localHashMap.put("board", Build.BOARD);
      localHashMap.put("manufacturer", Build.MANUFACTURER);
      localHashMap.put("brand", Build.BRAND);
      localHashMap.put("model", Build.MODEL);
      a(PhotoFlowLogger.Event.CAMERA_EXCEPTION, localHashMap, "user_event", null, null);
      if (this.b != null)
      {
        StringBuilder localStringBuilder = new StringBuilder(200);
        localStringBuilder.append(paramString);
        localStringBuilder.append(" Layout:");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" Device:");
        localStringBuilder.append(this.f);
        localStringBuilder.append(" Camera:");
        localStringBuilder.append(this.g);
        this.b.a("CameraException", localStringBuilder.toString(), paramException);
      }
      return;
      Log.a("CameraException", paramString + ": " + paramException.toString());
    }
  }

  public PhotoFlowLogger b()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("ex_tag_screen", PhotoFlowLogger.TagScreen.PRODUCTION.toString());
    a(PhotoFlowLogger.Event.TAG_START_TYPING, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger b(int paramInt)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("media_attachment_count", Integer.toString(paramInt));
    a(PhotoFlowLogger.Event.EXTERNAL_PHOTO, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger b(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("multi_success", Integer.toString(paramInt1));
    localHashMap.put("multi_fail", Integer.toString(paramInt2));
    localHashMap.put("has_video", "false");
    localHashMap.put("has_photo", "true");
    if (paramInt2 > 0)
    {
      localHashMap.put("upload_fail", "false");
      a(PhotoFlowLogger.Event.COMPOSER_POST_FAILURE, localHashMap, null);
    }
    while (true)
    {
      return this;
      a(PhotoFlowLogger.Event.COMPOSER_POST_SUCCESS, localHashMap, null);
    }
  }

  public PhotoFlowLogger b(Uri paramUri)
  {
    return a(false, paramUri);
  }

  public PhotoFlowLogger b(boolean paramBoolean)
  {
    HashMap localHashMap = Maps.a();
    if (paramBoolean);
    for (String str = "auto_retry"; ; str = "user_retry")
    {
      localHashMap.put("retry", str);
      a(PhotoFlowLogger.Event.COMPOSER_POST_RETRY, localHashMap, null);
      return this;
    }
  }

  public void b(String paramString)
  {
    this.e = paramString;
  }

  public PhotoFlowLogger c()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("ex_tag_screen", PhotoFlowLogger.TagScreen.CONSUMPTION.toString());
    a(PhotoFlowLogger.Event.TAG_CANCELLED, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger c(int paramInt)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("media_attachment_count", Integer.toString(paramInt));
    a(PhotoFlowLogger.Event.COMPOSER_MEDIA_UPLOAD_INIT, localHashMap, null);
    return this;
  }

  public PhotoFlowLogger c(Uri paramUri)
  {
    return a(true, paramUri);
  }

  public PhotoFlowLogger c(boolean paramBoolean)
  {
    HashMap localHashMap = Maps.a();
    if (paramBoolean);
    for (String str = "auto_retry"; ; str = "user_retry")
    {
      localHashMap.put("publish_retry", str);
      a(PhotoFlowLogger.Event.COMPOSER_POST_RETRY, localHashMap, null);
      return this;
    }
  }

  public void c(String paramString)
  {
    this.f = paramString;
  }

  public PhotoFlowLogger d()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("ex_tag_screen", PhotoFlowLogger.TagScreen.CONSUMPTION.toString());
    a(PhotoFlowLogger.Event.TAG_INITIATED, localHashMap, null);
    return this;
  }

  public void d(int paramInt)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("size", Integer.toString(paramInt));
    a(PhotoFlowLogger.Event.CAMERA_TAKE_PHOTO, localHashMap, null);
  }

  public void d(String paramString)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("camera_flow", paramString);
    a(PhotoFlowLogger.Event.CAMERA_FLOW, localHashMap, null);
  }

  public PhotoFlowLogger e()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("ex_tag_screen", PhotoFlowLogger.TagScreen.CONSUMPTION.toString());
    a(PhotoFlowLogger.Event.TAG_START_TYPING, localHashMap, null);
    return this;
  }

  public void e(String paramString)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("camera_ref", paramString);
    a(PhotoFlowLogger.Event.CAMERA_START, localHashMap, null);
  }

  public PhotoFlowLogger f()
  {
    HashMap localHashMap = Maps.a();
    a(PhotoFlowLogger.Event.ROTATE, localHashMap, null);
    return this;
  }

  public void f(String paramString)
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("camera_flash", paramString);
    a(PhotoFlowLogger.Event.CAMERA_FLASH, localHashMap, null);
  }

  public void g()
  {
    HashMap localHashMap = Maps.a();
    a(PhotoFlowLogger.Event.CAMERA_LOADING, localHashMap, null);
  }

  public void h()
  {
    HashMap localHashMap = Maps.a();
    a(PhotoFlowLogger.Event.CAMERA_REVIEW, localHashMap, null);
  }

  public void i()
  {
    HashMap localHashMap = Maps.a();
    a(PhotoFlowLogger.Event.VIDEO_PLAYED_IN_REVIEW, localHashMap, null);
  }

  public void j()
  {
    HashMap localHashMap = Maps.a();
    a(PhotoFlowLogger.Event.CAMERA_REVIEW_ACCEPT, localHashMap, null);
  }

  public void k()
  {
    HashMap localHashMap = Maps.a();
    a(PhotoFlowLogger.Event.CAMERA_REVIEW_REJECT, localHashMap, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.analytics.PhotoFlowLogger
 * JD-Core Version:    0.6.0
 */