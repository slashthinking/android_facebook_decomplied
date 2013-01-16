package com.facebook.katana.features.tagging;

import com.facebook.katana.service.method.TaggingGraphGetSearchResponse;
import java.util.ArrayList;
import java.util.List;

abstract class TaggingTypeaheadDataSource$SearchQuery
{
  private boolean a = false;
  private final List<TaggingGraphGetSearchResponse> b = new ArrayList();

  private TaggingTypeaheadDataSource$SearchQuery(TaggingTypeaheadDataSource paramTaggingTypeaheadDataSource)
  {
  }

  public abstract void a();

  public void a(TaggingGraphGetSearchResponse paramTaggingGraphGetSearchResponse)
  {
    synchronized (this.b)
    {
      this.b.add(paramTaggingGraphGetSearchResponse);
      this.a = true;
      this.b.notify();
      return;
    }
  }

  public TaggingGraphGetSearchResponse b()
  {
    synchronized (this.b)
    {
      while (true)
      {
        boolean bool = this.a;
        if (bool)
          break;
        try
        {
          this.b.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
      return (TaggingGraphGetSearchResponse)this.b.get(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TaggingTypeaheadDataSource.SearchQuery
 * JD-Core Version:    0.6.0
 */