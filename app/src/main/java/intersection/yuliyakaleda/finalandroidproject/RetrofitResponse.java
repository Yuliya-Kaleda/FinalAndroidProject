package intersection.yuliyakaleda.finalandroidproject;

import java.util.List;

public class RetrofitResponse {
  private List<Track> results;

  public RetrofitResponse(List<Track> results) {
    this.results = results;
  }

  public List<Track> getTracks() {
    return results;
  }

  public void setTracks(List<Track> results) {
    this.results = results;
  }
}
