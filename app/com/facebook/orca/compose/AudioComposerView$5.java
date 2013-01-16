package com.facebook.orca.compose;

import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Handler;
import com.facebook.orca.attachments.AudioRecorder.RecordingCallback;
import com.facebook.orca.audio.AudioRecorderTooltipController;
import com.facebook.orca.audio.AudioRecorderTopBarController;
import com.facebook.orca.common.util.SystemClock;

class AudioComposerView$5
  implements AudioRecorder.RecordingCallback
{
  private Runnable c;

  public void a()
  {
    if (this.c != null)
      this.a.removeCallbacks(this.c);
    AudioComposerView.c(this.b);
  }

  public void a(MediaRecorder paramMediaRecorder)
  {
    AudioComposerView.b(this.b, true);
    if (AudioComposerView.i(this.b))
      AudioComposerView.b(this.b);
    AudioComposerView.j(this.b).c();
    AudioComposerView.a(this.b, SystemClock.b().a());
    this.c = new AudioComposerView.5.1(this, paramMediaRecorder);
    this.a.post(this.c);
  }

  public void a(Uri paramUri, int paramInt)
  {
    AudioComposerView.h(this.b).a(paramUri);
    this.a.removeCallbacks(this.c);
    AudioComposerView.j(this.b).a(paramInt);
    AudioComposerView.k(this.b).c();
    AudioComposerView.a(this.b, 0);
  }

  public void a(Uri paramUri, boolean paramBoolean)
  {
    this.a.removeCallbacks(this.c);
    if (paramBoolean)
      AudioComposerView.a(this.b, paramUri);
    AudioComposerView.c(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.AudioComposerView.5
 * JD-Core Version:    0.6.0
 */