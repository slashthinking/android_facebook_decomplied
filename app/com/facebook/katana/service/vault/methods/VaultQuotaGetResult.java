package com.facebook.katana.service.vault.methods;

import org.json.JSONObject;

public class VaultQuotaGetResult
{
  private long a;
  private long b;

  public VaultQuotaGetResult(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.getLong("used");
    this.b = paramJSONObject.getLong("total");
  }

  public long a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultQuotaGetResult
 * JD-Core Version:    0.6.0
 */