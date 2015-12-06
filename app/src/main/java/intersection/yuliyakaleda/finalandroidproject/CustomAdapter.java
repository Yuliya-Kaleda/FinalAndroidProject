package intersection.yuliyakaleda.finalandroidproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {

  private Context context;
  private int layoutResourceId;
  private List<Track> tracks;

  public CustomAdapter (Context context, int layoutResourceId, List<Track> tracks) {
    super(context, layoutResourceId, tracks);
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.tracks = tracks;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    Track track = tracks.get(position);
    View row = convertView;
    CustomHolder holder = null;

    if(row == null)
    {
      LayoutInflater inflater = ((Activity)context).getLayoutInflater();
      row = inflater.inflate(layoutResourceId, parent, false);
      holder = new CustomHolder();
      holder.artist = (TextView) row.findViewById(R.id.artist);
      holder.trackName = (TextView) row.findViewById(R.id.track_name);
      holder.image = (ImageView) row.findViewById(R.id.image);
      row.setTag(holder);
    }
    else
    {
      holder = (CustomHolder)row.getTag();
    }

    holder.artist.setText(track.getArtistName());
    holder.trackName.setText(track.getTrackName());
    Picasso.with(context).load(track.getArtworkUrl30()).into(holder.image);
    return row;
  }

  static class CustomHolder
  {
    TextView artist;
    TextView trackName;
    ImageView image;
  }
}
