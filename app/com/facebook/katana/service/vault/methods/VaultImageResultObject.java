package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class VaultImageResultObject
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="date_taken")
  public String dateTaken;

  @JMAutogen.InferredType(jsonFieldName="id")
  public long fbid;

  @JMAutogen.InferredType(jsonFieldName="height")
  public int height;

  @JMAutogen.InferredType(jsonFieldName="source")
  public String uri;

  @JMAutogen.InferredType(jsonFieldName="width")
  public int width;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultImageResultObject
 * JD-Core Version:    0.6.0
 */