/*
 * Copyright 2015 LuMeng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * 工具类,将字符串转为gson或者将gson转为字符串
 */
public class GsonConvertor {

    private static final ThreadLocal<Gson> gsonLocal = new ThreadLocal<Gson>(){
        @Override
        protected Gson initialValue() {
            return new Gson();
        }
    };

    public static String toJson(Object object) {
        return gsonLocal.get().toJson(object);
    }

    public static String toJson(Object object, Type type) {
        return gsonLocal.get().toJson(object, type);
    }

    public static <T> T fromJson(String jsonString, Type type) throws JsonSyntaxException {
        return gsonLocal.get().<T>fromJson(jsonString, type);
    }

    public static <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException  {
        return gsonLocal.get().<T>fromJson(reader, type);
    }
}
