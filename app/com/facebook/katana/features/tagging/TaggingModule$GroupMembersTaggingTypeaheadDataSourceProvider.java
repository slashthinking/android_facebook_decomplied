package com.facebook.katana.features.tagging;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class TaggingModule$GroupMembersTaggingTypeaheadDataSourceProvider extends AbstractProvider<GroupMembersTaggingTypeaheadDataSource>
{
  private TaggingModule$GroupMembersTaggingTypeaheadDataSourceProvider(TaggingModule paramTaggingModule)
  {
  }

  public GroupMembersTaggingTypeaheadDataSource a()
  {
    return new GroupMembersTaggingTypeaheadDataSource((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TaggingModule.GroupMembersTaggingTypeaheadDataSourceProvider
 * JD-Core Version:    0.6.0
 */