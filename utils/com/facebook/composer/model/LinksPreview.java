package com.facebook.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LinksPreview
  implements Parcelable
{
  public static final Parcelable.Creator<LinksPreview> CREATOR = new LinksPreview.1();

  @JsonProperty("caption")
  public final String caption;

  @JsonProperty("description")
  public final String description;

  @JsonProperty("href")
  public final String href;

  @JsonProperty("media")
  public final List<LinksPreview.Media> media;

  @JsonProperty("name")
  public final String name;

  public LinksPreview()
  {
    this.href = null;
    this.name = null;
    this.caption = null;
    this.description = null;
    this.media = Collections.emptyList();
  }

  private LinksPreview(Parcel paramParcel)
  {
    this.href = paramParcel.readString();
    this.name = paramParcel.readString();
    this.caption = paramParcel.readString();
    this.description = paramParcel.readString();
    this.media = paramParcel.readArrayList(LinksPreview.Media.class.getClassLoader());
  }

  @JsonIgnore
  public String a()
  {
    String str;
    if (this.media == null)
      str = null;
    while (true)
    {
      return str;
      Iterator localIterator = this.media.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          LinksPreview.Media localMedia = (LinksPreview.Media)localIterator.next();
          if ("image".equals(localMedia.type))
          {
            str = localMedia.src;
            break;
          }
        }
      str = null;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return this.name;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.href);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.caption);
    paramParcel.writeString(this.description);
    paramParcel.writeList(this.media);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.model.LinksPreview
 * JD-Core Version:    0.6.2
 */