package com.facebook.bugreporter.tasklist;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.AuthNotRequired;

@AuthNotRequired
public class ViewTaskActivity extends FbFragmentActivity
{
  private static final Class<?> n = ViewTaskActivity.class;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    requestWindowFeature(3);
    setFeatureDrawableResource(3, 2130839035);
    setContentView(2130903580);
    setTitleColor(getResources().getColor(17170444));
    TextView localTextView = (TextView)f(2131297873);
    Task localTask = (Task)getIntent().getParcelableExtra("task");
    String str1 = localTask.taskTitle + "\n\n";
    String str2 = str1 + "Task Number: " + localTask.taskNumber + "\n\n";
    localTextView.setText(str2 + "Description \n" + localTask.taskDesc);
    findViewById(2131297874).setOnClickListener(new ViewTaskActivity.1(this));
    findViewById(2131297875).setOnClickListener(new ViewTaskActivity.2(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.ViewTaskActivity
 * JD-Core Version:    0.6.0
 */