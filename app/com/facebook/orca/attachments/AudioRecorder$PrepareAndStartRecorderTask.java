package com.facebook.orca.attachments;

import android.media.AudioManager;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Handler;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.file.TempFileManager;
import java.io.File;

class AudioRecorder$PrepareAndStartRecorderTask extends AsyncTask<Void, Void, AudioRecorder.RecordResult>
{
  private MediaRecorder b;
  private File c;
  private boolean d;
  private boolean e;

  private AudioRecorder$PrepareAndStartRecorderTask(AudioRecorder paramAudioRecorder)
  {
  }

  // ERROR //
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:d	Z
    //   6: istore_2
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_2
    //   10: ifne +10 -> 20
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 31	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:d	Z
    //   18: iconst_1
    //   19: istore_3
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_3
    //   23: ifeq +57 -> 80
    //   26: aload_0
    //   27: getfield 33	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:b	Landroid/media/MediaRecorder;
    //   30: invokevirtual 38	android/media/MediaRecorder:stop	()V
    //   33: aload_0
    //   34: getfield 33	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:b	Landroid/media/MediaRecorder;
    //   37: invokevirtual 41	android/media/MediaRecorder:reset	()V
    //   40: aload_0
    //   41: getfield 43	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:e	Z
    //   44: ifeq +29 -> 73
    //   47: aload_0
    //   48: getfield 18	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:a	Lcom/facebook/orca/attachments/AudioRecorder;
    //   51: invokestatic 48	com/facebook/orca/attachments/AudioRecorder:e	(Lcom/facebook/orca/attachments/AudioRecorder;)Landroid/media/AudioManager;
    //   54: aload_0
    //   55: getfield 18	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:a	Lcom/facebook/orca/attachments/AudioRecorder;
    //   58: invokestatic 51	com/facebook/orca/attachments/AudioRecorder:d	(Lcom/facebook/orca/attachments/AudioRecorder;)Lcom/facebook/orca/attachments/AudioRecorder$FocusChangeListener;
    //   61: invokevirtual 57	android/media/AudioManager:abandonAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I
    //   64: iconst_1
    //   65: if_icmpne +8 -> 73
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 43	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:e	Z
    //   73: aload_0
    //   74: getfield 33	com/facebook/orca/attachments/AudioRecorder$PrepareAndStartRecorderTask:b	Landroid/media/MediaRecorder;
    //   77: invokevirtual 60	android/media/MediaRecorder:release	()V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore 4
    //   88: ldc 62
    //   90: ldc 64
    //   92: aload 4
    //   94: invokestatic 69	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: goto -17 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   2	22	81	finally
    //   82	84	81	finally
    //   26	80	86	java/lang/Throwable
  }

  protected AudioRecorder.RecordResult a(Void[] paramArrayOfVoid)
  {
    this.b = new MediaRecorder();
    AudioRecorder.RecordResult localRecordResult;
    try
    {
      this.c = AudioRecorder.c(this.a).a("orca-audio-", ".mp4", Boolean.valueOf(true));
      this.b.setAudioSource(1);
      this.b.setOutputFormat(2);
      this.b.setAudioEncoder(3);
      this.b.setAudioChannels(1);
      this.b.setAudioSamplingRate(8000);
      this.b.setOutputFile(this.c.getAbsolutePath());
      if (isCancelled())
      {
        localRecordResult = AudioRecorder.RecordResult.INTERRUPTED;
      }
      else
      {
        this.b.prepare();
        if (AudioRecorder.e(this.a).requestAudioFocus(AudioRecorder.d(this.a), 0, 2) != 1)
        {
          localRecordResult = AudioRecorder.RecordResult.ERROR;
        }
        else
        {
          this.e = true;
          this.b.start();
          localRecordResult = AudioRecorder.RecordResult.SUCCESS;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      BLog.d("orca:AudioRecorder", "Recording initialization failed", localThrowable);
      localRecordResult = AudioRecorder.RecordResult.ERROR;
    }
    return localRecordResult;
  }

  File a()
  {
    return this.c;
  }

  protected void a(AudioRecorder.RecordResult paramRecordResult)
  {
    if (paramRecordResult == AudioRecorder.RecordResult.SUCCESS)
    {
      AudioRecorder.b(this.a).a(this.b);
      AudioRecorder.g(this.a).postDelayed(AudioRecorder.f(this.a), 60000L);
      AudioRecorder.h(this.a);
    }
    while (true)
    {
      return;
      if (paramRecordResult == AudioRecorder.RecordResult.ERROR)
      {
        BLog.e("orca:AudioRecorder", "Error occurred when preparing the audio recorder.");
        b();
        if (AudioRecorder.i(this.a) != this)
          continue;
        AudioRecorder.a(this.a, null);
        continue;
      }
    }
  }

  protected void onCancelled()
  {
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AudioRecorder.PrepareAndStartRecorderTask
 * JD-Core Version:    0.6.0
 */