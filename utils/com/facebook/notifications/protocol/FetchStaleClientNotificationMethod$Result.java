package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchStaleClientNotificationMethod$Result
  implements Parcelable
{
  public static final Parcelable.Creator<Result> CREATOR = new FetchStaleClientNotificationMethod.Result.1();

  @JsonProperty("link")
  public final String link;

  @JsonProperty("message")
  public final String message;

  @JsonProperty("notification_id")
  public final long notificationID;

  public FetchStaleClientNotificationMethod$Result()
  {
    this.message = null;
    this.link = null;
    this.notificationID = 0L;
  }

  public FetchStaleClientNotificationMethod$Result(Parcel paramParcel)
  {
    this.message = paramParcel.readString();
    this.link = paramParcel.readString();
    this.notificationID = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.message);
    paramParcel.writeString(this.link);
    paramParcel.writeLong(this.notificationID);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchStaleClientNotificationMethod.Result
 * JD-Core Version:    0.6.2
 */