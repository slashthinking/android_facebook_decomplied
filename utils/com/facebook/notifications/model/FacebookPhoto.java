package com.facebook.notifications.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class FacebookPhoto
  implements JMStaticKeysDictDestination
{
  private static final Class<?> CLSTAG = FacebookPhoto.class;
  private static final String TAG = CLSTAG.getSimpleName();

  @JMAutogen.InferredType(jsonFieldName="object_id")
  public final long objectId = 0L;

  @JMAutogen.InferredType(jsonFieldName="src")
  public final String objectPhoto = null;
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.model.FacebookPhoto
 * JD-Core Version:    0.6.2
 */