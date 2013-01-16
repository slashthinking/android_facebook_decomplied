package com.facebook.orca.sms;

import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.inject.AbstractProvider;

class MmsSmsModule$MmsContentResolverHandlerProvider extends AbstractProvider<MmsContentResolverHandler>
{
  private MmsSmsModule$MmsContentResolverHandlerProvider(MmsSmsModule paramMmsSmsModule)
  {
  }

  public MmsContentResolverHandler a()
  {
    return new MmsContentResolverHandler(MmsSmsModule.a(this.a), (MmsSmsUserUtils)b(MmsSmsUserUtils.class), (MediaAttachmentUtil)b(MediaAttachmentUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsModule.MmsContentResolverHandlerProvider
 * JD-Core Version:    0.6.0
 */