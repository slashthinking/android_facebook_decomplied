package com.facebook.zero;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.zero.protocol.methods.FetchZeroTokenMethod;
import com.facebook.zero.protocol.methods.ValidateZeroTokenMethod;

class ZeroModule$ZeroTokenHandlerProvider extends AbstractProvider<ZeroTokenHandler>
{
  private ZeroModule$ZeroTokenHandlerProvider(ZeroModule paramZeroModule)
  {
  }

  public ZeroTokenHandler a()
  {
    return new ZeroTokenHandler((SingleMethodRunner)b(SingleMethodRunner.class), (FetchZeroTokenMethod)b(FetchZeroTokenMethod.class), (ValidateZeroTokenMethod)b(ValidateZeroTokenMethod.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroModule.ZeroTokenHandlerProvider
 * JD-Core Version:    0.6.2
 */