package com.facebook.pages.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class PageInfo
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<PageInfo> CREATOR = new PageInfo.1();

  @JMAutogen.InferredType(jsonFieldName="access_token")
  public final String accessToken;

  @JMAutogen.InferredType(jsonFieldName="fan_count")
  public final long fanCount;

  @JMAutogen.InferredType(jsonFieldName="page_id")
  public final long pageId;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String pageName;

  @JMAutogen.InferredType(jsonFieldName="square_pic_url")
  public final String squareProfilePicUrl;

  private PageInfo()
  {
    this.pageId = 0L;
    this.pageName = null;
    this.accessToken = null;
    this.fanCount = 0L;
    this.squareProfilePicUrl = null;
  }

  public PageInfo(Parcel paramParcel)
  {
    this.pageId = paramParcel.readLong();
    this.pageName = paramParcel.readString();
    this.accessToken = paramParcel.readString();
    this.fanCount = paramParcel.readLong();
    this.squareProfilePicUrl = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("name", this.pageName).add("fan count", Long.valueOf(this.fanCount)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.pageId);
    paramParcel.writeString(this.pageName);
    paramParcel.writeString(this.accessToken);
    paramParcel.writeLong(this.fanCount);
    paramParcel.writeString(this.squareProfilePicUrl);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.model.PageInfo
 * JD-Core Version:    0.6.0
 */