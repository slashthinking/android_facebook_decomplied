package com.facebook.orca.threadview.upsell;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.contacts.models.ContactSummary;

class MergedThreadsUpsellController$1
  implements LoaderManager.LoaderCallbacks<ContactSummary>
{
  public Loader<ContactSummary> a(int paramInt, Bundle paramBundle)
  {
    return new MergedThreadsUpsellLoader(MergedThreadsUpsellController.a(this.c), this.a, this.b);
  }

  public void a(Loader<ContactSummary> paramLoader)
  {
  }

  public void a(Loader<ContactSummary> paramLoader, ContactSummary paramContactSummary)
  {
    MergedThreadsUpsellController.a(this.c, paramContactSummary);
    if (paramContactSummary != ContactSummary.a)
      MergedThreadsUpsellController.b(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.upsell.MergedThreadsUpsellController.1
 * JD-Core Version:    0.6.0
 */