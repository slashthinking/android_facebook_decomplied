package com.facebook.feed.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.FeedStory;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Comparator;

public class StoryUpdate
  implements Parcelable
{
  public static final Parcelable.Creator<StoryUpdate> CREATOR = new StoryUpdate.1();
  public static final ArrayList<StoryUpdate> a = Lists.a();
  public static final Comparator<StoryUpdate> b = new StoryUpdate.StoryUpdateComparator();
  private final String c;
  private final FeedStory d;

  public StoryUpdate(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = ((FeedStory)paramParcel.readParcelable(FeedStory.class.getClassLoader()));
  }

  public StoryUpdate(String paramString, FeedStory paramFeedStory)
  {
    this.c = paramString;
    this.d = paramFeedStory;
  }

  public String a()
  {
    return this.c;
  }

  public FeedStory b()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      StoryUpdate localStoryUpdate = (StoryUpdate)paramObject;
      if (this.c.equals(localStoryUpdate.c))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    return this.c.hashCode();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.d, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.StoryUpdate
 * JD-Core Version:    0.6.0
 */