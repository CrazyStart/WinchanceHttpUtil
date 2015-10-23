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

package http;

import java.util.ArrayList;

/**
 * @author L.M
 * @version 1.0.0
 * Interface of {@link java.net.HttpURLConnection}
 */
public interface HttpUrlConnectionInterface {

    String get(String url) throws Exception;

    String put(String url, String params) throws Exception;

    String putWithOneFile(String url, String path) throws Exception;

    String putWithFiles(String url, ArrayList<String> path) throws Exception;

    String putWithOneFileParams(String url, String path, String userReqString) throws Exception;

    String putWithFilesParams(String url, ArrayList<String> path, String params) throws Exception;

    String post(String url, String params) throws Exception;

    String postWithOneFile(String url, String path) throws Exception;

    String postWithFiles(String url, ArrayList<String> path) throws Exception;

    String postWithOneFileParams(String url, String path, String uesrReqString) throws Exception;

    String postWithFilesParams(String url, ArrayList<String> path, String params) throws Exception;

    String delete(String url) throws Exception;
}
