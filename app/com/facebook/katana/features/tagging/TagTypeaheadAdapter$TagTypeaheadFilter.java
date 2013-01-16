package com.facebook.katana.features.tagging;

import android.widget.Filter.FilterResults;
import com.facebook.orca.inject.FbInjector;
import java.util.List;

public class TagTypeaheadAdapter$TagTypeaheadFilter extends BaseTagTypeaheadAdapter.BaseTagTypeaheadFilter
{
  private boolean b = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  private boolean g = true;

  protected TagTypeaheadAdapter$TagTypeaheadFilter(TagTypeaheadAdapter paramTagTypeaheadAdapter)
  {
    super(paramTagTypeaheadAdapter);
  }

  public TagTypeaheadFilter a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public TagTypeaheadFilter b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public TagTypeaheadFilter c(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }

  public TagTypeaheadFilter d(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }

  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    List localList = ((TaggingTypeaheadDataSource)FbInjector.a(this.c.getContext()).a(TaggingTypeaheadDataSource.class)).a(paramCharSequence, this.b, this.d, this.e, this.f, this.g);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    localFilterResults.values = localList;
    localFilterResults.count = localList.size();
    return localFilterResults;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TagTypeaheadAdapter.TagTypeaheadFilter
 * JD-Core Version:    0.6.0
 */