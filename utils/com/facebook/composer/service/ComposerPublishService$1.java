package com.facebook.composer.service;

import com.facebook.composer.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.protocol.PublishPostParams;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ComposerPublishService$1 extends OperationResultFutureCallback
{
  ComposerPublishService$1(ComposerPublishService paramComposerPublishService, PublishPostParams paramPublishPostParams)
  {
  }

  protected void a(ServiceException paramServiceException)
  {
    ComposerPublishService.a(this.b).a(null, this.a.a, this.a.b);
  }

  public void a(OperationResult paramOperationResult)
  {
    ComposerPublishService.a(this.b).a(paramOperationResult.f(), this.a.a, this.a.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.service.ComposerPublishService.1
 * JD-Core Version:    0.6.2
 */