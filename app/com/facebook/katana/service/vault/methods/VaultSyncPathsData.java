package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import java.util.List;

public class VaultSyncPathsData
  implements JMStaticKeysDictDestination
{

  @JMAutogen.ListType(b={VaultSyncPathObject.class}, jsonFieldName="data")
  public List<VaultSyncPathObject> paths = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultSyncPathsData
 * JD-Core Version:    0.6.0
 */