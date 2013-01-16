package com.facebook.katana.features.tagging;

import com.facebook.widget.tagging.TaggingProfile;
import java.util.ArrayList;
import java.util.List;

abstract class GroupMembersTaggingTypeaheadDataSource$GroupQuery
{
  private boolean a = false;
  private final ArrayList<TaggingProfile> b = new ArrayList();

  private GroupMembersTaggingTypeaheadDataSource$GroupQuery(GroupMembersTaggingTypeaheadDataSource paramGroupMembersTaggingTypeaheadDataSource)
  {
  }

  public abstract void a();

  public void a(List<TaggingProfile> paramList)
  {
    synchronized (this.b)
    {
      this.b.addAll(paramList);
      this.a = true;
      this.b.notify();
      return;
    }
  }

  public ArrayList<TaggingProfile> b()
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
      return this.b;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.GroupMembersTaggingTypeaheadDataSource.GroupQuery
 * JD-Core Version:    0.6.0
 */