package com.facebook.katana.features.tagging;

import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.service.method.TaggingGraphGetSearchResponse;

class TaggingTypeaheadDataSource$2 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, TaggingGraphGetSearchResponse paramTaggingGraphGetSearchResponse)
  {
    if (paramInt == 200)
      this.a.a(paramTaggingGraphGetSearchResponse);
    while (true)
    {
      return;
      this.a.a(null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TaggingTypeaheadDataSource.2
 * JD-Core Version:    0.6.0
 */