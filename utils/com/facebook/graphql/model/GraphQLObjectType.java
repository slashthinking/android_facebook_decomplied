package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLObjectType
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLObjectType> CREATOR = new GraphQLObjectType.1();
  private GraphQLObjectType.ObjectType a;

  @JsonProperty("name")
  private final String name;

  protected GraphQLObjectType()
  {
    this.a = null;
    this.name = null;
  }

  public GraphQLObjectType(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    b();
  }

  public GraphQLObjectType(GraphQLObjectType.ObjectType paramObjectType)
  {
    this.a = paramObjectType;
    this.name = paramObjectType.toString();
  }

  public GraphQLObjectType(String paramString)
  {
    this.name = paramString;
    b();
  }

  @JsonIgnore
  public GraphQLObjectType.ObjectType a()
  {
    if (this.a == null)
      b();
    return this.a;
  }

  public void b()
  {
    if (this.name == null);
    while (true)
    {
      return;
      try
      {
        this.a = GraphQLObjectType.ObjectType.valueOf(this.name);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (BuildConstants.a())
          ErrorReporting.a("FeedObjectType", "Unsupported FeedObjectType: " + this.name, false);
        this.a = GraphQLObjectType.ObjectType.Invalid;
      }
    }
  }

  @JsonIgnore
  public String c()
  {
    return this.name;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a().toString());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLObjectType
 * JD-Core Version:    0.6.2
 */