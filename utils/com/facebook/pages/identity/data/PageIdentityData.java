package com.facebook.pages.identity.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPhoneNumber;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTimeRange;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.graphql.model.PageFriendsHereNow;
import com.facebook.graphql.model.PageFriendsWhoLike;
import com.facebook.graphql.model.PageFriendsWhoVisited;
import com.facebook.graphql.model.PageRecommendationList;
import com.facebook.graphql.model.PageStarRatersList;
import com.facebook.graphql.model.PageViewerVisitsList;
import java.util.List;

public class PageIdentityData
  implements Parcelable
{
  public static final Parcelable.Creator<PageIdentityData> CREATOR = new PageIdentityData.1();
  private final long a;
  private final GraphQLAddress b;
  private final List<String> c;
  private final GraphQLFocusedPhoto d;
  private final GraphQLTextWithEntities e;
  private final PageRecommendationList f;
  private final List<GraphQLTimeRange> g;
  private final boolean h;
  private final GraphQLLocation i;
  private final String j;
  private final PageRecommendationList k;
  private final double l;
  private final GraphQLProfileList m;
  private final GraphQLProfileList n;
  private final GraphQLPhoneNumber o;
  private final String p;
  private final GraphQLImage q;
  private final PageStarRatersList r;
  private final PageFriendsWhoLike s;
  private final PageFriendsWhoVisited t;
  private final GraphQLTextWithEntities u;
  private final int v;
  private final PageViewerVisitsList w;
  private final PageFriendsHereNow x;
  private boolean y;

  public PageIdentityData(long paramLong, GraphQueryResultEntry paramGraphQueryResultEntry)
  {
    this.a = paramLong;
    this.b = paramGraphQueryResultEntry.address;
    this.c = paramGraphQueryResultEntry.categoryNames;
    this.d = paramGraphQueryResultEntry.coverPhoto;
    this.y = paramGraphQueryResultEntry.doesViewerLike;
    this.x = paramGraphQueryResultEntry.friendsHereNow;
    this.e = paramGraphQueryResultEntry.friendsHereNowSocialContext;
    this.f = paramGraphQueryResultEntry.friendRecommendations;
    if ((paramGraphQueryResultEntry.hours != null) && (paramGraphQueryResultEntry.hours.size() > 0));
    for (this.g = paramGraphQueryResultEntry.hours; ; this.g = null)
    {
      this.h = paramGraphQueryResultEntry.expressedAsPlace;
      this.i = paramGraphQueryResultEntry.location;
      this.j = paramGraphQueryResultEntry.name;
      this.k = paramGraphQueryResultEntry.nonFriendRecommendations;
      this.l = paramGraphQueryResultEntry.overallRating;
      this.m = paramGraphQueryResultEntry.pageLikers;
      this.n = paramGraphQueryResultEntry.pageVisits;
      this.o = paramGraphQueryResultEntry.phoneNumber;
      this.p = paramGraphQueryResultEntry.priceRangeDescription;
      this.q = paramGraphQueryResultEntry.profilePicture;
      this.r = paramGraphQueryResultEntry.pageRaters;
      this.s = paramGraphQueryResultEntry.friendsWhoLike;
      this.t = paramGraphQueryResultEntry.friendsWhoVisited;
      this.u = paramGraphQueryResultEntry.socialContextForNonLikingViewer;
      this.v = paramGraphQueryResultEntry.viewerRating;
      this.w = paramGraphQueryResultEntry.viewerVisits;
      return;
    }
  }

  private PageIdentityData(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = ((GraphQLAddress)paramParcel.readParcelable(GraphQLAddress.class.getClassLoader()));
    this.d = null;
    this.c = paramParcel.readArrayList(String.class.getClassLoader());
    this.x = ((PageFriendsHereNow)paramParcel.readParcelable(GraphQLProfileList.class.getClassLoader()));
    this.e = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.f = ((PageRecommendationList)paramParcel.readParcelable(PageRecommendationList.class.getClassLoader()));
    this.g = paramParcel.readArrayList(GraphQLTimeRange.class.getClassLoader());
    if (paramParcel.readByte() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.h = bool;
      this.i = ((GraphQLLocation)paramParcel.readParcelable(GraphQLLocation.class.getClassLoader()));
      this.j = paramParcel.readString();
      this.k = ((PageRecommendationList)paramParcel.readParcelable(PageRecommendationList.class.getClassLoader()));
      this.l = paramParcel.readDouble();
      this.m = ((GraphQLProfileList)paramParcel.readParcelable(GraphQLProfileList.class.getClassLoader()));
      this.n = ((GraphQLProfileList)paramParcel.readParcelable(GraphQLProfileList.class.getClassLoader()));
      this.o = ((GraphQLPhoneNumber)paramParcel.readParcelable(GraphQLPhoneNumber.class.getClassLoader()));
      this.p = paramParcel.readString();
      this.q = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
      this.r = ((PageStarRatersList)paramParcel.readParcelable(PageStarRatersList.class.getClassLoader()));
      this.s = ((PageFriendsWhoLike)paramParcel.readParcelable(PageFriendsWhoLike.class.getClassLoader()));
      this.t = ((PageFriendsWhoVisited)paramParcel.readParcelable(PageFriendsWhoVisited.class.getClassLoader()));
      this.u = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
      this.v = paramParcel.readInt();
      this.w = ((PageViewerVisitsList)paramParcel.readParcelable(PageViewerVisitsList.class.getClassLoader()));
      return;
    }
  }

  public PageIdentityData(PageIdentityDataBuilder paramPageIdentityDataBuilder)
  {
    this.y = paramPageIdentityDataBuilder.a();
    this.a = paramPageIdentityDataBuilder.b();
    this.b = paramPageIdentityDataBuilder.c();
    this.c = paramPageIdentityDataBuilder.d();
    this.d = paramPageIdentityDataBuilder.e();
    this.x = paramPageIdentityDataBuilder.f();
    this.e = paramPageIdentityDataBuilder.g();
    this.f = paramPageIdentityDataBuilder.h();
    this.g = paramPageIdentityDataBuilder.i();
    this.h = paramPageIdentityDataBuilder.j();
    this.i = paramPageIdentityDataBuilder.k();
    this.j = paramPageIdentityDataBuilder.l();
    this.k = paramPageIdentityDataBuilder.m();
    this.l = paramPageIdentityDataBuilder.n();
    this.m = paramPageIdentityDataBuilder.o();
    this.n = paramPageIdentityDataBuilder.p();
    this.o = paramPageIdentityDataBuilder.q();
    this.p = paramPageIdentityDataBuilder.r();
    this.q = paramPageIdentityDataBuilder.s();
    this.r = paramPageIdentityDataBuilder.t();
    this.s = paramPageIdentityDataBuilder.u();
    this.t = paramPageIdentityDataBuilder.v();
    this.u = paramPageIdentityDataBuilder.w();
    this.v = paramPageIdentityDataBuilder.x();
    this.w = paramPageIdentityDataBuilder.y();
  }

  public long a()
  {
    return this.a;
  }

  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  public GraphQLAddress b()
  {
    return this.b;
  }

  public List<String> c()
  {
    return this.c;
  }

  public GraphQLFocusedPhoto d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public PageFriendsHereNow e()
  {
    return this.x;
  }

  public GraphQLTextWithEntities f()
  {
    return this.e;
  }

  public PageRecommendationList g()
  {
    return this.f;
  }

  public boolean h()
  {
    return this.y;
  }

  public List<GraphQLTimeRange> i()
  {
    return this.g;
  }

  public boolean j()
  {
    return this.h;
  }

  public GraphQLLocation k()
  {
    return this.i;
  }

  public String l()
  {
    return this.j;
  }

  public PageRecommendationList m()
  {
    return this.k;
  }

  public double n()
  {
    return this.l;
  }

  public GraphQLProfileList o()
  {
    return this.m;
  }

  public GraphQLProfileList p()
  {
    return this.n;
  }

  public GraphQLPhoneNumber q()
  {
    return this.o;
  }

  public String r()
  {
    return this.p;
  }

  public GraphQLImage s()
  {
    return this.q;
  }

  public PageStarRatersList t()
  {
    return this.r;
  }

  public PageFriendsWhoLike u()
  {
    return this.s;
  }

  public PageFriendsWhoVisited v()
  {
    return this.t;
  }

  public GraphQLTextWithEntities w()
  {
    return this.u;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeList(this.c);
    paramParcel.writeParcelable(this.x, paramInt);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeParcelable(this.f, paramInt);
    paramParcel.writeList(this.g);
    if (this.h);
    for (int i1 = 1; ; i1 = 0)
    {
      paramParcel.writeByte((byte)i1);
      paramParcel.writeParcelable(this.i, paramInt);
      paramParcel.writeString(this.j);
      paramParcel.writeParcelable(this.k, paramInt);
      paramParcel.writeDouble(this.l);
      paramParcel.writeParcelable(this.m, paramInt);
      paramParcel.writeParcelable(this.n, paramInt);
      paramParcel.writeParcelable(this.o, paramInt);
      paramParcel.writeString(this.p);
      paramParcel.writeParcelable(this.q, paramInt);
      paramParcel.writeParcelable(this.r, paramInt);
      paramParcel.writeParcelable(this.s, paramInt);
      paramParcel.writeParcelable(this.t, paramInt);
      paramParcel.writeParcelable(this.u, paramInt);
      paramParcel.writeInt(this.v);
      paramParcel.writeParcelable(this.w, paramInt);
      return;
    }
  }

  public int x()
  {
    return this.v;
  }

  public PageViewerVisitsList y()
  {
    return this.w;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.data.PageIdentityData
 * JD-Core Version:    0.6.2
 */