package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.feed.model.FeedType;

public class ClearCacheAfterCursorParams
  implements Parcelable
{
  public static final Parcelable.Creator<ClearCacheAfterCursorParams> CREATOR = new ClearCacheAfterCursorParams.1();
  public final FeedType a;
  public final String b;

  public ClearCacheAfterCursorParams(Parcel paramParcel)
  {
    this.a = ((FeedType)paramParcel.readParcelable(FeedType.class.getClassLoader()));
    this.b = paramParcel.readString();
  }

  public ClearCacheAfterCursorParams(FeedType paramFeedType, String paramString)
  {
    this.a = paramFeedType;
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
 * Qualified Name:     com.facebook.feed.protocol.ClearCacheAfterCursorParams
 * JD-Core Version:    0.6.0
 */