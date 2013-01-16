package com.facebook.orca.users;

import com.facebook.common.util.TriState;
import com.facebook.orca.annotations.MeUser;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsMeUserAnEmployeeProvider
  implements Provider<TriState>
{
  private final Provider<User> a;

  @Inject
  public IsMeUserAnEmployeeProvider(@MeUser Provider<User> paramProvider)
  {
    this.a = paramProvider;
  }

  public TriState a()
  {
    User localUser = (User)this.a.b();
    TriState localTriState;
    if (localUser == null)
      localTriState = TriState.UNSET;
    while (true)
    {
      return localTriState;
      if (localUser.x())
      {
        localTriState = TriState.YES;
        continue;
      }
      localTriState = TriState.NO;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.IsMeUserAnEmployeeProvider
 * JD-Core Version:    0.6.0
 */