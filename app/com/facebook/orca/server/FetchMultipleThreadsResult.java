package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class FetchMultipleThreadsResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMultipleThreadsResult> CREATOR;
  public static final FetchMultipleThreadsResult a = new FetchMultipleThreadsResult(ImmutableList.d());
  private final ImmutableList<FetchThreadResult> b;

  static
  {
    CREATOR = new FetchMultipleThreadsResult.1();
  }

  private FetchMultipleThreadsResult(Parcel paramParcel)
  {
    this.b = ImmutableList.a(paramParcel.readArrayList(FetchThreadResult.class.getClassLoader()));
  }

  public FetchMultipleThreadsResult(ImmutableList<FetchThreadResult> paramImmutableList)
  {
    if (paramImmutableList != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.b = paramImmutableList;
      return;
    }
  }

  public ImmutableList<FetchThreadResult> a()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchMultipleThreadsResult
 * JD-Core Version:    0.6.0
 */