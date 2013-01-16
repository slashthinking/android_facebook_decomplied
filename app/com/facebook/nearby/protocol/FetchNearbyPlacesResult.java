package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.nearby.model.NearbyPlaceEdge;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FetchNearbyPlacesResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNearbyPlacesResult> CREATOR = new FetchNearbyPlacesResult.1();

  @JsonProperty("edges")
  public final List<NearbyPlaceEdge> nearbyPlaces;

  @JsonProperty("search_session_id")
  public final String searchSessionId;

  private FetchNearbyPlacesResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.searchSessionId = paramParcel.readString();
    this.nearbyPlaces = paramParcel.readArrayList(NearbyPlaceEdge.class.getClassLoader());
  }

  protected FetchNearbyPlacesResult(DataFreshnessResult paramDataFreshnessResult, long paramLong, String paramString, List<NearbyPlaceEdge> paramList)
  {
    super(paramDataFreshnessResult, paramLong);
    this.searchSessionId = paramString;
    this.nearbyPlaces = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.searchSessionId);
    paramParcel.writeList(this.nearbyPlaces);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.protocol.FetchNearbyPlacesResult
 * JD-Core Version:    0.6.0
 */