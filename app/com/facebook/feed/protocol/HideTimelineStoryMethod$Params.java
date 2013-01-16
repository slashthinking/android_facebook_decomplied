package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Preconditions;

public class HideTimelineStoryMethod$Params
  implements Parcelable
{
  public String a;

  public HideTimelineStoryMethod$Params(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.a = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.HideTimelineStoryMethod.Params
 * JD-Core Version:    0.6.0
 */