package com.facebook.orca.compose;

import android.net.Uri;
import com.google.common.base.Preconditions;

final class AudioComposerView$MaximumLengthRecording
{
  private Uri b = null;

  private AudioComposerView$MaximumLengthRecording(AudioComposerView paramAudioComposerView)
  {
  }

  public Uri a()
  {
    Preconditions.checkState(b());
    return this.b;
  }

  public void a(Uri paramUri)
  {
    if (!b());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.b = paramUri;
      return;
    }
  }

  public boolean b()
  {
    if (this.b != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void c()
  {
    this.b = null;
  }

  public void d()
  {
    AudioComposerView.a(this.a, a());
    c();
    AudioComposerView.c(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.AudioComposerView.MaximumLengthRecording
 * JD-Core Version:    0.6.0
 */