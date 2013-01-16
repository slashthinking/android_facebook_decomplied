package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class GraphQLImage
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLImage> CREATOR = new GraphQLImage.1();

  @JsonProperty("height")
  public final int height;

  @JsonProperty("uri")
  public final String uri;

  @JsonProperty("width")
  public final int width;

  protected GraphQLImage()
  {
    this.uri = null;
    this.width = 0;
    this.height = 0;
  }

  public GraphQLImage(Parcel paramParcel)
  {
    this.uri = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
  }

  public GraphQLImage(String paramString, int paramInt1, int paramInt2)
  {
    this.uri = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public static int a(int paramInt)
  {
    return a(new int[] { 75, 130, 180, 320, 480, 600, 720, 960, 2048 }, paramInt);
  }

  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt[(-1 + paramArrayOfInt.length)];
    for (int j = -1 + paramArrayOfInt.length; ; j--)
    {
      if ((j < 0) || (paramInt > paramArrayOfInt[j]))
        return i;
      i = paramArrayOfInt[j];
    }
  }

  @JsonIgnore
  public boolean a()
  {
    if (this.uri != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject);
    GraphQLImage localGraphQLImage;
    do
    {
      while (true)
      {
        return bool;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
        {
          bool = false;
        }
        else
        {
          localGraphQLImage = (GraphQLImage)paramObject;
          if (this.height != localGraphQLImage.height)
          {
            bool = false;
          }
          else
          {
            if (this.width == localGraphQLImage.width)
              break;
            bool = false;
          }
        }
      }
      if (this.uri == null)
        break;
    }
    while (this.uri.equals(localGraphQLImage.uri));
    while (true)
    {
      bool = false;
      break;
      if (localGraphQLImage.uri == null)
        break;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.uri;
    arrayOfObject[1] = Integer.valueOf(this.width);
    arrayOfObject[2] = Integer.valueOf(this.height);
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uri);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLImage
 * JD-Core Version:    0.6.2
 */