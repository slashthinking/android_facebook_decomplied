package com.facebook.orca.attachments;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.widget.Toast;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.file.TempFileManager;
import com.facebook.orca.media.MediaResource;
import com.google.common.base.Preconditions;
import java.io.File;

public class AudioRecorder
{
  private final AudioManager a;
  private final MediaAttachmentFactory b;
  private final Context c;
  private final Handler d;
  private final AudioRecorder.FocusChangeListener e;
  private final Runnable f;
  private final AndroidThreadUtil g;
  private final TempFileManager h;
  private AudioRecorder.PrepareAndStartRecorderTask i;
  private AudioRecorder.RecordingCallback j;
  private long k;
  private long l;

  public AudioRecorder(Context paramContext, MediaAttachmentFactory paramMediaAttachmentFactory, AndroidThreadUtil paramAndroidThreadUtil, TempFileManager paramTempFileManager)
  {
    this.c = paramContext;
    this.b = paramMediaAttachmentFactory;
    this.g = paramAndroidThreadUtil;
    this.h = paramTempFileManager;
    this.a = ((AudioManager)paramContext.getSystemService("audio"));
    this.d = new Handler();
    this.e = new AudioRecorder.FocusChangeListener(this, null);
    this.f = new AudioRecorder.1(this);
  }

  private Uri d()
  {
    this.g.a();
    this.d.removeCallbacks(this.f);
    f();
    AudioRecorder.PrepareAndStartRecorderTask localPrepareAndStartRecorderTask = this.i;
    Uri localUri = null;
    if (localPrepareAndStartRecorderTask == null);
    while (true)
    {
      return localUri;
      if (this.i.getStatus() != AsyncTask.Status.FINISHED)
      {
        this.i.cancel(true);
        this.i = null;
        localUri = null;
        continue;
      }
      Preconditions.checkNotNull(this.i);
      AudioRecorder.PrepareAndStartRecorderTask.a(this.i);
      Uri.Builder localBuilder = Uri.fromFile(this.i.a()).buildUpon().scheme("file");
      this.i = null;
      localUri = localBuilder.build();
    }
  }

  private void e()
  {
    this.k = SystemClock.b().a();
    this.l = 0L;
  }

  private void f()
  {
    this.l = (SystemClock.b().a() - this.k);
    this.k = 0L;
  }

  public MediaAttachment a(Uri paramUri, long paramLong)
  {
    MediaResource localMediaResource = MediaResource.a(paramUri, paramLong);
    MediaAttachment localMediaAttachment = this.b.b(localMediaResource);
    if (localMediaAttachment == null)
    {
      BLog.e("orca:AudioRecorder", "audio attachment null in stop");
      Toast.makeText(this.c, this.c.getString(2131362717), 0).show();
    }
    return localMediaAttachment;
  }

  public void a()
  {
    if (!b());
    while (true)
    {
      return;
      Uri localUri = d();
      if (localUri != null)
        new File(localUri.getPath()).delete();
      this.j.a();
    }
  }

  public void a(AudioRecorder.RecordingCallback paramRecordingCallback)
  {
    if (this.i == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.g.a();
      this.j = paramRecordingCallback;
      this.i = new AudioRecorder.PrepareAndStartRecorderTask(this, null);
      this.i.execute(new Void[0]);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.j.a(d(), paramBoolean);
  }

  public boolean b()
  {
    if (this.i != null);
    for (int m = 1; ; m = 0)
      return m;
  }

  public long c()
  {
    return this.l;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AudioRecorder
 * JD-Core Version:    0.6.0
 */