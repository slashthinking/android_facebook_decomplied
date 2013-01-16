package com.facebook.orca.attachments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AudioAttachmentData
  implements Parcelable
{
  public static final Parcelable.Creator<AudioAttachmentData> CREATOR = new AudioAttachmentData.1();
  private final long a;
  private final Uri b;

  public AudioAttachmentData(long paramLong, Uri paramUri)
  {
    this.a = paramLong;
    this.b = paramUri;
  }

  private AudioAttachmentData(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
  }

  public long a()
  {
    return this.a;
  }

  public Uri b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AudioAttachmentData
 * JD-Core Version:    0.6.0
 */