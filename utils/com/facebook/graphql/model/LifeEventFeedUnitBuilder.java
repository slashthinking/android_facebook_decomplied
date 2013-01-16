package com.facebook.graphql.model;

import android.text.Spannable;
import java.util.List;

public class LifeEventFeedUnitBuilder
{
  private GraphQLObjectType a;
  private GraphQLIcon b;
  private String c;
  private String d;
  private Feedback e;
  private GraphQLTextWithEntities f;
  private GraphQLTextWithEntities g;
  private GraphQLTextWithEntities h;
  private GraphQLTextWithEntities i;
  private List<GraphQLMedia> j;
  private long k = -1L;
  private Spannable l;
  private Spannable m;
  private Spannable n;
  private Spannable o;

  public LifeEventFeedUnitBuilder(LifeEventFeedUnit paramLifeEventFeedUnit)
  {
    this.a = paramLifeEventFeedUnit.type;
    this.b = paramLifeEventFeedUnit.icon;
    this.c = paramLifeEventFeedUnit.id;
    this.d = paramLifeEventFeedUnit.url;
    this.e = paramLifeEventFeedUnit.S();
    this.f = paramLifeEventFeedUnit.title;
    this.g = paramLifeEventFeedUnit.subtitle;
    this.h = paramLifeEventFeedUnit.underSubtitle;
    this.i = paramLifeEventFeedUnit.message;
    this.j = paramLifeEventFeedUnit.unitPhotos;
    this.k = paramLifeEventFeedUnit.getFetchTimeMs();
    this.l = paramLifeEventFeedUnit.a();
    this.m = paramLifeEventFeedUnit.c();
    this.n = paramLifeEventFeedUnit.d();
    this.o = paramLifeEventFeedUnit.d();
  }

  public GraphQLObjectType a()
  {
    return this.a;
  }

  public LifeEventFeedUnitBuilder a(long paramLong)
  {
    this.k = paramLong;
    return this;
  }

  public LifeEventFeedUnitBuilder a(Feedback paramFeedback)
  {
    this.e = paramFeedback;
    return this;
  }

  public LifeEventFeedUnit b()
  {
    return new LifeEventFeedUnit(this);
  }

  public GraphQLIcon c()
  {
    return this.b;
  }

  public String d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }

  public Feedback f()
  {
    return this.e;
  }

  public GraphQLTextWithEntities g()
  {
    return this.f;
  }

  public GraphQLTextWithEntities h()
  {
    return this.g;
  }

  public GraphQLTextWithEntities i()
  {
    return this.h;
  }

  public GraphQLTextWithEntities j()
  {
    return this.i;
  }

  public List<GraphQLMedia> k()
  {
    return this.j;
  }

  public long l()
  {
    return this.k;
  }

  public Spannable m()
  {
    return this.l;
  }

  public Spannable n()
  {
    return this.m;
  }

  public Spannable o()
  {
    return this.n;
  }

  public Spannable p()
  {
    return this.o;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.LifeEventFeedUnitBuilder
 * JD-Core Version:    0.6.2
 */