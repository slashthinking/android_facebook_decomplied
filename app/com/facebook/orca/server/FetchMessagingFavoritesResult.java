package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class FetchMessagingFavoritesResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMessagingFavoritesResult> CREATOR = new FetchMessagingFavoritesResult.1();
  private final ImmutableList<User> a;

  private FetchMessagingFavoritesResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
  }

  public FetchMessagingFavoritesResult(DataFreshnessResult paramDataFreshnessResult, ImmutableList<User> paramImmutableList, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramImmutableList;
  }

  public ImmutableList<User> a()
  {
    return this.a;
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
 * Qualified Name:     com.facebook.orca.server.FetchMessagingFavoritesResult
 * JD-Core Version:    0.6.0
 */