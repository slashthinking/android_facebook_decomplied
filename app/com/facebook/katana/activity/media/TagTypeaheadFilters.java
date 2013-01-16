package com.facebook.katana.activity.media;

public class TagTypeaheadFilters
{
  private TagTypeaheadFilters.TypeaheadFilterAdapter a = null;

  public TagTypeaheadFilters(TagTypeaheadFilters.TypeaheadFilterAdapter paramTypeaheadFilterAdapter)
  {
    this.a = paramTypeaheadFilterAdapter;
  }

  public TagTypeaheadFilters.DuplicateFilter a()
  {
    return new TagTypeaheadFilters.DuplicateFilter(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.TagTypeaheadFilters
 * JD-Core Version:    0.6.0
 */