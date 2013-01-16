package com.facebook.orca.audio;

import android.content.Context;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.media.MediaDownloader;

public class AudioMediaDownloader extends MediaDownloader
{
  public AudioMediaDownloader(Context paramContext, OrcaHttpRequestProcessor paramOrcaHttpRequestProcessor)
  {
    super(paramContext, paramOrcaHttpRequestProcessor, "audio");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioMediaDownloader
 * JD-Core Version:    0.6.0
 */