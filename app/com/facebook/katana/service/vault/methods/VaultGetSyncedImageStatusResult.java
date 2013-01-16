package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMAutogen.DynamicKeyDictType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.google.common.collect.Maps;
import java.util.Map;

public class VaultGetSyncedImageStatusResult
  implements JMStaticKeysDictDestination
{

  @JMAutogen.DynamicKeyDictType(jsonFieldName="data", valueElementType=VaultGetSyncedImageStatus.class)
  public Map<String, VaultGetSyncedImageStatus> mResult = Maps.a();

  public Map<String, VaultGetSyncedImageStatus> a()
  {
    return this.mResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultGetSyncedImageStatusResult
 * JD-Core Version:    0.6.0
 */