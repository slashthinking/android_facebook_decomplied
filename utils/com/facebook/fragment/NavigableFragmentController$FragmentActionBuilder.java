package com.facebook.fragment;

import android.content.Intent;

public class NavigableFragmentController$FragmentActionBuilder
{
  Intent a;

  public NavigableFragmentController$FragmentActionBuilder(Class<? extends NavigableFragment> paramClass)
  {
    this.a = new Intent("com.facebook.fragment.FRAGMENT_ACTION").setClassName(paramClass.getPackage().getName(), paramClass.getName());
  }

  public FragmentActionBuilder a()
  {
    this.a.putExtra("com.facebook.fragment.PUSH_BACK_STACK", true);
    return this;
  }

  public FragmentActionBuilder b()
  {
    this.a.putExtra("com.facebook.fragment.CLEAR_BACK_STACK", true);
    return this;
  }

  public Intent c()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder
 * JD-Core Version:    0.6.2
 */