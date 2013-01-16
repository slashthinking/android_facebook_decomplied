package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class PeopleYouMayKnowItem
  implements Parcelable
{
  public static final Parcelable.Creator<PeopleYouMayKnowItem> CREATOR = new PeopleYouMayKnowItem.1();

  @JsonIgnore
  private boolean a;

  @JsonIgnore
  private boolean b;

  @JsonProperty("profile")
  public final GraphQLProfile profile;

  @JsonProperty("tracking")
  public final String tracking;

  protected PeopleYouMayKnowItem()
  {
    this.profile = null;
    this.tracking = null;
    this.a = false;
    this.b = false;
  }

  public PeopleYouMayKnowItem(Parcel paramParcel)
  {
    this.profile = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.tracking = paramParcel.readString();
    int j;
    if (paramParcel.readByte() == i)
    {
      j = i;
      this.a = j;
      if (paramParcel.readByte() != i)
        break label64;
    }
    while (true)
    {
      this.b = i;
      return;
      j = 0;
      break;
      label64: i = 0;
    }
  }

  @JsonIgnore
  public boolean a()
  {
    return this.b;
  }

  @JsonIgnore
  public PeopleYouMayKnowItem b()
  {
    this.b = true;
    return this;
  }

  @JsonIgnore
  public JsonNode c()
  {
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    localArrayNode.add(this.tracking);
    return localArrayNode;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeParcelable(this.profile, paramInt);
    paramParcel.writeString(this.tracking);
    int j;
    if (this.a)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.b)
        break label56;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label56: i = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PeopleYouMayKnowItem
 * JD-Core Version:    0.6.2
 */