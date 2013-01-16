package com.facebook.orca.send;

import android.os.Bundle;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.database.DbSendHandler;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.protocol.WebServiceHandler;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.sms.MmsSmsServiceHandler;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.users.UserKey;

public class SendServiceHandler
  implements OrcaServiceHandler
{
  private static final Class<?> a = SendServiceHandler.class;
  private final ThreadDisplayCache b;
  private final ThreadsCache c;
  private final OrcaActivityBroadcaster d;
  private final DbSendHandler e;
  private final MmsSmsServiceHandler f;
  private final WebServiceHandler g;

  public SendServiceHandler(ThreadDisplayCache paramThreadDisplayCache, ThreadsCache paramThreadsCache, OrcaActivityBroadcaster paramOrcaActivityBroadcaster, DbSendHandler paramDbSendHandler, MmsSmsServiceHandler paramMmsSmsServiceHandler, WebServiceHandler paramWebServiceHandler)
  {
    this.b = paramThreadDisplayCache;
    this.c = paramThreadsCache;
    this.d = paramOrcaActivityBroadcaster;
    this.e = paramDbSendHandler;
    this.f = paramMmsSmsServiceHandler;
    this.g = paramWebServiceHandler;
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Tracer localTracer = Tracer.a("SendServiceHandler");
    try
    {
      String str = paramOperationParams.a();
      if ("send".equals(str))
      {
        OperationResult localOperationResult = b(paramOperationParams);
        return localOperationResult;
      }
      throw new IllegalArgumentException("Unknown operation type: " + str);
    }
    finally
    {
      localTracer.a(10L);
    }
    throw localObject;
  }

  protected OperationResult b(OperationParams paramOperationParams)
  {
    this.e.a();
    Bundle localBundle = paramOperationParams.b();
    String str1 = localBundle.getString("threadId");
    UserKey localUserKey = this.b.a(str1);
    Message localMessage = this.e.a(str1);
    Object localObject3;
    if (localMessage == null)
      localObject3 = OperationResult.b();
    while (true)
    {
      return localObject3;
      String str2 = null;
      if (localUserKey != null)
        str2 = localUserKey.c();
      localBundle.putString("userKeyInCanonicalThread", str2);
      localBundle.putParcelable("outgoingMessage", localMessage);
      try
      {
        if (MessagingIdUtil.g(str1));
        OperationResult localOperationResult1;
        for (Object localObject2 = this.f.a(paramOperationParams); ; localObject2 = localOperationResult1)
        {
          OperationResult localOperationResult2 = this.e.a(str1, (OperationResult)localObject2);
          NewMessageResult localNewMessageResult = (NewMessageResult)localOperationResult2.h();
          if (localNewMessageResult != null)
            this.c.a(localNewMessageResult.b(), localNewMessageResult.c());
          this.d.b(str1);
          localObject3 = localOperationResult2;
          break;
          localOperationResult1 = this.g.a(paramOperationParams);
        }
      }
      catch (Throwable localThrowable)
      {
        this.e.b(str1);
        throw new SendServiceHandler.SendMessageException(localThrowable, localMessage, null);
      }
      finally
      {
        this.d.b(str1);
      }
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.send.SendServiceHandler
 * JD-Core Version:    0.6.0
 */