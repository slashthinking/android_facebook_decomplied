package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ReportInfo> CREATOR = new ReportInfo.1();

  @JsonProperty("action")
  public final String action;

  protected ReportInfo()
  {
    this.action = null;
  }

  protected ReportInfo(Parcel paramParcel)
  {
    this.action = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.action);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.ReportInfo
 * JD-Core Version:    0.6.2
 */