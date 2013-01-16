package com.facebook.katana.activity.composer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ComposerPublisherResult
  implements Parcelable
{
  public static final Parcelable.Creator<ComposerPublisherResult> CREATOR = new ComposerPublisherResult.1();
  private String a;
  private String b;

  public ComposerPublisherResult()
  {
  }

  public ComposerPublisherResult(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public boolean a()
  {
    if (this.a != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String b()
  {
    return this.a;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerPublisherResult
 * JD-Core Version:    0.6.0
 */