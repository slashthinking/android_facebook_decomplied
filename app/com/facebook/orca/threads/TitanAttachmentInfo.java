package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TitanAttachmentInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TitanAttachmentInfo> CREATOR = new TitanAttachmentInfo.1();
  private final String a;
  private final int b;
  private final String c;
  private final String d;
  private final int e;
  private final TitanAttachmentInfo.ImageData f;

  private TitanAttachmentInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = ((TitanAttachmentInfo.ImageData)paramParcel.readParcelable(TitanAttachmentInfo.ImageData.class.getClassLoader()));
  }

  TitanAttachmentInfo(TitanAttachmentInfoBuilder paramTitanAttachmentInfoBuilder)
  {
    this.a = paramTitanAttachmentInfoBuilder.a();
    this.b = paramTitanAttachmentInfoBuilder.b();
    this.c = paramTitanAttachmentInfoBuilder.c();
    this.d = paramTitanAttachmentInfoBuilder.d();
    this.e = paramTitanAttachmentInfoBuilder.e();
    this.f = paramTitanAttachmentInfoBuilder.f();
  }

  public String a()
  {
    return this.a;
  }

  public int b()
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

  public int e()
  {
    return this.e;
  }

  public TitanAttachmentInfo.ImageData f()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeParcelable(this.f, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.TitanAttachmentInfo
 * JD-Core Version:    0.6.0
 */