package com.facebook.orca.attachments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ImageAttachmentData
  implements Parcelable
{
  public static final Parcelable.Creator<ImageAttachmentData> CREATOR = new ImageAttachmentData.1();
  private final Uri a;
  private final Uri b;
  private final int c;
  private final int d;
  private final Uri e;

  private ImageAttachmentData(Parcel paramParcel)
  {
    this.a = ((Uri)paramParcel.readParcelable(null));
    this.b = ((Uri)paramParcel.readParcelable(null));
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = ((Uri)paramParcel.readParcelable(null));
  }

  public ImageAttachmentData(ImageAttachmentDataBuilder paramImageAttachmentDataBuilder)
  {
    this.a = paramImageAttachmentDataBuilder.a();
    this.b = paramImageAttachmentDataBuilder.b();
    this.c = paramImageAttachmentDataBuilder.c();
    this.d = paramImageAttachmentDataBuilder.d();
    this.e = paramImageAttachmentDataBuilder.e();
  }

  public Uri a()
  {
    return this.a;
  }

  public Uri b()
  {
    return this.b;
  }

  public boolean c()
  {
    if ((this.c > 0) && (this.d > 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.d;
  }

  public ImageAttachmentData.Orientation f()
  {
    ImageAttachmentData.Orientation localOrientation;
    if (!c())
      localOrientation = ImageAttachmentData.Orientation.UNKNOWN;
    while (true)
    {
      return localOrientation;
      if (this.c == this.d)
      {
        localOrientation = ImageAttachmentData.Orientation.SQUARE;
        continue;
      }
      if (this.c < this.d)
      {
        localOrientation = ImageAttachmentData.Orientation.PORTRAIT;
        continue;
      }
      localOrientation = ImageAttachmentData.Orientation.LANDSCAPE;
    }
  }

  public Uri g()
  {
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.ImageAttachmentData
 * JD-Core Version:    0.6.0
 */