package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchNearbyPlacesParams
  implements Parcelable
{
  public static final Parcelable.Creator<SearchNearbyPlacesParams> CREATOR = new SearchNearbyPlacesParams.1();
  public final SearchArea a;
  public final String b;

  private SearchNearbyPlacesParams(Parcel paramParcel)
  {
    this.a = ((SearchArea)paramParcel.readParcelable(SearchArea.class.getClassLoader()));
    this.b = paramParcel.readString();
  }

  public SearchNearbyPlacesParams(SearchArea paramSearchArea, String paramString)
  {
    this.a = paramSearchArea;
    this.b = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.protocol.SearchNearbyPlacesParams
 * JD-Core Version:    0.6.0
 */