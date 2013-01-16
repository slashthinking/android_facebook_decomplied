package com.facebook.katana.features.tagging;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class TaggingModule$TaggingTypeaheadDataSourceProvider extends AbstractProvider<TaggingTypeaheadDataSource>
{
  private TaggingModule$TaggingTypeaheadDataSourceProvider(TaggingModule paramTaggingModule)
  {
  }

  public TaggingTypeaheadDataSource a()
  {
    return new TaggingTypeaheadDataSource((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TaggingModule.TaggingTypeaheadDataSourceProvider
 * JD-Core Version:    0.6.0
 */