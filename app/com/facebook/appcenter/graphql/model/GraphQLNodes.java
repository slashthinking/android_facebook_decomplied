package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GraphQLNodes<T>
  implements Parcelable
{

  @JsonProperty("nodes")
  public final List<T> nodes = null;

  public List<T> a()
  {
    return this.nodes;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.nodes);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.GraphQLNodes
 * JD-Core Version:    0.6.0
 */