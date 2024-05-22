import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import org.json.JSONArray;

import java.io.InputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;

class LoadImageTask extends AsyncTask<String, Void, Bitmap>
{
    private ImageView imageView;
    public LoadImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    public void execute(String iconURL) {

    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        HttpURLConnection connection =null;
        try
        {
            URL url = new URL(params[0]);
            connection=(HttpURLConnection) url.openConnection();
            try(InputStream inputStream = connection.getInputStream())
            {
                bitmap = BitmapFactory.decodeStream(inputStream);
                JSONArray bitmaps = null;
                bitmaps.put(Integer.parseInt(params[0]), bitmap);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }
        return bitmap;

    }
    @Override
    protected void onPostExecute(Bitmap bitmap)
    {
        imageView.setImageBitmap(bitmap);
    }
}
