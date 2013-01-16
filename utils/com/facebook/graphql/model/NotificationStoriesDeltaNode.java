package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationStoriesDeltaNode
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationStoriesDeltaNode> CREATOR = new NotificationStoriesDeltaNode.1();

  @JsonProperty("added")
  public final FeedStory addedStory;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("modified")
  public final FeedStory modifiedStory;

  @JsonProperty("removed")
  public final String removedID;

  @JsonProperty("__type__")
  public final GraphQLObjectType type;

  @JsonProperty("unchanged")
  public final String unchangedID;

  protected NotificationStoriesDeltaNode()
  {
    this.id = null;
    this.removedID = null;
    this.unchangedID = null;
    this.modifiedStory = null;
    this.addedStory = null;
    this.type = null;
  }

  protected NotificationStoriesDeltaNode(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.removedID = paramParcel.readString();
    this.unchangedID = paramParcel.readString();
    this.modifiedStory = ((FeedStory)paramParcel.readParcelable(FeedStory.class.getClassLoader()));
    this.addedStory = ((FeedStory)paramParcel.readParcelable(FeedStory.class.getClassLoader()));
    this.type = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.removedID);
    paramParcel.writeString(this.unchangedID);
    paramParcel.writeParcelable(this.modifiedStory, paramInt);
    paramParcel.writeParcelable(this.addedStory, paramInt);
    paramParcel.writeParcelable(this.type, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.NotificationStoriesDeltaNode
 * JD-Core Version:    0.6.2
 */