package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.List;

public class GraphQLProfileList
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLProfileList> CREATOR = new GraphQLProfileList.1();

  @JsonProperty("count")
  public final int count;

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo;

  @JsonProperty("nodes")
  public final List<GraphQLProfile> profiles;

  protected GraphQLProfileList()
  {
    this.count = 0;
    this.profiles = null;
    this.pageInfo = null;
  }

  public GraphQLProfileList(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
    this.profiles = Lists.a();
    paramParcel.readTypedList(this.profiles, GraphQLProfile.CREATOR);
    this.pageInfo = ((GraphQLPageInfo)paramParcel.readParcelable(GraphQLPageInfo.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
    paramParcel.writeTypedList(this.profiles);
    paramParcel.writeParcelable(this.pageInfo, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLProfileList
 * JD-Core Version:    0.6.2
 */