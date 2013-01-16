package com.facebook.orca.prefs;

import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class OrcaContactsPreferenceActivity$3$1 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    OrcaContactsPreferenceActivity.a(this.a.b, null);
    OrcaContactsPreferenceActivity.a(this.a.b, OrcaContactsPreferenceActivity.DeleteContactsPreferenceState.FINISHED_ERROR);
  }

  public void a(OperationResult paramOperationResult)
  {
    OrcaContactsPreferenceActivity.a(this.a.b, null);
    OrcaContactsPreferenceActivity.a(this.a.b, OrcaContactsPreferenceActivity.DeleteContactsPreferenceState.FINISHED_SUCCESS);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaContactsPreferenceActivity.3.1
 * JD-Core Version:    0.6.0
 */