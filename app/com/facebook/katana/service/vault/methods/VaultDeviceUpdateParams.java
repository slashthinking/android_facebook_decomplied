package com.facebook.katana.service.vault.methods;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class VaultDeviceUpdateParams
{
  private final long a;
  private Long b;
  private Boolean c;
  private String d;
  private Boolean e;

  public VaultDeviceUpdateParams(long paramLong)
  {
    this.a = paramLong;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
  }

  public long a()
  {
    return this.a;
  }

  public void a(long paramLong)
  {
    this.b = Long.valueOf(paramLong);
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.c = Boolean.valueOf(paramBoolean);
  }

  public List<NameValuePair> b()
  {
    ArrayList localArrayList = Lists.a();
    if (this.b != null)
      localArrayList.add(new BasicNameValuePair("last_sync_time", this.b.toString()));
    if (this.c != null)
      localArrayList.add(new BasicNameValuePair("enabled", this.c.toString()));
    if (this.d != null)
      localArrayList.add(new BasicNameValuePair("sync_mode", this.d));
    if (this.e != null)
      localArrayList.add(new BasicNameValuePair("sync_older_photos", this.e.toString()));
    return localArrayList;
  }

  public void b(boolean paramBoolean)
  {
    this.e = Boolean.valueOf(paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultDeviceUpdateParams
 * JD-Core Version:    0.6.0
 */