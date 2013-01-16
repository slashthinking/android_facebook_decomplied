package com.facebook.nearby.data;

import com.facebook.nearby.model.NearbyTopic;
import com.facebook.nearby.prefs.NearbyPrefKeys;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Provider;

public class CategorySearchHistoryManager
{
  private final OrcaSharedPreferences a;
  private final String b;
  private final CategorySearchHistoryManager.TopicSerialization c;
  private ImmutableList<NearbyTopic> d;

  public CategorySearchHistoryManager(OrcaSharedPreferences paramOrcaSharedPreferences, ObjectMapper paramObjectMapper, Provider<String> paramProvider)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = ((String)paramProvider.b());
    this.c = new CategorySearchHistoryManager.TopicSerialization(paramObjectMapper);
    this.d = b();
  }

  private ImmutableList<NearbyTopic> b()
  {
    String str = this.a.a(c(), "");
    if (!StringUtil.a(str));
    for (ImmutableList localImmutableList = ImmutableList.a(this.c.a(str)); ; localImmutableList = ImmutableList.d())
      return localImmutableList;
  }

  private PrefKey c()
  {
    return (PrefKey)NearbyPrefKeys.a.c("category_history/" + this.b);
  }

  public ImmutableList<NearbyTopic> a()
  {
    return this.d;
  }

  public void a(NearbyTopic paramNearbyTopic)
  {
    ImmutableList.Builder localBuilder = new ImmutableList.Builder();
    localBuilder.b(paramNearbyTopic);
    Iterator localIterator = this.d.iterator();
    int j;
    for (int i = 1; ; i = j)
    {
      if (localIterator.hasNext())
      {
        NearbyTopic localNearbyTopic = (NearbyTopic)localIterator.next();
        if (!localNearbyTopic.equals(paramNearbyTopic))
        {
          localBuilder.b(localNearbyTopic);
          j = i + 1;
          if (j != 10)
            continue;
        }
      }
      else
      {
        this.d = localBuilder.b();
        this.a.b().a(c(), this.c.a(this.d)).a();
        return;
      }
      j = i;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.data.CategorySearchHistoryManager
 * JD-Core Version:    0.6.0
 */