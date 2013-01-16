package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class GraphQLText
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLText> CREATOR = new GraphQLText.1();

  @JsonProperty("text")
  public final String text;

  protected GraphQLText()
  {
    this.text = null;
  }

  public GraphQLText(Parcel paramParcel)
  {
    this.text = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        bool = false;
      }
      else
      {
        GraphQLText localGraphQLText = (GraphQLText)paramObject;
        bool = this.text.equals(localGraphQLText.text);
      }
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.text;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.text);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLText
 * JD-Core Version:    0.6.2
 */