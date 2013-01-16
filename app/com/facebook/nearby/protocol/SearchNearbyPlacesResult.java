package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import java.util.List;

public class SearchNearbyPlacesResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<SearchNearbyPlacesResult> CREATOR = new SearchNearbyPlacesResult.1();
  public final String a;
  public final String b;
  public final List<NearbyTopic> c;
  public final List<TypeaheadPlace> d;

  private SearchNearbyPlacesResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readArrayList(NearbyTopic.class.getClassLoader());
    this.d = paramParcel.readArrayList(TypeaheadPlace.class.getClassLoader());
  }

  protected SearchNearbyPlacesResult(DataFreshnessResult paramDataFreshnessResult, long paramLong, String paramString1, String paramString2, List<NearbyTopic> paramList, List<TypeaheadPlace> paramList1)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramList;
    this.d = paramList1;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeList(this.c);
    paramParcel.writeList(this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.protocol.SearchNearbyPlacesResult
 * JD-Core Version:    0.6.0
 */