package com.facebook.orca.images;

import android.os.Bundle;
import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ImageSearchActivity$3 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    ImageSearchActivity.d(this.a);
  }

  public void a(OperationResult paramOperationResult)
  {
    ImageSearchActivity.a(this.a, (Bundle)paramOperationResult.h());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageSearchActivity.3
 * JD-Core Version:    0.6.0
 */