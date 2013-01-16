package com.facebook.pages.identity.ui.about;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLPhoneNumber;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;

class PageIdentityActionSheet$3
  implements View.OnClickListener
{
  PageIdentityActionSheet$3(PageIdentityActionSheet paramPageIdentityActionSheet)
  {
  }

  public void onClick(View paramView)
  {
    if ((PageIdentityActionSheet.c(this.a) != null) && (PageIdentityActionSheet.c(this.a).universalNumber != null))
    {
      PageIdentityActionSheet.e(this.a).d(PageIdentityActionSheet.d(this.a));
      PageIdentityActionSheet.f(this.a);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityActionSheet.3
 * JD-Core Version:    0.6.2
 */