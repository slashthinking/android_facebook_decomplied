package com.facebook.orca.contacts.favorites;

import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class EditFavoritesActivity$8 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    EditFavoritesActivity.a(this.a, null);
    EditFavoritesActivity.g(this.a).b();
    EditFavoritesActivity.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    EditFavoritesActivity.a(this.a, null);
    EditFavoritesActivity.g(this.a).b();
    EditFavoritesActivity.a(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.EditFavoritesActivity.8
 * JD-Core Version:    0.6.0
 */