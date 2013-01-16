package com.facebook.facedetection;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class FaceDetectionPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("fd/");
  public static final PrefKey b = (PrefKey)a.c("block_fd_until_time");
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.FaceDetectionPrefKeys
 * JD-Core Version:    0.6.2
 */