package id.co.zisal.dmt.fragment.search;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.enums.SnackbarType;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.BindString;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt.activity.ActivitySearchImageDetail;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentSearch extends ABaseFragment implements SearchView.OnQueryTextListener {

    @BindString(R.string.search)
    String titleFragmentSearch;

    @Bind(R.id.toolbarSearch)
    Toolbar toolbarSearch;

    @Bind(R.id.searchView)
    SearchView searchView;

    @Bind(R.id.gridImageSearch)
    GridView gridImageSearch;

    @Bind(R.id.progressBarFragmentSearchImageLoader)
    ProgressBar progressBarImageLoader;

    @BindColor(R.color.base_color)
    int baseColor;

    private GridImageAdapter gridImageAdapter;
    private ArrayList<GridImageItem> gridImageItems;

    @Override
    public String getFragmentTitle() {
        return titleFragmentSearch;
    }

    @Override
    public void initWidget() {
        toolbarSearch.setTitle(GeneralConstant.Punctuation.EMPTY);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarSearch);

        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint(titleFragmentSearch);
        searchView.setIconifiedByDefault(true);
        searchView.setMaxWidth(Integer.MAX_VALUE);

        //initUserImageGallery();
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_search;
    }

    private void initUserImageGallery(){
        gridImageItems = new ArrayList<>();
        gridImageAdapter = new GridImageAdapter(getActivity(), R.layout.grid_image_layout, gridImageItems);
        gridImageSearch.setAdapter(gridImageAdapter);

        //Grid view click event
        gridImageSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Get item at position
                GridImageItem item = (GridImageItem) parent.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), ActivitySearchImageDetail.class);
                ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);

                // Interesting data to pass across are the thumbnail size/location, the
                // resourceId of the source bitmap, the picture description, and the
                // orientation (to avoid returning back to an obsolete configuration if
                // the device rotates again in the meantime)

                int[] screenLocation = new int[2];
                imageView.getLocationOnScreen(screenLocation);

                //Pass the image title and url to DetailsActivity
                intent.putExtra("left", screenLocation[0]).
                        putExtra("top", screenLocation[1]).
                        putExtra("width", imageView.getWidth()).
                        putExtra("height", imageView.getHeight()).
                        putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
            }
        });

        //Start download
        new AsyncHttpTask().execute(ApplicationConstant.Rest.EndPoints.DUMMY_IMAGE);
        progressBarImageLoader.setVisibility(View.VISIBLE);
    }

    /*Belongs to Search View*/
    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(ApplicationConstant.LogTag.DMT_INFO, "Query text submit ".concat(query));
        Snackbar.with(getActivity())
                .text("Query text submit ".concat(query).concat("\n"))
                .type(SnackbarType.MULTI_LINE)
                .color(baseColor)
                .show(getActivity());
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(ApplicationConstant.LogTag.DMT_INFO, "Query text change ".concat(newText));
        return false;
    }

    //Downloading data asynchronously
    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            try {
                // Create Apache HttpClient
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse httpResponse = httpclient.execute(new HttpGet(params[0]));
                int statusCode = httpResponse.getStatusLine().getStatusCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    String response = streamToString(httpResponse.getEntity().getContent());
                    parseResult(response);
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed
                }
            } catch (Exception e) {
                Log.e(ApplicationConstant.LogTag.DMT_ERROR, e.getLocalizedMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            // Download complete. Let us update UI
            if (result == 1) {
                gridImageAdapter.setGridData(gridImageItems);
            } else {
                Log.e(ApplicationConstant.LogTag.DMT_ERROR, "Failed to fetch data!");
            }
            try{
                progressBarImageLoader.setVisibility(View.GONE);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    String streamToString(InputStream stream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }

        // Close stream
        if (null != stream) {
            stream.close();
        }
        return result;
    }

    /**
     * Parsing the feed results and get the list
     * @param result from  end point
     */
    private void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("posts");
            GridImageItem item;
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.optJSONObject(i);
                item = new GridImageItem();
                JSONArray attachments = post.getJSONArray("attachments");
                if (null != attachments && attachments.length() > 0) {
                    JSONObject attachment = attachments.getJSONObject(0);
                    if (attachment != null)
                        item.setImage(attachment.getString("url"));
                }
                gridImageItems.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
