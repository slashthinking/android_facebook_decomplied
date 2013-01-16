package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.DynamicKeyDictType;
import com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.types.JMForcedString;
import com.facebook.katana.util.StringUtils.JMNulledString;
import java.util.Map;

public class FacebookApp
  implements JMStaticKeysDictDestination
{
  public static final int INVALID_ID = -1;

  @JMAutogen.InferredType(jsonFieldName="app_id")
  public final long mAppId;

  @JMAutogen.DynamicKeyDictType(jsonFieldName="client_config", valueElementType=JMForcedString.class)
  public Map<String, String> mClientConfig = null;

  @JMAutogen.ExplicitType(jsonFieldName="logo_url", type=StringUtils.JMNulledString.class)
  public final String mImageUrl;

  @JMAutogen.InferredType(jsonFieldName="display_name")
  public final String mName;

  private FacebookApp()
  {
    this.mAppId = -1L;
    this.mName = null;
    this.mImageUrl = null;
  }

  public FacebookApp(long paramLong, String paramString1, String paramString2)
  {
    this.mAppId = paramLong;
    this.mName = paramString1;
    this.mImageUrl = paramString2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookApp
 * JD-Core Version:    0.6.0
 */