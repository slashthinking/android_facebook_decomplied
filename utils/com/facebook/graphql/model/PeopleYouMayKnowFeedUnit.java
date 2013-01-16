package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

public class PeopleYouMayKnowFeedUnit
  implements Parcelable, FeedUnit
{
  public static final Parcelable.Creator<PeopleYouMayKnowFeedUnit> CREATOR = new PeopleYouMayKnowFeedUnit.1();
  private long a = -1L;

  @JsonIgnore
  private boolean b;

  @JsonProperty("cache_id")
  private final String cacheId;

  @JsonProperty("items")
  public final List<PeopleYouMayKnowItem> suggestions;

  @JsonProperty("__type__")
  public final GraphQLObjectType type = new GraphQLObjectType(GraphQLObjectType.ObjectType.PeopleYouMayKnowFeedUnit);

  protected PeopleYouMayKnowFeedUnit()
  {
    this.b = false;
    this.suggestions = ImmutableList.d();
    this.cacheId = null;
  }

  public PeopleYouMayKnowFeedUnit(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.cacheId = paramParcel.readString();
    this.suggestions = Lists.a();
    paramParcel.readTypedList(this.suggestions, PeopleYouMayKnowItem.CREATOR);
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.b = i;
      return;
      i = 0;
    }
  }

  @JsonIgnore
  public boolean a()
  {
    return this.b;
  }

  @JsonIgnore
  public void b()
  {
    this.b = true;
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

  public void setFetchTimeMs(long paramLong)
  {
    this.a = paramLong;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.cacheId);
    paramParcel.writeTypedList(this.suggestions);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PeopleYouMayKnowFeedUnit
 * JD-Core Version:    0.6.2
 */