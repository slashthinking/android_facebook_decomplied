package com.facebook.bugreporter.tasklist;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class Task
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<Task> CREATOR = new Task.1();

  @JMAutogen.InferredType(jsonFieldName="task_desc")
  public final String taskDesc;

  @JMAutogen.InferredType(jsonFieldName="task_id")
  public final String taskId;

  @JMAutogen.InferredType(jsonFieldName="task_number")
  public final String taskNumber;

  @JMAutogen.InferredType(jsonFieldName="task_title")
  public final String taskTitle;

  private Task()
  {
    this.taskId = "-1";
    this.taskNumber = "-1";
    this.taskTitle = null;
    this.taskDesc = null;
  }

  private Task(Parcel paramParcel)
  {
    this.taskId = paramParcel.readString();
    this.taskNumber = paramParcel.readString();
    this.taskTitle = paramParcel.readString();
    this.taskDesc = paramParcel.readString();
  }

  public Task(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.taskId = paramString1;
    this.taskNumber = paramString2;
    this.taskTitle = paramString3;
    this.taskDesc = paramString4;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.taskId);
    paramParcel.writeString(this.taskNumber);
    paramParcel.writeString(this.taskTitle);
    paramParcel.writeString(this.taskDesc);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.Task
 * JD-Core Version:    0.6.0
 */