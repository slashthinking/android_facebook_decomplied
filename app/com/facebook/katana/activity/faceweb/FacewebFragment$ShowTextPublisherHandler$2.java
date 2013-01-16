package com.facebook.katana.activity.faceweb;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.katana.util.Utils;
import com.facebook.katana.webview.FacebookWebView;

class FacewebFragment$ShowTextPublisherHandler$2
  implements TextView.OnEditorActionListener
{
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramTextView.getText().toString().trim().length() > 0))
    {
      this.b.a(this.a, paramTextView);
      paramTextView.setText(new char[0], 0, 0);
      Utils.b(this.b.d.n());
    }
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowTextPublisherHandler.2
 * JD-Core Version:    0.6.0
 */