package com.facebook.orca.images;

import com.google.common.collect.ImmutableList;

public class MultiFetchImageParams
{
  private final ImmutableList<FetchImageParams> a;
  private final UrlImageCompositor b;

  public MultiFetchImageParams(ImmutableList<FetchImageParams> paramImmutableList, UrlImageCompositor paramUrlImageCompositor)
  {
    this.a = paramImmutableList;
    this.b = paramUrlImageCompositor;
  }

  public static boolean a(MultiFetchImageParams paramMultiFetchImageParams1, MultiFetchImageParams paramMultiFetchImageParams2)
  {
    boolean bool;
    if ((paramMultiFetchImageParams1 == null) && (paramMultiFetchImageParams2 == null))
      bool = true;
    while (true)
    {
      return bool;
      if ((paramMultiFetchImageParams1 == null) || (paramMultiFetchImageParams2 == null))
        bool = false;
      else
        bool = paramMultiFetchImageParams1.a(paramMultiFetchImageParams2);
    }
  }

  public ImmutableList<FetchImageParams> a()
  {
    return this.a;
  }

  public boolean a(MultiFetchImageParams paramMultiFetchImageParams)
  {
    int i = this.a.size();
    int j = paramMultiFetchImageParams.a.size();
    boolean bool1 = false;
    if (i != j);
    while (true)
    {
      return bool1;
      for (int k = 0; ; k++)
      {
        if (k >= this.a.size())
          break label85;
        boolean bool2 = FetchImageParams.a((FetchImageParams)this.a.get(k), (FetchImageParams)paramMultiFetchImageParams.a.get(k));
        bool1 = false;
        if (!bool2)
          break;
      }
      label85: UrlImageCompositor localUrlImageCompositor1 = this.b;
      UrlImageCompositor localUrlImageCompositor2 = paramMultiFetchImageParams.b;
      bool1 = false;
      if (localUrlImageCompositor1 == localUrlImageCompositor2)
        bool1 = true;
    }
  }

  public UrlImageCompositor b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.MultiFetchImageParams
 * JD-Core Version:    0.6.2
 */