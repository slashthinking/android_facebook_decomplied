package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PageViewerVisitsList
  implements Parcelable
{
  public static final Parcelable.Creator<PageViewerVisitsList> CREATOR = new PageViewerVisitsList.1();

  @JsonProperty("count")
  public final int count;

  protected PageViewerVisitsList()
  {
    this.count = 0;
  }

  protected PageViewerVisitsList(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PageViewerVisitsList
 * JD-Core Version:    0.6.2
 */