package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TitanAttachmentInfo$ImageData
  implements Parcelable
{
  public static final Parcelable.Creator<ImageData> CREATOR = new TitanAttachmentInfo.ImageData.1();
  private int a;
  private int b;

  public TitanAttachmentInfo$ImageData(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public TitanAttachmentInfo$ImageData(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }

  public int a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.TitanAttachmentInfo.ImageData
 * JD-Core Version:    0.6.0
 */