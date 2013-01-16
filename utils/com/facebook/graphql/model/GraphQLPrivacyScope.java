package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLPrivacyScope
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLPrivacyScope> CREATOR = new GraphQLPrivacyScope.1();

  @JsonProperty("icon")
  public final GraphQLImage icon;

  @JsonProperty("label")
  public final String label;

  @JsonProperty("type")
  public final String type;

  protected GraphQLPrivacyScope()
  {
    this.icon = null;
    this.type = null;
    this.label = null;
  }

  private GraphQLPrivacyScope(Parcel paramParcel)
  {
    this.icon = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
    this.type = paramParcel.readString();
    this.label = paramParcel.readString();
  }

  public GraphQLPrivacyScope(GraphQLImage paramGraphQLImage, String paramString1, String paramString2)
  {
    this.icon = paramGraphQLImage;
    this.type = paramString1;
    this.label = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.icon, paramInt);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.label);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLPrivacyScope
 * JD-Core Version:    0.6.2
 */