package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

public class FetchFriendListFeedParams extends FetchNewsFeedParams
{
  public static final Parcelable.Creator<FetchFriendListFeedParams> CREATOR = new FetchFriendListFeedParams.1();
  private final String a;

  private FetchFriendListFeedParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
  }

  FetchFriendListFeedParams(FetchFriendListFeedParamsBuilder paramFetchFriendListFeedParamsBuilder)
  {
    super(paramFetchFriendListFeedParamsBuilder);
    this.a = paramFetchFriendListFeedParamsBuilder.a();
  }

  public static FetchFriendListFeedParamsBuilder newBuilder()
  {
    return new FetchFriendListFeedParamsBuilder();
  }

  public String a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FetchFriendListFeedParams;
    int i = 0;
    if (bool1)
    {
      boolean bool2 = super.equals(paramObject);
      i = 0;
      if (bool2)
      {
        boolean bool3 = ((FetchFriendListFeedParams)paramObject).a().equals(this.a);
        i = 0;
        if (bool3)
          i = 1;
      }
    }
    return i;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = e();
    arrayOfObject[1] = Integer.valueOf(b());
    arrayOfObject[2] = f();
    arrayOfObject[3] = d();
    arrayOfObject[4] = c();
    arrayOfObject[5] = g();
    arrayOfObject[6] = a();
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchFriendListFeedParams
 * JD-Core Version:    0.6.0
 */