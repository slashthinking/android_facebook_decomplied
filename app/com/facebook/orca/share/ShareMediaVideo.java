package com.facebook.orca.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShareMediaVideo
  implements Parcelable
{
  public static final Parcelable.Creator<ShareMediaVideo> CREATOR = new ShareMediaVideo.1();
  private final String a;
  private final String b;
  private final String c;
  private final String d;

  private ShareMediaVideo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }

  ShareMediaVideo(ShareMediaVideoBuilder paramShareMediaVideoBuilder)
  {
    this.a = paramShareMediaVideoBuilder.a();
    this.b = paramShareMediaVideoBuilder.b();
    this.c = paramShareMediaVideoBuilder.c();
    this.d = paramShareMediaVideoBuilder.d();
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareMediaVideo
 * JD-Core Version:    0.6.0
 */