package com.facebook.orca.compose;

import android.location.Location;
import com.facebook.orca.ops.OrcaServiceOperation.OnProgressListener;
import com.facebook.orca.server.OperationResult;

class ComposeFragment$14 extends OrcaServiceOperation.OnProgressListener
{
  public void a(OperationResult paramOperationResult)
  {
    Location localLocation = (Location)paramOperationResult.h();
    ComposeFragment.b(this.a, localLocation);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.14
 * JD-Core Version:    0.6.0
 */