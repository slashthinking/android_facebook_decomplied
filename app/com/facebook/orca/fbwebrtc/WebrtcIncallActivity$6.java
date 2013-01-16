package com.facebook.orca.fbwebrtc;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class WebrtcIncallActivity$6 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    WebrtcIncallActivity.a(this.a, null);
    Class localClass = WebrtcIncallActivity.i();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(WebrtcIncallActivity.g(this.a));
    BLog.d(localClass, "Failed to fetch contact %d", arrayOfObject);
  }

  public void a(OperationResult paramOperationResult)
  {
    WebrtcIncallActivity.a(this.a, null);
    WebrtcIncallActivity.a(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcIncallActivity.6
 * JD-Core Version:    0.6.0
 */