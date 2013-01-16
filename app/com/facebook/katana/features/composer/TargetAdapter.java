package com.facebook.katana.features.composer;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.katana.activity.composer.TargetSelectorActivity.Target;

public class TargetAdapter extends ArrayAdapter<TargetSelectorActivity.Target>
{
  private LayoutInflater a;
  private int b;

  public TargetAdapter(Context paramContext)
  {
    super(paramContext, 2130903092, 2131296489, TargetSelectorActivity.Target.values());
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }

  public int a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      notifyDataSetChanged();
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Context localContext = getContext();
    View localView1;
    LinearLayout localLinearLayout;
    View localView2;
    if (paramView != null)
    {
      localView1 = paramView;
      localLinearLayout = (LinearLayout)localView1;
      ((ImageView)localLinearLayout.findViewById(2131296488)).setVisibility(8);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131296489);
      localTextView.setText(((TargetSelectorActivity.Target)getItem(paramInt)).getLabel(localContext));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)localContext.getResources().getDimension(2131230900), 1.0F);
      localLayoutParams.setMargins((int)localContext.getResources().getDimension(2131230923), 0, 0, 0);
      localTextView.setLayoutParams(localLayoutParams);
      localView2 = localLinearLayout.findViewById(2131296490);
      if (paramInt != a())
        break label159;
    }
    label159: for (int i = 0; ; i = 8)
    {
      localView2.setVisibility(i);
      return localLinearLayout;
      localView1 = this.a.inflate(2130903092, null);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.TargetAdapter
 * JD-Core Version:    0.6.0
 */