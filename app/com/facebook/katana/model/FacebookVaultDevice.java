package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class FacebookVaultDevice
  implements JMStaticKeysDictDestination
{
  public static final String SYNC_MODE_API_DEFAULT_VALUE = "WIFI_ONLY";
  public static final String SYNC_MODE_MOBILE_RADIO = "MOBILE_RADIO";
  public static final String SYNC_MODE_OFF = "OFF";
  public static final String SYNC_MODE_WIFI_ONLY = "WIFI_ONLY";

  @JMAutogen.InferredType(jsonFieldName="enabled")
  public final boolean mEnabled = false;

  @JMAutogen.InferredType(jsonFieldName="id")
  public final long mFbid = 0L;

  @JMAutogen.InferredType(jsonFieldName="identifier_value")
  public final String mIdentifier = "";

  @JMAutogen.InferredType(jsonFieldName="last_sync_time")
  public final long mLastSyncTime = 0L;

  @JMAutogen.InferredType(jsonFieldName="owner_id")
  public final long mOwnerId = 0L;

  @JMAutogen.InferredType(jsonFieldName="sync_mode")
  public final String mSyncMode = "WIFI_ONLY";

  @JMAutogen.InferredType(jsonFieldName="sync_older_photos")
  public final boolean mSyncOlderPhotos = false;

  @JMAutogen.InferredType(jsonFieldName="date_created")
  public final long mTimeCreated = 0L;

  public static boolean a(String paramString)
  {
    if ((paramString.equals("MOBILE_RADIO")) || (paramString.equals("WIFI_ONLY")));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookVaultDevice
 * JD-Core Version:    0.6.0
 */