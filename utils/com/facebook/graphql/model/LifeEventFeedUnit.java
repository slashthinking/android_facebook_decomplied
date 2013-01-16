package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class LifeEventFeedUnit extends FeedbackableGraphQLNode
  implements Parcelable, FeedUnit
{
  private long a = -1L;
  private Spannable b;
  private Spannable c;
  private Spannable d;
  private Spannable e;

  @JsonProperty("icon")
  public final GraphQLIcon icon;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("message")
  public final GraphQLTextWithEntities message;

  @JsonProperty("subtitle")
  public final GraphQLTextWithEntities subtitle;

  @JsonProperty("title")
  public final GraphQLTextWithEntities title;

  @JsonProperty("__type__")
  public final GraphQLObjectType type;

  @JsonProperty("under_subtitle")
  public final GraphQLTextWithEntities underSubtitle;

  @JsonProperty("unit_photos")
  public final List<GraphQLMedia> unitPhotos;

  @JsonProperty("url")
  public final String url;

  protected LifeEventFeedUnit()
  {
    this.type = null;
    this.icon = null;
    this.id = null;
    this.url = null;
    this.title = null;
    this.subtitle = null;
    this.underSubtitle = null;
    this.message = null;
    this.unitPhotos = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
  }

  public LifeEventFeedUnit(LifeEventFeedUnitBuilder paramLifeEventFeedUnitBuilder)
  {
    super(paramLifeEventFeedUnitBuilder.f());
    this.type = paramLifeEventFeedUnitBuilder.a();
    this.icon = paramLifeEventFeedUnitBuilder.c();
    this.id = paramLifeEventFeedUnitBuilder.d();
    this.url = paramLifeEventFeedUnitBuilder.e();
    this.title = paramLifeEventFeedUnitBuilder.g();
    this.subtitle = paramLifeEventFeedUnitBuilder.h();
    this.underSubtitle = paramLifeEventFeedUnitBuilder.i();
    this.message = paramLifeEventFeedUnitBuilder.j();
    this.unitPhotos = paramLifeEventFeedUnitBuilder.k();
    this.a = paramLifeEventFeedUnitBuilder.l();
    this.b = paramLifeEventFeedUnitBuilder.m();
    this.c = paramLifeEventFeedUnitBuilder.n();
    this.d = paramLifeEventFeedUnitBuilder.o();
    this.e = paramLifeEventFeedUnitBuilder.p();
  }

  @JsonIgnore
  public Spannable a()
  {
    return this.b;
  }

  @JsonIgnore
  public void a(Spannable paramSpannable)
  {
    this.b = paramSpannable;
  }

  @JsonIgnore
  public void b(Spannable paramSpannable)
  {
    this.c = paramSpannable;
  }

  @JsonIgnore
  public Spannable c()
  {
    return this.c;
  }

  @JsonIgnore
  public void c(Spannable paramSpannable)
  {
    this.d = paramSpannable;
  }

  @JsonIgnore
  public Spannable d()
  {
    return this.d;
  }

  @JsonIgnore
  public void d(Spannable paramSpannable)
  {
    this.e = paramSpannable;
  }

  public int describeContents()
  {
    return 0;
  }

  @JsonIgnore
  public Spannable e()
  {
    return this.e;
  }

  @JsonIgnore
  public String getCacheId()
  {
    return this.id;
  }

  @JsonIgnore
  public long getFetchTimeMs()
  {
    return this.a;
  }

  @JsonIgnore
  public GraphQLObjectType getType()
  {
    return new GraphQLObjectType(GraphQLObjectType.ObjectType.LiveEventUnit);
  }

  @JsonIgnore
  public void setFetchTimeMs(long paramLong)
  {
    this.a = paramLong;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.LifeEventFeedUnit
 * JD-Core Version:    0.6.2
 */