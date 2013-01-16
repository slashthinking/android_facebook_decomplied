package com.facebook.orca.inject;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ProvisioningException extends RuntimeException
{
  public ProvisioningException()
  {
    super(a(null));
  }

  public ProvisioningException(String paramString)
  {
    super(a(paramString));
  }

  public ProvisioningException(Throwable paramThrowable)
  {
    super(a(null), paramThrowable);
  }

  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    label38: ProvisioningDebugStack.StackEntry localStackEntry;
    if (paramString != null)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
      Iterator localIterator = Lists.a(ProvisioningDebugStack.b()).iterator();
      if (!localIterator.hasNext())
        break label116;
      localStackEntry = (ProvisioningDebugStack.StackEntry)localIterator.next();
      if (localStackEntry.a != ProvisioningDebugStack.StackType.INSTANCE_GET)
        break label106;
      localStringBuilder.append(" while trying to get instance of ");
    }
    while (true)
    {
      localStringBuilder.append(localStackEntry.b).append("\n");
      break label38;
      localStringBuilder.append("Failure to provision.");
      break;
      label106: localStringBuilder.append(" while trying to get provider of ");
    }
    label116: return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ProvisioningException
 * JD-Core Version:    0.6.0
 */