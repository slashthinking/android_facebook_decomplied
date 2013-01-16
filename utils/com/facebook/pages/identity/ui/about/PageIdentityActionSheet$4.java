package com.facebook.pages.identity.ui.about;

import android.widget.Button;
import android.widget.Toast;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.identity.data.PageIdentityData;

class PageIdentityActionSheet$4 extends OperationResultFutureCallback
{
  PageIdentityActionSheet$4(PageIdentityActionSheet paramPageIdentityActionSheet, boolean paramBoolean)
  {
  }

  protected void a(ServiceException paramServiceException)
  {
    PageIdentityActionSheet.h(this.b).setSelected(PageIdentityActionSheet.g(this.b).h());
    int i;
    if (this.a)
      i = 2131361882;
    for (String str = "page_identity_like_fail"; ; str = "page_identity_unlike_fail")
    {
      Toast.makeText(this.b.getContext(), i, 1).show();
      PageIdentityActionSheet.i(this.b).a(str, paramServiceException.getMessage(), paramServiceException, false);
      return;
      i = 2131361883;
    }
  }

  public void a(OperationResult paramOperationResult)
  {
    PageIdentityActionSheet.g(this.b).a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityActionSheet.4
 * JD-Core Version:    0.6.2
 */