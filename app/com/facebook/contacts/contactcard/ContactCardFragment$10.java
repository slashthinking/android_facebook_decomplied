package com.facebook.contacts.contactcard;

import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ContactCardFragment$10 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    ContactCardFragment.c(this.a, null);
    ErrorDialogBuilder.a(this.a.p()).a(2131362339).b(2131362714).a();
  }

  public void a(OperationResult paramOperationResult)
  {
    ContactCardFragment.c(this.a, null);
    ContactCardFragment.a(this.a, true);
    this.a.O();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ContactCardFragment.10
 * JD-Core Version:    0.6.0
 */