package com.facebook.katana.service.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaUploaderController$MediaUnpublishedPhoto
  implements Parcelable
{
  public static final Parcelable.Creator<MediaUnpublishedPhoto> CREATOR = new MediaUploaderController.MediaUnpublishedPhoto.1();
  private final MediaUploaderController.MediaUnpublishedPhoto.SourceType a;
  private final String b;
  private final long c;

  private MediaUploaderController$MediaUnpublishedPhoto(Parcel paramParcel)
  {
    this.a = MediaUploaderController.MediaUnpublishedPhoto.SourceType.fromInt(paramParcel.readInt());
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
  }

  public MediaUploaderController$MediaUnpublishedPhoto(MediaUploaderController.MediaUnpublishedPhoto.SourceType paramSourceType, String paramString1, long paramLong, String paramString2)
  {
    this.a = paramSourceType;
    this.b = paramString1;
    this.c = paramLong;
  }

  public String a()
  {
    return this.b;
  }

  public long b()
  {
    return this.c;
  }

  public MediaUploaderController.MediaUnpublishedPhoto.SourceType c()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a.getValue());
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaUploaderController.MediaUnpublishedPhoto
 * JD-Core Version:    0.6.0
 */