package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Comparator;

public abstract class MediaItem
  implements Parcelable
{
  public static final Comparator<MediaItem> a = new MediaItem.DateCreatedComparator(null);
  private final long b;
  private final String c;
  private final String d;
  private final long e;
  private final String f;
  private final long g;

  public MediaItem(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    this.b = paramLong1;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramLong2;
    this.f = paramString3;
    this.g = paramLong3;
  }

  protected MediaItem(Parcel paramParcel)
  {
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readLong();
  }

  public static MediaItem.MediaType a(String paramString)
  {
    MediaItem.MediaType localMediaType;
    if (b(paramString))
      localMediaType = MediaItem.MediaType.PHOTO;
    while (true)
    {
      return localMediaType;
      if (c(paramString))
      {
        localMediaType = MediaItem.MediaType.VIDEO;
        continue;
      }
      localMediaType = null;
    }
  }

  private static boolean b(String paramString)
  {
    return paramString.startsWith("image/");
  }

  private static boolean c(String paramString)
  {
    return paramString.startsWith("video/");
  }

  public long a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.d;
  }

  public long d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public MediaItem.MediaType e()
  {
    return a(this.f);
  }

  public long f()
  {
    return this.g;
  }

  public boolean g()
  {
    if (this.g > 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String toString()
  {
    return "MediaItem(" + this.b + "," + this.c + "," + this.d + "," + this.f + "," + this.e + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.g);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.MediaItem
 * JD-Core Version:    0.6.0
 */