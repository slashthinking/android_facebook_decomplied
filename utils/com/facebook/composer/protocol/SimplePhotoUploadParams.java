package com.facebook.composer.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SimplePhotoUploadParams
  implements Parcelable
{
  public static final Parcelable.Creator<SimplePhotoUploadParams> CREATOR = new SimplePhotoUploadParams.1();
  private long a;
  private String b;
  private String c;
  private String d;

  public SimplePhotoUploadParams(long paramLong, String paramString1, String paramString2)
  {
    this(paramLong, paramString1, paramString2, null);
  }

  public SimplePhotoUploadParams(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }

  public SimplePhotoUploadParams(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }

  public String a()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public String b()
  {
    return this.c;
  }

  public long c()
  {
    return this.a;
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
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.SimplePhotoUploadParams
 * JD-Core Version:    0.6.2
 */