package com.facebook.orca.app;

import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.database.DbSendHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.WebServiceHandler;
import com.facebook.orca.send.SendServiceHandler;
import com.facebook.orca.sms.MmsSmsServiceHandler;

class MessagesModule$SendServiceHandlerProvider extends AbstractProvider<SendServiceHandler>
{
  private MessagesModule$SendServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public SendServiceHandler a()
  {
    return new SendServiceHandler((ThreadDisplayCache)b(ThreadDisplayCache.class), (ThreadsCache)b(ThreadsCache.class), (OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), (DbSendHandler)b(DbSendHandler.class), (MmsSmsServiceHandler)b(MmsSmsServiceHandler.class), (WebServiceHandler)b(WebServiceHandler.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.SendServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */