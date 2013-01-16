package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class NotificationStoriesDelta
  implements Parcelable
{
  public static final Parcelable.Creator<NotificationStoriesDelta> CREATOR = new NotificationStoriesDelta.1();

  @JsonProperty("edges")
  public final List<NotificationStoriesDelta.NotificationStoryDeltaEdge> edges;

  protected NotificationStoriesDelta()
  {
    this.edges = null;
  }

  protected NotificationStoriesDelta(Parcel paramParcel)
  {
    this.edges = new ArrayList();
    paramParcel.readTypedList(this.edges, NotificationStoriesDelta.NotificationStoryDeltaEdge.CREATOR);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.edges);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.NotificationStoriesDelta
 * JD-Core Version:    0.6.2
 */