package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class GraphQLActionLink
  implements Parcelable
{
  public static final Parcelable.Creator<GraphQLActionLink> CREATOR = new GraphQLActionLink.1();

  @JsonProperty("coupon")
  public final GraphQLCoupon coupon;

  @JsonProperty("page")
  public final GraphQLProfile page;

  @JsonProperty("title")
  public final String title;

  @JsonProperty("__type__")
  public final GraphQLObjectType type;

  @JsonProperty("url")
  public final String url;

  protected GraphQLActionLink()
  {
    this.type = null;
    this.page = null;
    this.title = null;
    this.url = null;
    this.coupon = null;
  }

  private GraphQLActionLink(Parcel paramParcel)
  {
    this.type = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.class.getClassLoader()));
    this.page = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.title = paramParcel.readString();
    this.url = paramParcel.readString();
    this.coupon = ((GraphQLCoupon)paramParcel.readParcelable(GraphQLCoupon.class.getClassLoader()));
  }

  protected GraphQLActionLink(GraphQLActionLink.Builder paramBuilder)
  {
    this.type = GraphQLActionLink.Builder.a(paramBuilder);
    this.page = GraphQLActionLink.Builder.b(paramBuilder);
    this.title = GraphQLActionLink.Builder.c(paramBuilder);
    this.url = GraphQLActionLink.Builder.d(paramBuilder);
    this.coupon = GraphQLActionLink.Builder.e(paramBuilder);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = paramObject instanceof GraphQLActionLink;
    boolean bool3 = false;
    if (!bool2)
      return bool3;
    GraphQLActionLink localGraphQLActionLink = (GraphQLActionLink)paramObject;
    int i;
    label48: int j;
    if ((this.type != null) && (this.type.equals(localGraphQLActionLink.type)))
    {
      i = bool1;
      if ((this.page != null) && ((localGraphQLActionLink.page == null) || (!this.page.id.equals(localGraphQLActionLink.page.id))))
        break label128;
      j = bool1;
      label87: boolean bool4 = Objects.equal(this.coupon, localGraphQLActionLink.coupon);
      if ((i == 0) || (j == 0) || (!bool4))
        break label134;
    }
    while (true)
    {
      bool3 = bool1;
      break;
      i = 0;
      break label48;
      label128: j = 0;
      break label87;
      label134: bool1 = false;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.type, paramInt);
    paramParcel.writeParcelable(this.page, paramInt);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.url);
    paramParcel.writeParcelable(this.coupon, paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLActionLink
 * JD-Core Version:    0.6.2
 */