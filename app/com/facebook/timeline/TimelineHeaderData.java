package com.facebook.timeline;

import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLPhoneNumber;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTimeRange;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.graphql.model.TimelineAppSectionList;
import com.facebook.graphql.model.TimelineBylineFragment;
import com.facebook.timeline.permissions.ProfilePermissions;
import com.facebook.timeline.permissions.ProfilePermissions.Permission;
import java.util.List;

public class TimelineHeaderData
{
  private int A;
  private List<TimelineBylineFragment> B;
  private TimelineHeaderFriendListData C;
  private boolean D;
  private ProfilePermissions E;
  private GraphQLTextWithEntities F;
  private boolean G;
  private List<String> H;
  private GraphQLPhoneNumber I;
  private String J;
  private String K;
  private List<GraphQLTimeRange> L;
  private GraphQLLocation M;
  private GraphQLAddress N;
  private String O;
  private TimelineHeaderData.InitializeState P = TimelineHeaderData.InitializeState.UNINITIALIZED;
  private long a;
  private long b;
  private int c;
  private GraphQLObjectType d;
  private String e;
  private String f;
  private TimelineHeaderData.Gender g;
  private GraphQLMedia h;
  private GraphQLImage i;
  private GraphQLFocusedPhoto j;
  private TimelineAppSectionList k;
  private String l;
  private GraphQLEntity m;
  private TimelineHeaderData.UserFriendshipStatus n = null;
  private TimelineHeaderData.SubscribeStatus o = null;
  private GraphQLProfileList p;
  private GraphQLProfileList q;
  private GraphQLProfileList r;
  private int s;
  private GraphQLFocusedPhoto t;
  private boolean u;
  private boolean v;
  private boolean w;
  private int x;
  private int y;
  private int z;

  public TimelineHeaderData(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.C = new TimelineHeaderFriendListData();
    this.c = 1;
  }

  public static TimelineHeaderData.SubscribeStatus a(String paramString)
  {
    Object localObject;
    if (paramString == null)
      localObject = TimelineHeaderData.SubscribeStatus.CANNOT_SUBSCRIBE;
    while (true)
    {
      return localObject;
      try
      {
        TimelineHeaderData.SubscribeStatus localSubscribeStatus = TimelineHeaderData.SubscribeStatus.valueOf(paramString);
        localObject = localSubscribeStatus;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = TimelineHeaderData.SubscribeStatus.CANNOT_SUBSCRIBE;
      }
    }
  }

  public static TimelineHeaderData.UserFriendshipStatus b(String paramString)
  {
    Object localObject;
    if (paramString == null)
      localObject = TimelineHeaderData.UserFriendshipStatus.CANNOT_REQUEST;
    while (true)
    {
      return localObject;
      try
      {
        TimelineHeaderData.UserFriendshipStatus localUserFriendshipStatus = TimelineHeaderData.UserFriendshipStatus.valueOf(paramString);
        localObject = localUserFriendshipStatus;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = TimelineHeaderData.UserFriendshipStatus.CANNOT_REQUEST;
      }
    }
  }

  public static TimelineHeaderData.Gender c(String paramString)
  {
    Object localObject;
    if (paramString == null)
      localObject = TimelineHeaderData.Gender.UNKNOWN;
    while (true)
    {
      return localObject;
      try
      {
        TimelineHeaderData.Gender localGender = TimelineHeaderData.Gender.valueOf(paramString);
        localObject = localGender;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = TimelineHeaderData.Gender.UNKNOWN;
      }
    }
  }

  public GraphQLFocusedPhoto A()
  {
    return this.t;
  }

  public TimelineHeaderFriendListData B()
  {
    return this.C;
  }

  public int C()
  {
    return this.x;
  }

  public int D()
  {
    return this.y;
  }

  public int E()
  {
    return this.z;
  }

  public int F()
  {
    return this.A;
  }

  public GraphQLObjectType.ObjectType G()
  {
    return this.d.a();
  }

  public boolean H()
  {
    return this.D;
  }

  public ProfilePermissions I()
  {
    return this.E;
  }

  public GraphQLTextWithEntities J()
  {
    return this.F;
  }

  public boolean K()
  {
    return this.G;
  }

  public String L()
  {
    return this.O;
  }

  public List<String> M()
  {
    return this.H;
  }

  public GraphQLPhoneNumber N()
  {
    return this.I;
  }

  public String O()
  {
    return this.K;
  }

  public GraphQLLocation P()
  {
    return this.M;
  }

  public GraphQLAddress Q()
  {
    return this.N;
  }

  public List<GraphQLTimeRange> R()
  {
    return this.L;
  }

  public TimelineHeaderData.InitializeState a()
  {
    return this.P;
  }

  public void a(int paramInt)
  {
    this.x = paramInt;
    this.c = (1 + this.c);
  }

  public void a(GraphQueryResultEntry paramGraphQueryResultEntry)
  {
    this.d = paramGraphQueryResultEntry.__type__;
    this.e = paramGraphQueryResultEntry.name;
    this.f = paramGraphQueryResultEntry.alternateName;
    if (paramGraphQueryResultEntry.gender != null)
      this.g = c(paramGraphQueryResultEntry.gender);
    this.i = paramGraphQueryResultEntry.profilePicture;
    this.h = paramGraphQueryResultEntry.profilePhoto;
    this.j = paramGraphQueryResultEntry.coverPhoto;
    this.k = paramGraphQueryResultEntry.timelineAppSections;
    this.u = paramGraphQueryResultEntry.canMessage;
    this.v = paramGraphQueryResultEntry.canViewerPost;
    this.w = paramGraphQueryResultEntry.canViewerSendGift;
    this.l = paramGraphQueryResultEntry.birthday;
    this.m = paramGraphQueryResultEntry.currentCity;
    this.B = paramGraphQueryResultEntry.bylines;
    if (paramGraphQueryResultEntry.friendshipStatus != null)
      this.n = b(paramGraphQueryResultEntry.friendshipStatus);
    if (paramGraphQueryResultEntry.subscribeStatus != null)
      this.o = a(paramGraphQueryResultEntry.subscribeStatus);
    this.p = paramGraphQueryResultEntry.featuredFriends;
    this.q = paramGraphQueryResultEntry.likedProfiles;
    this.r = paramGraphQueryResultEntry.subscriptions;
    this.t = paramGraphQueryResultEntry.recentPhoto;
    if (paramGraphQueryResultEntry.subscribers != null);
    for (int i1 = paramGraphQueryResultEntry.subscribers.count; ; i1 = 0)
    {
      this.s = i1;
      if (paramGraphQueryResultEntry.pageLikers != null)
        this.y = paramGraphQueryResultEntry.pageLikers.count;
      if (paramGraphQueryResultEntry.pageVisits != null)
        this.z = paramGraphQueryResultEntry.pageVisits.count;
      if (paramGraphQueryResultEntry.peopleTalkingAbout != null)
        this.A = paramGraphQueryResultEntry.peopleTalkingAbout.count;
      this.F = paramGraphQueryResultEntry.about;
      this.G = paramGraphQueryResultEntry.canViewerPostPhoto;
      this.H = paramGraphQueryResultEntry.categoryNames;
      this.I = paramGraphQueryResultEntry.phoneNumber;
      this.J = paramGraphQueryResultEntry.placeType;
      this.K = paramGraphQueryResultEntry.priceRangeDescription;
      this.D = paramGraphQueryResultEntry.viewerActsAsProfile;
      if (paramGraphQueryResultEntry.viewerProfilePermissions != null)
        this.E = new ProfilePermissions(paramGraphQueryResultEntry.viewerProfilePermissions);
      this.M = paramGraphQueryResultEntry.location;
      if (paramGraphQueryResultEntry.address != null)
        this.N = paramGraphQueryResultEntry.address;
      if ((paramGraphQueryResultEntry.hours != null) && (paramGraphQueryResultEntry.hours.size() > 0))
        this.L = paramGraphQueryResultEntry.hours;
      this.O = paramGraphQueryResultEntry.superCategoryType;
      this.P = TimelineHeaderData.InitializeState.FINAL_DATA;
      this.c = (1 + this.c);
      return;
    }
  }

  public void a(TimelineHeaderData.SubscribeStatus paramSubscribeStatus)
  {
    this.o = paramSubscribeStatus;
  }

  public void a(TimelineHeaderData.UserFriendshipStatus paramUserFriendshipStatus)
  {
    this.n = paramUserFriendshipStatus;
  }

  public void a(String paramString, GraphQLImage paramGraphQLImage, GraphQLObjectType paramGraphQLObjectType)
  {
    this.e = paramString;
    this.i = paramGraphQLImage;
    this.d = paramGraphQLObjectType;
    this.P = TimelineHeaderData.InitializeState.PRELIM_DATA;
    this.c = (1 + this.c);
  }

  public int b()
  {
    return this.c;
  }

  public long c()
  {
    return this.a;
  }

  public long d()
  {
    return this.b;
  }

  public GraphQLObjectType.ObjectType e()
  {
    if (this.d == null);
    for (GraphQLObjectType.ObjectType localObjectType = GraphQLObjectType.ObjectType.Invalid; ; localObjectType = this.d.a())
      return localObjectType;
  }

  public boolean f()
  {
    if (this.b == this.a);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean g()
  {
    if (e() == GraphQLObjectType.ObjectType.Page);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public GraphQLMedia h()
  {
    return this.h;
  }

  public GraphQLImage i()
  {
    return this.i;
  }

  public String j()
  {
    return this.e;
  }

  public String k()
  {
    return this.f;
  }

  public TimelineHeaderData.Gender l()
  {
    return this.g;
  }

  public GraphQLFocusedPhoto m()
  {
    return this.j;
  }

  public TimelineAppSectionList n()
  {
    return this.k;
  }

  public boolean o()
  {
    return this.u;
  }

  public boolean p()
  {
    return this.v;
  }

  public boolean q()
  {
    return this.w;
  }

  public boolean r()
  {
    boolean bool;
    if (e() == GraphQLObjectType.ObjectType.Page)
      if ((H()) && (I().a(ProfilePermissions.Permission.MODERATE_CONTENT)))
        bool = true;
    while (true)
    {
      return bool;
      bool = false;
      continue;
      bool = f();
    }
  }

  public boolean s()
  {
    if (this.P != TimelineHeaderData.InitializeState.FINAL_DATA);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public List<TimelineBylineFragment> t()
  {
    return this.B;
  }

  public TimelineHeaderData.UserFriendshipStatus u()
  {
    return this.n;
  }

  public TimelineHeaderData.SubscribeStatus v()
  {
    return this.o;
  }

  public GraphQLProfileList w()
  {
    return this.p;
  }

  public GraphQLProfileList x()
  {
    return this.q;
  }

  public GraphQLProfileList y()
  {
    return this.r;
  }

  public int z()
  {
    return this.s;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderData
 * JD-Core Version:    0.6.0
 */