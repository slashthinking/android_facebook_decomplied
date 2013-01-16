package com.facebook.notifications.model;

public class FacebookNotificationBuilder
{
  private long a;
  private long b;
  private long c;
  private String d;
  private String e;
  private boolean f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;

  public long a()
  {
    return this.a;
  }

  public FacebookNotificationBuilder a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }

  public FacebookNotificationBuilder a(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public FacebookNotificationBuilder a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }

  public long b()
  {
    return this.b;
  }

  public FacebookNotificationBuilder b(long paramLong)
  {
    this.b = paramLong;
    return this;
  }

  public FacebookNotificationBuilder b(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public long c()
  {
    return this.c;
  }

  public FacebookNotificationBuilder c(long paramLong)
  {
    this.c = paramLong;
    return this;
  }

  public FacebookNotificationBuilder c(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public FacebookNotificationBuilder d(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public String d()
  {
    return this.d;
  }

  public FacebookNotificationBuilder e(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public String e()
  {
    return this.e;
  }

  public FacebookNotificationBuilder f(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public boolean f()
  {
    return this.f;
  }

  public FacebookNotificationBuilder g(String paramString)
  {
    this.k = paramString;
    return this;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }

  public String i()
  {
    return this.j;
  }

  public String j()
  {
    return this.k;
  }

  public FacebookNotification k()
  {
    return new FacebookNotification(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.model.FacebookNotificationBuilder
 * JD-Core Version:    0.6.2
 */