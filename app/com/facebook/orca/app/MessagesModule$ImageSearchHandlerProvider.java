package com.facebook.orca.app;

import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.images.ImageSearchHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.ApiResponseChecker;

class MessagesModule$ImageSearchHandlerProvider extends AbstractProvider<ImageSearchHandler>
{
  private MessagesModule$ImageSearchHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public ImageSearchHandler a()
  {
    return new ImageSearchHandler((OrcaHttpRequestProcessor)b(OrcaHttpRequestProcessor.class), (ApiResponseChecker)b(ApiResponseChecker.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ImageSearchHandlerProvider
 * JD-Core Version:    0.6.0
 */