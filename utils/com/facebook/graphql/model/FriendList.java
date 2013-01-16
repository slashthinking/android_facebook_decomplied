package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FriendList
  implements Parcelable
{
  public static final Parcelable.Creator<FriendList> CREATOR = new FriendList.1();

  @JsonProperty("id")
  public final long id;

  @JsonProperty("list_type")
  public final String listType;

  @JsonProperty("name")
  public final String name;

  protected FriendList()
  {
    this.id = 0L;
    this.name = null;
    this.listType = null;
  }

  protected FriendList(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.name = paramParcel.readString();
    this.listType = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.listType);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FriendList
 * JD-Core Version:    0.6.2
 */