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

import utils.MODE;

/**
 * @author L.M
 * @version 1.0.0
 */
public class WinchanceHttpUrlConnection implements HttpUrlConnectionInterface {

    NetOperation asyncNetOperation;

    @Override
    public String put(String url, String params) throws Exception {
        return null;
    }

    @Override
    public String putWithOneFile(String url, String path) throws Exception {
        return null;
    }

    @Override
    public String putWithFiles(String url, ArrayList<String> path) throws Exception {
        return null;
    }

    @Override
    public String putWithOneFileParams(String url, String path, String userReqString) throws Exception {
        return null;
    }

    @Override
    public String putWithFilesParams(String url, ArrayList<String> path, String params) throws Exception {
        return null;
    }

    @Override
    public String get(String url) throws Exception {
        asyncNetOperation = new NetOperation("GET", null, MODE.NOFILE, url, null);
        String result = asyncNetOperation.httpOperation();
        return result;
    }

    @Override
    public String post(String url, String userReqString) throws Exception {
        asyncNetOperation = new NetOperation("POST", userReqString, MODE.NOFILE, url, null);
        String result = asyncNetOperation.httpOperation();
        return result;
    }

    @Override
    public String postWithOneFile(String url, String path) throws Exception {
        asyncNetOperation = new NetOperation("POST", null, MODE.ONEFILE, url, path);
        String result = asyncNetOperation.httpOperation();
        return result;
    }

    @Override
    public String postWithFiles(String url, ArrayList<String> path) throws Exception {
        asyncNetOperation = new NetOperation("POST", null, MODE.FILES, url, path);
        String result = asyncNetOperation.httpOperation();
        return result;
    }

    @Override
    public String postWithOneFileParams(String url, String path, String userreqString) throws Exception {
        asyncNetOperation = new NetOperation("POST", userreqString, MODE.ONEFILE_PARAMS, url, path);
        String result = asyncNetOperation.httpOperation();
        return result;
    }

    @Override
    public String postWithFilesParams(String url, ArrayList<String> path, String params) throws Exception {
        asyncNetOperation = new NetOperation("POST", null, MODE.FILES_PARAMS, url, path);
        String result = asyncNetOperation.httpOperation();
        return result;
    }

    @Override
    public String delete(String url) throws Exception {
        asyncNetOperation = new NetOperation("DELETE", null, MODE.NOFILE, url, null);
        String result = asyncNetOperation.httpOperation();
        return result;
    }

}
