package com.facebook.katana.service.vault;

import com.facebook.annotations.IsMeUserAnEmployee;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.orca.inject.AbstractProvider;

class VaultModule$FbErrorReporterProvider extends AbstractProvider<FbErrorReporter>
{
  private VaultModule$FbErrorReporterProvider(VaultModule paramVaultModule)
  {
  }

  public FbErrorReporter a()
  {
    return new FbErrorReporterImpl(a(TriState.class, IsMeUserAnEmployee.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.VaultModule.FbErrorReporterProvider
 * JD-Core Version:    0.6.0
 */