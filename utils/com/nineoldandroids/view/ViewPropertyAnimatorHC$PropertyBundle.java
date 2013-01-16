package com.nineoldandroids.view;

import java.util.ArrayList;

class ViewPropertyAnimatorHC$PropertyBundle
{
  int a;
  ArrayList<ViewPropertyAnimatorHC.NameValuesHolder> b;

  ViewPropertyAnimatorHC$PropertyBundle(int paramInt, ArrayList<ViewPropertyAnimatorHC.NameValuesHolder> paramArrayList)
  {
    this.a = paramInt;
    this.b = paramArrayList;
  }

  boolean a(int paramInt)
  {
    int j;
    if (((paramInt & this.a) != 0) && (this.b != null))
    {
      int i = this.b.size();
      j = 0;
      if (j < i)
        if (((ViewPropertyAnimatorHC.NameValuesHolder)this.b.get(j)).a == paramInt)
        {
          this.b.remove(j);
          this.a &= (paramInt ^ 0xFFFFFFFF);
        }
    }
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      j++;
      break;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorHC.PropertyBundle
 * JD-Core Version:    0.6.2
 */