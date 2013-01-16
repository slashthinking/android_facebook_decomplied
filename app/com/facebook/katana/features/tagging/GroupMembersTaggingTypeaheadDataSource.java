package com.facebook.katana.features.tagging;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.widget.tagging.TaggingProfile;
import java.util.ArrayList;
import java.util.List;

public class GroupMembersTaggingTypeaheadDataSource
{
  private Context a;

  public GroupMembersTaggingTypeaheadDataSource(Context paramContext)
  {
    this.a = paramContext;
  }

  private ArrayList<TaggingProfile> a(GroupMembersTaggingTypeaheadDataSource.GroupQuery paramGroupQuery)
  {
    AppSession.a(this.a, true).a(new GroupMembersTaggingTypeaheadDataSource.3(this, paramGroupQuery));
    paramGroupQuery.a();
    return paramGroupQuery.b();
  }

  public List<TaggingProfile> a(CharSequence paramCharSequence, Long paramLong)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0));
    for (Object localObject = a(paramLong); ; localObject = a(new GroupMembersTaggingTypeaheadDataSource.2(this, paramLong, paramCharSequence.toString())))
      return localObject;
  }

  public List<TaggingProfile> a(Long paramLong)
  {
    return a(new GroupMembersTaggingTypeaheadDataSource.1(this, paramLong));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.GroupMembersTaggingTypeaheadDataSource
 * JD-Core Version:    0.6.0
 */