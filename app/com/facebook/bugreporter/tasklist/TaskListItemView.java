package com.facebook.bugreporter.tasklist;

import android.content.Context;
import android.widget.TextView;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.widget.CustomViewGroup;

public class TaskListItemView extends CustomViewGroup
{
  private final TextView a;
  private final TextView b;
  private Task c;

  public TaskListItemView(Context paramContext)
  {
    super(paramContext);
    setContentView(2130903578);
    this.a = ((TextView)getView(2131297870));
    this.b = ((TextView)getView(2131297871));
  }

  public void setTask(Task paramTask)
  {
    this.c = paramTask;
    this.a.setText(paramTask.taskTitle);
    if (StringUtil.f(paramTask.taskDesc))
      this.b.setVisibility(8);
    while (true)
    {
      return;
      this.b.setVisibility(0);
      if (paramTask.taskNumber == "-1")
      {
        this.b.setText(paramTask.taskDesc);
        continue;
      }
      String str = "#" + paramTask.taskNumber + ": " + paramTask.taskDesc;
      this.b.setText(str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListItemView
 * JD-Core Version:    0.6.0
 */