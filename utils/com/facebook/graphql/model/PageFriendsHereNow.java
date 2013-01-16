package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class PageFriendsHereNow
  implements Parcelable
{
  public static final Parcelable.Creator<PageFriendsHereNow> CREATOR = new PageFriendsHereNow.1();

  @JsonProperty("count")
  public final int count;

  @JsonProperty("nodes")
  public final List<GraphQLProfile> friends;

  protected PageFriendsHereNow()
  {
    this.count = 0;
    this.friends = null;
  }

  protected PageFriendsHereNow(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
    this.friends = new ArrayList();
    paramParcel.readTypedList(this.friends, GraphQLProfile.CREATOR);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
    paramParcel.writeTypedList(this.friends);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PageFriendsHereNow
 * JD-Core Version:    0.6.2
 */