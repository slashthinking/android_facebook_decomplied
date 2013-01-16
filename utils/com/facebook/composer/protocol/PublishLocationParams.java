package com.facebook.composer.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.composer.model.ImplicitLocation;

public class PublishLocationParams
  implements Parcelable
{
  public static final Parcelable.Creator<PublishLocationParams> CREATOR = new PublishLocationParams.1();
  public final String a;
  public final String b;
  public final ImplicitLocation c;

  public PublishLocationParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ImplicitLocation.valueOf(paramParcel.readString());
  }

  public PublishLocationParams(String paramString1, String paramString2, ImplicitLocation paramImplicitLocation)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramImplicitLocation;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c.toString());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishLocationParams
 * JD-Core Version:    0.6.2
 */