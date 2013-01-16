package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimelineSection
  implements Parcelable
{

  @JsonProperty("id")
  public final String id = null;

  @JsonProperty("label")
  public final String label = null;

  @JsonProperty("timeline_units")
  public final TimelineUnitCollection units = null;

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.TimelineSection
 * JD-Core Version:    0.6.2
 */