package com.facebook.katana.activity.composer;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.renderer.PrivacyScopeMapper;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.facebook.graphql.model.GraphQLAggregatedRange;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPlace.Builder;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.Shareable;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.katana.provider.ConnectionsProviderInjectable;
import com.facebook.katana.ui.mentions.MentionSpan;
import com.facebook.katana.util.StringUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FeedStoryPreview
{
  private final FeedLinkifyUtil a;
  private final ConnectionsProviderInjectable b;
  private final FbErrorReporter c;

  private FeedStoryPreview(FeedLinkifyUtil paramFeedLinkifyUtil, ConnectionsProviderInjectable paramConnectionsProviderInjectable, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramFeedLinkifyUtil;
    this.b = paramConnectionsProviderInjectable;
    this.c = paramFbErrorReporter;
  }

  public static FeedStory a(Context paramContext, Editable paramEditable, FacebookUser paramFacebookUser, Set<Long> paramSet, FacebookPlace paramFacebookPlace, PrivacySetting paramPrivacySetting, long paramLong, FeedLinkifyUtil paramFeedLinkifyUtil, ConnectionsProviderInjectable paramConnectionsProviderInjectable, FbErrorReporter paramFbErrorReporter)
  {
    return new FeedStoryPreview(paramFeedLinkifyUtil, paramConnectionsProviderInjectable, paramFbErrorReporter).a(paramContext, paramEditable, paramFacebookUser, paramSet, paramFacebookPlace, paramPrivacySetting, paramLong);
  }

  private GraphQLEntity a(GraphQLProfile paramGraphQLProfile)
  {
    GraphQLEntity localGraphQLEntity;
    if (paramGraphQLProfile == null)
    {
      localGraphQLEntity = null;
      return localGraphQLEntity;
    }
    if (paramGraphQLProfile.getClass() == GraphQLPlace.class);
    for (GraphQLObjectType.ObjectType localObjectType = GraphQLObjectType.ObjectType.Page; ; localObjectType = GraphQLObjectType.ObjectType.User)
    {
      localGraphQLEntity = new GraphQLEntity(paramGraphQLProfile.id, new GraphQLObjectType(localObjectType));
      break;
    }
  }

  private GraphQLPlace a(FacebookPlace paramFacebookPlace)
  {
    if (paramFacebookPlace == null);
    GraphQLPlace.Builder localBuilder;
    for (GraphQLPlace localGraphQLPlace = null; ; localGraphQLPlace = localBuilder.a())
    {
      return localGraphQLPlace;
      GraphQLImage localGraphQLImage = new GraphQLImage(paramFacebookPlace.mPicUrl, 0, 0);
      localBuilder = new GraphQLPlace.Builder();
      localBuilder.b(String.valueOf(paramFacebookPlace.mPageId));
      localBuilder.c(paramFacebookPlace.mName);
      localBuilder.a(localGraphQLImage);
      localBuilder.a(new GraphQLObjectType(GraphQLObjectType.ObjectType.Page));
      localBuilder.a(new GraphQLLocation(paramFacebookPlace.mLatitude, paramFacebookPlace.mLongitude));
      localBuilder.a(this.a.a(new GraphQLObjectType(GraphQLObjectType.ObjectType.Page), Long.valueOf(paramFacebookPlace.mPageId)));
    }
  }

  private GraphQLPrivacyScope a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return new GraphQLPrivacyScope(null, paramString, null);
  }

  private GraphQLProfile a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong != 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      GraphQLImage localGraphQLImage = new GraphQLImage(paramString2, 0, 0);
      GraphQLProfile.Builder localBuilder = new GraphQLProfile.Builder();
      localBuilder.b(String.valueOf(paramLong));
      localBuilder.c(paramString1);
      localBuilder.a(localGraphQLImage);
      localBuilder.a(new GraphQLObjectType(GraphQLObjectType.ObjectType.User));
      return localBuilder.b();
    }
  }

  private GraphQLProfile a(Context paramContext, long paramLong)
  {
    FacebookProfile localFacebookProfile = this.b.a(paramContext, paramLong);
    if (localFacebookProfile != null);
    for (GraphQLProfile localGraphQLProfile = a(localFacebookProfile.mId, localFacebookProfile.mDisplayName, localFacebookProfile.mImageUrl); ; localGraphQLProfile = null)
      return localGraphQLProfile;
  }

  private GraphQLProfile a(FacebookUser paramFacebookUser)
  {
    Preconditions.checkNotNull(paramFacebookUser);
    return a(paramFacebookUser.mUserId, paramFacebookUser.a(), paramFacebookUser.mImageUrl);
  }

  private GraphQLTextWithEntities a(Context paramContext, String paramString, GraphQLProfile paramGraphQLProfile, List<GraphQLProfile> paramList, GraphQLPlace paramGraphQLPlace)
  {
    List localList = a(paramContext, paramString, paramList);
    ArrayList localArrayList = Lists.a(new GraphQLProfile[] { paramGraphQLProfile });
    localArrayList.addAll(paramList);
    if (paramGraphQLPlace != null)
      localArrayList.add(paramGraphQLPlace);
    return new GraphQLTextWithEntities(paramString, a(paramString, localArrayList), localList);
  }

  private String a(Context paramContext, List<GraphQLProfile> paramList)
  {
    Object[] arrayOfObject;
    if (paramList.size() > 2)
    {
      arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(-1 + paramList.size());
    }
    for (String str = paramContext.getString(2131363190, arrayOfObject); ; str = null)
      return str;
  }

  private List<GraphQLAggregatedRange> a(Context paramContext, String paramString, List<GraphQLProfile> paramList)
  {
    ArrayList localArrayList = Lists.a();
    String str = a(paramContext, paramList);
    if (str != null)
      localArrayList.add(new GraphQLAggregatedRange(paramString.indexOf(str), str.length(), -1 + paramList.size(), paramList.subList(1, paramList.size())));
    return localArrayList;
  }

  private List<GraphQLProfile> a(Context paramContext, Set<Long> paramSet)
  {
    Preconditions.checkNotNull(paramSet);
    ArrayList localArrayList = Lists.b(paramSet.size());
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      GraphQLProfile localGraphQLProfile = a(paramContext, ((Long)localIterator.next()).longValue());
      if (localGraphQLProfile == null)
        continue;
      localArrayList.add(localGraphQLProfile);
    }
    return ImmutableList.a(localArrayList);
  }

  public static List<GraphQLEntityRange> a(Editable paramEditable)
  {
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramEditable);
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MentionSpan.class);
    ArrayList localArrayList = Lists.a();
    if (arrayOfMentionSpan != null)
    {
      int j = arrayOfMentionSpan.length;
      while (i < j)
      {
        MentionSpan localMentionSpan = arrayOfMentionSpan[i];
        int k = localMentionSpan.a(paramEditable);
        localArrayList.add(new GraphQLEntityRange(new GraphQLEntity(String.valueOf(localMentionSpan.c()), new GraphQLObjectType(GraphQLObjectType.ObjectType.User)), k, localMentionSpan.b(paramEditable) - k));
        i++;
      }
    }
    return localArrayList;
  }

  private List<GraphQLEntityRange> a(String paramString, List<GraphQLProfile> paramList)
  {
    ArrayList localArrayList1 = Lists.a();
    if (paramString == null);
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      HashMap localHashMap = Maps.a();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext())
        continue;
      GraphQLProfile localGraphQLProfile = (GraphQLProfile)localIterator.next();
      String str = localGraphQLProfile.name;
      if (localHashMap.containsKey(localGraphQLProfile.name));
      for (int i = 1 + ((Integer)localHashMap.get(localGraphQLProfile.name)).intValue(); ; i = 0)
      {
        int j = paramString.indexOf(str, i);
        if (j == -1)
          break;
        localArrayList1.add(new GraphQLEntityRange(a(localGraphQLProfile), j, localGraphQLProfile.name.length()));
        localHashMap.put(localGraphQLProfile.name, Integer.valueOf(j));
        break;
      }
    }
  }

  private String b(Context paramContext, String paramString, GraphQLProfile paramGraphQLProfile, List<GraphQLProfile> paramList, GraphQLPlace paramGraphQLPlace)
  {
    String str1;
    if (paramList.size() > 0)
      if (paramList.size() == 1)
        str1 = ((GraphQLProfile)paramList.get(0)).name;
    while (true)
    {
      String str2;
      if ((str1 != null) && (paramGraphQLPlace != null))
      {
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = str1;
        arrayOfObject3[1] = paramGraphQLPlace.name;
        str2 = paramContext.getString(2131363194, arrayOfObject3);
      }
      while (true)
      {
        label79: if (StringUtils.c(paramString))
        {
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = paramGraphQLProfile.name;
          arrayOfObject1[1] = str2;
          str2 = paramContext.getString(2131363195, arrayOfObject1);
        }
        while (true)
        {
          return str2;
          if (paramList.size() == 2)
          {
            Object[] arrayOfObject5 = new Object[2];
            arrayOfObject5[0] = ((GraphQLProfile)paramList.get(0)).name;
            arrayOfObject5[1] = ((GraphQLProfile)paramList.get(1)).name;
            str1 = paramContext.getString(2131363191, arrayOfObject5);
            break;
          }
          Object[] arrayOfObject4 = new Object[2];
          arrayOfObject4[0] = ((GraphQLProfile)paramList.get(0)).name;
          arrayOfObject4[1] = a(paramContext, paramList);
          str1 = paramContext.getString(2131363191, arrayOfObject4);
          break;
          if ((str1 != null) && (paramGraphQLPlace == null))
          {
            str2 = paramContext.getString(2131363192, new Object[] { str1 });
            break label79;
          }
          if ((str1 != null) || (paramGraphQLPlace == null))
            break label320;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramGraphQLPlace.name;
          str2 = paramContext.getString(2131363193, arrayOfObject2);
          break label79;
          if (!StringUtils.c(str2))
            continue;
          str2 = null;
        }
        label320: str2 = null;
      }
      str1 = null;
    }
  }

  public FeedStory a(Context paramContext, Editable paramEditable, FacebookUser paramFacebookUser, Set<Long> paramSet, FacebookPlace paramFacebookPlace, PrivacySetting paramPrivacySetting, long paramLong)
  {
    GraphQLProfile localGraphQLProfile1 = a(paramFacebookUser);
    List localList = a(paramContext, paramSet);
    GraphQLPlace localGraphQLPlace = a(paramFacebookPlace);
    GraphQLPrivacyScope localGraphQLPrivacyScope = a(PrivacyScopeMapper.a(paramPrivacySetting, this.c));
    if (paramLong != paramFacebookUser.mUserId);
    for (GraphQLProfile localGraphQLProfile2 = a(paramContext, paramLong); ; localGraphQLProfile2 = null)
    {
      if (paramEditable == null);
      GraphQLTextWithEntities localGraphQLTextWithEntities3;
      Object localObject1;
      Shareable localShareable;
      Object localObject2;
      for (String str1 = null; StringUtils.c(str1); str1 = paramEditable.toString())
      {
        localGraphQLTextWithEntities3 = a(paramContext, b(paramContext, str1, localGraphQLProfile1, localList, localGraphQLPlace), localGraphQLProfile1, localList, localGraphQLPlace);
        localObject1 = null;
        localShareable = null;
        localObject2 = null;
        Feedback localFeedback = new FeedbackBuilder().a(true).b(true).n();
        long l = System.currentTimeMillis();
        return new FeedStoryBuilder().a(Lists.a(new GraphQLProfile[] { localGraphQLProfile1 })).a(l / 1000L).a(localGraphQLPlace).a((GraphQLTextWithEntities)localObject2).a(localGraphQLPrivacyScope).c((GraphQLTextWithEntities)localObject1).b(localGraphQLTextWithEntities3).a(localGraphQLProfile2).b(localList).b(l).a(FeedOptimisticPublishState.POSTING).a(localFeedback).a(localShareable).G();
      }
      GraphQLTextWithEntities localGraphQLTextWithEntities1 = new GraphQLTextWithEntities(str1, a(paramEditable), null);
      String str2 = b(paramContext, str1, localGraphQLProfile1, localList, localGraphQLPlace);
      if (str2 != null);
      for (GraphQLTextWithEntities localGraphQLTextWithEntities2 = a(paramContext, str2, localGraphQLProfile1, localList, localGraphQLPlace); ; localGraphQLTextWithEntities2 = null)
      {
        if ((paramPrivacySetting != null) && ("EVERYONE".equals(paramPrivacySetting.value)) && (localGraphQLPlace == null))
        {
          localShareable = Shareable.a;
          localObject1 = localGraphQLTextWithEntities2;
          localObject2 = localGraphQLTextWithEntities1;
          localGraphQLTextWithEntities3 = null;
          break;
        }
        localObject1 = localGraphQLTextWithEntities2;
        localObject2 = localGraphQLTextWithEntities1;
        localShareable = null;
        localGraphQLTextWithEntities3 = null;
        break;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.FeedStoryPreview
 * JD-Core Version:    0.6.0
 */