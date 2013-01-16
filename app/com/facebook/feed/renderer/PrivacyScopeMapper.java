package com.facebook.feed.renderer;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.ipc.model.PrivacySetting;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class PrivacyScopeMapper
{
  private static final ImmutableMap<String, Integer> a = ImmutableMap.k().b("acquaintances", Integer.valueOf(2130838869)).b("close_friends", Integer.valueOf(2130838870)).b("custom", Integer.valueOf(2130838871)).b("event", Integer.valueOf(2130838872)).b("everyone", Integer.valueOf(2130838873)).b("facebook", Integer.valueOf(2130838874)).b("family", Integer.valueOf(2130838875)).b("friends", Integer.valueOf(2130838876)).b("friends_except_acquaintances", Integer.valueOf(2130838877)).b("friends_of_friends", Integer.valueOf(2130838878)).b("generic_list", Integer.valueOf(2130838880)).b("group", Integer.valueOf(2130838879)).b("list_members", Integer.valueOf(2130838880)).b("location", Integer.valueOf(2130838881)).b("only_me", Integer.valueOf(2130838882)).b("school", Integer.valueOf(2130838883)).b("school_group", Integer.valueOf(2130838883)).b("work", Integer.valueOf(2130838884)).b();
  private static final ImmutableMap<String, String> b = ImmutableMap.k().b("ALL_FRIENDS", "friends").b("CUSTOM", "custom").b("EVERYONE", "everyone").b("FRIENDS_OF_FRIENDS", "friends_of_friends").b("NETWORKS_FRIENDS", "custom").b("SELF", "only_me").b();

  public static int a(String paramString)
  {
    Integer localInteger = (Integer)a.get(paramString);
    if (localInteger == null)
      localInteger = Integer.valueOf(2130838871);
    return localInteger.intValue();
  }

  public static String a(PrivacySetting paramPrivacySetting, FbErrorReporter paramFbErrorReporter)
  {
    String str;
    if (("CUSTOM".equals(paramPrivacySetting.value)) && ("114000975315193".equals(paramPrivacySetting.objects)))
      str = "facebook";
    while (true)
    {
      return str;
      str = (String)b.get(paramPrivacySetting.value);
      if (str != null)
        continue;
      paramFbErrorReporter.a("PrivacyScopeMapperUnmappedPrivacy", "Need to map the following privacy: " + paramPrivacySetting.value, true);
      str = (String)b.get("CUSTOM");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.PrivacyScopeMapper
 * JD-Core Version:    0.6.0
 */