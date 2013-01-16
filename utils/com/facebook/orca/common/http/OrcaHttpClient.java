package com.facebook.orca.common.http;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;

public abstract interface OrcaHttpClient extends HttpClient
{
  public abstract CookieStore a();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpClient
 * JD-Core Version:    0.6.2
 */