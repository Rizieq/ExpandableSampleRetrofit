package com.rizieq.expandablesampleretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.rizieq.expandablesampleretrofit.modelsecond.AllData;
import com.rizieq.expandablesampleretrofit.modelsecond.ChildLinkItem;
import com.rizieq.expandablesampleretrofit.modelsecond.ResponseSecond;
import com.rizieq.expandablesampleretrofit.modelsecond.ServeItem;
import com.rizieq.expandablesampleretrofit.network.ApiClient;
import com.rizieq.expandablesampleretrofit.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ImageView imgEditProfile;


    private RecyclerView list;
    private List<ChildLinkItem> childLinkItems;
    private List<ServeItem> serveItems;
    //private MainAdapter adapter = null;
    private ArrayList<Object> data = new ArrayList<>();


    private AdapterSecond adapterSecond;
    private ChildAdapter childAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*childLinkItems = new ArrayList<Object>();*/
        // INISIALISASI WIDGET
        list = findViewById(R.id.rvHome);

        // UNTUK SETINGAN RECYCLERVIEW
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        getDataSecond();


    }

    public void getDataSecond() {

        String id = "16";
        String mobile = "2y10s6ZYEuThB8IkZ0sl1ucOOeJFYf4DmGNbeIyB6j4l9lPpwdu41n5K";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjlhYzdlNDc0ZmNiNWFiZWIyMDNkOWU3YWIyMTQ2Y2RiOTgxNDhhMjQ0NTNmZTc3ZWM2OThhYmIyOTU3YWI4MDBjYjY1ODE5MTNlN2FiYjM1In0.eyJhdWQiOiIxIiwianRpIjoiOWFjN2U0NzRmY2I1YWJlYjIwM2Q5ZTdhYjIxNDZjZGI5ODE0OGEyNDQ1M2ZlNzdlYzY5OGFiYjI5NTdhYjgwMGNiNjU4MTkxM2U3YWJiMzUiLCJpYXQiOjE1NjU1OTIwMDcsIm5iZiI6MTU2NTU5MjAwNywiZXhwIjoxNTk3MjE0NDA3LCJzdWIiOiIxNiIsInNjb3BlcyI6W119.jNtulCSPQ_xPmjdVquugzHKYRByKZm4bvAINS6DCdkBJUqjPJtB0vHgJVZ8GydV3drdhonncpZ9JrEBWVTQGKjQn1LoVMYqjUVI7wW8S939QAog15MQ2hYDQCV3fJdLSNQhWeFhBIhWqSG6ZtsI_UF61U2wz0QIy26mKIE08-2wBpFXnXszyif9EdIu344tJwt7kVADcDKOqelG5xaYt6R3wIRkA_ySSEFjsGh2Aaq-Hwi6yMRQwO41dMMyxVNbivpgKf1EMUGH1MD-giatklGm-C61E8S1mar9ESBDh7Q12y6N-wPxEgNQHG3rFiqNxiwyhlBNkta3huHWzfJkJXhs-OvpwhYbPXH1ncGpvSYuGBg-G8jJPLFHHrjwy49YjWfJkzZ18CyuuPEWF--CCyryn-3ekjQpiKtscGlsierssVmYqgS0JNq722CX81MZmY_X-vEqxc_MHuEw1g5xP2YpCFl-pTnkJOnYMXGJXWUiaTvRJTsHMM1lb9AvXE3L-509udx2poEHyxEI6-_kG3lyllwc2UsGLq8dWP2q4Tf4P-eZZnpKvKlTP5OsjUqDN9cBDPQZ5QP0y6pCkxxCIK5ZPvrI-VaXhwQUhE-OMU2fUiCxcTrzUTFoVuMWZ5Zu2rDIy7fKueih2vOTHfs2G8YZIBabmfAqBGnCTWgQzMt0";
        String bearer = "Bearer " + token;

        ApiInterface apiClient = ApiClient.getInstance().create(ApiInterface.class);
        apiClient.getListSecond(id, mobile, bearer).enqueue(new Callback<ResponseSecond>() {
            @Override
            public void onResponse(Call<ResponseSecond> call, Response<ResponseSecond> response) {

                if (response.isSuccessful()) {

                    // ArrayList<ServeItem> dataServe = new ArrayList<>();




                    List<ServeItem> array = response.body().getServe();
                    for (int i = 0; i < array.size(); i++) {

                        String title = array.get(i).getTitle();
                        int id = array.get(i).getGroupLinkId();
                        Object unicode = array.get(i).getUnicode();

                        childLinkItems = new ArrayList<>();

                        List<ChildLinkItem> childLink = array.get(i).getChildLink();
                        for (int k = 0; k < childLink.size(); k++) {

                            String avatar = childLink.get(k).getAvatar();
                            String titleChild = childLink.get(k).getTitle();
                            int linkId = childLink.get(k).getLinkId();
                            int accountId = childLink.get(k).getAccountId();
                            int groupLinkId = childLink.get(k).getGroupLinkId();
                            int status = childLink.get(k).getStatus();

                            childLinkItems.add(new ChildLinkItem(avatar, titleChild, linkId, accountId, groupLinkId, status));

                        }


                        data.add(new ServeItem(id, unicode, title, childLinkItems));


                        String jumlahData = String.valueOf(data.size());
                        String jumlahChildSize = String.valueOf(childLinkItems.size());


                        Log.d("JUMLAH_DATA ", jumlahData + "JUMLAH_CHILD " + jumlahChildSize);

                        /*data.add(new AllData("",title,0,0,id,0,unicode,childLinkItems));*/


                        Log.d("title", title);


                    }
                    adapterSecond = new AdapterSecond(MainActivity.this, data);
                    list.setAdapter(adapterSecond);


                }
            }

            @Override
            public void onFailure(Call<ResponseSecond> call, Throwable t) {

                Toast.makeText(MainActivity.this, "gagal" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("onFailure: ", t.getLocalizedMessage());

            }
        });
    }


}
