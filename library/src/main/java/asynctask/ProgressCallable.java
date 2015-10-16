package asynctask;



/**
 * 被观察者
 * @version 1.0.0
 * @param <T> T
 */
public interface ProgressCallable<T> {

	/**
	 * 注册观察者对象
	 * @param pProgressListener see {@link IProgressListener}
	 * @throws Exception Exception
	 */
	public T call(final IProgressListener pProgressListener) throws Exception;
}