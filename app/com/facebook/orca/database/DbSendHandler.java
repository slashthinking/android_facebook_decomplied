package com.facebook.orca.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.Message;

public class DbSendHandler
{
  private final Class<?> a = DbSendHandler.class;
  private final ThreadsDatabaseSupplier b;
  private final DbInsertThreadsHandler c;
  private final DbFetchThreadHandler d;
  private final DbCache e;

  public DbSendHandler(ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, DbInsertThreadsHandler paramDbInsertThreadsHandler, DbFetchThreadHandler paramDbFetchThreadHandler, DbCache paramDbCache)
  {
    this.b = paramThreadsDatabaseSupplier;
    this.c = paramDbInsertThreadsHandler;
    this.d = paramDbFetchThreadHandler;
    this.e = paramDbCache;
  }

  private void b()
  {
    d(null);
  }

  private void c(String paramString)
  {
    d(paramString);
  }

  private void d(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
    localAndExpression.a(SqlQueryBuilder.a("msg_type", Integer.toString(900)));
    if (paramString != null)
      localAndExpression.a(SqlQueryBuilder.a("thread_id", paramString));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msg_type", Integer.valueOf(901));
    localSQLiteDatabase.update("messages", localContentValues, localAndExpression.a(), localAndExpression.b());
  }

  public OperationResult a(String paramString, OperationResult paramOperationResult)
  {
    NewMessageResult localNewMessageResult1 = (NewMessageResult)paramOperationResult.h();
    NewMessageResult localNewMessageResult2 = this.c.a(localNewMessageResult1);
    Message localMessage = this.d.c(paramString);
    paramOperationResult.g().putParcelable("result", localNewMessageResult2);
    paramOperationResult.g().putString("threadId", paramString);
    Bundle localBundle = paramOperationResult.g();
    if (localMessage != null);
    for (boolean bool = true; ; bool = false)
    {
      localBundle.putBoolean("hasMoreQueuedMessages", bool);
      return paramOperationResult;
    }
  }

  public Message a(String paramString)
  {
    return this.d.c(paramString);
  }

  public void a()
  {
    if (this.e.a());
    while (true)
    {
      return;
      b();
      this.e.a(true);
    }
  }

  public void b(String paramString)
  {
    c(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbSendHandler
 * JD-Core Version:    0.6.0
 */