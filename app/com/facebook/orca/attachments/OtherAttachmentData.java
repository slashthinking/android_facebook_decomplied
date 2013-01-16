package com.facebook.orca.attachments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OtherAttachmentData
  implements Parcelable
{
  public static final Parcelable.Creator<OtherAttachmentData> CREATOR = new OtherAttachmentData.1();
  private final String a;
  private final int b;
  private final String c;
  private final Uri d;

  private OtherAttachmentData(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = ((Uri)paramParcel.readParcelable(null));
  }

  OtherAttachmentData(String paramString1, int paramInt, String paramString2, Uri paramUri)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramUri;
  }

  public String a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public Uri c()
  {
    return this.d;
  }

  public String d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.d, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.OtherAttachmentData
 * JD-Core Version:    0.6.0
 */