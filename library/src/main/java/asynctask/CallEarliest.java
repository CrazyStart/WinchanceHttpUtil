package asynctask;

/**
 *
 * 回调接口,回调方法运行于主线程
 * @version 1.0.0
 * @param <T> T
 */
public interface CallEarliest<T> {
	
	public void onCallEarliest() throws Exception;
}
