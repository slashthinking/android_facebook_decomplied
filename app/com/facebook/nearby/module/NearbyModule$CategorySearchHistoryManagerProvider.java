package com.facebook.nearby.module;

import com.facebook.nearby.data.CategorySearchHistoryManager;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.fasterxml.jackson.databind.ObjectMapper;

class NearbyModule$CategorySearchHistoryManagerProvider extends AbstractProvider<CategorySearchHistoryManager>
{
  private NearbyModule$CategorySearchHistoryManagerProvider(NearbyModule paramNearbyModule)
  {
  }

  public CategorySearchHistoryManager a()
  {
    return new CategorySearchHistoryManager((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (ObjectMapper)b(ObjectMapper.class), a(String.class, MeUserId.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule.CategorySearchHistoryManagerProvider
 * JD-Core Version:    0.6.0
 */