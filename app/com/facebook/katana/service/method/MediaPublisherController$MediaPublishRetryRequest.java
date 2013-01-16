package com.facebook.katana.service.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Map;

public class MediaPublisherController$MediaPublishRetryRequest
  implements Parcelable
{
  public static final Parcelable.Creator<MediaPublishRetryRequest> CREATOR = new MediaPublisherController.MediaPublishRetryRequest.1();
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;

  private MediaPublisherController$MediaPublishRetryRequest(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }

  public MediaPublisherController$MediaPublishRetryRequest(GraphApiMethod paramGraphApiMethod, String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString2;
    this.c = paramString3;
    this.f = paramString1;
    this.a = paramGraphApiMethod.c;
    this.b = paramGraphApiMethod.d;
    if (paramGraphApiMethod.e.containsKey("name"))
      this.e = ((String)paramGraphApiMethod.e.get("name"));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.MediaPublisherController.MediaPublishRetryRequest
 * JD-Core Version:    0.6.0
 */