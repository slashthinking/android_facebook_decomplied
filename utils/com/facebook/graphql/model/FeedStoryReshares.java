package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedStoryReshares
  implements Parcelable
{
  public static final Parcelable.Creator<FeedStoryReshares> CREATOR = new FeedStoryReshares.1();
  public static final FeedStoryReshares a = new FeedStoryReshares();

  @JsonProperty("count")
  public final int count;

  private FeedStoryReshares()
  {
    this(0);
  }

  public FeedStoryReshares(int paramInt)
  {
    this.count = paramInt;
  }

  protected FeedStoryReshares(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStoryReshares
 * JD-Core Version:    0.6.2
 */