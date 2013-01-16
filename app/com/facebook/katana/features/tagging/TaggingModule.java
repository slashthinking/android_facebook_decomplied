package com.facebook.katana.features.tagging;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class TaggingModule extends AbstractModule
{
  protected void a()
  {
    a(TaggingTypeaheadDataSource.class).a(new TaggingModule.TaggingTypeaheadDataSourceProvider(this, null));
    a(GroupMembersTaggingTypeaheadDataSource.class).a(new TaggingModule.GroupMembersTaggingTypeaheadDataSourceProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TaggingModule
 * JD-Core Version:    0.6.0
 */