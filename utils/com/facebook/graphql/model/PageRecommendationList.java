package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PageRecommendationList
  implements Parcelable
{
  public static final Parcelable.Creator<PageRecommendationList> CREATOR = new PageRecommendationList.1();

  @JsonProperty("count")
  public final int count;

  @JsonProperty("nodes")
  public final List<PageRecommendation> recommendations;

  protected PageRecommendationList()
  {
    this.count = 0;
    this.recommendations = null;
  }

  private PageRecommendationList(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
    this.recommendations = paramParcel.readArrayList(PageRecommendation.class.getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
    paramParcel.writeList(this.recommendations);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PageRecommendationList
 * JD-Core Version:    0.6.2
 */