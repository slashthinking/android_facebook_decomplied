package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimelineAppSection
  implements Parcelable
{

  @JsonProperty("__type__")
  public final GraphQLObjectType __type__ = null;

  @JsonProperty("id")
  public final String id = null;

  @JsonProperty("logo")
  public final GraphQLImage logo = null;

  @JsonProperty("name")
  public final String name = null;

  @JsonProperty("section_type")
  public final String sectionType = null;

  @JsonProperty("url")
  public final String url = null;

  @JsonIgnore
  public TimelineAppSection.AppSectionType a()
  {
    try
    {
      TimelineAppSection.AppSectionType localAppSectionType2 = TimelineAppSection.AppSectionType.valueOf(this.sectionType);
      localAppSectionType1 = localAppSectionType2;
      return localAppSectionType1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        TimelineAppSection.AppSectionType localAppSectionType1 = TimelineAppSection.AppSectionType.UNKNOWN;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.TimelineAppSection
 * JD-Core Version:    0.6.2
 */