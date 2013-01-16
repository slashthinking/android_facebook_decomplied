package com.facebook.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LinksPreview$Media
  implements Parcelable
{
  public static final Parcelable.Creator<Media> CREATOR = new LinksPreview.Media.1();

  @JsonProperty("src")
  public final String src;

  @JsonProperty("type")
  public final String type;

  public LinksPreview$Media()
  {
    this.type = null;
    this.src = null;
  }

  private LinksPreview$Media(Parcel paramParcel)
  {
    this.type = paramParcel.readString();
    this.src = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return this.src;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.src);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.model.LinksPreview.Media
 * JD-Core Version:    0.6.2
 */