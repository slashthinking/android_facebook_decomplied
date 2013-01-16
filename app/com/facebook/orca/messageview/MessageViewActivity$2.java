package com.facebook.orca.messageview;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.orca.common.util.LocationUtils;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;

class MessageViewActivity$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Coordinates localCoordinates = MessageViewActivity.b(this.a).k();
    Uri localUri = LocationUtils.a(MessageViewActivity.b(this.a).f().d(), localCoordinates.b(), localCoordinates.c());
    if (localUri == null);
    while (true)
    {
      return;
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(localUri);
      this.a.startActivity(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageViewActivity.2
 * JD-Core Version:    0.6.0
 */