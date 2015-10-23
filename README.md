# WinchanceHttpUtil
### This project is created by Wichance Mobile Dev.
#### We will keep updating this project

-------

You can read update history in [CHANGELOG](./CHANGELOG.md)

We have the following tools:

- WinchaceHttpUrlConnection

    ```cpp
    WinchaceHttpUrlConnection connection = new WinchaceHttpUrlConnection();
    connection.get();
    connection.put();
    connection.post();
    connection.postWithOneFile();
    connection.postWithFiles();
    connection.postWithOneFileParams();
    ```
- ViewHolder
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
- CircleImageView
    You can use CircleImageView in your project directly.
    ```cpp
    <view.CircleImageView />
    ```
    And then you can setBorderColor, setBorderWidth, setScaleType. It support bitmap, int , drawable.


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