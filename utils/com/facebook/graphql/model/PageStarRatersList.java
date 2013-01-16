package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class PageStarRatersList
  implements Parcelable
{
  public static final Parcelable.Creator<PageStarRatersList> CREATOR = new PageStarRatersList.1();

  @JsonProperty("count")
  public final int count;

  @JsonProperty("edges")
  public final List<PageStarRatersEdge> raters;

  protected PageStarRatersList()
  {
    this.count = 0;
    this.raters = new ArrayList();
  }

  public PageStarRatersList(int paramInt, List<PageStarRatersEdge> paramList)
  {
    this.count = paramInt;
    this.raters = paramList;
  }

  protected PageStarRatersList(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
    this.raters = paramParcel.readArrayList(PageStarRatersEdge.class.getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
    paramParcel.writeList(this.raters);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PageStarRatersList
 * JD-Core Version:    0.6.2
 */