package com.facebook.katana.service.vault.methods;

import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.katana.model.FacebookVaultDevice;
import java.util.List;

public class VaultDeviceGetResult
  implements JMStaticKeysDictDestination
{

  @JMAutogen.ListType(b={FacebookVaultDevice.class}, jsonFieldName="data")
  public List<FacebookVaultDevice> data = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultDeviceGetResult
 * JD-Core Version:    0.6.0
 */