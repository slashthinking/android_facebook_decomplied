package com.facebook.nearby.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class NearbyPlaces
{

  @JsonProperty("edges")
  public final List<NearbyPlaceEdge> edges = null;

  @JsonProperty("search_session_id")
  public final String searchSessionId = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.model.NearbyPlaces
 * JD-Core Version:    0.6.0
 */