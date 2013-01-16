package com.facebook.feed.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

public class FeedType
  implements Parcelable
{
  public static final Parcelable.Creator<FeedType> CREATOR;
  public static final FeedType a = new FeedType(NewsFeedType.MOST_RECENT);
  public static final FeedType b = new FeedType(NewsFeedType.TOP_STORIES);
  public final String c;

  static
  {
    CREATOR = new FeedType.1();
  }

  public FeedType(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
  }

  public FeedType(NewsFeedType paramNewsFeedType)
  {
    this(paramNewsFeedType.value);
  }

  public FeedType(String paramString)
  {
    if (paramString == null);
    for (this.c = b.c; ; this.c = paramString)
      return;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof FeedType)));
    for (boolean bool = false; ; bool = Objects.equal(this.c, ((FeedType)paramObject).c))
      return bool;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.c;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.model.FeedType
 * JD-Core Version:    0.6.0
 */