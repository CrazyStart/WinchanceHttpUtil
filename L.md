###L
Simple, pretty and powerful logger for android

Logger provides :
- Thread information
- Class information
- Method information
- Pretty-print for json content
- Pretty-print for new line "\n"
- Clean output
- Jump to source

### Dependency
https://jitpack.io/#orhanobut/logger/1.12

```groovy
dependencies {
  compile 'com.winchance.library:library:1.0.3'
}
```

### Usage
Note: Because of the latest changes, L.init() must be called once to initiate. This will be fixed in the next version

```java
L.i("hello");
L.ii("hello");
L.d("hello");
L.dd("hello");
L.e("hello");
L.ee("hello");
L.w("hello");
L.ww("hello");
L.v("hello");
L.wtf("hello");
L.json(JSON_CONTENT);
L.xml(XML_CONTENT);
L.object(OBJECT);
```

###License
<pre>
Copyright 2015 LuMeng

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
