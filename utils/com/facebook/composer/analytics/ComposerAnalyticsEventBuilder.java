package com.facebook.composer.analytics;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.composer.protocol.PublishPostParams.PublishType;
import com.facebook.orca.server.ErrorCode;

public class ComposerAnalyticsEventBuilder
{
  private HoneyClientEvent a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;

  public ComposerAnalyticsEventBuilder(String paramString)
  {
    this.a = new HoneyClientEvent(paramString).d("composer");
  }

  public static ComposerAnalyticsEventBuilder a()
  {
    return new ComposerAnalyticsEventBuilder("composer_post");
  }

  public static ComposerAnalyticsEventBuilder b()
  {
    return new ComposerAnalyticsEventBuilder("composer_post_failure");
  }

  public ComposerAnalyticsEventBuilder a(PublishPostParams.PublishType paramPublishType)
  {
    this.c = paramPublishType.toString();
    return this;
  }

  public ComposerAnalyticsEventBuilder a(ErrorCode paramErrorCode)
  {
    this.e = paramErrorCode.toString();
    return this;
  }

  public ComposerAnalyticsEventBuilder a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public ComposerAnalyticsEventBuilder b(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public HoneyClientEvent c()
  {
    String str1 = this.b;
    HoneyClientEvent localHoneyClientEvent = null;
    if (str1 != null)
    {
      String str2 = this.c;
      localHoneyClientEvent = null;
      if (str2 != null)
      {
        String str3 = this.d;
        localHoneyClientEvent = null;
        if (str3 != null)
          break label37;
      }
    }
    while (true)
    {
      return localHoneyClientEvent;
      label37: this.a.b("publish_method", this.b).b("publish_type", this.c).b("params", this.d);
      if (this.a.g().equals("composer_post"))
      {
        localHoneyClientEvent = this.a;
      }
      else
      {
        boolean bool = this.a.g().equals("composer_post_failure");
        localHoneyClientEvent = null;
        if (bool)
        {
          String str4 = this.e;
          localHoneyClientEvent = null;
          if (str4 != null)
          {
            String str5 = this.f;
            localHoneyClientEvent = null;
            if (str5 != null)
              localHoneyClientEvent = this.a.b("error_code", this.e).b("error_message", this.f);
          }
        }
      }
    }
  }

  public ComposerAnalyticsEventBuilder c(String paramString)
  {
    this.f = paramString;
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.analytics.ComposerAnalyticsEventBuilder
 * JD-Core Version:    0.6.2
 */