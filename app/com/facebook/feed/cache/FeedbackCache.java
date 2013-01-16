package com.facebook.feed.cache;

import android.support.v4.util.LruCache;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.data.FeedbackMutator.Result;
import com.facebook.feed.protocol.FetchNodeListParams;
import com.facebook.feed.util.FetchFeedbackType;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class FeedbackCache
{
  private static final Class<?> a = FeedbackCache.class;
  private final LruCache<String, FeedbackCache.CacheEntry> b;
  private final Map<String, String> c = Maps.a();
  private final Map<String, String> d = Maps.a();
  private final FeedbackMutator e;

  public FeedbackCache(int paramInt, FeedbackMutator paramFeedbackMutator)
  {
    this.b = new FeedbackCache.1(this, paramInt);
    this.e = paramFeedbackMutator;
  }

  private FeedStoryComments a(FeedStoryComments paramFeedStoryComments1, FeedStoryComments paramFeedStoryComments2, FetchFeedbackType paramFetchFeedbackType, String paramString)
  {
    if ((paramFetchFeedbackType.hasComments()) && (paramFetchFeedbackType.hasNewerData()))
      if ((paramString != null) && (paramString.equals(paramFeedStoryComments1.pageInfo.startCursor)) && (!paramFeedStoryComments2.pageInfo.hasNextPage));
    while (true)
    {
      return paramFeedStoryComments2;
      GraphQLPageInfo localGraphQLPageInfo2 = new GraphQLPageInfo(paramFeedStoryComments2.pageInfo.startCursor, paramFeedStoryComments1.pageInfo.endCursor, paramFeedStoryComments2.pageInfo.hasPreviousPage, paramFeedStoryComments1.pageInfo.hasNextPage);
      ImmutableSet localImmutableSet = new ImmutableSet.Builder().b(paramFeedStoryComments2.comments.iterator()).b(paramFeedStoryComments1.comments.iterator()).b();
      paramFeedStoryComments2 = new FeedStoryComments(paramFeedStoryComments2.count, localImmutableSet, localGraphQLPageInfo2);
      continue;
      if ((paramFeedStoryComments2 != null) && (paramFeedStoryComments2.count != paramFeedStoryComments1.count))
      {
        int i = paramFeedStoryComments2.count;
        Object localObject;
        label162: GraphQLPageInfo localGraphQLPageInfo1;
        if (paramFeedStoryComments1 == null)
        {
          localObject = null;
          localGraphQLPageInfo1 = null;
          if (paramFeedStoryComments1 != null)
            break label195;
        }
        while (true)
        {
          paramFeedStoryComments2 = new FeedStoryComments(i, (Set)localObject, localGraphQLPageInfo1);
          break;
          localObject = paramFeedStoryComments1.comments;
          break label162;
          label195: localGraphQLPageInfo1 = paramFeedStoryComments1.pageInfo;
        }
      }
      paramFeedStoryComments2 = paramFeedStoryComments1;
    }
  }

  private FeedStoryLikers a(FeedStoryLikers paramFeedStoryLikers1, FeedStoryLikers paramFeedStoryLikers2, FetchFeedbackType paramFetchFeedbackType, String paramString)
  {
    if ((paramFetchFeedbackType.hasLikers()) && (paramFetchFeedbackType.hasNewerData()))
      if ((paramString != null) && (paramString.equals(paramFeedStoryLikers1.pageInfo.startCursor)) && (!paramFeedStoryLikers2.pageInfo.hasNextPage));
    while (true)
    {
      return paramFeedStoryLikers2;
      GraphQLPageInfo localGraphQLPageInfo2 = new GraphQLPageInfo(paramFeedStoryLikers2.pageInfo.startCursor, paramFeedStoryLikers1.pageInfo.endCursor, paramFeedStoryLikers2.pageInfo.hasPreviousPage, paramFeedStoryLikers1.pageInfo.hasNextPage);
      ImmutableList localImmutableList = ImmutableList.e().b(paramFeedStoryLikers2.likers.iterator()).b(paramFeedStoryLikers1.likers.iterator()).b();
      paramFeedStoryLikers2 = new FeedStoryLikers(paramFeedStoryLikers2.count, localImmutableList, localGraphQLPageInfo2);
      continue;
      if ((paramFeedStoryLikers2 != null) && (paramFeedStoryLikers2.count != paramFeedStoryLikers1.count))
      {
        int i = paramFeedStoryLikers2.count;
        List localList;
        label162: GraphQLPageInfo localGraphQLPageInfo1;
        if (paramFeedStoryLikers1 == null)
        {
          localList = null;
          localGraphQLPageInfo1 = null;
          if (paramFeedStoryLikers1 != null)
            break label195;
        }
        while (true)
        {
          paramFeedStoryLikers2 = new FeedStoryLikers(i, localList, localGraphQLPageInfo1);
          break;
          localList = paramFeedStoryLikers1.likers;
          break label162;
          label195: localGraphQLPageInfo1 = paramFeedStoryLikers1.pageInfo;
        }
      }
      paramFeedStoryLikers2 = paramFeedStoryLikers1;
    }
  }

  private Feedback a(Feedback paramFeedback)
  {
    this.b.a(paramFeedback.d(), new FeedbackCache.CacheEntry(this, paramFeedback, null));
    this.c.put(paramFeedback.legacyApiPostId, paramFeedback.d());
    return paramFeedback;
  }

  private boolean a(FeedStoryComments paramFeedStoryComments)
  {
    if ((paramFeedStoryComments != null) && (!paramFeedStoryComments.comments.isEmpty()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean a(FeedStoryLikers paramFeedStoryLikers)
  {
    if ((paramFeedStoryLikers != null) && (!paramFeedStoryLikers.likers.isEmpty()));
    for (int i = 1; ; i = 0)
      return i;
  }

  Feedback a(Feedback paramFeedback, FetchFeedbackType paramFetchFeedbackType, String paramString)
  {
    monitorenter;
    if (paramFeedback != null);
    try
    {
      String str = paramFeedback.d();
      Object localObject1;
      if (str == null)
        localObject1 = null;
      while (true)
      {
        return localObject1;
        localObject1 = a(paramFeedback.d());
        if (localObject1 == null)
        {
          localObject1 = a(paramFeedback);
          continue;
        }
        if (((Feedback)localObject1).getFetchTimeMs() >= paramFeedback.getFetchTimeMs())
          continue;
        FeedStoryComments localFeedStoryComments = a(((Feedback)localObject1).comments, paramFeedback.comments, paramFetchFeedbackType, paramString);
        FeedStoryLikers localFeedStoryLikers = a(((Feedback)localObject1).likers, paramFeedback.likers, paramFetchFeedbackType, paramString);
        Feedback localFeedback = a(new FeedbackBuilder().a(paramFeedback).a(localFeedStoryComments).a(localFeedStoryLikers).n());
        localObject1 = localFeedback;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  Feedback a(Feedback paramFeedback, String paramString)
  {
    monitorenter;
    if (paramFeedback != null);
    try
    {
      if (paramFeedback.d() != null)
      {
        boolean bool = Strings.isNullOrEmpty(paramString);
        if (!bool)
          break label30;
      }
      label30: Feedback localFeedback;
      for (Object localObject1 = null; ; localObject1 = localFeedback)
      {
        return localObject1;
        this.d.put(paramString, paramFeedback.d());
        localFeedback = a(paramFeedback);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  Feedback a(String paramString)
  {
    monitorenter;
    Feedback localFeedback;
    if (paramString == null)
      localFeedback = null;
    while (true)
    {
      monitorexit;
      return localFeedback;
      try
      {
        FeedbackCache.CacheEntry localCacheEntry = (FeedbackCache.CacheEntry)this.b.a(paramString);
        if (localCacheEntry == null)
        {
          localFeedback = null;
          continue;
        }
        localFeedback = localCacheEntry.a;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  Feedback a(String paramString, FeedComment paramFeedComment)
  {
    monitorenter;
    Object localObject2;
    if (paramString == null)
      localObject2 = null;
    while (true)
    {
      monitorexit;
      return localObject2;
      try
      {
        localObject2 = b(paramString);
        if (localObject2 == null)
          continue;
        Feedback localFeedback = a(this.e.a((Feedback)localObject2, paramFeedComment));
        localObject2 = localFeedback;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  Feedback a(String paramString, GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    monitorenter;
    Object localObject2;
    if (paramString == null)
      localObject2 = null;
    while (true)
    {
      monitorexit;
      return localObject2;
      try
      {
        localObject2 = b(paramString);
        if ((localObject2 == null) || (paramBoolean == ((Feedback)localObject2).doesViewerLike))
          continue;
        Feedback localFeedback = a(this.e.a((Feedback)localObject2, paramGraphQLProfile));
        localObject2 = localFeedback;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  Feedback a(String paramString1, String paramString2, FetchNodeListParams paramFetchNodeListParams)
  {
    monitorenter;
    if (paramString1 == null);
    for (Feedback localFeedback = null; ; localFeedback = null)
      while (true)
      {
        monitorexit;
        return localFeedback;
        label121: 
        try
        {
          if ((paramFetchNodeListParams.d() == null) && (paramFetchNodeListParams.c() == null))
          {
            FeedbackCache.CacheEntry localCacheEntry = (FeedbackCache.CacheEntry)this.b.a(paramString1);
            if (localCacheEntry == null)
            {
              localFeedback = null;
              break label121;
            }
            localFeedback = localCacheEntry.a;
            break label121;
            if ((a(localFeedback.likers)) && (paramString2.equals("fetchLikersFeedParams")))
              continue;
            if (a(localFeedback.comments))
            {
              boolean bool = paramString2.equals("fetchCommentsParams");
              if (bool)
                continue;
            }
          }
          localFeedback = null;
        }
        finally
        {
          monitorexit;
        }
      }
  }

  Feedback a(String paramString1, String paramString2, GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    monitorenter;
    Object localObject1;
    if ((paramString1 == null) || (paramString2 == null))
      localObject1 = null;
    while (true)
    {
      monitorexit;
      return localObject1;
      FeedComment localFeedComment;
      label165: label171: 
      do
      {
        try
        {
          Feedback localFeedback1 = b(paramString1);
          if ((localFeedback1 == null) || (localFeedback1.comments == null))
            break label165;
          Iterator localIterator = localFeedback1.comments.comments.iterator();
          while (true)
            if (localIterator.hasNext())
            {
              localFeedComment = (FeedComment)localIterator.next();
              if (!paramString2.equals(localFeedComment.S().legacyApiPostId))
                continue;
              break label171;
              Feedback localFeedback2 = localFeedComment.S();
              Preconditions.checkNotNull(localFeedback2);
              if (paramBoolean == localFeedback2.doesViewerLike)
              {
                localObject1 = localFeedback1;
                break;
              }
              Feedback localFeedback3 = a(this.e.a(localFeedback1, localFeedComment, paramGraphQLProfile).a);
              localObject1 = localFeedback3;
            }
        }
        finally
        {
          monitorexit;
        }
        continue;
        localObject1 = null;
        break;
      }
      while (localFeedComment != null);
      localObject1 = null;
    }
  }

  void a()
  {
    monitorenter;
    try
    {
      this.b.a();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  Feedback b(String paramString)
  {
    monitorenter;
    Object localObject2;
    if (paramString == null)
      localObject2 = null;
    while (true)
    {
      monitorexit;
      return localObject2;
      try
      {
        Feedback localFeedback = a((String)this.c.get(paramString));
        localObject2 = localFeedback;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  Feedback c(String paramString)
  {
    monitorenter;
    try
    {
      boolean bool = Strings.isNullOrEmpty(paramString);
      if (bool);
      Feedback localFeedback;
      for (Object localObject2 = null; ; localObject2 = localFeedback)
      {
        return localObject2;
        localFeedback = a((String)this.d.get(paramString));
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedbackCache
 * JD-Core Version:    0.6.0
 */