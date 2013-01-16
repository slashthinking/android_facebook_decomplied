package com.facebook.widget;

import android.widget.AbsListView.OnScrollListener;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.app.UserInteractionListener;
import com.google.common.base.Preconditions;

public abstract class ListViewPreloader
{
  public static final ListViewPreloader.PreloadDirection b = ListViewPreloader.PreloadDirection.CLOSEST_FIRST;
  public static final ListViewPreloader.PreloadType c = ListViewPreloader.PreloadType.ALL_OFFSCREEN;
  private final BetterListView a;
  private final UserInteractionController d;
  private final UserInteractionListener e;
  private final boolean f;
  private final AbsListView.OnScrollListener g;
  private final int h;
  private final ListViewPreloader.PreloadDirection i;
  private final ListViewPreloader.PreloadType j;
  private boolean k = false;
  private boolean l = false;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private int q = -1;

  public ListViewPreloader(BetterListView paramBetterListView, int paramInt, ListViewPreloader.PreloadDirection paramPreloadDirection, ListViewPreloader.PreloadType paramPreloadType, UserInteractionController paramUserInteractionController, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramBetterListView);
    boolean bool1;
    if (paramInt >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      boolean bool2;
      if (!paramBoolean)
      {
        bool2 = false;
        if (paramUserInteractionController == null);
      }
      else
      {
        bool2 = true;
      }
      Preconditions.checkArgument(bool2);
      Preconditions.checkNotNull(paramPreloadDirection);
      Preconditions.checkNotNull(paramPreloadType);
      this.a = paramBetterListView;
      this.h = paramInt;
      this.i = paramPreloadDirection;
      this.j = paramPreloadType;
      this.g = new ListViewPreloader.1(this);
      this.a.a(this.g);
      this.d = paramUserInteractionController;
      this.f = paramBoolean;
      if (this.f)
        break label181;
      this.e = new ListViewPreloader.2(this);
      this.d.a(this.e);
    }
    while (true)
    {
      return;
      bool1 = false;
      break;
      label181: this.e = null;
    }
  }

  private void a()
  {
    int i1;
    int i2;
    int i3;
    int i4;
    if ((this.l) && ((!this.k) || (this.f)))
    {
      if ((this.j == ListViewPreloader.PreloadType.ALL_ONSCREEN_AND_OFFSCREEN) && (this.i == ListViewPreloader.PreloadDirection.CLOSEST_FIRST))
        for (int i6 = this.n; i6 <= this.o; i6++)
          a(i6);
      i1 = Math.max(this.n - this.m, this.p - this.o);
      i2 = i1 + 1;
      if (this.i != ListViewPreloader.PreloadDirection.FURTHEST_FIRST)
        break label221;
      i3 = -1;
      i4 = 0;
    }
    while (true)
      if (i1 != i4)
      {
        if (this.n - i1 >= this.m)
          a(this.n - i1);
        if (i1 + this.o <= this.p)
          a(i1 + this.o);
        i1 += i3;
      }
      else
      {
        if ((this.j == ListViewPreloader.PreloadType.ALL_ONSCREEN_AND_OFFSCREEN) && (this.i == ListViewPreloader.PreloadDirection.FURTHEST_FIRST))
          for (int i5 = this.n; i5 <= this.o; i5++)
            a(i5);
        this.l = false;
        return;
        label221: i1 = 1;
        i3 = 1;
        i4 = i2;
      }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0);
    while (true)
    {
      return;
      if ((this.n != paramInt1) || (this.o != -1 + (paramInt1 + paramInt2)) || (this.q != paramInt3))
      {
        this.n = paramInt1;
        this.o = (-1 + (paramInt1 + paramInt2));
        this.q = paramInt3;
        int i1 = this.m;
        int i2 = this.p;
        this.m = Math.max(this.n - this.h, 0);
        this.p = Math.min(1 + (this.o + this.h), paramInt3 - 1);
        if ((this.m != i1) || (this.p != i2))
        {
          this.l = true;
          while (i1 < this.m)
          {
            if ((i1 >= 0) && (i1 < this.q))
              b(i1);
            i1++;
          }
          for (int i3 = 1 + this.p; i3 <= i2; i3++)
            if ((i3 >= 0) && (i3 < this.q))
              b(i3);
          a();
        }
      }
    }
  }

  private void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    a();
  }

  public abstract void a(int paramInt);

  public abstract void b(int paramInt);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ListViewPreloader
 * JD-Core Version:    0.6.2
 */