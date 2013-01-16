package com.facebook.orca.compose;

import android.location.Location;
import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ComposeFragment$13 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    ComposeFragment.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    Location localLocation = (Location)paramOperationResult.h();
    ComposeFragment.a(this.a, localLocation);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.13
 * JD-Core Version:    0.6.0
 */