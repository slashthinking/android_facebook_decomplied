package com.facebook.katana.features.composer;

import android.content.Context;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.server.utils.ParcelableBoolean;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class MinorStatusClient$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    ParcelableBoolean localParcelableBoolean = (ParcelableBoolean)paramOperationResult.h();
    this.a.a(this.b, true, this.c, String.valueOf(localParcelableBoolean.a), Boolean.valueOf(localParcelableBoolean.a));
    MinorStatusClient.a(this.d, null);
  }

  public void a(Throwable paramThrowable)
  {
    this.a.a(this.b, false, this.c, null, null);
    MinorStatusClient.a(this.d, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.MinorStatusClient.1
 * JD-Core Version:    0.6.0
 */