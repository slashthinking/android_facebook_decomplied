package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class VideoItem extends MediaItem
{
  public static final Parcelable.Creator<VideoItem> CREATOR = new VideoItem.1();

  public VideoItem(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    super(paramLong1, paramString1, paramString2, paramString3, paramLong2, paramLong3);
  }

  private VideoItem(Parcel paramParcel)
  {
    super(paramParcel);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.VideoItem
 * JD-Core Version:    0.6.0
 */