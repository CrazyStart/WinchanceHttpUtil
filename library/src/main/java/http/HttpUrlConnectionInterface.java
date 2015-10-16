/*
 * Copyright (c) 2015. LuMeng
 * If you have something wanna download, my github account is lubeast.
 * QQ : 736350143
 * Mail : jiahe@dajiaok.com
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
