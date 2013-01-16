package com.facebook.orca.threadview;

import android.net.Uri;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.attachments.AudioPlayerBubbleView;
import com.facebook.orca.debug.BLog;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

class ThreadViewAudioAttachmentView$4
  implements FutureCallback<Uri>
{
  public void a(Uri paramUri)
  {
    if (this.a != ThreadViewAudioAttachmentView.d(this.b));
    while (true)
    {
      return;
      ThreadViewAudioAttachmentView.a(this.b, paramUri);
      this.b.a();
    }
  }

  public void a(Throwable paramThrowable)
  {
    if (this.a != ThreadViewAudioAttachmentView.d(this.b));
    while (true)
    {
      return;
      BLog.e(ThreadViewAudioAttachmentView.d(), "downloading audio failed!", paramThrowable);
      ThreadViewAudioAttachmentView.e(this.b).setIsLoading(false);
      ThreadViewAudioAttachmentView.e(this.b).setTimerText("error");
      ThreadViewAudioAttachmentView.a(this.b, ThreadViewAudioAttachmentView.AudioState.ERROR);
      ThreadViewAudioAttachmentView.f(this.b).a(new HoneyClientEvent("audio_clips_download_error").b("error_message", paramThrowable.toString()).d("audio_clips"));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewAudioAttachmentView.4
 * JD-Core Version:    0.6.0
 */