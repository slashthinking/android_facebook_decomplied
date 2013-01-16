package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLStoryInsights
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLStoryInsights> CREATOR = new GraphQLStoryInsights.1();

  @JsonProperty("organic_reach")
  public final long organicReach;

  @JsonProperty("paid_reach")
  public final long paidReach;

  @JsonProperty("total_reach")
  public final long totalReach;

  @JsonProperty("viral_reach")
  public final long viralReach;

  protected GraphQLStoryInsights()
  {
    this.totalReach = 0L;
    this.organicReach = 0L;
    this.viralReach = 0L;
    this.paidReach = 0L;
  }

  protected GraphQLStoryInsights(Parcel paramParcel)
  {
    this.totalReach = paramParcel.readLong();
    this.organicReach = paramParcel.readLong();
    this.viralReach = paramParcel.readLong();
    this.paidReach = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.totalReach);
    paramParcel.writeLong(this.organicReach);
    paramParcel.writeLong(this.viralReach);
    paramParcel.writeLong(this.paidReach);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLStoryInsights
 * JD-Core Version:    0.6.2
 */