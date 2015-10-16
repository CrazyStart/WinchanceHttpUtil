/*
 * Copyright (c) 2015. LuMeng
 * If you have something wanna download, my github account is lubeast.
 * QQ : 736350143
 * Mail : jiahe@dajiaok.com
 */

package http;

import java.util.ArrayList;

import utils.MODE;

/**
 * Created by lumeng on 15/7/22.
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
