package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLObjectType;

public class MarkImpressionsLoggedParams
  implements Parcelable
{
  public static final Parcelable.Creator<MarkImpressionsLoggedParams> CREATOR = new MarkImpressionsLoggedParams.1();
  public final String a;
  public final GraphQLObjectType b;

  public MarkImpressionsLoggedParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.class.getClassLoader()));
  }

  protected MarkImpressionsLoggedParams(String paramString, GraphQLObjectType paramGraphQLObjectType)
  {
    this.a = paramString;
    this.b = paramGraphQLObjectType;
  }

  public static MarkImpressionsLoggedParams.Builder a()
  {
    return new MarkImpressionsLoggedParams.Builder();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.MarkImpressionsLoggedParams
 * JD-Core Version:    0.6.0
 */