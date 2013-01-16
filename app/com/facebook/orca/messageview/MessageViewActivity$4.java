package com.facebook.orca.messageview;

import android.widget.TextView;
import com.facebook.orca.common.ui.util.MessageRenderingUtil;
import com.facebook.orca.location.GeocodingForMessageLocationResult;
import com.google.common.util.concurrent.FutureCallback;

class MessageViewActivity$4
  implements FutureCallback<GeocodingForMessageLocationResult>
{
  public void a(GeocodingForMessageLocationResult paramGeocodingForMessageLocationResult)
  {
    MessageViewActivity.a(this.a, null);
    String str = MessageViewActivity.d(this.a).a(paramGeocodingForMessageLocationResult.a(), paramGeocodingForMessageLocationResult.b());
    if (str != null)
      MessageViewActivity.e(this.a).setText(str);
  }

  public void a(Throwable paramThrowable)
  {
    MessageViewActivity.a(this.a, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageViewActivity.4
 * JD-Core Version:    0.6.0
 */