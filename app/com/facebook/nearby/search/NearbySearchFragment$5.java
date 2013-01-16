package com.facebook.nearby.search;

import android.content.res.Resources;
import android.widget.EditText;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.protocol.SearchNearbyPlacesResult;
import com.facebook.nearby.ui.TypeaheadStatusView;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import java.util.concurrent.CancellationException;

class NearbySearchFragment$5 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    NearbySearchFragment.e(this.b).a(paramServiceException.getMessage(), this.a, NearbySearchFragment.d(this.b));
    BLog.e(NearbySearchFragment.a(), "Error searching nearby places", paramServiceException);
    NearbySearchFragment.f(this.b).setVisibility(0);
    NearbySearchFragment.f(this.b).a(this.b.q().getString(2131361899));
  }

  public void a(OperationResult paramOperationResult)
  {
    if (this.a.equals(NearbySearchFragment.b(this.b).getText().toString()))
    {
      NearbySearchFragment.e(this.b).d(this.a, NearbySearchFragment.d(this.b));
      NearbySearchFragment.f(this.b).setVisibility(8);
      NearbySearchFragment.a(this.b, (SearchNearbyPlacesResult)paramOperationResult.h());
    }
  }

  protected void a(CancellationException paramCancellationException)
  {
    super.a(paramCancellationException);
    NearbySearchFragment.e(this.b).c(this.a, NearbySearchFragment.d(this.b));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.NearbySearchFragment.5
 * JD-Core Version:    0.6.0
 */