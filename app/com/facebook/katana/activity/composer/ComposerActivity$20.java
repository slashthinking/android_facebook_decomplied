package com.facebook.katana.activity.composer;

import com.facebook.common.util.Toaster;
import com.facebook.composer.model.LinksPreview;
import com.facebook.composer.model.SharePreview;
import com.facebook.graphql.model.Shareable;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class ComposerActivity$20
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    LinksPreview localLinksPreview = (LinksPreview)paramOperationResult.h();
    ComposerActivity.a(this.b, this.a, SharePreview.a(localLinksPreview));
  }

  public void a(Throwable paramThrowable)
  {
    Toaster.a(this.b.getApplicationContext(), 2131361976, 17);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.20
 * JD-Core Version:    0.6.0
 */