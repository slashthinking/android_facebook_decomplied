package com.facebook.orca.threads;

import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.annotations.IsSmsOnlyModeEnabled;
import com.facebook.orca.auth.MeUserAuthDataStore;
import javax.inject.Inject;
import javax.inject.Provider;

public class CurrentFolderTypeProvider
  implements Provider<FolderType>
{
  private final MeUserAuthDataStore a;
  private final Provider<Boolean> b;
  private final Provider<Boolean> c;

  @Inject
  public CurrentFolderTypeProvider(MeUserAuthDataStore paramMeUserAuthDataStore, @IsClientSmsEnabled Provider<Boolean> paramProvider1, @IsSmsOnlyModeEnabled Provider<Boolean> paramProvider2)
  {
    this.a = paramMeUserAuthDataStore;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public FolderType a()
  {
    FolderType localFolderType;
    if (this.a.d())
      if (((Boolean)this.b.b()).booleanValue())
        localFolderType = FolderType.e;
    while (true)
    {
      return localFolderType;
      localFolderType = FolderType.b;
      continue;
      if (((Boolean)this.c.b()).booleanValue())
      {
        localFolderType = FolderType.d;
        continue;
      }
      localFolderType = FolderType.a;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.CurrentFolderTypeProvider
 * JD-Core Version:    0.6.0
 */