package asynctask;

/**
 *
 * 回调接口,回调方法运行于主线程
 * @ClassName: CallEarliest
 * @version 1.0
 * @param <T>
 */
public interface CallEarliest<T> {
	
	public void onCallEarliest() throws Exception;
}
