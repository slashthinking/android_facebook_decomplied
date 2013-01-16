package com.facebook.orca.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.orca.attachments.AudioRecorder;

class AudioComposerView$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (AudioComposerView.d(this.a).b())
      AudioComposerView.d(this.a).a(false);
    if (AudioComposerView.g(this.a) != null)
      AudioComposerView.g(this.a).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.AudioComposerView.3
 * JD-Core Version:    0.6.0
 */