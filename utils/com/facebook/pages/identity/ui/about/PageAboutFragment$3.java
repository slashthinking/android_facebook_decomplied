package com.facebook.pages.identity.ui.about;

import android.app.ProgressDialog;
import com.facebook.common.util.Toaster;
import com.facebook.composer.protocol.PostRecommendationParams;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PageRecommendation;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.identity.data.PageIdentityData;
import com.google.common.util.concurrent.FutureCallback;

class PageAboutFragment$3
  implements FutureCallback<OperationResult>
{
  PageAboutFragment$3(PageAboutFragment paramPageAboutFragment, ProgressDialog paramProgressDialog, PostRecommendationParams paramPostRecommendationParams)
  {
  }

  public void a(OperationResult paramOperationResult)
  {
    this.a.dismiss();
    PageRecommendation localPageRecommendation = new PageRecommendation(paramOperationResult.f(), System.currentTimeMillis(), PageAboutFragment.a(this.c), new GraphQLTextWithEntities(this.b.b), PageAboutFragment.b(this.c).x());
    PageAboutFragment.c(this.c).a(localPageRecommendation);
    Toaster.a(this.c.p(), this.c.e(2131361875));
  }

  public void a(Throwable paramThrowable)
  {
    this.a.dismiss();
    Toaster.a(this.c.p(), this.c.e(2131361876));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageAboutFragment.3
 * JD-Core Version:    0.6.2
 */