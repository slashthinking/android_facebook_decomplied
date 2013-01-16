package com.facebook.nearby.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.orca.activity.OrcaFragment;
import com.google.common.collect.ImmutableMap;
import java.util.List;

public class SubcategorySearchFragment extends OrcaFragment
{
  private static final Class<?> a = SubcategorySearchFragment.class;
  private ListView b;
  private SubcategorySearchAdapter c;
  private TextView d;

  private void a()
  {
    this.b = ((ListView)g(2131297155));
    this.d = ((TextView)n().findViewById(2131296686));
    this.b.setOnItemClickListener(new SubcategorySearchFragment.1(this));
    String str = n().getIntent().getStringExtra("extra_search_topic_name");
    this.d.setText(str);
    NearbySearchCategoryList localNearbySearchCategoryList = NearbySearchCategoryList.a(p());
    this.c = new SubcategorySearchAdapter(p());
    this.c.a((List)localNearbySearchCategoryList.i.get(str));
    this.b.setAdapter(this.c);
  }

  private void a(NearbyTopic paramNearbyTopic)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result_topic", paramNearbyTopic);
    n().setResult(-1, localIntent);
    n().finish();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903294, paramViewGroup, false);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.SubcategorySearchFragment
 * JD-Core Version:    0.6.0
 */