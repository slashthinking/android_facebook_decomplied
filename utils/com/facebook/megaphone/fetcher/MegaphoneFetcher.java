package com.facebook.megaphone.fetcher;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.megaphone.api.FetchMegaphoneMethod;
import com.facebook.megaphone.constants.MegaphoneConstants;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import javax.inject.Provider;

public class MegaphoneFetcher
{
  private static final String a = MegaphoneFetcher.class.getSimpleName();
  private final FetchMegaphoneMethod b;
  private final Provider<OrcaServiceOperationFactory> c;
  private final FbErrorReporter d;
  private int e = MegaphoneConstants.a;

  public MegaphoneFetcher(FetchMegaphoneMethod paramFetchMegaphoneMethod, Provider<OrcaServiceOperationFactory> paramProvider, FbErrorReporter paramFbErrorReporter)
  {
    this.c = paramProvider;
    this.d = paramFbErrorReporter;
    this.b = paramFetchMegaphoneMethod;
  }

  public void a(int paramInt)
  {
    this.e = paramInt;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.fetcher.MegaphoneFetcher
 * JD-Core Version:    0.6.2
 */