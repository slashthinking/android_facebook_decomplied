package com.facebook.notifications.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.NotificationStoriesDelta;
import com.facebook.graphql.model.NotificationStoriesDelta.NotificationStoryDeltaEdge;
import com.facebook.graphql.model.NotificationStoriesDeltaNode;
import com.facebook.graphql.model.NotificationStoryEdge;
import com.facebook.graphql.model.NotificationStoryEdge.Builder;
import com.facebook.ipc.notifications.GQLNotificationsContract;
import com.facebook.notifications.model.NotificationStories;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GQLNotificationsContentProviderHelper
{
  private final GQLNotificationsContract a;
  private final ContentResolver b;
  private final NotificationsLastUpdatedTimeUtil c;
  private final ObjectMapper d;

  public GQLNotificationsContentProviderHelper(GQLNotificationsContract paramGQLNotificationsContract, @FromApplication ContentResolver paramContentResolver, NotificationsLastUpdatedTimeUtil paramNotificationsLastUpdatedTimeUtil, ObjectMapper paramObjectMapper)
  {
    this.a = ((GQLNotificationsContract)Preconditions.checkNotNull(paramGQLNotificationsContract));
    this.b = ((ContentResolver)Preconditions.checkNotNull(paramContentResolver));
    this.c = ((NotificationsLastUpdatedTimeUtil)Preconditions.checkNotNull(paramNotificationsLastUpdatedTimeUtil));
    this.d = ((ObjectMapper)Preconditions.checkNotNull(paramObjectMapper));
  }

  private NotificationStoryEdge a(FeedStory paramFeedStory, String paramString)
  {
    return new NotificationStoryEdge.Builder().a(paramFeedStory).a(paramString).a();
  }

  private static <T> Iterable<T> a(Iterable<T> paramIterable)
  {
    if (paramIterable == null)
      paramIterable = Collections.emptyList();
    return paramIterable;
  }

  static String a(String paramString, List<String> paramList)
  {
    Iterable localIterable = Iterables.a(paramList, new GQLNotificationsContentProviderHelper.1());
    return paramString + " IN(" + Joiner.on(',').join(localIterable) + ")";
  }

  private ImmutableList<String> b()
  {
    ImmutableList.Builder localBuilder = new ImmutableList.Builder();
    Cursor localCursor = this.b.query(this.a.e, GQLNotificationsContract.b, null, null, null);
    if (localCursor != null);
    try
    {
      int i;
      if (localCursor.moveToFirst())
        i = localCursor.getColumnIndex("notif_id");
      try
      {
        boolean bool;
        do
        {
          localBuilder.b(localCursor.getString(i));
          bool = localCursor.moveToNext();
        }
        while (bool);
        return localBuilder.b();
      }
      catch (Exception localException)
      {
        while (true)
          BLog.d("GQLNotificationsContentProviderHelper", localException.getMessage(), localException);
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }

  private void b(List<String> paramList, String paramString)
  {
    if (paramList.size() > 0)
      this.b.delete(this.a.e, paramString, null);
  }

  ContentValues a(NotificationStoryEdge paramNotificationStoryEdge, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    FeedStory localFeedStory = paramNotificationStoryEdge.notificationStory;
    localContentValues.put("notif_id", localFeedStory.id);
    localContentValues.put("seen_state", localFeedStory.seenState);
    localContentValues.put("updated", Long.valueOf(localFeedStory.creationTime));
    localContentValues.put("cache_id", localFeedStory.cacheId);
    localContentValues.put("recipient_id", Long.valueOf(paramLong));
    localContentValues.put("cursor", paramNotificationStoryEdge.cursor);
    localContentValues.put("gql_payload", this.d.writeValueAsString(localFeedStory));
    return localContentValues;
  }

  // ERROR //
  public FeedStory a(Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 181
    //   3: invokeinterface 123 2 0
    //   8: istore_2
    //   9: aload_1
    //   10: ldc 212
    //   12: invokeinterface 123 2 0
    //   17: istore_3
    //   18: aload_1
    //   19: ldc 186
    //   21: invokeinterface 123 2 0
    //   26: istore 4
    //   28: getstatic 222	com/facebook/common/json/FBJsonFactory:a	Lcom/facebook/common/json/FBJsonFactory;
    //   31: aload_1
    //   32: iload_3
    //   33: invokeinterface 127 2 0
    //   38: invokevirtual 226	com/facebook/common/json/FBJsonFactory:createJsonParser	(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;
    //   41: astore 8
    //   43: aload 8
    //   45: aload_0
    //   46: getfield 40	com/facebook/notifications/provider/GQLNotificationsContentProviderHelper:d	Lcom/fasterxml/jackson/databind/ObjectMapper;
    //   49: invokevirtual 232	com/fasterxml/jackson/core/JsonParser:setCodec	(Lcom/fasterxml/jackson/core/ObjectCodec;)V
    //   52: aload 8
    //   54: ldc 171
    //   56: invokevirtual 236	com/fasterxml/jackson/core/JsonParser:readValueAs	(Ljava/lang/Class;)Ljava/lang/Object;
    //   59: checkcast 171	com/facebook/graphql/model/FeedStory
    //   62: astore 6
    //   64: new 238	com/facebook/graphql/model/FeedStoryBuilder
    //   67: dup
    //   68: aload 6
    //   70: invokespecial 241	com/facebook/graphql/model/FeedStoryBuilder:<init>	(Lcom/facebook/graphql/model/FeedStory;)V
    //   73: aload_1
    //   74: iload_2
    //   75: invokeinterface 127 2 0
    //   80: invokevirtual 244	com/facebook/graphql/model/FeedStoryBuilder:b	(Ljava/lang/String;)Lcom/facebook/graphql/model/FeedStoryBuilder;
    //   83: aload_1
    //   84: iload 4
    //   86: invokeinterface 248 2 0
    //   91: invokevirtual 251	com/facebook/graphql/model/FeedStoryBuilder:a	(J)Lcom/facebook/graphql/model/FeedStoryBuilder;
    //   94: invokevirtual 255	com/facebook/graphql/model/FeedStoryBuilder:G	()Lcom/facebook/graphql/model/FeedStory;
    //   97: astore 9
    //   99: aload 9
    //   101: astore 6
    //   103: aload 6
    //   105: areturn
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 6
    //   111: aload 5
    //   113: astore 7
    //   115: ldc 140
    //   117: aload 7
    //   119: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   122: aload 7
    //   124: invokestatic 148	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -24 -> 103
    //   130: astore 7
    //   132: goto -17 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   28	64	106	java/lang/Exception
    //   64	99	130	java/lang/Exception
  }

  FetchGraphQLNotificationsResult a(FetchGraphQLNotificationsParams paramFetchGraphQLNotificationsParams)
  {
    ArrayList localArrayList = new ArrayList();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "recipient_id";
    arrayOfObject[1] = Long.valueOf(paramFetchGraphQLNotificationsParams.e());
    String str = StringUtil.a("%s=%d", arrayOfObject);
    Cursor localCursor = this.b.query(this.a.e, GQLNotificationsContract.a, str, null, null);
    if (localCursor != null);
    while (true)
    {
      try
      {
        int i;
        int j;
        int k;
        int m;
        if (localCursor.moveToFirst())
        {
          i = localCursor.getColumnIndex("seen_state");
          j = localCursor.getColumnIndex("gql_payload");
          k = localCursor.getColumnIndex("updated");
          m = localCursor.getColumnIndex("cursor");
        }
        try
        {
          JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(localCursor.getString(j));
          localJsonParser.setCodec(this.d);
          localArrayList.add(a(new FeedStoryBuilder((FeedStory)localJsonParser.readValueAs(FeedStory.class)).b(localCursor.getString(i)).a(localCursor.getLong(k)).G(), localCursor.getString(m)));
          boolean bool = localCursor.moveToNext();
          if (bool)
            continue;
          if (localCursor != null)
            localCursor.close();
          if (localArrayList.size() > 0)
          {
            localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
            return new FetchGraphQLNotificationsResult(new NotificationStories(localArrayList), paramFetchGraphQLNotificationsParams.e(), localDataFreshnessResult, this.c.a());
          }
        }
        catch (Exception localException)
        {
          BLog.d("GQLNotificationsContentProviderHelper", localException.getMessage(), localException);
          continue;
        }
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
      DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.NO_DATA;
    }
  }

  public ImmutableList<String> a(long paramLong)
  {
    ImmutableList.Builder localBuilder = new ImmutableList.Builder();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "recipient_id";
    arrayOfObject[1] = Long.valueOf(paramLong);
    String str = StringUtil.a("%s=%d", arrayOfObject);
    Cursor localCursor = this.b.query(this.a.e, new String[] { "cache_id" }, str, null, null);
    if (localCursor != null);
    try
    {
      int i;
      if (localCursor.moveToFirst())
        i = localCursor.getColumnIndex("cache_id");
      try
      {
        boolean bool;
        do
        {
          localBuilder.b(localCursor.getString(i));
          bool = localCursor.moveToNext();
        }
        while (bool);
        return localBuilder.b();
      }
      catch (Exception localException)
      {
        while (true)
          BLog.d("GQLNotificationsContentProviderHelper", localException.getMessage(), localException);
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }

  void a()
  {
    ImmutableList localImmutableList1 = b();
    int i = localImmutableList1.size();
    if (i > 30)
    {
      ImmutableList localImmutableList2 = localImmutableList1.a(29, i - 1);
      b(localImmutableList2, a("notif_id", localImmutableList2));
    }
  }

  void a(FetchGraphQLNotificationsResult paramFetchGraphQLNotificationsResult)
  {
    if (paramFetchGraphQLNotificationsResult.a == null);
    while (true)
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator1 = a(paramFetchGraphQLNotificationsResult.a.newStories).iterator();
      while (localIterator1.hasNext())
        localArrayList2.add((NotificationStoryEdge)localIterator1.next());
      NotificationStoriesDelta localNotificationStoriesDelta = paramFetchGraphQLNotificationsResult.a.deltaStories;
      if (localNotificationStoriesDelta != null)
      {
        Iterator localIterator2 = a(localNotificationStoriesDelta.edges).iterator();
        while (localIterator2.hasNext())
        {
          NotificationStoriesDelta.NotificationStoryDeltaEdge localNotificationStoryDeltaEdge = (NotificationStoriesDelta.NotificationStoryDeltaEdge)localIterator2.next();
          if (localNotificationStoryDeltaEdge.node.modifiedStory != null)
            localArrayList2.add(a(localNotificationStoryDeltaEdge.node.modifiedStory, localNotificationStoryDeltaEdge.cursor));
          else if (!StringUtil.a(localNotificationStoryDeltaEdge.node.removedID))
            localArrayList1.add(localNotificationStoryDeltaEdge.node.removedID);
        }
        b(localArrayList1, a("notif_id", localArrayList1));
      }
      a(localArrayList2, paramFetchGraphQLNotificationsResult.b);
      a();
    }
  }

  void a(List<NotificationStoryEdge> paramList, long paramLong)
  {
    ContentValues[] arrayOfContentValues;
    Iterator localIterator;
    int i;
    if (paramList.size() > 0)
    {
      arrayOfContentValues = new ContentValues[paramList.size()];
      localIterator = paramList.iterator();
      i = 0;
    }
    while (true)
    {
      NotificationStoryEdge localNotificationStoryEdge;
      if (localIterator.hasNext())
        localNotificationStoryEdge = (NotificationStoryEdge)localIterator.next();
      try
      {
        localContentValues = a(localNotificationStoryEdge, paramLong);
        localContentValues.put("cursor", localNotificationStoryEdge.cursor);
        j = i + 1;
      }
      catch (Exception localException1)
      {
        try
        {
          ContentValues localContentValues;
          int j;
          arrayOfContentValues[i] = localContentValues;
          while (true)
          {
            label87: i = j;
            break;
            this.b.bulkInsert(this.a.e, arrayOfContentValues);
            return;
            localException1 = localException1;
            j = i;
          }
        }
        catch (Exception localException2)
        {
          break label87;
        }
      }
    }
  }

  void a(List<String> paramList, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("seen_state", paramString);
    String str = a("notif_id", paramList);
    this.b.update(this.a.e, localContentValues, str, null);
  }

  public String b(long paramLong)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "recipient_id";
    arrayOfObject[1] = Long.valueOf(paramLong);
    String str1 = StringUtil.a("%s=%d", arrayOfObject);
    Cursor localCursor = this.b.query(this.a.e.buildUpon().appendQueryParameter("LIMIT", "1").build(), new String[] { "cursor" }, str1, null, null);
    Object localObject1 = null;
    if (localCursor != null);
    try
    {
      boolean bool = localCursor.moveToFirst();
      localObject1 = null;
      if (bool);
      try
      {
        String str2 = localCursor.getString(localCursor.getColumnIndex("cursor"));
        localObject1 = str2;
        return localObject1;
      }
      catch (Exception localException)
      {
        while (true)
        {
          BLog.d("GQLNotificationsContentProviderHelper", localException.getMessage(), localException);
          localObject1 = null;
        }
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.provider.GQLNotificationsContentProviderHelper
 * JD-Core Version:    0.6.2
 */