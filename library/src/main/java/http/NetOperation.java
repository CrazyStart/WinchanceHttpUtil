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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import utils.ErrorEnum;
import utils.MODE;

/**
 * @author L.M
 * @version 1.0.0
 */
public class NetOperation {
    private final String TAG = "MultipartPost";
    private static final String CRLF = "\r\n";
    private static final String BOUNDARY = "AaB03x";

    //编码格式
    static String CHARSET = "UTF-8";
    //链接
    private String url;
    //请求类型 GET, POST, PUT, DELETE
    private String reqKind;
    //传图模式
    private MODE mode;
    //用户请求
    private String userReqString = "";
    //发送数据时dataoutputstream内容
    public List<PostParameter> wparams = new ArrayList<PostParameter>();
    //参数
    private String paramsname;
    //文件路径
    private Object pathobject;
    //全局urlconnection
    private HttpURLConnection httpURLConnection;
    //sessionId
    private static String SESSION = "";

    /**
     * @param reqKind       请求类型GET, POST,PUT,DELETE
     * @param userReqString 用户请求
     * @param mode          模式
     * @param url           链接
     * @param pathobject    数据
     */
    public NetOperation(String reqKind, String userReqString, MODE mode, String url, Object pathobject) {
        this.reqKind = reqKind;
        this.userReqString = userReqString;
        this.url = url;
        this.mode = mode;
        this.pathobject = pathobject;
    }

    /**
     * 网络操作
     *
     * @return see method {@link #serverBack()}
     * @throws Exception Exception
     */
    public String httpOperation() throws Exception {

        InputStream inputStream = null;
        /* 初始化http设置 */
        initHttp(url, reqKind);

        if (null != reqKind && !reqKind.equals("")) {
            switch (reqKind) {
                case "GET":
                    return serverBack();
                case "POST":
                    postOperation(mode);
                    break;
                case "PUT":
                    postOperation(mode);
                    break;
                case "DELETE":
                    return serverBack();
                default:
                    break;
            }
        } else {
            return ErrorEnum.NetMethodError.getMsg();
        }
        return serverBack();
    }

    /**
     * 初始化http设置
     *
     * @param url     url
     * @param reqKind request kind
     */
    private void initHttp(String url, String reqKind) throws Exception {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            httpURLConnection = null;
        }
        URL address = new URL(url);
        httpURLConnection = (HttpURLConnection) address.openConnection();
        httpURLConnection.setRequestMethod(reqKind);
        httpURLConnection.setDoInput(true);
            /* 当请求方法不是get的时候才设置输出 */
        if (!reqKind.equals("GET") && !reqKind.equals("DELETE")) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setUseCaches(false); //设置不能适用缓存
        httpURLConnection.setConnectTimeout(3000);   //设置连接超时时间
        httpURLConnection.setReadTimeout(3000);   // 设置读取时间读取超时
        httpURLConnection.setRequestProperty("Charset", CHARSET);//设置文件字符集
        httpURLConnection.setRequestProperty("Cookie", SESSION);
        if (!MODE.NOFILE.equals(mode)) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
        }
    }

    /**
     * 发送数据，带文件发送数据，带文件带参数发送数据(单文件多文件同体)
     *
     * @throws Exception exception
     */
    public void DataOutPic() throws Exception {
        if (paramsname != null || !"".equals(paramsname)) {
            wparams.add(new PostParameter<String>(paramsname, userReqString));
        }
        if (pathobject != null || !"".equals(pathobject)) {
            if (mode.equals(MODE.ONEFILE) || mode.equals(MODE.ONEFILE_PARAMS)) {
                String path = pathobject.toString();
                FlushFile(path);
            } else {
                List<String> pathobjects = (ArrayList<String>) pathobject;
                for (String path : pathobjects) {
                    FlushFile(path);
                }
            }
        }
    }

    /**
     * @param path file path
     * @throws Exception Exception
     */
    private void FlushFile(String path) throws Exception {
        File FILE = new File(path);
        wparams.add(new PostParameter<File>("heads", FILE));//前参数为文件识别名，后参数为filepathobject
        DataOutputStream dos = null;
        InputStream is = null;
        dos = new DataOutputStream(httpURLConnection.getOutputStream());
        for (PostParameter param : wparams) {
            Log.d(TAG, "Processning param: " + param.getParamName());//打印发送文件名（自定义）
            if (param.getValue() == null) {
                param.setValue("");
            }
            if (param.getValue().getClass() == File.class) {
                postFileParameter(dos, (File) param.getValue(), param.getContentType());
            } else {
                postStringParameter(dos, param.getValue().toString());
            }
        }
        dos.writeBytes(closeBoundary());
        dos.flush();
        wparams.clear();
        if (dos != null) {
            dos.close();
        }
        if (is != null) {
            is.close();
        }
    }

    /**
     * 如果发送数据中只含有键值对
     *
     * @param dos        数据流
     * @param paramValue 文字内容
     * @throws IOException IOException
     */
    private void postStringParameter(DataOutputStream dos, String paramValue) throws IOException {
        dos.writeBytes(boundary() + CRLF);
        dos.writeBytes("Content-Disposition: form-data; name=\"" + "paramter" + "\"" + CRLF + CRLF);
        dos.writeBytes(paramValue + CRLF);
    }

    /**
     * 发送数据中含有文件
     *
     * @param dos         DataOutputStream字符输出流
     * @param file        文件
     * @param contentType 文件发送类型
     * @throws IOException IOException
     */
    private void postFileParameter(DataOutputStream dos, File file, String contentType) throws Exception {
        dos.writeBytes(boundary() + CRLF);
        dos.writeBytes("Content-Disposition: form-data; name=\"" + "parameter" + "\"; filename=\"" + file.getName() + "\"" + CRLF);
        dos.writeBytes("Content-Type: " + contentType + CRLF);
//		dos.writeBytes("Content-Transfer-Encoding: binary" + CRLF);//可要可不要
        dos.writeBytes(CRLF);
        FileInputStream fileInputStream = new FileInputStream(file);
        writeData(fileInputStream, dos);
    }

    /**
     * 根据mode值判断传图操作
     * 1.无文件     DataOut()
     * 2.单文件     DataOutPic()
     * 3.多文件     DataOutPics()
     *
     * @param mode, 模式
     */
    @SuppressWarnings("unchecked")
    private void postOperation(MODE mode) throws Exception {
        if (mode.equals(MODE.NOFILE)) {
            DataOut();
        } else if (mode.equals(MODE.ONEFILE)) {
            DataOutPic();
        } else if (mode.equals(MODE.FILES)) {
            /* 多张图片 */
            DataOutPic();
        } else if (mode.equals(MODE.FILES_PARAMS)) {
            /* 多张图片带描述 */
            DataOutPic();
        } else {
            /* 单张图片带描述 */
            DataOutPic();
        }
    }

    /**
     * 文件分隔符结尾
     *
     * @return string
     */
    private String closeBoundary() {
        return boundary() + "--" + CRLF;
    }

    /**
     * 文件分隔符
     *
     * @return string
     */
    private String boundary() {
        return "--" + BOUNDARY;
    }


    /**
     * response的Code返回值
     *
     * @return response code
     * @throws Exception Exception
     */
    public int HttpResponseCode() throws Exception {
        int code = httpURLConnection.getResponseCode();
        return code;
    }

    /**
     * 发送用户请求
     *
     * @throws Exception Exception
     */
    private void DataOut() throws Exception {
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), Charset.forName("UTF-8")));
        printWriter.print(userReqString);
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 将数据存放在dataOutputStream并上传至服务器
     *
     * @param fileInputStream  fileInputStream
     * @param dataOutputStream dataOutputStream
     */
    private static void writeData(FileInputStream fileInputStream, DataOutputStream dataOutputStream) throws Exception {
        int bytesAvailable = fileInputStream.available();
        int maxBufferSize = 1024;
        int bufferSize = Math.min(bytesAvailable, maxBufferSize);
        byte[] buffer = new byte[bufferSize];

        int bytesRead = fileInputStream.read(buffer, 0, bufferSize);

        while (bytesRead > 0) {
            dataOutputStream.write(buffer, 0, bufferSize);
            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = null;
            buffer = new byte[bufferSize];
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
        }
        dataOutputStream.writeBytes(CRLF);
        dataOutputStream.flush();
        fileInputStream.close();
    }

    /**
     * 服务器返回值
     *
     * @return string
     */
    private String serverBack() throws Exception {
        StringBuilder result = new StringBuilder();
        InputStream inputStream = null;
            /* 若sessioinID为空,则从当前连接获取sessionID */
        if (SESSION.isEmpty() || SESSION.equals("")) {
            String a = httpURLConnection.getHeaderField("Set-Cookie");
            String[] header = a.split(";");
            SESSION = header[0];
        }

        inputStream = httpURLConnection.getInputStream();
        if (null != inputStream) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while (null != (line = reader.readLine())) {
                result.append(line);
            }
            inputStream.close();
        }
        return result.toString();
    }

}
