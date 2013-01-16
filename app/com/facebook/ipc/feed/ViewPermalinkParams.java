package com.facebook.ipc.feed;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.FeedStory;
import com.facebook.ipc.intent.FacebookOnlyIntentParams;
import com.google.common.base.Preconditions;

public class ViewPermalinkParams
  implements FacebookOnlyIntentParams
{
  public static final Parcelable.Creator<ViewPermalinkParams> CREATOR;
  private static final Class<?> b = ViewPermalinkParams.class;
  public final FeedStory a;

  static
  {
    CREATOR = new ViewPermalinkParams.1();
  }

  public ViewPermalinkParams(Parcel paramParcel)
  {
    this.a = ((FeedStory)paramParcel.readParcelable(FeedStory.class.getClassLoader()));
  }

  public ViewPermalinkParams(FeedStory paramFeedStory)
  {
    this.a = ((FeedStory)Preconditions.checkNotNull(paramFeedStory));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.a.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.feed.ViewPermalinkParams
 * JD-Core Version:    0.6.0
 */