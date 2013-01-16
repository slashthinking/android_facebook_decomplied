package com.facebook.katana.activity.faceweb;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.facebook.katana.webview.FacebookWebView;

class FacewebFragment$ShowTextPublisherHandler$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    EditText localEditText = (EditText)this.b.d.A().findViewById(2131296563);
    if (localEditText.getText().toString().trim().length() > 0)
      this.b.a(this.a, localEditText);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowTextPublisherHandler.5
 * JD-Core Version:    0.6.0
 */