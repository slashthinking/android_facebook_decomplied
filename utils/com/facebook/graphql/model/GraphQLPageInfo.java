package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class GraphQLPageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLPageInfo> CREATOR = new GraphQLPageInfo.1();
  public static GraphQLPageInfo a = new GraphQLPageInfo();

  @JsonProperty("end_cursor")
  public final String endCursor;

  @JsonProperty("has_next_page")
  public final boolean hasNextPage;

  @JsonProperty("has_previous_page")
  public final boolean hasPreviousPage;

  @JsonProperty("start_cursor")
  public final String startCursor;

  public GraphQLPageInfo()
  {
    this.startCursor = null;
    this.endCursor = null;
    this.hasNextPage = false;
    this.hasPreviousPage = false;
  }

  public GraphQLPageInfo(Parcel paramParcel)
  {
    this.startCursor = paramParcel.readString();
    this.endCursor = paramParcel.readString();
    int j;
    if (paramParcel.readByte() == i)
    {
      j = i;
      this.hasNextPage = j;
      if (paramParcel.readByte() != i)
        break label56;
    }
    while (true)
    {
      this.hasPreviousPage = i;
      return;
      j = 0;
      break;
      label56: i = 0;
    }
  }

  public GraphQLPageInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.startCursor = paramString1;
    this.endCursor = paramString2;
    this.hasPreviousPage = paramBoolean1;
    this.hasNextPage = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof GraphQLPageInfo;
    boolean bool2 = false;
    if (bool1)
    {
      Class localClass1 = getClass();
      Class localClass2 = paramObject.getClass();
      bool2 = false;
      if (localClass1 == localClass2)
        break label34;
    }
    while (true)
    {
      return bool2;
      label34: GraphQLPageInfo localGraphQLPageInfo = (GraphQLPageInfo)paramObject;
      boolean bool3 = Objects.equal(Boolean.valueOf(this.hasPreviousPage), Boolean.valueOf(localGraphQLPageInfo.hasPreviousPage));
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(Boolean.valueOf(this.hasNextPage), Boolean.valueOf(localGraphQLPageInfo.hasNextPage));
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = Objects.equal(this.startCursor, localGraphQLPageInfo.startCursor);
          bool2 = false;
          if (bool5)
          {
            boolean bool6 = Objects.equal(this.endCursor, localGraphQLPageInfo.endCursor);
            bool2 = false;
            if (bool6)
              bool2 = true;
          }
        }
      }
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.startCursor;
    arrayOfObject[1] = this.endCursor;
    arrayOfObject[2] = Boolean.valueOf(this.hasPreviousPage);
    arrayOfObject[3] = Boolean.valueOf(this.hasNextPage);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("startCursor", this.startCursor).add("endCursor", this.endCursor).add("hasPreviousPage", Boolean.valueOf(this.hasPreviousPage)).add("hasNextPage", Boolean.valueOf(this.hasNextPage)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.startCursor);
    paramParcel.writeString(this.endCursor);
    int j;
    if (this.hasNextPage)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.hasPreviousPage)
        break label55;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label55: i = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLPageInfo
 * JD-Core Version:    0.6.2
 */