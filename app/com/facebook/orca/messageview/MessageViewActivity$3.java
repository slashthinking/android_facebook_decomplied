package com.facebook.orca.messageview;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.threads.Message;
import java.util.List;

class MessageViewActivity$3 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("threadid");
    if ((MessageViewActivity.c(this.a).equals(str)) && (paramIntent.getStringArrayListExtra("message_ids").contains(MessageViewActivity.b(this.a).a())))
      this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageViewActivity.3
 * JD-Core Version:    0.6.0
 */