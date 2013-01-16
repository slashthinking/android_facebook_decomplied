package com.facebook.composer.protocol;

import com.facebook.graphql.model.Shareable;
import com.google.common.collect.Sets;
import java.util.Set;

public class PublishPostParamsBuilder
{
  private String a;
  private long b;
  private String c;
  private String d;
  private boolean e;
  private boolean f;
  private Set<Long> g = Sets.a();
  private String h;
  private String i;
  private String j;
  private long k;
  private Shareable l;
  private String m;
  private PublishPostParams.PublishType n;

  public PublishPostParams a()
  {
    return new PublishPostParams(this);
  }

  public PublishPostParamsBuilder a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }

  public PublishPostParamsBuilder a(PublishPostParams.PublishType paramPublishType)
  {
    this.n = paramPublishType;
    return this;
  }

  public PublishPostParamsBuilder a(Shareable paramShareable)
  {
    this.l = paramShareable;
    return this;
  }

  public PublishPostParamsBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public PublishPostParamsBuilder a(Set<Long> paramSet)
  {
    this.g = paramSet;
    return this;
  }

  public PublishPostParamsBuilder a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public PublishPostParamsBuilder b(long paramLong)
  {
    this.k = paramLong;
    return this;
  }

  public PublishPostParamsBuilder b(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public PublishPostParamsBuilder b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }

  public String b()
  {
    return this.a;
  }

  public long c()
  {
    return this.b;
  }

  public PublishPostParamsBuilder c(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public PublishPostParamsBuilder d(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public String d()
  {
    return this.c;
  }

  public PublishPostParamsBuilder e(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public String e()
  {
    return this.d;
  }

  public PublishPostParamsBuilder f(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public boolean f()
  {
    return this.e;
  }

  public PublishPostParamsBuilder g(String paramString)
  {
    this.m = paramString;
    return this;
  }

  public boolean g()
  {
    return this.f;
  }

  public Set<Long> h()
  {
    return this.g;
  }

  public String i()
  {
    return this.h;
  }

  public PublishPostParams.PublishType j()
  {
    return this.n;
  }

  public String k()
  {
    return this.i;
  }

  public String l()
  {
    return this.j;
  }

  public long m()
  {
    return this.k;
  }

  public Shareable n()
  {
    return this.l;
  }

  public String o()
  {
    return this.m;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishPostParamsBuilder
 * JD-Core Version:    0.6.2
 */