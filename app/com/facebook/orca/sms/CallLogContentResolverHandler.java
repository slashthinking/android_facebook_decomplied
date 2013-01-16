package com.facebook.orca.sms;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog.Calls;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableList<Ljava.lang.Long;>;
import java.util.Iterator;
import java.util.List;

public class CallLogContentResolverHandler
{
  private static final Class<?> a = CallLogContentResolverHandler.class;
  private static final String[] b = { "_id", "date", "number", "type" };
  private Context c;
  private MmsSmsUserUtils d;

  public CallLogContentResolverHandler(Context paramContext, MmsSmsUserUtils paramMmsSmsUserUtils)
  {
    this.c = paramContext;
    this.d = paramMmsSmsUserUtils;
  }

  private Message a(Cursor paramCursor, String paramString)
  {
    String str1 = MessagingIdUtil.d(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("number"));
    User localUser = this.d.a(str2);
    int i = paramCursor.getInt(paramCursor.getColumnIndex("type"));
    ParticipantInfo localParticipantInfo1;
    String str3;
    int j;
    ParticipantInfo localParticipantInfo2;
    if ((i == 1) || (i == 3))
    {
      localParticipantInfo1 = this.d.a(localUser);
      if (i == 1)
      {
        Context localContext2 = this.c;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localParticipantInfo1.d();
        str3 = localContext2.getString(2131362730, arrayOfObject2);
        j = 100;
        localParticipantInfo2 = localParticipantInfo1;
      }
    }
    while (true)
    {
      long l1 = paramCursor.getLong(paramCursor.getColumnIndex("date"));
      long l2 = 1000000L * l1;
      return new MessageBuilder().a(str1).b(paramString).d(str3).a(j).a(localParticipantInfo2).a(l1).c(l2).a(false).f("call log").a(Message.ChannelSource.CALL_LOG).v();
      if (i == 3)
      {
        Context localContext1 = this.c;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localParticipantInfo1.d();
        str3 = localContext1.getString(2131362731, arrayOfObject1);
        j = 101;
        localParticipantInfo2 = localParticipantInfo1;
        continue;
        if (i == 2)
        {
          localParticipantInfo2 = this.d.a();
          j = 102;
          ParticipantInfo localParticipantInfo3 = this.d.a(localUser);
          Context localContext3 = this.c;
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = localParticipantInfo3.d();
          str3 = localContext3.getString(2131362732, arrayOfObject3);
          continue;
        }
        localParticipantInfo2 = null;
        j = 0;
        str3 = null;
        continue;
      }
      localParticipantInfo2 = localParticipantInfo1;
      j = 0;
      str3 = null;
    }
  }

  ImmutableList<Long> a(FetchMmsSmsMessagesParams paramFetchMmsSmsMessagesParams, ImmutableList<User> paramImmutableList)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramImmutableList.iterator();
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      User localUser = (User)localIterator.next();
      boolean bool;
      label49: Object localObject3;
      if (localUser.a() == User.Type.PHONE_NUMBER)
      {
        bool = true;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localUser.a();
        Preconditions.checkArgument(bool, "Expecting User of type PHONE_NUMBER, was given User of type %s", arrayOfObject);
        localObject3 = SqlQueryBuilder.a("PHONE_NUMBERS_EQUAL(number, " + localUser.b() + ", 1)");
        if (localObject1 != null)
          break label124;
      }
      while (true)
      {
        localObject1 = localObject3;
        break;
        bool = false;
        break label49;
        label124: localObject3 = SqlQueryBuilder.b(new SqlQueryBuilder.Expression[] { localObject1, localObject3 });
      }
    }
    long l;
    if (paramFetchMmsSmsMessagesParams.c() != null)
      l = paramFetchMmsSmsMessagesParams.c().longValue();
    Cursor localCursor;
    while (true)
    {
      SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a(new SqlQueryBuilder.Expression[] { SqlQueryBuilder.d("date", Long.toString(l)), localObject1 });
      String str = " LIMIT " + (1 + paramFetchMmsSmsMessagesParams.b());
      localCursor = this.c.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[] { "_id" }, localAndExpression.a(), localAndExpression.b(), "date DESC" + str);
      try
      {
        if (!localCursor.moveToNext())
          break;
        localBuilder.b(Long.valueOf(localCursor.getLong(localCursor.getColumnIndex("_id"))));
      }
      finally
      {
        localCursor.close();
      }
    }
    localCursor.close();
    return (ImmutableList<Long>)localBuilder.b();
  }

  ImmutableList<Message> a(List<Long> paramList, String paramString)
  {
    if (paramList.isEmpty());
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      Cursor localCursor = this.c.getContentResolver().query(CallLog.Calls.CONTENT_URI, b, "_id IN " + SqlUtil.a(paramList), null, "date DESC");
      try
      {
        if (localCursor.moveToNext())
          localBuilder.b(a(localCursor, paramString));
      }
      finally
      {
        localCursor.close();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.CallLogContentResolverHandler
 * JD-Core Version:    0.6.0
 */