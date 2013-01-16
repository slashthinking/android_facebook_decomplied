package com.facebook.orca.sms;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android_src.provider.Telephony.Sms;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableList<Lcom.facebook.orca.sms.FetchMmsSmsThreadSummaryResult;>;
import java.util.Collection;
import java.util.List;

public class SmsContentResolverHandler
{
  private static final Class<?> a = SmsContentResolverHandler.class;
  private final Context b;
  private final MmsSmsUserUtils c;

  public SmsContentResolverHandler(Context paramContext, MmsSmsUserUtils paramMmsSmsUserUtils)
  {
    this.b = paramContext;
    this.c = paramMmsSmsUserUtils;
  }

  static String a(String paramString)
  {
    if (StringUtil.a(paramString));
    Object[] arrayOfObject;
    for (String str = StringLocaleUtil.a("SELECT MAX(date) AS normalized_date, thread_id AS thread_id, MAX(_id) AS _id FROM sms WHERE %1$s GROUP BY thread_id", new Object[] { "type IN (1, 2, 5)" }); ; str = StringLocaleUtil.a("SELECT MAX(date) AS normalized_date, thread_id AS thread_id, MAX(_id) AS _id FROM sms WHERE %1$s GROUP BY thread_id", arrayOfObject))
    {
      return str;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = ("type IN (1, 2, 5) AND " + paramString);
    }
  }

  private String a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 == null);
    for (String str = ""; ; str = paramString2 + " AND ")
      return "_id IN (SELECT sms._id FROM (" + a(paramString1) + ") sms " + "LEFT JOIN " + "(" + MmsContentResolverHandler.a(paramString1) + ") mms " + "ON sms.thread_id=mms.thread_id " + "WHERE " + str + "(mms.normalized_date<sms.normalized_date OR mms.normalized_date IS NULL) " + "ORDER BY sms.normalized_date DESC " + "LIMIT " + (paramInt + 1) + ")";
  }

  private ImmutableList<FetchMmsSmsThreadSummaryResult> b(String paramString)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Cursor localCursor = this.b.getContentResolver().query(Telephony.Sms.a, MmsSmsProjections.b, paramString, null, "date DESC");
    while (true)
    {
      String str3;
      try
      {
        int i = localCursor.getColumnIndex("thread_id");
        int j = localCursor.getColumnIndex("_id");
        int k = localCursor.getColumnIndex("date");
        int m = localCursor.getColumnIndex("subject");
        int n = localCursor.getColumnIndex("body");
        int i1 = localCursor.getColumnIndex("address");
        int i2 = localCursor.getColumnIndex("type");
        int i3 = localCursor.getColumnIndex("read");
        if (!localCursor.moveToNext())
          break;
        long l1 = localCursor.getLong(i);
        long l2 = localCursor.getLong(j);
        long l3 = localCursor.getLong(k);
        String str1 = localCursor.getString(m);
        String str2 = localCursor.getString(n);
        str3 = localCursor.getString(i1);
        int i4 = localCursor.getInt(i2);
        int i5 = localCursor.getInt(i3);
        if ((i4 == 2) || (i4 == 6) || (i4 == 4))
        {
          localObject2 = this.c.a();
          if (i5 != 0)
            break label299;
          bool = true;
          localBuilder.b(new FetchMmsSmsThreadSummaryResult(l1, l2, l3, bool, str1, str2, (ParticipantInfo)localObject2));
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      User localUser = this.c.a(str3);
      ParticipantInfo localParticipantInfo = this.c.a(localUser);
      Object localObject2 = localParticipantInfo;
      continue;
      label299: boolean bool = false;
    }
    localCursor.close();
    return (ImmutableList<FetchMmsSmsThreadSummaryResult>)localBuilder.b();
  }

  private String b(FetchMmsSmsThreadListParams paramFetchMmsSmsThreadListParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sms.normalized_date");
    if (paramFetchMmsSmsThreadListParams.b() != null)
    {
      localStringBuilder.append(">");
      localStringBuilder.append(paramFetchMmsSmsThreadListParams.b());
    }
    while (true)
    {
      return a(null, localStringBuilder.toString(), paramFetchMmsSmsThreadListParams.a());
      localStringBuilder.append("<=");
      localStringBuilder.append(paramFetchMmsSmsThreadListParams.c());
    }
  }

  private String c(List<Long> paramList)
  {
    return a("thread_id IN " + SqlUtil.a(paramList), null, paramList.size());
  }

  public long a(long paramLong)
  {
    String[] arrayOfString1 = { "thread_id" };
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = Long.toString(paramLong);
    Cursor localCursor = this.b.getContentResolver().query(Telephony.Sms.a, arrayOfString1, "_id=?", arrayOfString2, null);
    try
    {
      if (localCursor.moveToNext())
      {
        long l = localCursor.getLong(localCursor.getColumnIndex("thread_id"));
        return l;
      }
      throw new Exception("Could not find SmsId by MessageId");
    }
    finally
    {
      localCursor.close();
    }
    throw localObject;
  }

  public long a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("address", paramString1);
    localContentValues.put("date", Long.valueOf(paramLong1));
    localContentValues.put("date_sent", Long.valueOf(paramLong2));
    localContentValues.put("body", paramString2);
    localContentValues.put("type", Integer.valueOf(paramInt));
    localContentValues.put("seen", Integer.valueOf(1));
    Uri localUri = this.b.getContentResolver().insert(Telephony.Sms.a, localContentValues);
    if (localUri == null)
    {
      localContentValues.remove("date_sent");
      localUri = this.b.getContentResolver().insert(Telephony.Sms.a, localContentValues);
    }
    return Long.parseLong(localUri.getLastPathSegment());
  }

  Message a(Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndex("type"));
    ParticipantInfo localParticipantInfo;
    int j;
    if (i == 2)
    {
      localParticipantInfo = this.c.a();
      j = 0;
    }
    while (true)
    {
      String str1 = paramCursor.getString(paramCursor.getColumnIndex("subject"));
      String str2 = paramCursor.getString(paramCursor.getColumnIndex("body"));
      long l1 = paramCursor.getLong(paramCursor.getColumnIndex("thread_id"));
      long l2 = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      String str3 = MessagingIdUtil.a(l1);
      String str4 = MessagingIdUtil.b(l2);
      long l3 = paramCursor.getLong(paramCursor.getColumnIndex("date"));
      long l4 = 1000000L * l3;
      return new MessageBuilder().a(str4).b(str3).a(j).c(str1).d(str2).a(l3).c(l4).a(localParticipantInfo).a(false).f("sms").a(Message.ChannelSource.SMS).v();
      if (i == 1)
      {
        String str5 = paramCursor.getString(paramCursor.getColumnIndex("address"));
        User localUser = this.c.a(str5);
        localParticipantInfo = this.c.a(localUser);
        j = 0;
        continue;
      }
      if (i == 5)
      {
        localParticipantInfo = this.c.a();
        j = 901;
        continue;
      }
      localParticipantInfo = null;
      j = 0;
    }
  }

  ImmutableList<Long> a(FetchMmsSmsMessagesParams paramFetchMmsSmsMessagesParams)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    SqlQueryBuilder.Expression localExpression;
    if (paramFetchMmsSmsMessagesParams.c() != null)
      localExpression = SqlQueryBuilder.d("date", Long.toString(paramFetchMmsSmsMessagesParams.c().longValue()));
    Cursor localCursor;
    while (true)
    {
      SqlQueryBuilder.Expression[] arrayOfExpression = new SqlQueryBuilder.Expression[3];
      arrayOfExpression[0] = SqlQueryBuilder.a("thread_id", Long.toString(paramFetchMmsSmsMessagesParams.a()));
      arrayOfExpression[1] = SqlQueryBuilder.a("type IN (1, 2, 5)");
      arrayOfExpression[2] = localExpression;
      SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a(arrayOfExpression);
      localCursor = this.b.getContentResolver().query(Telephony.Sms.a, MmsSmsProjections.a, localAndExpression.a(), localAndExpression.b(), "date DESC LIMIT " + (1 + paramFetchMmsSmsMessagesParams.b()));
      try
      {
        int i = localCursor.getColumnIndex("_id");
        if (!localCursor.moveToNext())
          break;
        localBuilder.b(Long.valueOf(localCursor.getLong(i)));
      }
      finally
      {
        localCursor.close();
      }
    }
    localCursor.close();
    return localBuilder.b();
  }

  ImmutableList<FetchMmsSmsThreadSummaryResult> a(FetchMmsSmsThreadListParams paramFetchMmsSmsThreadListParams)
  {
    return b(b(paramFetchMmsSmsThreadListParams));
  }

  ImmutableList<FetchMmsSmsThreadSummaryResult> a(List<Long> paramList)
  {
    return b(c(paramList));
  }

  void a(Collection<Long> paramCollection)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Integer.valueOf(1));
    this.b.getContentResolver().update(Telephony.Sms.a, localContentValues, "thread_id IN " + SqlUtil.a(paramCollection), null);
  }

  ImmutableList<Message> b(List<Long> paramList)
  {
    if (paramList.isEmpty());
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      String str = "_id IN " + SqlUtil.a(paramList);
      Cursor localCursor = this.b.getContentResolver().query(Telephony.Sms.a, MmsSmsProjections.c, str, null, "date DESC");
      try
      {
        if (localCursor.moveToNext())
          localBuilder.b(a(localCursor));
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  void b(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    this.b.getContentResolver().delete(Telephony.Sms.a, "_id=?", arrayOfString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.SmsContentResolverHandler
 * JD-Core Version:    0.6.0
 */