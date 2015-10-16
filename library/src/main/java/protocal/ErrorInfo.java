package protocal;

public enum ErrorInfo {
    OK(200L, "OK"),

    NOT_LOGIN(0x1000L, "NOT LOGIN"),

    IO_EXCEPTION(0x8000L, "IO EXCEPTION"),

    UNKNOWN(0xFFFFL, "UNKNOWN");

    private final Long code;
    private final String msg;

    private ErrorInfo(Long code, String msg) {
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
