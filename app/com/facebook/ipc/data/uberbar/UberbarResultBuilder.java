package com.facebook.ipc.data.uberbar;

import android.net.Uri;
import java.util.List;

public class UberbarResultBuilder
{
  private String a;
  private UberbarResult.FriendStatus b;
  private Uri c;
  private Uri d;
  private Uri e;
  private String f;
  private String g;
  private UberbarResult.Type h;
  private long i;
  private List<String> j;

  public static UberbarResultBuilder a(UberbarResult paramUberbarResult)
  {
    return new UberbarResultBuilder().a(paramUberbarResult.a).a(paramUberbarResult.b).a(paramUberbarResult.c).b(paramUberbarResult.d).c(paramUberbarResult.e).b(paramUberbarResult.f).c(paramUberbarResult.g).a(paramUberbarResult.h).a(paramUberbarResult.i).a(paramUberbarResult.j);
  }

  public UberbarResult a()
  {
    return new UberbarResult(this);
  }

  public UberbarResultBuilder a(long paramLong)
  {
    this.i = paramLong;
    return this;
  }

  public UberbarResultBuilder a(Uri paramUri)
  {
    this.c = paramUri;
    return this;
  }

  public UberbarResultBuilder a(UberbarResult.FriendStatus paramFriendStatus)
  {
    this.b = paramFriendStatus;
    return this;
  }

  public UberbarResultBuilder a(UberbarResult.Type paramType)
  {
    this.h = paramType;
    return this;
  }

  public UberbarResultBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public UberbarResultBuilder a(List<String> paramList)
  {
    this.j = paramList;
    return this;
  }

  public UberbarResultBuilder b(Uri paramUri)
  {
    this.d = paramUri;
    return this;
  }

  public UberbarResultBuilder b(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public String b()
  {
    return this.a;
  }

  public UberbarResult.FriendStatus c()
  {
    return this.b;
  }

  public UberbarResultBuilder c(Uri paramUri)
  {
    this.e = paramUri;
    return this;
  }

  public UberbarResultBuilder c(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public Uri d()
  {
    return this.c;
  }

  public Uri e()
  {
    return this.d;
  }

  public Uri f()
  {
    return this.e;
  }

  public String g()
  {
    return this.f;
  }

  public String h()
  {
    return this.g;
  }

  public UberbarResult.Type i()
  {
    return this.h;
  }

  public long j()
  {
    return this.i;
  }

  public List<String> k()
  {
    return this.j;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.data.uberbar.UberbarResultBuilder
 * JD-Core Version:    0.6.0
 */