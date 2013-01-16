package com.facebook.orca.compose;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.orca.attachments.AudioRecorder;

class AudioComposerView$2
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    switch (paramMotionEvent.getAction())
    {
    default:
      i = 0;
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      return i;
      if (AudioComposerView.d(this.a).b())
        continue;
      AudioComposerView.e(this.a);
      continue;
      AudioComposerView.a(this.a, paramMotionEvent);
      continue;
      AudioComposerView.b(this.a, paramMotionEvent);
      continue;
      AudioComposerView.f(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.AudioComposerView.2
 * JD-Core Version:    0.6.0
 */