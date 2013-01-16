package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VaultAllImagesGetResult
  implements JMStaticKeysDictDestination
{

  @JMAutogen.ListType(b={VaultImageResultObject.class}, jsonFieldName="data")
  public List<VaultImageResultObject> data = null;

  @JMAutogen.InferredType(jsonFieldName="paging")
  public Map<String, String> paging = Collections.emptyMap();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultAllImagesGetResult
 * JD-Core Version:    0.6.0
 */