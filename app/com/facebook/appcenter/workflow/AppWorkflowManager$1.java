package com.facebook.appcenter.workflow;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

class AppWorkflowManager$1
  implements AppWorkflowManager.IWorkflowDisplayStateListener
{
  public void a(String paramString, AppWorkflowManager.DisplayState paramDisplayState)
  {
    Intent localIntent = new Intent("com.facebook.appcenter.workflow.display_state_update");
    localIntent.putExtra("appId", paramString);
    localIntent.putExtra("text", AppWorkflowManager.a(this.a).getString(paramDisplayState.textId));
    localIntent.putExtra("enabled", paramDisplayState.enabled);
    LocalBroadcastManager.a(AppWorkflowManager.a(this.a)).a(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppWorkflowManager.1
 * JD-Core Version:    0.6.0
 */