package com.facebook.content;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.AbstractProvider;

class ContentModule$SecureContextHelperProvider extends AbstractProvider<SecureContextHelper>
{
  private ContentModule$SecureContextHelperProvider(ContentModule paramContentModule)
  {
  }

  public SecureContextHelper a()
  {
    return new SecureContextHelper((SecureContextHelperUtil)b(SecureContextHelperUtil.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.ContentModule.SecureContextHelperProvider
 * JD-Core Version:    0.6.0
 */