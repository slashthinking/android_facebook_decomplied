package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;

public class FetchPeopleYouMayKnowMethod$Result
  implements Parcelable
{
  public static final Parcelable.Creator<Result> CREATOR = new FetchPeopleYouMayKnowMethod.Result.1();

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo;

  @JsonProperty("nodes")
  public final List<PersonYouMayKnow> peopleYouMayKnow;

  public FetchPeopleYouMayKnowMethod$Result()
  {
    this(null, null);
  }

  public FetchPeopleYouMayKnowMethod$Result(Parcel paramParcel)
  {
    this.peopleYouMayKnow = Arrays.asList((PersonYouMayKnow[])(PersonYouMayKnow[])paramParcel.readParcelableArray(PersonYouMayKnow.class.getClassLoader()));
    this.pageInfo = ((GraphQLPageInfo)paramParcel.readParcelable(GraphQLPageInfo.class.getClassLoader()));
  }

  public FetchPeopleYouMayKnowMethod$Result(List<PersonYouMayKnow> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    this.peopleYouMayKnow = paramList;
    this.pageInfo = paramGraphQLPageInfo;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelableArray((Parcelable[])this.peopleYouMayKnow.toArray(new PersonYouMayKnow[this.peopleYouMayKnow.size()]), paramInt);
    paramParcel.writeParcelable(this.pageInfo, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.FetchPeopleYouMayKnowMethod.Result
 * JD-Core Version:    0.6.0
 */