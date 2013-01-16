package com.facebook.composer.service;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.common.util.Toaster;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.protocol.PublishPostParams;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ComposerPublishService$2 extends OperationResultFutureCallback
{
  ComposerPublishService$2(ComposerPublishService paramComposerPublishService, String paramString, PublishPostParams paramPublishPostParams)
  {
  }

  protected void a(ServiceException paramServiceException)
  {
    String str = ComposerPublishService.b(this.c).a(paramServiceException, true, true);
    Toaster.a(ComposerPublishService.c(this.c), str);
    HoneyClientEvent localHoneyClientEvent = ComposerAnalyticsEventBuilder.b().a(paramServiceException.a()).c(str).a(this.a).a(this.b.a()).b(this.b.b()).c();
    ComposerPublishService.d(this.c).a(localHoneyClientEvent);
  }

  public void a(OperationResult paramOperationResult)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.service.ComposerPublishService.2
 * JD-Core Version:    0.6.2
 */