package com.facebook.feed.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum NewsFeedType
  implements Parcelable
{
  public static final Parcelable.Creator<NewsFeedType> CREATOR;
  public final String value;

  static
  {
    NewsFeedType[] arrayOfNewsFeedType = new NewsFeedType[2];
    arrayOfNewsFeedType[0] = MOST_RECENT;
    arrayOfNewsFeedType[1] = TOP_STORIES;
    $VALUES = arrayOfNewsFeedType;
    CREATOR = new NewsFeedType.1();
  }

  private NewsFeedType(String paramString)
  {
    this.value = paramString;
  }

  public static NewsFeedType getNewsFeedTypeByValue(String paramString)
  {
    if (MOST_RECENT.value.equals(paramString));
    for (NewsFeedType localNewsFeedType = MOST_RECENT; ; localNewsFeedType = TOP_STORIES)
      return localNewsFeedType;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.value);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.model.NewsFeedType
 * JD-Core Version:    0.6.0
 */