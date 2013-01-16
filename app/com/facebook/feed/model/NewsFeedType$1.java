package com.facebook.feed.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class NewsFeedType$1
  implements Parcelable.Creator<NewsFeedType>
{
  public NewsFeedType a(Parcel paramParcel)
  {
    return NewsFeedType.getNewsFeedTypeByValue(paramParcel.readString());
  }

  public NewsFeedType[] a(int paramInt)
  {
    return new NewsFeedType[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.model.NewsFeedType.1
 * JD-Core Version:    0.6.0
 */