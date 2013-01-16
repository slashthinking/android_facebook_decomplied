package com.facebook.orca.sms;

import com.facebook.orca.annotations.IsCallLogEnabled;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.threads.ThreadSnippetUtil;

class MmsSmsModule$MmsSmsContentResolverHandlerProvider extends AbstractProvider<MmsSmsContentResolverHandler>
{
  private MmsSmsModule$MmsSmsContentResolverHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsSmsContentResolverHandler a()
  {
    return new MmsSmsContentResolverHandler(MmsSmsModule.a(this.a), (SmsContentResolverHandler)b(SmsContentResolverHandler.class), (MmsContentResolverHandler)b(MmsContentResolverHandler.class), (CallLogContentResolverHandler)b(CallLogContentResolverHandler.class), (MmsSmsUserUtils)b(MmsSmsUserUtils.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (ThreadSnippetUtil)b(ThreadSnippetUtil.class), a(Boolean.class, IsCallLogEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsSmsContentResolverHandlerProvider
 * JD-Core Version:    0.6.0
 */