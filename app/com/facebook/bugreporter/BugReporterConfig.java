package com.facebook.bugreporter;

import com.facebook.bugreporter.tasklist.TagInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public abstract interface BugReporterConfig
{
  public abstract boolean a();

  public abstract ImmutableSet<Long> b();

  public abstract ImmutableList<TagInfo> c();

  public abstract ImmutableSet<Long> d();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporterConfig
 * JD-Core Version:    0.6.0
 */