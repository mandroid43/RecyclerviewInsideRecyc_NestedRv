package com.manapps.mandroid.recyclerviewinsiderecyc_nestedrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecyclerView();
        sendRecyclerViewDataRequest();

    }

    //setup recycler view
    private void setUpRecyclerView() {
        recyclerView =  findViewById(R.id.sectioned_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void sendRecyclerViewDataRequest() {
        //assume you are getting data from api or local storage by function getDataList
        List<ParentItemModel> parentItemList = getDataList();
        showRecyclerViewData(parentItemList);
    }

    private List<ParentItemModel> getDataList() {
//this is the format of data we are going to recieve
        // you can edit the data according to your needs
//        {
//            "parentItemList": [
//            {
//                "section": "Section1",
//                    "childItemsList": [
//                {
//                    "title": "Child1",
//                        "photoUrl": "photoUrl1"
//                },
//                {
//                    "title": "Child2",
//                        "photoUrl": "photoUrl2"
//                }
//      ]
//            },
//            {
//                "section": "Section2",
//                    "childItemsList": [
//                {
//                    "title": "Child1",
//                        "photoUrl": "photoUrl1"
//                },
//                {
//                    "title": "Child2",
//                        "photoUrl": "photoUrl2"
//                },
//                {
//                    "title": "Child3",
//                        "photoUrl": "photoUrl3"
//                }
//      ]
//            }
//  ]
//        }


        List<ParentItemModel> parentItemList = new ArrayList<>();

        ParentItemModel parentItemModel1 = new ParentItemModel();
        parentItemModel1.setSection("Section1");

        List<ChildItemModel> childItemList1 = new ArrayList<>();
        ChildItemModel childItemModel1 = new ChildItemModel();
        childItemModel1.setTitle("Child1");
        childItemModel1.setPhotoUrl("Child1PhotoUrl");

        childItemList1.add(childItemModel1);

        ChildItemModel childItemModel2 = new ChildItemModel();
        childItemModel2.setTitle("Child2");
        childItemModel2.setPhotoUrl("Child2PhotoUrl");
        childItemList1.add(childItemModel2);

        parentItemModel1.setChildItemsList(childItemList1);

        parentItemList.add(parentItemModel1);


        ParentItemModel parentItemModel2 = new ParentItemModel();
        parentItemModel2.setSection("Section2");

        List<ChildItemModel> childItemList2 = new ArrayList<>();
        ChildItemModel childItemModel3 = new ChildItemModel();
        childItemModel3.setTitle("Child3");
        childItemModel3.setPhotoUrl("Child3PhotoUrl");

        childItemList2.add(childItemModel3);

        ChildItemModel childItemModel4 = new ChildItemModel();
        childItemModel4.setTitle("Child4");
        childItemModel4.setPhotoUrl("Child4PhotoUrl");
        childItemList2.add(childItemModel4);

        parentItemModel2.setChildItemsList(childItemList2);

        parentItemList.add(parentItemModel2);

        return parentItemList;
    }

    private void showRecyclerViewData(List<ParentItemModel> parentItemList) {

        ParentRvItemAdapter adapter = new ParentRvItemAdapter(this, parentItemList);
        recyclerView.setAdapter(adapter);
    }
}