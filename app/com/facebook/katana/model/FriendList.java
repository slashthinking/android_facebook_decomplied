package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.ipc.model.PrivacySetting;

public class FriendList
  implements JMStaticKeysDictDestination
{
  public static long INVALID_FBID = -1L;

  @JMAutogen.InferredType(jsonFieldName="flid")
  public final long flid = INVALID_FBID;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String name = null;

  @JMAutogen.InferredType(jsonFieldName="owner")
  public final long owner = INVALID_FBID;

  @JMAutogen.InferredType(jsonFieldName="type")
  public final String type = null;

  public PrivacySetting a()
  {
    return new PrivacySetting(null, "CUSTOM", this.name, Long.toString(this.flid), null, null, null, "SOME_FRIENDS");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FriendList
 * JD-Core Version:    0.6.0
 */