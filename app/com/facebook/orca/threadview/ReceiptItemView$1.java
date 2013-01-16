package com.facebook.orca.threadview;

import com.facebook.orca.common.ui.util.MessageRenderingUtil;
import com.facebook.orca.common.ui.widgets.text.RowReceiptTextView;
import com.facebook.orca.common.ui.widgets.text.RowReceiptTextView.Data;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.location.GeocodingCache;
import com.facebook.orca.location.GeocodingForMessageLocationResult;
import com.google.common.util.concurrent.FutureCallback;

class ReceiptItemView$1
  implements FutureCallback<GeocodingForMessageLocationResult>
{
  public void a(GeocodingForMessageLocationResult paramGeocodingForMessageLocationResult)
  {
    ReceiptItemView.a(this.b, null);
    String str = ReceiptItemView.a(this.b).a(paramGeocodingForMessageLocationResult.a(), paramGeocodingForMessageLocationResult.b());
    if (str != null)
    {
      ReceiptItemView.b(this.b).setData(new RowReceiptTextView.Data(str));
      ReceiptItemView.c(this.b).a(this.a, str);
    }
  }

  public void a(Throwable paramThrowable)
  {
    ReceiptItemView.a(this.b, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ReceiptItemView.1
 * JD-Core Version:    0.6.0
 */