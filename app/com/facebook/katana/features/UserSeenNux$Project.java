package com.facebook.katana.features;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum UserSeenNux$Project
{
  private static final Map<Long, Project> idToProject;
  public final long projectId;

  static
  {
    Project[] arrayOfProject = new Project[1];
    arrayOfProject[0] = EVENT_TAG_EXPANSION;
    $VALUES = arrayOfProject;
    idToProject = new HashMap();
    Iterator localIterator = EnumSet.allOf(Project.class).iterator();
    while (localIterator.hasNext())
    {
      Project localProject = (Project)localIterator.next();
      idToProject.put(Long.valueOf(localProject.projectId), localProject);
    }
  }

  private UserSeenNux$Project(long paramLong)
  {
    this.projectId = paramLong;
  }

  public static Project fromID(long paramLong)
  {
    return (Project)idToProject.get(Long.valueOf(paramLong));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.UserSeenNux.Project
 * JD-Core Version:    0.6.0
 */