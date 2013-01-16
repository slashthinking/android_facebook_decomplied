package com.facebook.pages.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import com.facebook.pages.data.model.FacebookProfile;
import com.google.common.collect.ImmutableList;

public class FetchPageNewLikesResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchPageNewLikesResult> CREATOR = new FetchPageNewLikesResult.1();
  private final ImmutableList<FacebookProfile> a;

  protected FetchPageNewLikesResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(null));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.server.FetchPageNewLikesResult
 * JD-Core Version:    0.6.0
 */