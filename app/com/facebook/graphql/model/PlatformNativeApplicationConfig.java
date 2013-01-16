package com.facebook.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PlatformNativeApplicationConfig
{

  @JsonProperty("can_deeplink")
  public final boolean canDeeplink = false;

  @JsonProperty("class_name")
  public final String className = null;

  @JsonProperty("id")
  public final String id = null;

  @JsonProperty("key_hashes")
  public final List<String> keyHashes = null;

  @JsonProperty("package_name")
  public final String packageName = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.PlatformNativeApplicationConfig
 * JD-Core Version:    0.6.0
 */