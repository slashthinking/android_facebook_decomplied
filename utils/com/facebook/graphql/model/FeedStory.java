package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Spannable;
import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FeedStory extends FeedbackableGraphQLNode
  implements Parcelable, FeedUnit, OptimisticEntity, Postprocessable, Sponsorable
{
  public static final Parcelable.Creator<FeedStory> CREATOR = new FeedStory.1();

  @JsonIgnore
  public FeedStory a;

  @JsonProperty("action_links")
  public final List<GraphQLActionLink> actionLinks;

  @JsonProperty("actors")
  public final List<GraphQLProfile> actors;

  @JsonProperty("application")
  public final GraphQLApplication application;

  @JsonProperty("attached_action_links")
  public final List<GraphQLActionLink> attachedActionLinks;

  @JsonProperty("attached_story")
  public final FeedStory attachedStory;

  @JsonProperty("attachments")
  public final List<FeedStoryAttachment> attachments;

  @JsonIgnore
  public Set<String> b;

  @JsonIgnore
  private ArrayNode c;

  @JsonProperty("cache_id")
  public final String cacheId;

  @JsonProperty("can_viewer_delete")
  public final boolean canViewerDelete;

  @JsonProperty("creation_time")
  public final long creationTime;

  @JsonIgnore
  private GraphQLActionLink d;
  private FeedStory.PageStoryType e;

  @JsonProperty("explicit_place")
  public final GraphQLPlace explicitPlace;
  private Spannable f;
  private Spannable g;
  private Spannable h;
  private Spannable i;

  @JsonProperty("icon")
  public final GraphQLImage icon;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("implicit_place")
  public final GraphQLPlace implicitPlace;

  @JsonProperty("insights")
  public final GraphQLStoryInsights insights;
  private List<String> j;
  private boolean k;
  private long l = -1L;

  @JsonProperty("legacy_api_story_id")
  public final String legacyApiStoryId;
  private FeedStory.StoryFreshness m = FeedStory.StoryFreshness.NEW;

  @JsonProperty("message")
  public final GraphQLTextWithEntities message;

  @JsonProperty("privacy_scope")
  public final GraphQLPrivacyScope privacyScope;

  @JsonProperty("publish_state")
  FeedOptimisticPublishState publishState;

  @JsonProperty("report_info")
  public final ReportInfo reportInfo;

  @JsonProperty("secondary_actions")
  public final List<GraphQLActionLink> secondaryActions;

  @JsonProperty("seen_state")
  public final String seenState;

  @JsonProperty("shareable")
  public final Shareable shareable;

  @JsonProperty("sponsored_data")
  public final FeedStorySponsoredData sponsoredData;

  @JsonProperty("substories")
  public final List<FeedStory> substories;

  @JsonProperty("substory_count")
  private final int substoryCount;

  @JsonProperty("suffix")
  public final GraphQLTextWithEntities suffix;

  @JsonProperty("title")
  public final GraphQLTextWithEntities title;

  @JsonProperty("to")
  public final GraphQLProfile to;

  @JsonProperty("tracking")
  public final String tracking;

  @JsonProperty("__type__")
  public final GraphQLObjectType type;

  @JsonProperty("url")
  public final String url;

  @JsonProperty("via")
  public final GraphQLProfile via;

  @JsonProperty("with")
  public final List<GraphQLProfile> with;

  public FeedStory()
  {
    this.type = null;
    this.id = null;
    this.cacheId = null;
    this.creationTime = 0L;
    this.icon = null;
    this.title = null;
    this.message = null;
    this.seenState = null;
    this.suffix = null;
    this.url = null;
    this.actors = null;
    this.attachments = ImmutableList.d();
    this.privacyScope = null;
    this.actionLinks = ImmutableList.d();
    this.attachedActionLinks = ImmutableList.d();
    this.secondaryActions = ImmutableList.d();
    this.tracking = null;
    this.to = null;
    this.via = null;
    this.with = ImmutableList.d();
    this.application = null;
    this.implicitPlace = null;
    this.explicitPlace = null;
    this.attachedStory = null;
    this.substories = ImmutableList.d();
    this.substoryCount = 0;
    this.canViewerDelete = false;
    this.reportInfo = null;
    this.legacyApiStoryId = null;
    this.sponsoredData = null;
    this.insights = null;
    this.shareable = null;
    this.c = null;
    this.a = null;
    this.publishState = FeedOptimisticPublishState.NONE;
    this.e = FeedStory.PageStoryType.UNSET;
    this.b = Sets.a();
  }

  public FeedStory(Parcel paramParcel)
  {
    this.type = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.class.getClassLoader()));
    this.id = paramParcel.readString();
    this.cacheId = paramParcel.readString();
    this.creationTime = paramParcel.readLong();
    this.icon = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
    this.title = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.message = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.seenState = paramParcel.readString();
    this.suffix = ((GraphQLTextWithEntities)paramParcel.readParcelable(GraphQLTextWithEntities.class.getClassLoader()));
    this.url = paramParcel.readString();
    this.actors = Lists.a();
    paramParcel.readTypedList(this.actors, GraphQLProfile.CREATOR);
    this.attachments = Lists.a();
    this.actionLinks = Lists.a();
    paramParcel.readTypedList(this.actionLinks, GraphQLActionLink.CREATOR);
    this.attachedActionLinks = Lists.a();
    paramParcel.readTypedList(this.attachedActionLinks, GraphQLActionLink.CREATOR);
    this.secondaryActions = Lists.a();
    paramParcel.readTypedList(this.secondaryActions, GraphQLActionLink.CREATOR);
    this.tracking = paramParcel.readString();
    this.privacyScope = ((GraphQLPrivacyScope)paramParcel.readParcelable(GraphQLPrivacyScope.class.getClassLoader()));
    this.to = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.via = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.with = Lists.a();
    paramParcel.readTypedList(this.with, GraphQLProfile.CREATOR);
    this.application = ((GraphQLApplication)paramParcel.readParcelable(GraphQLApplication.class.getClassLoader()));
    this.implicitPlace = ((GraphQLPlace)paramParcel.readParcelable(GraphQLPlace.class.getClassLoader()));
    this.explicitPlace = ((GraphQLPlace)paramParcel.readParcelable(GraphQLPlace.class.getClassLoader()));
    this.sponsoredData = ((FeedStorySponsoredData)paramParcel.readParcelable(FeedStorySponsoredData.class.getClassLoader()));
    this.insights = ((GraphQLStoryInsights)paramParcel.readParcelable(GraphQLStoryInsights.class.getClassLoader()));
    this.attachedStory = ((FeedStory)paramParcel.readParcelable(FeedStory.class.getClassLoader()));
    this.substories = Lists.a();
    paramParcel.readTypedList(this.substories, CREATOR);
    this.substoryCount = paramParcel.readInt();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.canViewerDelete = bool;
      this.reportInfo = ((ReportInfo)paramParcel.readParcelable(ReportInfo.class.getClassLoader()));
      this.legacyApiStoryId = paramParcel.readString();
      this.shareable = ((Shareable)paramParcel.readParcelable(Shareable.class.getClassLoader()));
      return;
    }
  }

  public FeedStory(FeedStoryBuilder paramFeedStoryBuilder)
  {
    super(paramFeedStoryBuilder.R());
    this.type = paramFeedStoryBuilder.f();
    this.id = paramFeedStoryBuilder.J();
    this.cacheId = paramFeedStoryBuilder.g();
    this.creationTime = paramFeedStoryBuilder.a();
    this.icon = paramFeedStoryBuilder.h();
    this.title = paramFeedStoryBuilder.i();
    this.message = paramFeedStoryBuilder.b();
    this.seenState = paramFeedStoryBuilder.j();
    this.suffix = paramFeedStoryBuilder.k();
    this.url = paramFeedStoryBuilder.l();
    this.actors = paramFeedStoryBuilder.c();
    this.attachments = paramFeedStoryBuilder.m();
    this.actionLinks = paramFeedStoryBuilder.p();
    this.attachedActionLinks = paramFeedStoryBuilder.q();
    this.secondaryActions = paramFeedStoryBuilder.r();
    this.tracking = paramFeedStoryBuilder.n();
    this.privacyScope = paramFeedStoryBuilder.o();
    this.to = paramFeedStoryBuilder.s();
    this.via = paramFeedStoryBuilder.t();
    this.with = paramFeedStoryBuilder.d();
    this.application = paramFeedStoryBuilder.u();
    this.implicitPlace = paramFeedStoryBuilder.v();
    this.explicitPlace = paramFeedStoryBuilder.e();
    this.sponsoredData = paramFeedStoryBuilder.w();
    this.insights = paramFeedStoryBuilder.F();
    this.attachedStory = paramFeedStoryBuilder.H();
    this.substories = paramFeedStoryBuilder.x();
    this.substoryCount = paramFeedStoryBuilder.y();
    this.canViewerDelete = paramFeedStoryBuilder.z();
    this.reportInfo = paramFeedStoryBuilder.A();
    this.legacyApiStoryId = paramFeedStoryBuilder.B();
    this.shareable = paramFeedStoryBuilder.T();
    this.c = paramFeedStoryBuilder.C();
    this.e = paramFeedStoryBuilder.K();
    this.a = paramFeedStoryBuilder.D();
    this.d = paramFeedStoryBuilder.L();
    this.b = paramFeedStoryBuilder.E();
    this.f = paramFeedStoryBuilder.M();
    this.g = paramFeedStoryBuilder.N();
    this.h = paramFeedStoryBuilder.O();
    this.i = paramFeedStoryBuilder.P();
    this.publishState = paramFeedStoryBuilder.S();
    this.k = paramFeedStoryBuilder.Q();
    setFetchTimeMs(paramFeedStoryBuilder.I());
    a(paramFeedStoryBuilder.D());
  }

  private void T()
  {
    if ((this.j != null) || (this.a != null));
    while (true)
    {
      return;
      this.j = Lists.a();
      if (this.sponsoredData != null)
        this.sponsoredData.a(this.j);
      if ((this.attachedStory != null) && (this.attachedStory.sponsoredData != null))
        this.sponsoredData.a(this.j);
      if (F())
      {
        Iterator localIterator = this.substories.iterator();
        while (localIterator.hasNext())
        {
          FeedStory localFeedStory = (FeedStory)localIterator.next();
          if (localFeedStory.sponsoredData != null)
            localFeedStory.sponsoredData.a(this.j);
        }
      }
    }
  }

  private void U()
  {
    if (this.e != FeedStory.PageStoryType.UNSET);
    while (true)
    {
      return;
      this.d = X();
      if (this.d != null)
      {
        GraphQLObjectType.ObjectType localObjectType = this.d.type.a();
        if (GraphQLObjectType.ObjectType.LikePageActionLink.equals(localObjectType))
          this.e = FeedStory.PageStoryType.PAGE_LIKE;
        else if (GraphQLObjectType.ObjectType.GetCouponActionLink.equals(localObjectType))
          this.e = FeedStory.PageStoryType.OFFER;
      }
      else
      {
        this.d = V();
        if (((this.d != null) && (GraphQLObjectType.ObjectType.LikePageActionLink.equals(this.d.type.a()))) || ((this.sponsoredData != null) && (this.sponsoredData.a())))
        {
          this.e = FeedStory.PageStoryType.NCPP;
        }
        else
        {
          this.d = W();
          if ((this.d != null) && (GraphQLObjectType.ObjectType.LikePageActionLink.equals(this.d.type.a())))
          {
            this.e = FeedStory.PageStoryType.GROUPER;
            if (this.attachedStory != null)
              if (FeedStory.PageStoryType.OFFER.equals(this.attachedStory.A()))
              {
                this.e = FeedStory.PageStoryType.GROUPER_WITH_OFFER;
                this.d = null;
              }
              else
              {
                this.attachedStory.a(FeedStory.PageStoryType.GROUPER_ATTACHED_STORY);
              }
          }
          else
          {
            this.e = FeedStory.PageStoryType.OTHER;
          }
        }
      }
    }
  }

  @JsonIgnore
  private GraphQLActionLink V()
  {
    return a(this.actionLinks);
  }

  @JsonIgnore
  private GraphQLActionLink W()
  {
    return a(this.attachedActionLinks);
  }

  @JsonIgnore
  private GraphQLActionLink X()
  {
    if (e() != null);
    for (GraphQLActionLink localGraphQLActionLink = a(e().actionLinks); ; localGraphQLActionLink = null)
      return localGraphQLActionLink;
  }

  private boolean Y()
  {
    GraphQLProfile localGraphQLProfile = a();
    if ((localGraphQLProfile != null) && (localGraphQLProfile.objectType.a().equals(GraphQLObjectType.ObjectType.Page)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  private FeedStory Z()
  {
    while (this.a != null)
      this = this.a;
    return this;
  }

  private GraphQLActionLink a(List<GraphQLActionLink> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()));
    for (GraphQLActionLink localGraphQLActionLink = (GraphQLActionLink)paramList.get(0); ; localGraphQLActionLink = null)
      return localGraphQLActionLink;
  }

  private void aa()
  {
    if (d())
    {
      Iterator localIterator2 = this.attachments.iterator();
      while (localIterator2.hasNext())
        ((FeedStoryAttachment)localIterator2.next()).a();
    }
    if (this.attachedStory != null)
      this.attachedStory.aa();
    if (this.substories != null)
    {
      Iterator localIterator1 = this.substories.iterator();
      while (localIterator1.hasNext())
        ((FeedStory)localIterator1.next()).aa();
    }
  }

  private void ab()
  {
    if (this.c == null)
    {
      this.c = new ArrayNode(JsonNodeFactory.instance);
      for (FeedStory localFeedStory = this; localFeedStory != null; localFeedStory = localFeedStory.a)
        if (localFeedStory.tracking != null)
          this.c.add(localFeedStory.tracking);
    }
  }

  private FeedStoryAttachment b(List<FeedStoryAttachment> paramList)
  {
    FeedStoryAttachment localFeedStoryAttachment;
    if ((paramList == null) || (paramList.isEmpty()))
      localFeedStoryAttachment = null;
    while (true)
    {
      return localFeedStoryAttachment;
      Iterator localIterator = paramList.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          localFeedStoryAttachment = (FeedStoryAttachment)localIterator.next();
          GraphQLMedia localGraphQLMedia = localFeedStoryAttachment.media;
          FeedStoryAttachmentTarget localFeedStoryAttachmentTarget = localFeedStoryAttachment.target;
          if ((localGraphQLMedia != null) && (this.shareable.id.equals(localGraphQLMedia.id)))
            break;
          if ((localFeedStoryAttachment.target != null) && (this.shareable.id.equals(localFeedStoryAttachmentTarget.id)))
            break;
        }
      localFeedStoryAttachment = null;
    }
  }

  @JsonIgnore
  public FeedStory.PageStoryType A()
  {
    U();
    return this.e;
  }

  public boolean B()
  {
    boolean bool1 = true;
    U();
    boolean bool2;
    if (this.sponsoredData == null)
    {
      if (this.a != null)
      {
        FeedStorySponsoredData localFeedStorySponsoredData = this.a.sponsoredData;
        bool2 = false;
        if (localFeedStorySponsoredData != null);
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
    }
    if ((this.e != FeedStory.PageStoryType.NCPP) && (this.e != FeedStory.PageStoryType.GROUPER) && (!Y()));
    while (true)
    {
      bool2 = bool1;
      break;
      bool1 = false;
    }
  }

  public boolean C()
  {
    boolean bool1 = true;
    boolean bool3;
    if (this.a == null)
      if ((this.sponsoredData != null) && (!w()))
        bool3 = bool1;
    while (true)
    {
      return bool3;
      bool1 = false;
      break;
      boolean bool2 = this.a.C();
      bool3 = false;
      if (!bool2)
        if ((this.sponsoredData == null) || (w()))
        {
          FeedStorySponsoredData localFeedStorySponsoredData = this.a.sponsoredData;
          bool3 = false;
          if (localFeedStorySponsoredData == null);
        }
        else
        {
          bool3 = bool1;
        }
    }
  }

  public boolean D()
  {
    return S().doesViewerLike;
  }

  public boolean E()
  {
    if (d())
    {
      Iterator localIterator = this.attachments.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (!((FeedStoryAttachment)localIterator.next()).g());
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean F()
  {
    if ((this.substories != null) && (!this.substories.isEmpty()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public void G()
  {
    Z().b.clear();
  }

  @JsonIgnore
  public Spannable H()
  {
    return this.f;
  }

  @JsonIgnore
  public Spannable I()
  {
    return this.g;
  }

  @JsonIgnore
  public Spannable J()
  {
    return this.h;
  }

  @JsonIgnore
  public Spannable K()
  {
    return this.i;
  }

  @JsonIgnore
  public FeedStory.StoryFreshness L()
  {
    return this.m;
  }

  @JsonIgnore
  public boolean M()
  {
    if ((this.shareable != null) && (this.shareable.a()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public FeedStoryAttachment N()
  {
    FeedStoryAttachment localFeedStoryAttachment;
    if ((this.shareable == null) || (StringUtil.a(this.shareable.id)))
      localFeedStoryAttachment = null;
    while (true)
    {
      return localFeedStoryAttachment;
      localFeedStoryAttachment = b(this.attachments);
      if (localFeedStoryAttachment == null)
        if (this.attachedStory != null)
          localFeedStoryAttachment = b(this.attachedStory.attachments);
        else
          localFeedStoryAttachment = null;
    }
  }

  @JsonIgnore
  public boolean O()
  {
    if ((E()) && (this.attachments != null) && (this.attachments.size() >= 1) && (((FeedStoryAttachment)this.attachments.get(0)).l()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public boolean P()
  {
    if (this.publishState == FeedOptimisticPublishState.POSTING);
    for (boolean bool = true; ; bool = super.P())
      return bool;
  }

  @JsonIgnore
  public FeedStory a(String paramString)
  {
    if ((this.cacheId != null) && (Objects.equal(this.cacheId, paramString)));
    while (true)
    {
      return this;
      if (this.attachedStory != null)
      {
        FeedStory localFeedStory = this.attachedStory.a(paramString);
        if (localFeedStory != null)
          this = localFeedStory;
      }
      else
      {
        if (this.substories != null)
        {
          Iterator localIterator = this.substories.iterator();
          while (true)
            if (localIterator.hasNext())
            {
              this = ((FeedStory)localIterator.next()).a(paramString);
              if (this != null)
                break;
            }
        }
        this = null;
      }
    }
  }

  @JsonIgnore
  public GraphQLProfile a()
  {
    if ((this.actors != null) && (this.actors.size() > 0));
    for (GraphQLProfile localGraphQLProfile = (GraphQLProfile)this.actors.get(0); ; localGraphQLProfile = null)
      return localGraphQLProfile;
  }

  @JsonIgnore
  public void a(Spannable paramSpannable)
  {
    this.f = paramSpannable;
  }

  @JsonIgnore
  public void a(FeedOptimisticPublishState paramFeedOptimisticPublishState)
  {
    this.publishState = paramFeedOptimisticPublishState;
  }

  public void a(FeedStory.PageStoryType paramPageStoryType)
  {
    this.e = paramPageStoryType;
  }

  @JsonIgnore
  public void a(FeedStory.StoryFreshness paramStoryFreshness)
  {
    this.m = paramStoryFreshness;
  }

  @JsonIgnore
  public void a(FeedStory paramFeedStory)
  {
    this.a = paramFeedStory;
    if (this.substories != null)
    {
      Iterator localIterator3 = this.substories.iterator();
      while (localIterator3.hasNext())
        ((FeedStory)localIterator3.next()).a(this);
    }
    if (this.attachedStory != null)
      this.attachedStory.a(this);
    if (this.attachments != null)
    {
      Iterator localIterator2 = this.attachments.iterator();
      while (localIterator2.hasNext())
        ((FeedStoryAttachment)localIterator2.next()).a(this);
    }
    if (this.attachments != null)
    {
      Iterator localIterator1 = this.attachments.iterator();
      while (localIterator1.hasNext())
      {
        FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)localIterator1.next();
        if (localFeedStoryAttachment.media != null)
          localFeedStoryAttachment.media.a = this;
      }
    }
  }

  @JsonIgnore
  public boolean a(FeedStoryAttachment paramFeedStoryAttachment)
  {
    String str = paramFeedStoryAttachment.i();
    if ((!str.equals("unknown_attachment")) && (Z().b.contains(str)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public void b(Spannable paramSpannable)
  {
    this.g = paramSpannable;
  }

  @JsonIgnore
  public void b(FeedStoryAttachment paramFeedStoryAttachment)
  {
    Z().b.add(paramFeedStoryAttachment.i());
  }

  @JsonIgnore
  public boolean b()
  {
    if (this.publishState == FeedOptimisticPublishState.POSTING);
    for (boolean bool = true; ; bool = super.b())
      return bool;
  }

  @JsonIgnore
  public FeedOptimisticPublishState c()
  {
    return this.publishState;
  }

  @JsonIgnore
  public void c(Spannable paramSpannable)
  {
    this.h = paramSpannable;
  }

  @JsonIgnore
  public void d(Spannable paramSpannable)
  {
    this.i = paramSpannable;
  }

  public boolean d()
  {
    if ((this.attachments != null) && (!this.attachments.isEmpty()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int describeContents()
  {
    return 0;
  }

  @JsonIgnore
  public FeedStoryAttachment e()
  {
    if ((this.attachments != null) && (!this.attachments.isEmpty()));
    for (FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)this.attachments.get(0); ; localFeedStoryAttachment = null)
      return localFeedStoryAttachment;
  }

  @JsonIgnore
  public GraphQLActionLink f()
  {
    U();
    return this.d;
  }

  public boolean g()
  {
    boolean bool = true;
    GraphQLProfile localGraphQLProfile = a();
    if ((localGraphQLProfile == null) || (localGraphQLProfile.profilePicture == null))
      bool = false;
    while (true)
    {
      return bool;
      if ((S() == null) && (this.message == null))
        if (this.attachedStory != null)
          bool = false;
        else if ((this.substories != null) && (!this.substories.isEmpty()))
          bool = false;
        else if (h())
          bool = false;
    }
  }

  public String getCacheId()
  {
    return this.cacheId;
  }

  public long getFetchTimeMs()
  {
    return this.l;
  }

  public GraphQLObjectType getType()
  {
    return new GraphQLObjectType(GraphQLObjectType.ObjectType.Story);
  }

  @JsonIgnore
  public boolean h()
  {
    FeedStoryAttachment localFeedStoryAttachment = e();
    if ((localFeedStoryAttachment != null) && (localFeedStoryAttachment.f()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public boolean i()
  {
    boolean bool;
    if ((this.actionLinks != null) && (this.actionLinks.size() > 0))
      if (((GraphQLActionLink)this.actionLinks.get(0)).type.a() == GraphQLObjectType.ObjectType.FindFriendsActionLink)
        bool = true;
    while (true)
    {
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }

  @JsonIgnore
  public int j()
  {
    if (this.substories == null);
    for (int n = 0; ; n = this.substoryCount)
      return n;
  }

  @JsonIgnore
  public ArrayNode k()
  {
    ab();
    return this.c;
  }

  @JsonIgnore
  public int l()
  {
    if ((S() == null) || (S().likers == null));
    for (int n = 0; ; n = S().likers.count)
      return n;
  }

  @JsonIgnore
  public int m()
  {
    if ((S() == null) || (S().comments == null));
    for (int n = 0; ; n = S().b())
      return n;
  }

  public boolean n()
  {
    boolean bool1 = R();
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = FeedStory.PageStoryType.OFFER.equals(A());
      bool2 = false;
      if (!bool3)
        break label30;
    }
    while (true)
    {
      return bool2;
      label30: for (FeedStory localFeedStory = this.a; ; localFeedStory = localFeedStory.a)
      {
        if (localFeedStory == null)
          break label65;
        boolean bool4 = localFeedStory.R();
        bool2 = false;
        if (bool4)
          break;
      }
      label65: bool2 = true;
    }
  }

  public boolean o()
  {
    if ((this.insights != null) && (this.insights.totalReach > 0L));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void p()
  {
    a(null);
    aa();
    ab();
    U();
    T();
  }

  public boolean q()
  {
    if ((this.explicitPlace != null) && (this.explicitPlace.location != null) && (this.explicitPlace.location.b()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  @JsonIgnore
  public List<GraphQLProfile> r()
  {
    Object localObject;
    if ((this.with == null) || (this.with.size() == 0))
      localObject = null;
    while (true)
    {
      return localObject;
      localObject = Lists.a(this.with);
      ((List)localObject).add(0, a());
    }
  }

  @JsonIgnore
  public int s()
  {
    int n = 0;
    for (FeedStory localFeedStory = this.a; localFeedStory != null; localFeedStory = localFeedStory.a)
      n++;
    return n;
  }

  public void setFetchTimeMs(long paramLong)
  {
    this.l = paramLong;
    if (S() != null)
      S().setFetchTimeMs(paramLong);
    if (this.attachedStory != null)
      this.attachedStory.setFetchTimeMs(paramLong);
    if (this.substories != null)
    {
      Iterator localIterator = this.substories.iterator();
      while (localIterator.hasNext())
        ((FeedStory)localIterator.next()).setFetchTimeMs(paramLong);
    }
  }

  @JsonIgnore
  public int t()
  {
    if ((this.a != null) && (((this.a.substories != null) && (this.a.substories.contains(this))) || (this.a.w())));
    for (int n = this.a.t(); ; n = s())
      return n;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(this.id);
    localStringBuilder.append(',');
    if (this.title != null)
    {
      localStringBuilder.append(this.title.text);
      localStringBuilder.append(',');
    }
    if ((this.actors != null) && (this.actors.size() > 0))
    {
      localStringBuilder.append(((GraphQLProfile)this.actors.get(0)).name);
      localStringBuilder.append(',');
      localStringBuilder.append("ProfilePics: [");
      Iterator localIterator = this.actors.iterator();
      while (localIterator.hasNext())
      {
        GraphQLProfile localGraphQLProfile = (GraphQLProfile)localIterator.next();
        if (localGraphQLProfile.profilePicture != null)
        {
          localStringBuilder.append(localGraphQLProfile.profilePicture.uri);
          localStringBuilder.append("|");
        }
      }
      localStringBuilder.append("]");
    }
    if (this.message != null)
      localStringBuilder.append(this.message.text);
    while (true)
    {
      localStringBuilder.append(',');
      localStringBuilder.append(this.creationTime);
      if ((this.attachments != null) && (this.attachments.size() > 0))
      {
        localStringBuilder.append("attachment 0:");
        localStringBuilder.append(((FeedStoryAttachment)this.attachments.get(0)).title);
      }
      if (this.shareable != null)
      {
        localStringBuilder.append(", shareable: { id: ").append(this.shareable.id);
        localStringBuilder.append(", __type__: ").append(this.shareable.type);
        localStringBuilder.append("}");
      }
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      localStringBuilder.append("NULL");
    }
  }

  @JsonIgnore
  public int u()
  {
    int n = 0;
    int i1;
    int i2;
    label28: int i3;
    if (this.attachedStory != null)
    {
      i1 = 1 + this.attachedStory.u();
      if (!F())
        break label81;
      i2 = i1;
      if (n >= this.substories.size())
        break label83;
      i3 = 1 + ((FeedStory)this.substories.get(n)).u();
      if (i2 >= i3)
        break label85;
    }
    while (true)
    {
      n++;
      i2 = i3;
      break label28;
      i1 = 0;
      break;
      label81: i2 = i1;
      label83: return i2;
      label85: i3 = i2;
    }
  }

  @JsonIgnore
  public GraphQLActionLink v()
  {
    GraphQLActionLink localGraphQLActionLink;
    if (this.secondaryActions != null)
    {
      Iterator localIterator = this.secondaryActions.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localGraphQLActionLink = (GraphQLActionLink)localIterator.next();
      }
      while ((localGraphQLActionLink.type == null) || (!localGraphQLActionLink.type.a().equals(GraphQLObjectType.ObjectType.ReportActionLink)));
    }
    while (true)
    {
      return localGraphQLActionLink;
      localGraphQLActionLink = null;
    }
  }

  @JsonIgnore
  public boolean w()
  {
    if ((this.attachedStory != null) && (!F()) && (!n()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.type, paramInt);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.cacheId);
    paramParcel.writeLong(this.creationTime);
    paramParcel.writeParcelable(this.icon, paramInt);
    paramParcel.writeParcelable(this.title, paramInt);
    paramParcel.writeParcelable(this.message, paramInt);
    paramParcel.writeString(this.seenState);
    paramParcel.writeParcelable(this.suffix, paramInt);
    paramParcel.writeString(this.url);
    paramParcel.writeTypedList(this.actors);
    paramParcel.writeTypedList(this.actionLinks);
    paramParcel.writeTypedList(this.attachedActionLinks);
    paramParcel.writeTypedList(this.secondaryActions);
    paramParcel.writeString(this.tracking);
    paramParcel.writeParcelable(this.privacyScope, paramInt);
    paramParcel.writeParcelable(this.to, paramInt);
    paramParcel.writeParcelable(this.via, paramInt);
    paramParcel.writeTypedList(this.with);
    paramParcel.writeParcelable(this.application, paramInt);
    paramParcel.writeParcelable(this.implicitPlace, paramInt);
    paramParcel.writeParcelable(this.explicitPlace, paramInt);
    paramParcel.writeParcelable(this.sponsoredData, paramInt);
    paramParcel.writeParcelable(this.insights, paramInt);
    paramParcel.writeParcelable(this.attachedStory, paramInt);
    paramParcel.writeTypedList(this.substories);
    paramParcel.writeInt(this.substoryCount);
    if (this.canViewerDelete);
    for (int n = 1; ; n = 0)
    {
      paramParcel.writeByte((byte)n);
      paramParcel.writeParcelable(this.reportInfo, paramInt);
      paramParcel.writeString(this.legacyApiStoryId);
      paramParcel.writeParcelable(this.shareable, paramInt);
      return;
    }
  }

  @JsonIgnore
  public List<String> x()
  {
    T();
    return this.j;
  }

  public void y()
  {
    this.k = true;
  }

  @JsonIgnore
  public boolean z()
  {
    return this.k;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStory
 * JD-Core Version:    0.6.2
 */