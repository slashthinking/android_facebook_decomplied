package com.facebook.orca.sms;

import android.content.Context;
import android.net.ConnectivityManager;
import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsSendMessageHandlerProvider extends AbstractProvider<MmsSendMessageHandler>
{
  private MmsSmsModule$MmsSendMessageHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSendMessageHandler a()
  {
    return new MmsSendMessageHandler(MmsSmsModule.a(this.a), (MmsContentResolverHandler)b(MmsContentResolverHandler.class), (ConnectivityManager)MmsSmsModule.a(this.a).getSystemService("connectivity"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSendMessageHandlerProvider
 * JD-Core Version:    0.6.0
 */