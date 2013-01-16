package com.facebook.orca.threadlist;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer.OnRefreshListener;
import com.facebook.orca.debug.BLog;

class ThreadListFragment$3 extends RefreshableListViewContainer.OnRefreshListener
{
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!ThreadListFragment.a(this.a).isMusicActive()));
    try
    {
      AssetFileDescriptor localAssetFileDescriptor = this.a.q().openRawResourceFd(2131099652);
      MediaPlayer localMediaPlayer = new MediaPlayer();
      localMediaPlayer.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
      localAssetFileDescriptor.close();
      localMediaPlayer.setAudioStreamType(1);
      localMediaPlayer.setVolume(0.3F, 0.3F);
      localMediaPlayer.setOnCompletionListener(new ThreadListFragment.3.1(this));
      localMediaPlayer.prepare();
      localMediaPlayer.start();
      this.a.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        BLog.b(ThreadListFragment.L(), "MediaPlayer create failed: ", localThrowable);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListFragment.3
 * JD-Core Version:    0.6.0
 */