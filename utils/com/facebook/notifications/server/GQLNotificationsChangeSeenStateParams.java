package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.FeedStory.SeenState;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public class GQLNotificationsChangeSeenStateParams
  implements Parcelable
{
  public static final Parcelable.Creator<GQLNotificationsChangeSeenStateParams> CREATOR = new GQLNotificationsChangeSeenStateParams.1();
  private final ImmutableList<String> a;
  private final FeedStory.SeenState b;

  public GQLNotificationsChangeSeenStateParams(Parcel paramParcel)
  {
    this.b = FeedStory.SeenState.valueOf(paramParcel.readString());
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList(localArrayList, null);
    this.a = ImmutableList.a(localArrayList);
  }

  public ImmutableList<String> a()
  {
    return this.a;
  }

  public FeedStory.SeenState b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b.name());
    paramParcel.writeList(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.server.GQLNotificationsChangeSeenStateParams
 * JD-Core Version:    0.6.2
 */