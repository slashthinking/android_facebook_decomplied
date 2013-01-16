package com.facebook.appcenter.ui.gdp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.appcenter.model.AppPrivacyOption;
import com.facebook.appcenter.model.AppPrivacyOptionList;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppDetailPrivacyPickerView extends CustomViewGroup
  implements View.OnClickListener
{
  private List<AppDetailPrivacyPickerRowView> a;
  private AppDetailPrivacyPickerView.PrivacyPickerListener b;

  public AppDetailPrivacyPickerView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AppDetailPrivacyPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppDetailPrivacyPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903052);
    LinearLayout localLinearLayout = (LinearLayout)getView(2131296382);
    this.a = new ArrayList();
    List localList = (List)getInjector().a(AppPrivacyOptionList.class);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      AppPrivacyOption localAppPrivacyOption = (AppPrivacyOption)localIterator.next();
      AppDetailPrivacyPickerRowView localAppDetailPrivacyPickerRowView = new AppDetailPrivacyPickerRowView(paramContext);
      localAppDetailPrivacyPickerRowView.setPrivacyOption(localAppPrivacyOption);
      localAppDetailPrivacyPickerRowView.setOnClickListener(this);
      a(paramContext, localLinearLayout);
      localLinearLayout.addView(localAppDetailPrivacyPickerRowView);
      this.a.add(localAppDetailPrivacyPickerRowView);
    }
    if (localList.size() > 0)
      a(paramContext, localLinearLayout);
  }

  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    View.inflate(paramContext, 2130903054, paramViewGroup);
  }

  public void onClick(View paramView)
  {
    for (int i = 0; i < this.a.size(); i++)
    {
      if ((this.a.get(i) != paramView) || (this.b == null))
        continue;
      this.b.a(i);
    }
  }

  public void setListener(AppDetailPrivacyPickerView.PrivacyPickerListener paramPrivacyPickerListener)
  {
    this.b = paramPrivacyPickerListener;
  }

  public void setSelectedIndex(int paramInt)
  {
    int i = 0;
    if (i < this.a.size())
    {
      if (i == paramInt)
        ((AppDetailPrivacyPickerRowView)this.a.get(i)).setRowSelected(Boolean.valueOf(true));
      while (true)
      {
        i++;
        break;
        ((AppDetailPrivacyPickerRowView)this.a.get(i)).setRowSelected(Boolean.valueOf(false));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.gdp.AppDetailPrivacyPickerView
 * JD-Core Version:    0.6.0
 */