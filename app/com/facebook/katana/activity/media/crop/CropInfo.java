package com.facebook.katana.activity.media.crop;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CropInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CropInfo> CREATOR = new CropInfo.1();
  private final float[] a = new float[8];

  public CropInfo(Parcel paramParcel)
  {
    paramParcel.readFloatArray(this.a);
  }

  public CropInfo(float[] paramArrayOfFloat)
  {
    a(paramArrayOfFloat);
  }

  public void a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length == 8)
      for (int i = 0; i < 8; i++)
        this.a[i] = paramArrayOfFloat[i];
  }

  public float[] a()
  {
    return this.a;
  }

  public float b()
  {
    float[] arrayOfFloat = a();
    return (float)(57.295779513082323D * (float)Math.atan2(arrayOfFloat[3] - arrayOfFloat[1], arrayOfFloat[2] - arrayOfFloat[0]));
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < 8; i++)
      localStringBuilder.append(this.a[i] + ",");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.a != null)
      paramParcel.writeFloatArray(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropInfo
 * JD-Core Version:    0.6.0
 */