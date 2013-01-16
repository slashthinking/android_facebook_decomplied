package com.facebook.katana.activity.media.detection;

import com.facebook.katana.activity.media.Facebox;
import java.util.ArrayList;
import java.util.List;

public class PhotoDetectionData
{
  private List<Facebox> a;

  public PhotoDetectionData()
  {
    this.a = new ArrayList();
  }

  public PhotoDetectionData(List<Facebox> paramList)
  {
    this.a = paramList;
  }

  public List<Facebox> a()
  {
    return this.a;
  }

  public void a(Facebox paramFacebox)
  {
    this.a.remove(paramFacebox);
  }

  public void b(Facebox paramFacebox)
  {
    this.a.add(paramFacebox);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.detection.PhotoDetectionData
 * JD-Core Version:    0.6.0
 */