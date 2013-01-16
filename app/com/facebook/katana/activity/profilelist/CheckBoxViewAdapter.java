package com.facebook.katana.activity.profilelist;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import java.util.Collection;

public class CheckBoxViewAdapter<ElementType>
{
  protected final Collection<ElementType> a;

  public CheckBoxViewAdapter(Collection<ElementType> paramCollection)
  {
    this.a = paramCollection;
  }

  public View a(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131297761)).inflate();
    return paramView;
  }

  public void a(View paramView, ElementType paramElementType)
  {
    ((CheckBox)paramView.findViewById(2131296491)).setChecked(this.a.contains(paramElementType));
  }

  void a(ElementType paramElementType, View paramView)
  {
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131296491);
    if (this.a.contains(paramElementType))
    {
      this.a.remove(paramElementType);
      localCheckBox.setChecked(false);
    }
    while (true)
    {
      return;
      this.a.add(paramElementType);
      localCheckBox.setChecked(true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.CheckBoxViewAdapter
 * JD-Core Version:    0.6.0
 */