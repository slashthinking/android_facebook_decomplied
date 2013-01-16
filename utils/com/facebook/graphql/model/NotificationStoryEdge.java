package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

public class NotificationStoryEdge
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationStoryEdge> CREATOR = new NotificationStoryEdge.1();

  @JsonProperty("cursor")
  public final String cursor;

  @JsonProperty("node")
  public final FeedStory notificationStory;

  protected NotificationStoryEdge()
  {
    this.notificationStory = null;
    this.cursor = null;
  }

  protected NotificationStoryEdge(Parcel paramParcel)
  {
    this.notificationStory = ((FeedStory)paramParcel.readParcelable(FeedStory.class.getClassLoader()));
    this.cursor = paramParcel.readString();
  }

  protected NotificationStoryEdge(NotificationStoryEdge.Builder paramBuilder)
  {
    Preconditions.checkNotNull(paramBuilder);
    this.notificationStory = NotificationStoryEdge.Builder.a(paramBuilder);
    this.cursor = NotificationStoryEdge.Builder.b(paramBuilder);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.notificationStory, paramInt);
    paramParcel.writeString(this.cursor);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.NotificationStoryEdge
 * JD-Core Version:    0.6.2
 */