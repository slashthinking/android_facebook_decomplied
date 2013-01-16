package com.facebook.pages.identity.data;

import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPhoneNumber;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTimeRange;
import com.facebook.graphql.model.PageFriendsHereNow;
import com.facebook.graphql.model.PageFriendsWhoLike;
import com.facebook.graphql.model.PageFriendsWhoVisited;
import com.facebook.graphql.model.PageRecommendationList;
import com.facebook.graphql.model.PageStarRatersList;
import com.facebook.graphql.model.PageViewerVisitsList;
import java.util.List;

public class PageIdentityDataBuilder
{
  private boolean a;
  private long b;
  private GraphQLAddress c;
  private List<String> d;
  private GraphQLFocusedPhoto e;
  private PageFriendsHereNow f;
  private GraphQLTextWithEntities g;
  private PageRecommendationList h;
  private List<GraphQLTimeRange> i;
  private boolean j;
  private GraphQLLocation k;
  private String l;
  private PageRecommendationList m;
  private double n;
  private GraphQLProfileList o;
  private GraphQLProfileList p;
  private GraphQLPhoneNumber q;
  private String r;
  private GraphQLImage s;
  private PageStarRatersList t;
  private PageFriendsWhoLike u;
  private PageFriendsWhoVisited v;
  private int w;
  private GraphQLTextWithEntities x;
  private PageViewerVisitsList y;

  public PageIdentityDataBuilder a(double paramDouble)
  {
    this.n = paramDouble;
    return this;
  }

  public PageIdentityDataBuilder a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }

  public PageIdentityDataBuilder a(GraphQLAddress paramGraphQLAddress)
  {
    this.c = paramGraphQLAddress;
    return this;
  }

  public PageIdentityDataBuilder a(GraphQLLocation paramGraphQLLocation)
  {
    this.k = paramGraphQLLocation;
    return this;
  }

  public PageIdentityDataBuilder a(PageStarRatersList paramPageStarRatersList)
  {
    this.t = paramPageStarRatersList;
    return this;
  }

  public PageIdentityDataBuilder a(String paramString)
  {
    this.l = paramString;
    return this;
  }

  public PageIdentityDataBuilder a(List<String> paramList)
  {
    this.d = paramList;
    return this;
  }

  public PageIdentityDataBuilder a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }

  public boolean a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public PageIdentityDataBuilder b(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }

  public GraphQLAddress c()
  {
    return this.c;
  }

  public List<String> d()
  {
    return this.d;
  }

  public GraphQLFocusedPhoto e()
  {
    return this.e;
  }

  public PageFriendsHereNow f()
  {
    return this.f;
  }

  public GraphQLTextWithEntities g()
  {
    return this.g;
  }

  public PageRecommendationList h()
  {
    return this.h;
  }

  public List<GraphQLTimeRange> i()
  {
    return this.i;
  }

  public boolean j()
  {
    return this.j;
  }

  public GraphQLLocation k()
  {
    return this.k;
  }

  public String l()
  {
    return this.l;
  }

  public PageRecommendationList m()
  {
    return this.m;
  }

  public double n()
  {
    return this.n;
  }

  public GraphQLProfileList o()
  {
    return this.o;
  }

  public GraphQLProfileList p()
  {
    return this.p;
  }

  public GraphQLPhoneNumber q()
  {
    return this.q;
  }

  public String r()
  {
    return this.r;
  }

  public GraphQLImage s()
  {
    return this.s;
  }

  public PageStarRatersList t()
  {
    return this.t;
  }

  public PageFriendsWhoLike u()
  {
    return this.u;
  }

  public PageFriendsWhoVisited v()
  {
    return this.v;
  }

  public GraphQLTextWithEntities w()
  {
    return this.x;
  }

  public int x()
  {
    return this.w;
  }

  public PageViewerVisitsList y()
  {
    return this.y;
  }

  public PageIdentityData z()
  {
    return new PageIdentityData(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.data.PageIdentityDataBuilder
 * JD-Core Version:    0.6.2
 */