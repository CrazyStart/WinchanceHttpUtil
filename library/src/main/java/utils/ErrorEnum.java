package utils;

public enum ErrorEnum  {

	NetMethodError(200L,"网络请求类型错误"),//网络请求类型错误
	CodeError(201L,"返回code值出错，无返回值"),//返回code值出错，无返回值
	ResponseError(202L,"服务器返回错误"),//返回错误
	FilesTransformationError(203L,"多文件转换流出错"),//多文件转换流出错
	FileTransformationError(204L,"单文件转换出错"),//单文件转换出错
	TextTransformationError(205L,"文字转换出错"),//文字转换出错
	SaveDataOutputStreamError(206L,"存储为上传用dataoutputstream出错"),//存储为上传用dataoutputstream出错
	MalformedURLError(207L,"url内部出错"),//url内部出错
	IOError(208L,"IO流出错");//IO流出错

	private final Long code;
    private final String msg;

    private ErrorEnum(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
