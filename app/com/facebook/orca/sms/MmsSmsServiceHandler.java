package com.facebook.orca.sms;

import android.os.Bundle;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.AbstractOrcaServiceHandlerFilter;
import com.facebook.orca.server.CreateThreadParams;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.server.FetchMoreMessagesParams;
import com.facebook.orca.server.FetchMoreThreadsParams;
import com.facebook.orca.server.FetchMultipleThreadsParams;
import com.facebook.orca.server.FetchMultipleThreadsResult;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.MarkThreadParams.Mark;
import com.facebook.orca.server.ModifyThreadParams;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagingIdUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class MmsSmsServiceHandler extends AbstractOrcaServiceHandlerFilter
  implements OrcaServiceHandler
{
  private static final Class<?> a = MmsSmsServiceHandler.class;
  private final MmsSmsFetchThreadsHandler b;
  private final MmsSmsFetchThreadHandler c;
  private final MmsSmsSendMessageHandler d;
  private final MmsSmsContentResolverHandler e;
  private final OrcaSharedPreferences f;
  private final MmsSmsLogger g;

  public MmsSmsServiceHandler(MmsSmsFetchThreadsHandler paramMmsSmsFetchThreadsHandler, MmsSmsFetchThreadHandler paramMmsSmsFetchThreadHandler, MmsSmsSendMessageHandler paramMmsSmsSendMessageHandler, MmsSmsContentResolverHandler paramMmsSmsContentResolverHandler, OrcaSharedPreferences paramOrcaSharedPreferences, MmsSmsLogger paramMmsSmsLogger)
  {
    super("MmsSmsServiceHandler");
    this.b = paramMmsSmsFetchThreadsHandler;
    this.c = paramMmsSmsFetchThreadHandler;
    this.d = paramMmsSmsSendMessageHandler;
    this.e = paramMmsSmsContentResolverHandler;
    this.f = paramOrcaSharedPreferences;
    this.g = paramMmsSmsLogger;
  }

  protected OperationResult A(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Tracer localTracer = Tracer.a("MmsSmsServiceHandler.handleFetchMultipleThreads");
    ImmutableList.Builder localBuilder;
    try
    {
      FetchMultipleThreadsParams localFetchMultipleThreadsParams = (FetchMultipleThreadsParams)paramOperationParams.b().getParcelable("fetchMultipleThreadsParams");
      localBuilder = ImmutableList.e();
      Iterator localIterator = localFetchMultipleThreadsParams.b().iterator();
      while (localIterator.hasNext())
      {
        FetchThreadParams localFetchThreadParams = (FetchThreadParams)localIterator.next();
        localBuilder.b(this.c.a(localFetchThreadParams));
      }
    }
    finally
    {
      localTracer.a();
    }
    OperationResult localOperationResult = OperationResult.a(new FetchMultipleThreadsResult(localBuilder.b()));
    localTracer.a();
    return localOperationResult;
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Tracer localTracer = Tracer.a("MmsSmsServiceHandler");
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
    Message localMessage = (Message)paramOperationParams.b().getParcelable("outgoingMessage");
    return OperationResult.a(this.d.a(localMessage));
  }

  protected OperationResult c(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Tracer localTracer = Tracer.a("MmsSmsServiceHandler.handleFetchThreadList");
    try
    {
      FetchThreadListParams localFetchThreadListParams = (FetchThreadListParams)paramOperationParams.b().getParcelable("fetchThreadListParams");
      OperationResult localOperationResult = OperationResult.a(this.b.a(localFetchThreadListParams));
      return localOperationResult;
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }

  protected OperationResult d(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Tracer localTracer = Tracer.a("MmsSmsServiceHandler.handleFetchMoreThreads");
    try
    {
      FetchMoreThreadsParams localFetchMoreThreadsParams = (FetchMoreThreadsParams)paramOperationParams.b().getParcelable("fetchMoreThreadsParams");
      OperationResult localOperationResult = OperationResult.a(this.b.a(localFetchMoreThreadsParams));
      return localOperationResult;
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }

  protected OperationResult e(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Tracer localTracer = Tracer.a("MmsSmsServiceHandler.handleFetchThread");
    try
    {
      FetchThreadParams localFetchThreadParams = (FetchThreadParams)paramOperationParams.b().getParcelable("fetchThreadParams");
      OperationResult localOperationResult = OperationResult.a(this.c.a(localFetchThreadParams));
      return localOperationResult;
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }

  protected OperationResult f(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    CreateThreadParams localCreateThreadParams = (CreateThreadParams)paramOperationParams.b().getParcelable("createThreadParams");
    boolean bool = false;
    try
    {
      FetchThreadResult localFetchThreadResult = this.d.a(localCreateThreadParams);
      bool = true;
      OperationResult localOperationResult = OperationResult.a(localFetchThreadResult);
      return localOperationResult;
    }
    finally
    {
      this.g.a(localCreateThreadParams.d().size(), bool);
    }
    throw localObject;
  }

  protected OperationResult j(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    MarkThreadParams localMarkThreadParams = (MarkThreadParams)paramOperationParams.b().getParcelable("markThreadParams");
    String str = localMarkThreadParams.a();
    if ((localMarkThreadParams.b() == MarkThreadParams.Mark.READ) && (localMarkThreadParams.c()))
    {
      long l = MessagingIdUtil.c(str);
      this.e.c(l);
    }
    return OperationResult.b();
  }

  protected OperationResult m(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    String str = ((DeleteThreadParams)paramOperationParams.b().getParcelable("deleteThreadParams")).a();
    long l = MessagingIdUtil.c(str);
    boolean bool = false;
    try
    {
      this.e.d(l);
      bool = true;
      OperationResult localOperationResult = OperationResult.b();
      return localOperationResult;
    }
    finally
    {
      this.g.b(str, bool);
    }
    throw localObject;
  }

  // ERROR //
  protected OperationResult n(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 58	com/facebook/orca/server/OperationParams:b	()Landroid/os/Bundle;
    //   4: ldc 248
    //   6: invokevirtual 66	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   9: checkcast 250	com/facebook/orca/server/DeleteMessagesParams
    //   12: invokevirtual 253	com/facebook/orca/server/DeleteMessagesParams:b	()Lcom/google/common/collect/ImmutableSet;
    //   15: invokevirtual 256	com/google/common/collect/ImmutableSet:iterator	()Ljava/util/Iterator;
    //   18: astore_3
    //   19: iconst_0
    //   20: istore 4
    //   22: aload_3
    //   23: invokeinterface 86 1 0
    //   28: ifeq +84 -> 112
    //   31: aload_3
    //   32: invokeinterface 90 1 0
    //   37: checkcast 124	java/lang/String
    //   40: astore 5
    //   42: aload_0
    //   43: getfield 40	com/facebook/orca/sms/MmsSmsServiceHandler:e	Lcom/facebook/orca/sms/MmsSmsContentResolverHandler;
    //   46: aload 5
    //   48: invokevirtual 258	com/facebook/orca/sms/MmsSmsContentResolverHandler:c	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 44	com/facebook/orca/sms/MmsSmsServiceHandler:g	Lcom/facebook/orca/sms/MmsSmsLogger;
    //   55: aload 5
    //   57: iconst_1
    //   58: invokevirtual 260	com/facebook/orca/sms/MmsSmsLogger:c	(Ljava/lang/String;Z)V
    //   61: iload 4
    //   63: istore 9
    //   65: iload 9
    //   67: istore 4
    //   69: goto -47 -> 22
    //   72: astore 7
    //   74: iload 4
    //   76: iconst_1
    //   77: iadd
    //   78: istore 8
    //   80: aload_0
    //   81: getfield 44	com/facebook/orca/sms/MmsSmsServiceHandler:g	Lcom/facebook/orca/sms/MmsSmsLogger;
    //   84: aload 5
    //   86: iconst_0
    //   87: invokevirtual 260	com/facebook/orca/sms/MmsSmsLogger:c	(Ljava/lang/String;Z)V
    //   90: iload 8
    //   92: istore 9
    //   94: goto -29 -> 65
    //   97: astore 6
    //   99: aload_0
    //   100: getfield 44	com/facebook/orca/sms/MmsSmsServiceHandler:g	Lcom/facebook/orca/sms/MmsSmsLogger;
    //   103: aload 5
    //   105: iconst_0
    //   106: invokevirtual 260	com/facebook/orca/sms/MmsSmsLogger:c	(Ljava/lang/String;Z)V
    //   109: aload 6
    //   111: athrow
    //   112: iload 4
    //   114: ifle +14 -> 128
    //   117: new 246	java/lang/Exception
    //   120: dup
    //   121: ldc_w 262
    //   124: invokespecial 263	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: invokestatic 232	com/facebook/orca/server/OperationResult:b	()Lcom/facebook/orca/server/OperationResult;
    //   131: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   42	51	72	java/lang/Exception
    //   42	51	97	finally
  }

  protected OperationResult o(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    ModifyThreadParams localModifyThreadParams = (ModifyThreadParams)paramOperationParams.b().getParcelable("modifyThreadParams");
    FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).a(ThreadCriteria.a(localModifyThreadParams.a())).a(2).h();
    return OperationResult.a(this.c.a(localFetchThreadParams));
  }

  protected OperationResult q(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    OrcaSharedPreferences.Editor localEditor = this.f.b();
    localEditor.a(MessagesPrefKeys.e, System.currentTimeMillis());
    localEditor.a();
    return OperationResult.b();
  }

  protected OperationResult v(OperationParams paramOperationParams, OrcaServiceHandler paramOrcaServiceHandler)
  {
    Tracer localTracer = Tracer.a("MmsSmsServiceHandler.handleFetchMoreMessages");
    try
    {
      FetchMoreMessagesParams localFetchMoreMessagesParams = (FetchMoreMessagesParams)paramOperationParams.b().getParcelable("fetchMoreMessagesParams");
      OperationResult localOperationResult = OperationResult.a(this.c.a(localFetchMoreMessagesParams));
      return localOperationResult;
    }
    finally
    {
      localTracer.a();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsServiceHandler
 * JD-Core Version:    0.6.0
 */