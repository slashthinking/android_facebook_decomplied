package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLStoryInsights;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchStoryInsightsResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchStoryInsightsResult> CREATOR = new FetchStoryInsightsResult.1();

  @JsonProperty("feedback")
  public final Feedback feedback;

  @JsonProperty("insights")
  public final GraphQLStoryInsights insights;

  protected FetchStoryInsightsResult()
  {
    this.insights = null;
    this.feedback = null;
  }

  protected FetchStoryInsightsResult(Parcel paramParcel)
  {
    this.insights = ((GraphQLStoryInsights)paramParcel.readParcelable(null));
    this.feedback = ((Feedback)paramParcel.readParcelable(null));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.insights, paramInt);
    paramParcel.writeParcelable(this.feedback, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.FetchStoryInsightsResult
 * JD-Core Version:    0.6.0
 */