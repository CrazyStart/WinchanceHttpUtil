# WinchanceHttpUtil
[![API](https://img.shields.io/badge/API-8%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=8)
[![Bintray](https://img.shields.io/bintray/v/lubeast/maven/winchance-http-util.svg)](https://bintray.com/lubeast/maven/winchance-http-util/_latestVersion)
[![Twitter](https://img.shields.io/badge/Twitter-@LuMengHZ-blue.svg?style=flat)](http://twitter.com/LuMengHZ)
![License](https://img.shields.io/github/license/lubeast/WinchanceHttpUtil.svg)

### This project is created by Wichance Mobile Dev.
#### We will keep updating this project

-------

You can read update history in [CHANGELOG](./CHANGELOG.md)

We have the following tools:

- **CommonAdapter for ListView and GridView**

    You can write adapter in a simple way through use our **CommonAdapter**
    
    ```cpp
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CommonAdapter<Bean>(  
                        getApplicationContext(), mDatas, R.layout.item_list)  {  
            @Override  
            public void convert(ViewHolder helper, Bean item) {  
                helper.setText(R.id.tv_title, item.getTitle());  
                helper.setText(R.id.tv_describe, item.getDesc());  
                helper.setText(R.id.tv_phone, item.getPhone());  
                helper.setText(R.id.tv_time, item.getTime());  
                // helper.getView(R.id.tv_title).setOnClickListener(l)  
                    }  
                });
    ```

- **WinchaceHttpUrlConnection**

    ```cpp
    WinchaceHttpUrlConnection connection = new WinchaceHttpUrlConnection();
    connection.get();
    connection.put();
    connection.post();
    connection.postWithOneFile();
    connection.postWithFiles();
    connection.postWithOneFileParams();
    ```
- **ViewHolder**

    We can use ViewHolder like this:
    
    ```cpp
    public View getView(int position, View convertView, ViewGroup parent) {
         if (convertView == null) {
             convertView = LayoutInflater
             .from(context).inflate(R.layout.good_list_item, null, false);
         }
         ViewHolder mViewHolder = ViewHolder.get(convertView);
         TextView price = mViewHolder.getView(R.id.price);
         //...其他getView
         return convertView;
    }
    ```
- **CircleImageView**

    You can use CircleImageView in your project directly.
    
    ```cpp
    <view.CircleImageView />
    ```
    And then you can setBorderColor, setBorderWidth, setScaleType. It support bitmap, int , drawable.

- **L**

    This is a log util depends on [orhanobut](https://github.com/orhanobut/logger)
    And you can watch [L](./L.md) for detail

------------

###License

```
Copyright (C) 2015 LuMeng

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
