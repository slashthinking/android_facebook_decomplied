package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationStoriesDelta$NotificationStoryDeltaEdge
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationStoryDeltaEdge> CREATOR = new NotificationStoriesDelta.NotificationStoryDeltaEdge.1();

  @JsonProperty("cursor")
  public final String cursor;

  @JsonProperty("node")
  public final NotificationStoriesDeltaNode node;

  protected NotificationStoriesDelta$NotificationStoryDeltaEdge()
  {
    this.node = null;
    this.cursor = null;
  }

  protected NotificationStoriesDelta$NotificationStoryDeltaEdge(Parcel paramParcel)
  {
    this.node = ((NotificationStoriesDeltaNode)paramParcel.readParcelable(NotificationStoriesDeltaNode.class.getClassLoader()));
    this.cursor = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.node, paramInt);
    paramParcel.writeString(this.cursor);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.NotificationStoriesDelta.NotificationStoryDeltaEdge
 * JD-Core Version:    0.6.2
 */