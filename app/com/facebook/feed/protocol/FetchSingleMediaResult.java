package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLMedia;

public class FetchSingleMediaResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchSingleMediaResult> CREATOR = new FetchSingleMediaResult.1();
  public final GraphQLMedia a;

  public FetchSingleMediaResult(Parcel paramParcel)
  {
    this.a = ((GraphQLMedia)paramParcel.readParcelable(GraphQLMedia.class.getClassLoader()));
  }

  public FetchSingleMediaResult(GraphQLMedia paramGraphQLMedia)
  {
    this.a = paramGraphQLMedia;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchSingleMediaResult
 * JD-Core Version:    0.6.0
 */