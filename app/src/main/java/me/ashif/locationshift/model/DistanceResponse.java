package me.ashif.locationshift.model;

import java.util.List;

/**
 * Created by Ashif on 12/9/17,September,2017
 * github.com/SheikhZayed
 */

public class DistanceResponse {

  private String status;
  private List<GeocodedWaypointsBean> geocoded_waypoints;
  private List<RoutesBean> routes;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<GeocodedWaypointsBean> getGeocoded_waypoints() {
    return geocoded_waypoints;
  }

  public void setGeocoded_waypoints(List<GeocodedWaypointsBean> geocoded_waypoints) {
    this.geocoded_waypoints = geocoded_waypoints;
  }

  public List<RoutesBean> getRoutes() {
    return routes;
  }

  public void setRoutes(List<RoutesBean> routes) {
    this.routes = routes;
  }

  public static class GeocodedWaypointsBean {
    /**
     * geocoder_status : OK
     * place_id : ChIJN63hxJv-DDkRZPlvyRsIStQ
     * types : ["political","sublocality","sublocality_level_1"]
     */

    private String geocoder_status;
    private String place_id;
    private List<String> types;

    public String getGeocoder_status() {
      return geocoder_status;
    }

    public void setGeocoder_status(String geocoder_status) {
      this.geocoder_status = geocoder_status;
    }

    public String getPlace_id() {
      return place_id;
    }

    public void setPlace_id(String place_id) {
      this.place_id = place_id;
    }

    public List<String> getTypes() {
      return types;
    }

    public void setTypes(List<String> types) {
      this.types = types;
    }
  }

  public static class RoutesBean {
    /**
     * bounds : {"northeast":{"lat":28.7391693,"lng":77.2579767},"southwest":{"lat":28.6351259,"lng":77.22718739999999}}
     * copyrights : Map data Â©2016 Google
     * legs : [{"distance":{"text":"15.0 km","value":14994},"duration":{"text":"29
     * mins","value":1762},"end_address":"Mahatma Gandhi Marg, RPS Complex, Raj Ghat, New Delhi,
     * Delhi 110002, India","end_location":{"lat":28.6351259,"lng":77.2560503},"start_address":"Biharipur,
     * New Delhi, Delhi 110094, India","start_location":{"lat":28.7391693,"lng":77.2505958},"steps":[{"distance":{"text":"76
     * m","value":76},"duration":{"text":"1 min","value":14},"end_location":{"lat":28.73861549999999,"lng":77.2505669},"html_instructions":"Head
     * <b>south<\/b>","polyline":{"points":"yblnDg_ovMlAb@NB@@@A@A@CF["},"start_location":{"lat":28.7391693,"lng":77.2505958},"travel_mode":"DRIVING"},{"distance":{"text":"0.2
     * km","value":242},"duration":{"text":"1 min","value":51},"end_location":{"lat":28.7365921,"lng":77.2496736},"html_instructions":"Turn
     * <b>right<\/b>","maneuver":"turn-right","polyline":{"points":"k_lnDa_ovM~@\\P@L@H@FBRHXLtFrB"},"start_location":{"lat":28.73861549999999,"lng":77.2505669},"travel_mode":"DRIVING"},{"distance":{"text":"0.3
     * km","value":334},"duration":{"text":"1 min","value":71},"end_location":{"lat":28.7358499,"lng":77.2470429},"html_instructions":"Turn
     * <b>right<\/b> toward <b>Service Rd<\/b>","maneuver":"turn-right","polyline":{"points":"urknDmynvMGZ?@@@B@\\Lh@RB@B@@@?@?BVJj@Zh@XHB@@?@?@ET[hBGd@?BAP?PCX?BEdC"},"start_location":{"lat":28.7365921,"lng":77.2496736},"travel_mode":"DRIVING"},{"distance":{"text":"0.1
     * km","value":135},"duration":{"text":"1 min","value":25},"end_location":{"lat":28.73465089999999,"lng":77.2468524},"html_instructions":"Turn
     * <b>left<\/b> onto <b>Service Rd<\/b>","maneuver":"turn-left","polyline":{"points":"anknD_invMt@DvCXZBD@"},"start_location":{"lat":28.7358499,"lng":77.2470429},"travel_mode":"DRIVING"},{"distance":{"text":"33
     * m","value":33},"duration":{"text":"1 min","value":11},"end_location":{"lat":28.7344896,"lng":77.2466211},"html_instructions":"Turn
     * <b>right<\/b> toward <b>Sonia Vihar - Pushta Rd<\/b>","maneuver":"turn-right","polyline":{"points":"qfknDygnvM?F@DBBDBND@B@B?H"},"start_location":{"lat":28.73465089999999,"lng":77.2468524},"travel_mode":"DRIVING"},{"distance":{"text":"2.8
     * km","value":2828},"duration":{"text":"7 mins","value":406},"end_location":{"lat":28.7095117,"lng":77.241214},"html_instructions":"Turn
     * <b>left<\/b> onto <b>Sonia Vihar - Pushta Rd<\/b><div style=\"font-size:0.9em\">Pass by BR
     * Model Public School (on the left in 1.8&nbsp;km)<\/div>","maneuver":"turn-left","polyline":{"points":"qeknDkfnvMl@FfDZxDb@J?\\DXF|ANtD`@|BVhC\\|@Pz@J~@NjANlD^z@J`IlAxVxC`El@nFt@nCf@p@Lr@LjAPtFn@|j@~H"},"start_location":{"lat":28.7344896,"lng":77.2466211},"travel_mode":"DRIVING"},{"distance":{"text":"1.5
     * km","value":1487},"duration":{"text":"6 mins","value":367},"end_location":{"lat":28.7111084,"lng":77.22732380000001},"html_instructions":"Turn
     * <b>right<\/b> onto <b>NH9<\/b>","maneuver":"turn-right","polyline":{"points":"mifnDqdmvMjANVFk@zCaCtLe@xBcAvEIXIVEHCFEHEFWnAq@rDc@~Bc@pBaBpI_@rBW~C?VBNDPd@f@\\b@DFDJFRn@pCBT?JBf@@XDn@Fh@Fd@VfA"},"start_location":{"lat":28.7095117,"lng":77.241214},"travel_mode":"DRIVING"},{"distance":{"text":"0.2
     * km","value":222},"duration":{"text":"1 min","value":34},"end_location":{"lat":28.7091571,"lng":77.22748469999999},"html_instructions":"Turn
     * <b>left<\/b>","maneuver":"turn-left","polyline":{"points":"msfnDwmjvMTHTDl@Hh@O^KVEVCbAIzAGPA"},"start_location":{"lat":28.7111084,"lng":77.22732380000001},"travel_mode":"DRIVING"},{"distance":{"text":"3.3
     * km","value":3300},"duration":{"text":"5 mins","value":287},"end_location":{"lat":28.6798143,"lng":77.22939660000002},"html_instructions":"Take
     * the ramp onto <b>Outer Ring Rd<\/b><div style=\"font-size:0.9em\">Pass by Indraprastha Gas
     * Limited Cng Filling Station Metcalf House (on the left in 3.1&nbsp;km)<\/div>","polyline":{"points":"ggfnDwnjvMRE~EoAzC_@PArAM~@A`AHzANhBZdBd@d@Br@Hp@Fb@BT?N@vA?fL?~Mb@lFNvABP@NApFaAd@Gr@K\\Cx@ClAArEC@?`KEbACv@Cp@G`@Gl@K^I^IlAa@fEsAn@Mr@MNCt@ExGSlUo@fAChAGbEMdDK"},"start_location":{"lat":28.7091571,"lng":77.22748469999999},"travel_mode":"DRIVING"},{"distance":{"text":"1.6
     * km","value":1568},"duration":{"text":"2 mins","value":149},"end_location":{"lat":28.6670075,"lng":77.2339891},"html_instructions":"Continue
     * onto <b>NH44<\/b><div style=\"font-size:0.9em\">Pass by Ladakh Buddhist Vihara (on the left
     * in 850&nbsp;m)<\/div>","polyline":{"points":"yo`nDwzjvMJ?F?TANApC]r@ERELCZI`@Mj@_@f@c@PQt@{@dA_A\\YNKPIJEHAHAL?R@PBnBd@`AZ`AN~@NXBJ@H@P?JAJAt@OxDu@`AU\\EnB]~Ci@lCi@xBq@rDoApBo@XKNIPMRQ@AzDmF"},"start_location":{"lat":28.6798143,"lng":77.22939660000002},"travel_mode":"DRIVING"},{"distance":{"text":"3.6
     * km","value":3561},"duration":{"text":"5 mins","value":274},"end_location":{"lat":28.645238,"lng":77.2556925},"html_instructions":"Slight
     * <b>left<\/b> to stay on <b>NH44<\/b><div style=\"font-size:0.9em\">Pass by the water (on the
     * left in 2.3&nbsp;km)<\/div>","maneuver":"turn-slight-left","polyline":{"points":"y_~mDmwkvM^_A`@mAR_@LOLMNKVKh@Mx@Mx@ExBOfACVCPEPERITMNOBGNQnAsB@AdAqCJ_@Lc@Pk@\\y@~AcEBK@K?W?Y@}A?]AUEYCSOq@e@eAQo@CY?SDc@DYD_@DiAAq@BiADoADcABSBMBMBKFOJS`@[BC`Ai@nAg@f@Wr@i@V]^i@Xe@nA}BVm@Tc@j@cAz@yAfAkBb@o@RWRQTQPIPKVI\\KNCDA\\AzDEt@Gd@G^I\\IbAYn@SFCxAe@PGjA_@j@Sl@e@nDwBt@a@vFcDb@W@?HGBAJE?ADC@?JG@??AJExDqBzAw@jFuCfB}@pAw@zEoCpAw@l@_@BARQNOVY`AaA"},"start_location":{"lat":28.6670075,"lng":77.2339891},"travel_mode":"DRIVING"},{"distance":{"text":"1.2
     * km","value":1208},"duration":{"text":"1 min","value":73},"end_location":{"lat":28.6351259,"lng":77.2560503},"html_instructions":"Continue
     * straight to stay on <b>NH44<\/b><div style=\"font-size:0.9em\">Destination will be on the
     * left<\/div>","maneuver":"straight","polyline":{"points":"wwymDa_pvMVYXWb@_@l@a@l@_@\\STMZOb@SbA_@p@Wj@Uv@WVK|@]tAi@b@O`@KVG`@IVC^A`@AXBZBd@D^Hd@Jb@LzDx@v@NfEjAbLzCVHXLFD"},"start_location":{"lat":28.645238,"lng":77.2556925},"travel_mode":"DRIVING"}],"traffic_speed_entry":[],"via_waypoint":[]}]
     * overview_polyline : {"points":"yblnDg_ovM|Af@B?BEF[~@\\^BPDl@VtFrBGZ?@@@nAd@DB?DvBdA@Di@hDE`AEdCt@DrD\\D@?FDHTHBF?Hl@F`J~@`D\\rHx@fEn@zBZxFn@|JxAxVxC`El@nFt@nCf@dBZjAPtFn@hm@nIVFk@zCgDnPmApFO`@IPEFWnAuArHeCbM_@rBW~CBf@DPd@f@b@j@L^n@pCBTBr@FhANnAVfATHbANhA[n@I~CQd@G~EoAzC_@dBO~@A`AHzANhBZdBd@d@BdBPx@BfB@fL?~Mb@dIR`@?vGiApAO|IIdMIhBKnAS~@StGuBbB[dAIf^cAzNe@x@CdEc@`@I|@WrAcAfAmAbByA`@UTGVAd@DnBd@`AZ`C^d@DZ@fGiA~A[nGgAlCi@xBq@dH_Ch@Ud@_@|DoF`AmC`@o@\\Y`AYx@Mx@E`ESh@Id@Od@]dBoCpAqD^oA|B}FDW@mDGo@SeAe@eAQo@Cm@J}@D_@DiA@{BJsCN{@Rc@d@_@`Ai@nAg@f@Wr@i@v@gAhBcDl@qAfB}CjB{Cf@i@f@[h@Ul@Ob@CzDEt@GdAQxC{@bFaBl@e@nDwBlHeEr@a@PKZOhR}JlHgE~BwAVSf@i@xA{A|@w@zAaAr@a@~@c@tBw@xDwAxBy@x@Sx@M`ACt@FdAN|HbBjRfFp@VFD"}
     * summary : NH44
     * warnings : []
     * waypoint_order : []
     */

    private BoundsBean bounds;
    private String copyrights;
    private OverviewPolylineBean overview_polyline;
    private String summary;
    private List<LegsBean> legs;
    private List<?> warnings;
    private List<?> waypoint_order;

    public BoundsBean getBounds() {
      return bounds;
    }

    public void setBounds(BoundsBean bounds) {
      this.bounds = bounds;
    }

    public String getCopyrights() {
      return copyrights;
    }

    public void setCopyrights(String copyrights) {
      this.copyrights = copyrights;
    }

    public OverviewPolylineBean getOverview_polyline() {
      return overview_polyline;
    }

    public void setOverview_polyline(OverviewPolylineBean overview_polyline) {
      this.overview_polyline = overview_polyline;
    }

    public String getSummary() {
      return summary;
    }

    public void setSummary(String summary) {
      this.summary = summary;
    }

    public List<LegsBean> getLegs() {
      return legs;
    }

    public void setLegs(List<LegsBean> legs) {
      this.legs = legs;
    }

    public List<?> getWarnings() {
      return warnings;
    }

    public void setWarnings(List<?> warnings) {
      this.warnings = warnings;
    }

    public List<?> getWaypoint_order() {
      return waypoint_order;
    }

    public void setWaypoint_order(List<?> waypoint_order) {
      this.waypoint_order = waypoint_order;
    }

    public static class BoundsBean {
      /**
       * northeast : {"lat":28.7391693,"lng":77.2579767}
       * southwest : {"lat":28.6351259,"lng":77.22718739999999}
       */

      private NortheastBean northeast;
      private SouthwestBean southwest;

      public NortheastBean getNortheast() {
        return northeast;
      }

      public void setNortheast(NortheastBean northeast) {
        this.northeast = northeast;
      }

      public SouthwestBean getSouthwest() {
        return southwest;
      }

      public void setSouthwest(SouthwestBean southwest) {
        this.southwest = southwest;
      }

      public static class NortheastBean {
        /**
         * lat : 28.7391693
         * lng : 77.2579767
         */

        private double lat;
        private double lng;

        public double getLat() {
          return lat;
        }

        public void setLat(double lat) {
          this.lat = lat;
        }

        public double getLng() {
          return lng;
        }

        public void setLng(double lng) {
          this.lng = lng;
        }
      }

      public static class SouthwestBean {
        /**
         * lat : 28.6351259
         * lng : 77.22718739999999
         */

        private double lat;
        private double lng;

        public double getLat() {
          return lat;
        }

        public void setLat(double lat) {
          this.lat = lat;
        }

        public double getLng() {
          return lng;
        }

        public void setLng(double lng) {
          this.lng = lng;
        }
      }
    }

    public static class OverviewPolylineBean {
      /**
       * points : yblnDg_ovM|Af@B?BEF[~@\^BPDl@VtFrBGZ?@@@nAd@DB?DvBdA@Di@hDE`AEdCt@DrD\D@?FDHTHBF?Hl@F`J~@`D\rHx@fEn@zBZxFn@|JxAxVxC`El@nFt@nCf@dBZjAPtFn@hm@nIVFk@zCgDnPmApFO`@IPEFWnAuArHeCbM_@rBW~CBf@DPd@f@b@j@L^n@pCBTBr@FhANnAVfATHbANhA[n@I~CQd@G~EoAzC_@dBO~@A`AHzANhBZdBd@d@BdBPx@BfB@fL?~Mb@dIR`@?vGiApAO|IIdMIhBKnAS~@StGuBbB[dAIf^cAzNe@x@CdEc@`@I|@WrAcAfAmAbByA`@UTGVAd@DnBd@`AZ`C^d@DZ@fGiA~A[nGgAlCi@xBq@dH_Ch@Ud@_@|DoF`AmC`@o@\Y`AYx@Mx@E`ESh@Id@Od@]dBoCpAqD^oA|B}FDW@mDGo@SeAe@eAQo@Cm@J}@D_@DiA@{BJsCN{@Rc@d@_@`Ai@nAg@f@Wr@i@v@gAhBcDl@qAfB}CjB{Cf@i@f@[h@Ul@Ob@CzDEt@GdAQxC{@bFaBl@e@nDwBlHeEr@a@PKZOhR}JlHgE~BwAVSf@i@xA{A|@w@zAaAr@a@~@c@tBw@xDwAxBy@x@Sx@M`ACt@FdAN|HbBjRfFp@VFD
       */

      private String points;

      public String getPoints() {
        return points;
      }

      public void setPoints(String points) {
        this.points = points;
      }
    }

    public static class LegsBean {
      /**
       * distance : {"text":"15.0 km","value":14994}
       * duration : {"text":"29 mins","value":1762}
       * end_address : Mahatma Gandhi Marg, RPS Complex, Raj Ghat, New Delhi, Delhi 110002, India
       * end_location : {"lat":28.6351259,"lng":77.2560503}
       * start_address : Biharipur, New Delhi, Delhi 110094, India
       * start_location : {"lat":28.7391693,"lng":77.2505958}
       * steps : [{"distance":{"text":"76 m","value":76},"duration":{"text":"1
       * min","value":14},"end_location":{"lat":28.73861549999999,"lng":77.2505669},"html_instructions":"Head
       * <b>south<\/b>","polyline":{"points":"yblnDg_ovMlAb@NB@@@A@A@CF["},"start_location":{"lat":28.7391693,"lng":77.2505958},"travel_mode":"DRIVING"},{"distance":{"text":"0.2
       * km","value":242},"duration":{"text":"1 min","value":51},"end_location":{"lat":28.7365921,"lng":77.2496736},"html_instructions":"Turn
       * <b>right<\/b>","maneuver":"turn-right","polyline":{"points":"k_lnDa_ovM~@\\P@L@H@FBRHXLtFrB"},"start_location":{"lat":28.73861549999999,"lng":77.2505669},"travel_mode":"DRIVING"},{"distance":{"text":"0.3
       * km","value":334},"duration":{"text":"1 min","value":71},"end_location":{"lat":28.7358499,"lng":77.2470429},"html_instructions":"Turn
       * <b>right<\/b> toward <b>Service Rd<\/b>","maneuver":"turn-right","polyline":{"points":"urknDmynvMGZ?@@@B@\\Lh@RB@B@@@?@?BVJj@Zh@XHB@@?@?@ET[hBGd@?BAP?PCX?BEdC"},"start_location":{"lat":28.7365921,"lng":77.2496736},"travel_mode":"DRIVING"},{"distance":{"text":"0.1
       * km","value":135},"duration":{"text":"1 min","value":25},"end_location":{"lat":28.73465089999999,"lng":77.2468524},"html_instructions":"Turn
       * <b>left<\/b> onto <b>Service Rd<\/b>","maneuver":"turn-left","polyline":{"points":"anknD_invMt@DvCXZBD@"},"start_location":{"lat":28.7358499,"lng":77.2470429},"travel_mode":"DRIVING"},{"distance":{"text":"33
       * m","value":33},"duration":{"text":"1 min","value":11},"end_location":{"lat":28.7344896,"lng":77.2466211},"html_instructions":"Turn
       * <b>right<\/b> toward <b>Sonia Vihar - Pushta Rd<\/b>","maneuver":"turn-right","polyline":{"points":"qfknDygnvM?F@DBBDBND@B@B?H"},"start_location":{"lat":28.73465089999999,"lng":77.2468524},"travel_mode":"DRIVING"},{"distance":{"text":"2.8
       * km","value":2828},"duration":{"text":"7 mins","value":406},"end_location":{"lat":28.7095117,"lng":77.241214},"html_instructions":"Turn
       * <b>left<\/b> onto <b>Sonia Vihar - Pushta Rd<\/b><div style=\"font-size:0.9em\">Pass by BR
       * Model Public School (on the left in 1.8&nbsp;km)<\/div>","maneuver":"turn-left","polyline":{"points":"qeknDkfnvMl@FfDZxDb@J?\\DXF|ANtD`@|BVhC\\|@Pz@J~@NjANlD^z@J`IlAxVxC`El@nFt@nCf@p@Lr@LjAPtFn@|j@~H"},"start_location":{"lat":28.7344896,"lng":77.2466211},"travel_mode":"DRIVING"},{"distance":{"text":"1.5
       * km","value":1487},"duration":{"text":"6 mins","value":367},"end_location":{"lat":28.7111084,"lng":77.22732380000001},"html_instructions":"Turn
       * <b>right<\/b> onto <b>NH9<\/b>","maneuver":"turn-right","polyline":{"points":"mifnDqdmvMjANVFk@zCaCtLe@xBcAvEIXIVEHCFEHEFWnAq@rDc@~Bc@pBaBpI_@rBW~C?VBNDPd@f@\\b@DFDJFRn@pCBT?JBf@@XDn@Fh@Fd@VfA"},"start_location":{"lat":28.7095117,"lng":77.241214},"travel_mode":"DRIVING"},{"distance":{"text":"0.2
       * km","value":222},"duration":{"text":"1 min","value":34},"end_location":{"lat":28.7091571,"lng":77.22748469999999},"html_instructions":"Turn
       * <b>left<\/b>","maneuver":"turn-left","polyline":{"points":"msfnDwmjvMTHTDl@Hh@O^KVEVCbAIzAGPA"},"start_location":{"lat":28.7111084,"lng":77.22732380000001},"travel_mode":"DRIVING"},{"distance":{"text":"3.3
       * km","value":3300},"duration":{"text":"5 mins","value":287},"end_location":{"lat":28.6798143,"lng":77.22939660000002},"html_instructions":"Take
       * the ramp onto <b>Outer Ring Rd<\/b><div style=\"font-size:0.9em\">Pass by Indraprastha Gas
       * Limited Cng Filling Station Metcalf House (on the left in 3.1&nbsp;km)<\/div>","polyline":{"points":"ggfnDwnjvMRE~EoAzC_@PArAM~@A`AHzANhBZdBd@d@Br@Hp@Fb@BT?N@vA?fL?~Mb@lFNvABP@NApFaAd@Gr@K\\Cx@ClAArEC@?`KEbACv@Cp@G`@Gl@K^I^IlAa@fEsAn@Mr@MNCt@ExGSlUo@fAChAGbEMdDK"},"start_location":{"lat":28.7091571,"lng":77.22748469999999},"travel_mode":"DRIVING"},{"distance":{"text":"1.6
       * km","value":1568},"duration":{"text":"2 mins","value":149},"end_location":{"lat":28.6670075,"lng":77.2339891},"html_instructions":"Continue
       * onto <b>NH44<\/b><div style=\"font-size:0.9em\">Pass by Ladakh Buddhist Vihara (on the
       * left
       * in 850&nbsp;m)<\/div>","polyline":{"points":"yo`nDwzjvMJ?F?TANApC]r@ERELCZI`@Mj@_@f@c@PQt@{@dA_A\\YNKPIJEHAHAL?R@PBnBd@`AZ`AN~@NXBJ@H@P?JAJAt@OxDu@`AU\\EnB]~Ci@lCi@xBq@rDoApBo@XKNIPMRQ@AzDmF"},"start_location":{"lat":28.6798143,"lng":77.22939660000002},"travel_mode":"DRIVING"},{"distance":{"text":"3.6
       * km","value":3561},"duration":{"text":"5 mins","value":274},"end_location":{"lat":28.645238,"lng":77.2556925},"html_instructions":"Slight
       * <b>left<\/b> to stay on <b>NH44<\/b><div style=\"font-size:0.9em\">Pass by the water (on
       * the left in 2.3&nbsp;km)<\/div>","maneuver":"turn-slight-left","polyline":{"points":"y_~mDmwkvM^_A`@mAR_@LOLMNKVKh@Mx@Mx@ExBOfACVCPEPERITMNOBGNQnAsB@AdAqCJ_@Lc@Pk@\\y@~AcEBK@K?W?Y@}A?]AUEYCSOq@e@eAQo@CY?SDc@DYD_@DiAAq@BiADoADcABSBMBMBKFOJS`@[BC`Ai@nAg@f@Wr@i@V]^i@Xe@nA}BVm@Tc@j@cAz@yAfAkBb@o@RWRQTQPIPKVI\\KNCDA\\AzDEt@Gd@G^I\\IbAYn@SFCxAe@PGjA_@j@Sl@e@nDwBt@a@vFcDb@W@?HGBAJE?ADC@?JG@??AJExDqBzAw@jFuCfB}@pAw@zEoCpAw@l@_@BARQNOVY`AaA"},"start_location":{"lat":28.6670075,"lng":77.2339891},"travel_mode":"DRIVING"},{"distance":{"text":"1.2
       * km","value":1208},"duration":{"text":"1 min","value":73},"end_location":{"lat":28.6351259,"lng":77.2560503},"html_instructions":"Continue
       * straight to stay on <b>NH44<\/b><div style=\"font-size:0.9em\">Destination will be on the
       * left<\/div>","maneuver":"straight","polyline":{"points":"wwymDa_pvMVYXWb@_@l@a@l@_@\\STMZOb@SbA_@p@Wj@Uv@WVK|@]tAi@b@O`@KVG`@IVC^A`@AXBZBd@D^Hd@Jb@LzDx@v@NfEjAbLzCVHXLFD"},"start_location":{"lat":28.645238,"lng":77.2556925},"travel_mode":"DRIVING"}]
       * traffic_speed_entry : []
       * via_waypoint : []
       */

      private DistanceBean distance;
      private DurationBean duration;
      private String end_address;
      private EndLocationBean end_location;
      private String start_address;
      private StartLocationBean start_location;
      private List<StepsBean> steps;
      private List<?> traffic_speed_entry;
      private List<?> via_waypoint;

      public DistanceBean getDistance() {
        return distance;
      }

      public void setDistance(DistanceBean distance) {
        this.distance = distance;
      }

      public DurationBean getDuration() {
        return duration;
      }

      public void setDuration(DurationBean duration) {
        this.duration = duration;
      }

      public String getEnd_address() {
        return end_address;
      }

      public void setEnd_address(String end_address) {
        this.end_address = end_address;
      }

      public EndLocationBean getEnd_location() {
        return end_location;
      }

      public void setEnd_location(EndLocationBean end_location) {
        this.end_location = end_location;
      }

      public String getStart_address() {
        return start_address;
      }

      public void setStart_address(String start_address) {
        this.start_address = start_address;
      }

      public StartLocationBean getStart_location() {
        return start_location;
      }

      public void setStart_location(StartLocationBean start_location) {
        this.start_location = start_location;
      }

      public List<StepsBean> getSteps() {
        return steps;
      }

      public void setSteps(List<StepsBean> steps) {
        this.steps = steps;
      }

      public List<?> getTraffic_speed_entry() {
        return traffic_speed_entry;
      }

      public void setTraffic_speed_entry(List<?> traffic_speed_entry) {
        this.traffic_speed_entry = traffic_speed_entry;
      }

      public List<?> getVia_waypoint() {
        return via_waypoint;
      }

      public void setVia_waypoint(List<?> via_waypoint) {
        this.via_waypoint = via_waypoint;
      }

      public static class DistanceBean {
        /**
         * text : 15.0 km
         * value : 14994
         */

        private String text;
        private int value;

        public String getText() {
          return text;
        }

        public void setText(String text) {
          this.text = text;
        }

        public int getValue() {
          return value;
        }

        public void setValue(int value) {
          this.value = value;
        }
      }

      public static class DurationBean {
        /**
         * text : 29 mins
         * value : 1762
         */

        private String text;
        private int value;

        public String getText() {
          return text;
        }

        public void setText(String text) {
          this.text = text;
        }

        public int getValue() {
          return value;
        }

        public void setValue(int value) {
          this.value = value;
        }
      }

      public static class EndLocationBean {
        /**
         * lat : 28.6351259
         * lng : 77.2560503
         */

        private double lat;
        private double lng;

        public double getLat() {
          return lat;
        }

        public void setLat(double lat) {
          this.lat = lat;
        }

        public double getLng() {
          return lng;
        }

        public void setLng(double lng) {
          this.lng = lng;
        }
      }

      public static class StartLocationBean {
        /**
         * lat : 28.7391693
         * lng : 77.2505958
         */

        private double lat;
        private double lng;

        public double getLat() {
          return lat;
        }

        public void setLat(double lat) {
          this.lat = lat;
        }

        public double getLng() {
          return lng;
        }

        public void setLng(double lng) {
          this.lng = lng;
        }
      }

      public static class StepsBean {
        /**
         * distance : {"text":"76 m","value":76}
         * duration : {"text":"1 min","value":14}
         * end_location : {"lat":28.73861549999999,"lng":77.2505669}
         * html_instructions : Head <b>south</b>
         * polyline : {"points":"yblnDg_ovMlAb@NB@@@A@A@CF["}
         * start_location : {"lat":28.7391693,"lng":77.2505958}
         * travel_mode : DRIVING
         * maneuver : turn-right
         */

        private DistanceBeanX distance;
        private DurationBeanX duration;
        private EndLocationBeanX end_location;
        private String html_instructions;
        private PolylineBean polyline;
        private StartLocationBeanX start_location;
        private String travel_mode;
        private String maneuver;

        public DistanceBeanX getDistance() {
          return distance;
        }

        public void setDistance(DistanceBeanX distance) {
          this.distance = distance;
        }

        public DurationBeanX getDuration() {
          return duration;
        }

        public void setDuration(DurationBeanX duration) {
          this.duration = duration;
        }

        public EndLocationBeanX getEnd_location() {
          return end_location;
        }

        public void setEnd_location(EndLocationBeanX end_location) {
          this.end_location = end_location;
        }

        public String getHtml_instructions() {
          return html_instructions;
        }

        public void setHtml_instructions(String html_instructions) {
          this.html_instructions = html_instructions;
        }

        public PolylineBean getPolyline() {
          return polyline;
        }

        public void setPolyline(PolylineBean polyline) {
          this.polyline = polyline;
        }

        public StartLocationBeanX getStart_location() {
          return start_location;
        }

        public void setStart_location(StartLocationBeanX start_location) {
          this.start_location = start_location;
        }

        public String getTravel_mode() {
          return travel_mode;
        }

        public void setTravel_mode(String travel_mode) {
          this.travel_mode = travel_mode;
        }

        public String getManeuver() {
          return maneuver;
        }

        public void setManeuver(String maneuver) {
          this.maneuver = maneuver;
        }

        public static class DistanceBeanX {
          /**
           * text : 76 m
           * value : 76
           */

          private String text;
          private int value;

          public String getText() {
            return text;
          }

          public void setText(String text) {
            this.text = text;
          }

          public int getValue() {
            return value;
          }

          public void setValue(int value) {
            this.value = value;
          }
        }

        public static class DurationBeanX {
          /**
           * text : 1 min
           * value : 14
           */

          private String text;
          private int value;

          public String getText() {
            return text;
          }

          public void setText(String text) {
            this.text = text;
          }

          public int getValue() {
            return value;
          }

          public void setValue(int value) {
            this.value = value;
          }
        }

        public static class EndLocationBeanX {
          /**
           * lat : 28.73861549999999
           * lng : 77.2505669
           */

          private double lat;
          private double lng;

          public double getLat() {
            return lat;
          }

          public void setLat(double lat) {
            this.lat = lat;
          }

          public double getLng() {
            return lng;
          }

          public void setLng(double lng) {
            this.lng = lng;
          }
        }

        public static class PolylineBean {
          /**
           * points : yblnDg_ovMlAb@NB@@@A@A@CF[
           */

          private String points;

          public String getPoints() {
            return points;
          }

          public void setPoints(String points) {
            this.points = points;
          }
        }

        public static class StartLocationBeanX {
          /**
           * lat : 28.7391693
           * lng : 77.2505958
           */

          private double lat;
          private double lng;

          public double getLat() {
            return lat;
          }

          public void setLat(double lat) {
            this.lat = lat;
          }

          public double getLng() {
            return lng;
          }

          public void setLng(double lng) {
            this.lng = lng;
          }
        }
      }
    }
  }
}
