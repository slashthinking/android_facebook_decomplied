package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class TokenRefreshRequestResponse
  implements JMStaticKeysDictDestination
{
  public static long INVALID_DATE = -1L;

  @JMAutogen.InferredType(jsonFieldName="access_token")
  public final String accessToken = null;

  @JMAutogen.InferredType(jsonFieldName="expires_at")
  public final long expiresAt = INVALID_DATE;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.TokenRefreshRequestResponse
 * JD-Core Version:    0.6.0
 */