package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.NotificationStoriesDelta;
import com.facebook.graphql.model.NotificationStoryEdge;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class NotificationStories
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationStories> CREATOR = new NotificationStories.1();

  @JsonProperty("deltas")
  public final NotificationStoriesDelta deltaStories;

  @JsonProperty("edges")
  public final List<NotificationStoryEdge> newStories;

  protected NotificationStories()
  {
    this.newStories = null;
    this.deltaStories = null;
  }

  private NotificationStories(Parcel paramParcel)
  {
    this.newStories = new ArrayList();
    paramParcel.readTypedList(this.newStories, NotificationStoryEdge.CREATOR);
    this.deltaStories = ((NotificationStoriesDelta)paramParcel.readParcelable(NotificationStoriesDelta.class.getClassLoader()));
  }

  public NotificationStories(List<NotificationStoryEdge> paramList)
  {
    this.newStories = paramList;
    this.deltaStories = null;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.newStories);
    paramParcel.writeParcelable(this.deltaStories, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.model.NotificationStories
 * JD-Core Version:    0.6.2
 */