package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

public class RecommendedApplicationsFeedUnit
  implements Parcelable, FeedUnit, Postprocessable, Sponsorable
{
  private long a = -1L;

  @JsonProperty("items")
  public final List<RecommendedApplicationsFeedUnitItem> apps;
  private List<String> b;
  private boolean c;

  @JsonProperty("cache_id")
  private final String cacheId;

  @JsonProperty("title")
  public final GraphQLTextWithEntities title;

  @JsonProperty("__type__")
  public final GraphQLObjectType type = new GraphQLObjectType(GraphQLObjectType.ObjectType.RecommendedApplicationsFeedUnit);

  protected RecommendedApplicationsFeedUnit()
  {
    this.cacheId = null;
    this.title = null;
    this.apps = ImmutableList.d();
  }

  public RecommendedApplicationsFeedUnit(RecommendedApplicationsFeedUnitBuilder paramRecommendedApplicationsFeedUnitBuilder)
  {
    this.a = paramRecommendedApplicationsFeedUnitBuilder.a();
    this.cacheId = paramRecommendedApplicationsFeedUnitBuilder.b();
    this.title = paramRecommendedApplicationsFeedUnitBuilder.c();
    this.apps = paramRecommendedApplicationsFeedUnitBuilder.d();
  }

  private void b()
  {
    if (this.b != null);
    while (true)
    {
      return;
      RecommendedApplicationsFeedUnitItem localRecommendedApplicationsFeedUnitItem = a();
      if ((localRecommendedApplicationsFeedUnitItem == null) || (localRecommendedApplicationsFeedUnitItem.sponsoredData == null))
        continue;
      this.b = Lists.a();
      localRecommendedApplicationsFeedUnitItem.sponsoredData.a(this.b);
    }
  }

  public RecommendedApplicationsFeedUnitItem a()
  {
    if ((this.apps == null) || (this.apps.size() == 0));
    for (RecommendedApplicationsFeedUnitItem localRecommendedApplicationsFeedUnitItem = null; ; localRecommendedApplicationsFeedUnitItem = (RecommendedApplicationsFeedUnitItem)this.apps.get(0))
      return localRecommendedApplicationsFeedUnitItem;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getCacheId()
  {
    return this.cacheId;
  }

  public long getFetchTimeMs()
  {
    return this.a;
  }

  public GraphQLObjectType getType()
  {
    return this.type;
  }

  public void p()
  {
    b();
  }

  public void setFetchTimeMs(long paramLong)
  {
    this.a = paramLong;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.apps);
  }

  public List<String> x()
  {
    b();
    return this.b;
  }

  public void y()
  {
    this.c = true;
  }

  @JsonIgnore
  public boolean z()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.RecommendedApplicationsFeedUnit
 * JD-Core Version:    0.6.0
 */