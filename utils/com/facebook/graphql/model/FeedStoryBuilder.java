package com.facebook.graphql.model;

import android.text.Spannable;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FeedStoryBuilder
{
  private List<FeedStory> A = Collections.emptyList();
  private int B;
  private boolean C;
  private ReportInfo D;
  private String E;
  private Shareable F;
  private ArrayNode G;
  private FeedStory.PageStoryType H = FeedStory.PageStoryType.UNSET;
  private FeedStory I;
  private GraphQLActionLink J;
  private Set<String> K = Sets.a();
  private Spannable L;
  private Spannable M;
  private Spannable N;
  private Spannable O;
  private boolean P = false;
  private long Q = -1L;
  private Feedback R;
  private FeedOptimisticPublishState S = FeedOptimisticPublishState.NONE;
  private GraphQLObjectType a;
  private String b;
  private String c;
  private long d;
  private GraphQLImage e;
  private GraphQLTextWithEntities f;
  private GraphQLTextWithEntities g;
  private String h;
  private GraphQLTextWithEntities i;
  private String j;
  private List<GraphQLProfile> k = Collections.emptyList();
  private List<FeedStoryAttachment> l = Collections.emptyList();
  private List<GraphQLActionLink> m = Collections.emptyList();
  private List<GraphQLActionLink> n = Collections.emptyList();
  private List<GraphQLActionLink> o = Collections.emptyList();
  private String p;
  private GraphQLPrivacyScope q;
  private GraphQLProfile r;
  private GraphQLProfile s;
  private List<GraphQLProfile> t = Collections.emptyList();
  private GraphQLApplication u;
  private GraphQLPlace v;
  private GraphQLPlace w;
  private FeedStorySponsoredData x;
  private GraphQLStoryInsights y;
  private FeedStory z;

  public FeedStoryBuilder()
  {
  }

  public FeedStoryBuilder(FeedStory paramFeedStory)
  {
    this();
    this.a = paramFeedStory.type;
    this.b = paramFeedStory.id;
    this.c = paramFeedStory.cacheId;
    this.d = paramFeedStory.creationTime;
    this.e = paramFeedStory.icon;
    this.f = paramFeedStory.title;
    this.g = paramFeedStory.message;
    this.h = paramFeedStory.seenState;
    this.i = paramFeedStory.suffix;
    this.j = paramFeedStory.url;
    this.k = paramFeedStory.actors;
    this.l = paramFeedStory.attachments;
    this.m = paramFeedStory.actionLinks;
    this.n = paramFeedStory.attachedActionLinks;
    this.o = paramFeedStory.secondaryActions;
    this.p = paramFeedStory.tracking;
    this.q = paramFeedStory.privacyScope;
    this.r = paramFeedStory.to;
    this.s = paramFeedStory.via;
    this.t = paramFeedStory.with;
    this.u = paramFeedStory.application;
    this.v = paramFeedStory.implicitPlace;
    this.w = paramFeedStory.explicitPlace;
    this.x = paramFeedStory.sponsoredData;
    this.y = paramFeedStory.insights;
    this.z = paramFeedStory.attachedStory;
    this.A = paramFeedStory.substories;
    this.B = paramFeedStory.j();
    this.C = paramFeedStory.canViewerDelete;
    this.D = paramFeedStory.reportInfo;
    this.E = paramFeedStory.legacyApiStoryId;
    this.F = paramFeedStory.shareable;
    this.G = paramFeedStory.k();
    this.F = paramFeedStory.shareable;
    this.I = paramFeedStory.a;
    this.K = paramFeedStory.b;
    this.L = paramFeedStory.H();
    this.M = paramFeedStory.I();
    this.N = paramFeedStory.J();
    this.O = paramFeedStory.K();
    this.S = paramFeedStory.c();
    this.Q = paramFeedStory.getFetchTimeMs();
    this.R = paramFeedStory.S();
    this.P = paramFeedStory.z();
  }

  public ReportInfo A()
  {
    return this.D;
  }

  public String B()
  {
    return this.E;
  }

  public ArrayNode C()
  {
    return this.G;
  }

  public FeedStory D()
  {
    return this.I;
  }

  public Set<String> E()
  {
    return this.K;
  }

  public GraphQLStoryInsights F()
  {
    return this.y;
  }

  public FeedStory G()
  {
    return new FeedStory(this);
  }

  public FeedStory H()
  {
    return this.z;
  }

  public long I()
  {
    return this.Q;
  }

  public String J()
  {
    return this.b;
  }

  public FeedStory.PageStoryType K()
  {
    return this.H;
  }

  public GraphQLActionLink L()
  {
    return this.J;
  }

  public Spannable M()
  {
    return this.L;
  }

  public Spannable N()
  {
    return this.M;
  }

  public Spannable O()
  {
    return this.N;
  }

  public Spannable P()
  {
    return this.O;
  }

  public boolean Q()
  {
    return this.P;
  }

  public Feedback R()
  {
    return this.R;
  }

  public FeedOptimisticPublishState S()
  {
    return this.S;
  }

  public Shareable T()
  {
    return this.F;
  }

  public long a()
  {
    return this.d;
  }

  public FeedStoryBuilder a(long paramLong)
  {
    this.d = paramLong;
    return this;
  }

  public FeedStoryBuilder a(FeedOptimisticPublishState paramFeedOptimisticPublishState)
  {
    this.S = paramFeedOptimisticPublishState;
    return this;
  }

  public FeedStoryBuilder a(FeedStory paramFeedStory)
  {
    this.I = paramFeedStory;
    return this;
  }

  public FeedStoryBuilder a(Feedback paramFeedback)
  {
    this.R = paramFeedback;
    return this;
  }

  public FeedStoryBuilder a(GraphQLPlace paramGraphQLPlace)
  {
    this.w = paramGraphQLPlace;
    return this;
  }

  public FeedStoryBuilder a(GraphQLPrivacyScope paramGraphQLPrivacyScope)
  {
    this.q = paramGraphQLPrivacyScope;
    return this;
  }

  public FeedStoryBuilder a(GraphQLProfile paramGraphQLProfile)
  {
    this.r = paramGraphQLProfile;
    return this;
  }

  public FeedStoryBuilder a(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    this.g = paramGraphQLTextWithEntities;
    return this;
  }

  public FeedStoryBuilder a(Shareable paramShareable)
  {
    this.F = paramShareable;
    return this;
  }

  public FeedStoryBuilder a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public FeedStoryBuilder a(List<GraphQLProfile> paramList)
  {
    this.k = paramList;
    return this;
  }

  public FeedStoryBuilder a(boolean paramBoolean)
  {
    this.P = paramBoolean;
    return this;
  }

  public FeedStoryBuilder b(long paramLong)
  {
    this.Q = paramLong;
    return this;
  }

  public FeedStoryBuilder b(FeedStory paramFeedStory)
  {
    this.z = paramFeedStory;
    return this;
  }

  public FeedStoryBuilder b(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    this.f = paramGraphQLTextWithEntities;
    return this;
  }

  public FeedStoryBuilder b(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public FeedStoryBuilder b(List<GraphQLProfile> paramList)
  {
    this.t = paramList;
    return this;
  }

  public GraphQLTextWithEntities b()
  {
    return this.g;
  }

  public FeedStoryBuilder c(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    this.i = paramGraphQLTextWithEntities;
    return this;
  }

  public FeedStoryBuilder c(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public FeedStoryBuilder c(List<FeedStoryAttachment> paramList)
  {
    if ((paramList != null) && (paramList.size() == 0))
      paramList = null;
    this.l = paramList;
    return this;
  }

  public List<GraphQLProfile> c()
  {
    return this.k;
  }

  public FeedStoryBuilder d(List<GraphQLActionLink> paramList)
  {
    this.m = paramList;
    return this;
  }

  public List<GraphQLProfile> d()
  {
    return this.t;
  }

  public FeedStoryBuilder e(List<GraphQLActionLink> paramList)
  {
    this.n = paramList;
    return this;
  }

  public GraphQLPlace e()
  {
    return this.w;
  }

  public FeedStoryBuilder f(List<FeedStory> paramList)
  {
    this.A = paramList;
    return this;
  }

  public GraphQLObjectType f()
  {
    return this.a;
  }

  public String g()
  {
    return this.c;
  }

  public GraphQLImage h()
  {
    return this.e;
  }

  public GraphQLTextWithEntities i()
  {
    return this.f;
  }

  public String j()
  {
    return this.h;
  }

  public GraphQLTextWithEntities k()
  {
    return this.i;
  }

  public String l()
  {
    return this.j;
  }

  public List<FeedStoryAttachment> m()
  {
    return this.l;
  }

  public String n()
  {
    return this.p;
  }

  public GraphQLPrivacyScope o()
  {
    return this.q;
  }

  public List<GraphQLActionLink> p()
  {
    return this.m;
  }

  public List<GraphQLActionLink> q()
  {
    return this.n;
  }

  public List<GraphQLActionLink> r()
  {
    return this.o;
  }

  public GraphQLProfile s()
  {
    return this.r;
  }

  public GraphQLProfile t()
  {
    return this.s;
  }

  public GraphQLApplication u()
  {
    return this.u;
  }

  public GraphQLPlace v()
  {
    return this.v;
  }

  public FeedStorySponsoredData w()
  {
    return this.x;
  }

  public List<FeedStory> x()
  {
    return this.A;
  }

  public int y()
  {
    return this.B;
  }

  public boolean z()
  {
    return this.C;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.FeedStoryBuilder
 * JD-Core Version:    0.6.2
 */