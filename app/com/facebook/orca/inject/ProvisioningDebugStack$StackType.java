package com.facebook.orca.inject;

 enum ProvisioningDebugStack$StackType
{
  static
  {
    INSTANCE_GET = new StackType("INSTANCE_GET", 1);
    StackType[] arrayOfStackType = new StackType[2];
    arrayOfStackType[0] = PROVIDER_GET;
    arrayOfStackType[1] = INSTANCE_GET;
    $VALUES = arrayOfStackType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ProvisioningDebugStack.StackType
 * JD-Core Version:    0.6.0
 */