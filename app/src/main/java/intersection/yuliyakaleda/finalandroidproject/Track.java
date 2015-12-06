package intersection.yuliyakaleda.finalandroidproject;

public class Track {
  private String artistName;
  private String artworkUrl100;
  private String trackName;

  public Track(String artistName, String artworkUrl100, String trackName) {
    this.artistName = artistName;
    this.artworkUrl100 = artworkUrl100;
    this.trackName = trackName;
  }

  public String getArtistName() {
    return artistName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public String getArtworkUrl30() {
    return artworkUrl100;
  }

  public void setArtworkUrl30(String artworkUrl30) {
    this.artworkUrl100 = artworkUrl30;
  }

  public String getTrackName() {
    return trackName;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }
}
