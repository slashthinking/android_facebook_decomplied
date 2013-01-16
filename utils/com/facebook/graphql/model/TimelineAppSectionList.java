package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TimelineAppSectionList
  implements Parcelable
{

  @JsonProperty("count")
  public final int count = 0;

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo = null;

  @JsonProperty("nodes")
  public final List<TimelineAppSection> sections = null;

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.TimelineAppSectionList
 * JD-Core Version:    0.6.2
 */